package pacman;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;

/**
 * Scribble Canvas
 * @version 1.0
 */
public class PacCanvas extends JPanel 
implements KeyListener
{
   LinkedList<Food> fstorage = new LinkedList<Food>();
   LinkedList<Creature> cstorage = new LinkedList<Creature>();
   LinkedList<Terrain> tstorage = new LinkedList<Terrain>();
   transient Food food;
   transient Creature creature;
   transient Terrain terrain;
   transient MazeGrid maze;
   boolean end=false;
   int statusPoints = 0, curLevel = 1, lives = 3;
   transient PacFrame frame;
   transient final String[] lvlMsg =
   {"This is the first level. You shouldn't see this message.",
	"The monsters here will be as fast as the player, but dumb.",
	"The monsters here are smarter and will hunt you down.",
	"What you cannot see cannot hurt you...",
	"Alright, now altogether...DIE!!!"
   };
   transient final int lvl[][] = {
   {
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,3,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,3,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,3,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,2,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
   },
   {
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
			1,0,4,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,
			1,0,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,0,1,0,0,0,1,0,1,0,1,
			1,0,1,0,1,4,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,4,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,
			1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,4,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,4,1,0,1,0,1,
			1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,2,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
   },
   {
			0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,
			0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			0,0,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,
			1,0,0,0,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,1,
			1,0,1,0,1,5,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,
			1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,5,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,0,0,1,5,1,0,1,0,1,
			1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,2,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
			1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1
   },
   {
			0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,
			0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
			0,0,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,
			1,0,0,0,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,1,
			1,0,1,0,1,6,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,0,0,1,0,1,0,0,1,1,1,0,0,0,1,0,0,0,1,
			1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,6,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,0,0,1,6,1,0,1,0,1,
			1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,2,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
			1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1
   },
   {
			0,0,0,1,1,1,1,0,1,1,1,1,1,0,1,1,1,0,1,1,
			0,1,0,0,0,1,6,0,0,0,0,0,0,0,0,0,0,0,0,1,
			0,0,1,0,1,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,
			1,0,0,0,1,0,1,1,0,1,0,1,0,0,0,0,0,1,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,3,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,1,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,
			1,0,1,0,0,0,1,0,0,1,0,0,0,1,0,1,0,1,0,1,
			1,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0,0,0,0,0,
			1,1,1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,1,4,
			1,0,0,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,
			1,1,1,0,1,0,1,0,5,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,0,0,1,3,1,0,1,0,1,
			1,0,1,0,1,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,
			1,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,0,1,
			1,0,1,0,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,
			0,2,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,1,
			1,1,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,1,1,1
   }
   };
   
   /**
    * Constructor
    * @param f - frame
    */
   public PacCanvas(PacFrame f)
   {
		setBackground(Color.white);
		setFocusable(true);
		addKeyListener(this);
		
		maze = new MazeGrid(25,lvl[curLevel-1]);
		buildLists();
		
		setSize(maze.width*maze.square,maze.height*maze.square);
		setPreferredSize(new Dimension(maze.width*maze.square-10, maze.height*maze.square-10)) ;
		
		frame = f;
   }
   /**
    * Builds maze lists
    */
   protected void buildLists(){
	   for (int i = 0; i < maze.height; i++){
			for (int j = 0; j < maze.width; j++){
				switch (maze.grid[j*maze.width+i]){
				case 0: food = new Pill(i,j, maze.square);
						fstorage.add(food);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 1: terrain = new Wall(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 2: creature = new Player(i,j, maze.square, this);
						cstorage.add(creature);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 3: creature = new Monster1(i,j,maze.square, this);
						cstorage.add(creature);
						food = new Pill(i,j, maze.square);
						fstorage.add(food);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 4: creature = new Monster2(i,j,maze.square, this);
						cstorage.add(creature);
						food = new Pill(i,j, maze.square);
						fstorage.add(food);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 5: creature = new Monster3(i,j,maze.square, this);
						cstorage.add(creature);
						food = new Pill(i,j, maze.square);
						fstorage.add(food);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				case 6: creature = new Monster4(i,j,maze.square, this);
						cstorage.add(creature);
						food = new Pill(i,j, maze.square);
						fstorage.add(food);
						terrain = new Floor(i, j, maze.square);
						tstorage.add(terrain);
						break;
				}
				
			}
	   }
   }
   protected void clearLists(){
	   tstorage = new LinkedList<Terrain>();
	   cstorage = new LinkedList<Creature>();
	   fstorage = new LinkedList<Food>();
   }

   /**
    * @return
    */
   protected Creature findPlayer(){
	   ListIterator<Creature> citerator = cstorage.listIterator();
	   while ( citerator.hasNext() ){
		   Creature c = citerator.next();
		   if (c instanceof Player)
			   return c;
	   }
	   return null;
   }
   /**
    * Death of a Player
    */
   public void playerDeath(Player p){
	   pause();
	   if (!p.deathHack)
		   lives--;
	   if (lives <= 0)
		   endGame(false);
	   else{
		   p.curPos = p.startPos;
		   p.curDir = p.nextKeyDir = 'X';
		   p.moveTo(p.curPos, p.curDir);
		   repaint();
	   }
   }
   /**
    * Resume the game
    */
   public void resume(){
	   ListIterator<Creature> citerator = cstorage.listIterator();
	   while ( citerator.hasNext() ){
		   Creature c = citerator.next();
		   c.animate.restart();
	   }
	   frame.open.setEnabled(false);
	   frame.save.setEnabled(false);
	   frame.go.setEnabled(false);
	   frame.pause.setEnabled(true);
   }
   /**
    * Pause the game
    */
   public void pause(){
	   ListIterator<Creature> citerator = cstorage.listIterator();
	   while ( citerator.hasNext() ){
		   Creature c = citerator.next();
		   c.animate.stop();
	   }
	   frame.open.setEnabled(true);
	   frame.save.setEnabled(true);
	   frame.go.setEnabled(true);
	   frame.pause.setEnabled(false);
   }
   /**
    * @param p
    */
   public void eatFood(Point p){
	   ListIterator<Food> fiterator = fstorage.listIterator();
	   while ( fiterator.hasNext() ){
		   Food f = fiterator.next();
		   if (f.curPos.x == p.x && f.curPos.y == p.y){
			   statusPoints += f.points;
			   fstorage.remove(f);
			   //repaint();
			   return;
		   }
	   }
   }
   /**
    * Activate using home key.
    */
   private void chompChompCheat(){
	   fstorage = new LinkedList<Food>();
	   fstorage.add(food);
   }
   /**
    * Clears current window and redraws
    */
   public void newGame(){
	   end = false;
	   curLevel = 1;
	   maze = new MazeGrid(25,lvl[curLevel-1]);
	   pause(); // need to call pause twice...swing timers still going off before garbage collector can pick things up.
	   			// if we don't call it before clearing the lists, the reference will be lost and timers still go off
	   clearLists();
	   buildLists();
	   repaint();
	   pause();
	   statusPoints = 0;
	   lives = 3;
   }
   /**
    * Saves Game
    */
   public boolean saveGame(){
	   JFileChooser fc = new JFileChooser("./");
	   File file;
	   fc.addChoosableFileFilter(new PacFileFilter());
	   fc.setSelectedFile(new File("sav.pac"));
	   if (JFileChooser.APPROVE_OPTION == fc.showSaveDialog(this))
		   file = fc.getSelectedFile();
	   else
		   return false;//they canceled
	   try{
		   FileOutputStream fout = new FileOutputStream(file);
		   ObjectOutputStream out = new ObjectOutputStream(fout);
		   out.writeObject(this);
		   out.close();
		   fout.close();
		   return true;
	   }catch (Exception e){
		   file = null;
		   frame.showMessage("Error creating/saving file. Make sure you have write access to the selected file.");
		   return false;
	   }
   }
   /**
    * Open a file
    */
   @SuppressWarnings("unchecked")
   public void openGame(){
	   JFileChooser fc = new JFileChooser("./");
	   File file;
	   fc.addChoosableFileFilter(new PacFileFilter());
	   if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(this))
		   file = fc.getSelectedFile();
	   else
		   return;
	   try{
		   FileInputStream fin = new FileInputStream(file);
		   ObjectInputStream in = new ObjectInputStream(fin);
		   PacCanvas canvas = (PacCanvas)in.readObject();
		   clearLists();
		   cstorage = canvas.cstorage;
		   fstorage = canvas.fstorage;
		   tstorage = canvas.tstorage;
		   statusPoints = canvas.statusPoints;
		   end = canvas.end;
		   lives = canvas.lives;
		   curLevel = canvas.curLevel;
		   //otherwise the cretures will be using old non-existant? canvas
		   ListIterator<Creature> citerator = cstorage.listIterator();
		   while ( citerator.hasNext() ){
			   Creature c = citerator.next();
			   c.canvas = this;
		   }
		   fin.close();
		   in.close();
		   repaint();
		   pause();
	   }catch (Exception e){
		   file = null;
		   frame.showMessage("Error opening file. Make sure you have read access to the selected file.");
	   }
   }
   /**
    * New Level
    */
   protected void newLevel(){
	   curLevel++;
	   if (curLevel >= lvl.length+1)
		   endGame(true);
	   else {
		   pause(); // need to call pause twice...swing timers still going off before garbage collector can pick things up.
		   			// if we don't call it before clearing the lists, the reference will be lost and timers still go off
		   maze = new MazeGrid(25,lvl[curLevel-1]);
		   clearLists();
		   buildLists();
		   repaint();
		   pause();
		   frame.showMessage("Nicely done - on to level "+curLevel+"! "+lvlMsg[curLevel-1]);
	   }
   }
   
   protected void endGame(boolean won){
	   //show message and disable menus
	   end = true;
	   pause();
	   if (won)
		   frame.showMessage("You have won. Maybe Reagan will come back from the dead and give you an award.");
	   else
		   frame.showMessage("You have lost. I don't even feel I should be talking to you.");
	   frame.open.setEnabled(true);
	   frame.save.setEnabled(false);
	   frame.go.setEnabled(false);
	   frame.pause.setEnabled(false);
   }

   /**
    * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
    */
   public void paintComponent(Graphics gfx)
   {
      //super.paintComponent(gfx) ;
      Graphics2D g = (Graphics2D)gfx;
      int statusFood = 0;
	  ListIterator<Terrain> titerator = tstorage.listIterator();
      while ( titerator.hasNext() ){
    	  Terrain t = titerator.next();
    	  t.draw(g);
      }
      
      ListIterator<Food> fiterator = fstorage.listIterator();
      while ( fiterator.hasNext() ){
    	  Food f = fiterator.next();
    	  statusFood++;
    	  f.draw(g);
      }
      
      ListIterator<Creature> citerator = cstorage.listIterator();
	  while ( citerator.hasNext() ){
		  Creature c = citerator.next();
		  c.draw(g);
	  }
      
      frame.setStatus("Level: "+curLevel+". Current Points: "+statusPoints+". Number of pills left: "+statusFood+". Number of lives left: "+lives);
      if (statusFood == 0 && !end)
    	  newLevel();
   }
   //KEY EVENTS
   /**
    * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
    */
   public void keyReleased(KeyEvent e){}
   /**
    * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
    */
   public void keyPressed(KeyEvent e){
	   switch(e.getKeyCode()){
	   case KeyEvent.VK_HOME: chompChompCheat(); repaint();break;
	   case KeyEvent.VK_END: newLevel(); break;
	   case KeyEvent.VK_UP: 
		   findPlayer().nextKeyDir = 'N';
		   break;
	   case KeyEvent.VK_DOWN: 
		   findPlayer().nextKeyDir = 'S';
		   break;
	   case KeyEvent.VK_LEFT: 
		   findPlayer().nextKeyDir = 'W';
		   break;
	   case KeyEvent.VK_RIGHT: 
		   findPlayer().nextKeyDir = 'E';
		   break;
	   }
   }
   /**
    * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
    */
   public void keyTyped(KeyEvent e){}
}
