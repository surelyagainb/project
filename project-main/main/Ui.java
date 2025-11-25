package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

import object.Obj_Key;
public class Ui {

    GamePanel gp;
    Font calibri;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter;
    public boolean gameFinished = false;

    public Ui(GamePanel gp){
        this.gp = gp;
        calibri = new Font("Calibri", Font.PLAIN, 40);
        Obj_Key key = new Obj_Key();
        keyImage = key.image;
    }

    public void notif(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2){

        if(gameFinished == true){
            g2.setFont(calibri);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text = "You Found the treasure!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*3);
            g2.drawString(text, x, y);

            text = "You Won!";
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = gp.screenWidth/2 - textLength/2;
            y = gp.screenHeight/2 - (gp.tileSize*2);
            g2.drawString(text, x, y);

            gp.gameThread = null;

        }
        else{ 
        g2.setFont(calibri);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x "+gp.player.hasKey, 74, 69);

        if(messageOn == true){
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, 274, 274);

            messageCounter++;
            if(messageCounter > 180){
                messageCounter = 0;
                messageOn = false;
                }
            }
        }
    }
}
