package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import tile.TileManager;
import entity.NPC1;
import entity.Player;
import object.SuperObject;

import javax.swing.JPanel;
public class GamePanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; // 16 x 16 tile
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48 x 48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 766 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels

    public final int maxWorldCol = 100;
    public final int maxWorldRow = 100;
    public final int maxWorldWidth = tileSize * maxScreenCol;
    public final int maxWorlHeight = tileSize * maxScreenRow;
    
    int FPS = 60;
    TileManager tileM = new TileManager(this); //Call the tile manager
    KeyHandler keyH = new KeyHandler(this); //Used for player movements
    Thread gameThread; 
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public Ui ui = new Ui(this);
    public SuperObject obj[] = new SuperObject[20];
    public NPC1 npc = new NPC1(this);

    //Game State: pause, resume, etc.
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;


    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground((Color.BLACK));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame() {
        aSetter.setObject();
        gameState = playState;

    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        while(gameThread != null){
            double drawInterval = 1000000000/FPS; 
            double nextDrawTime = System.nanoTime() + drawInterval;
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/10000000;
                if (remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime +=drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }

    public void update(){

        if(gameState == playState){
            player.update();
        }
        if(gameState == pauseState){
            
        }
        
    }
        
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tileM.draw(g2); // always tile first before player, if player is first they are hidden
        for(int i = 0; i < obj.length; i++){
            if(obj[i] !=null){
                obj[i].draw(g2, this);
            }  
        }
        player.draw(g2); //put this below the tile if you want the player to be visible

        npc.draw(g2);

        ui.draw(g2);
        
        g2.dispose();
        
    }
}