package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.GamePanel;

public class NPC1 extends Entity {

    GamePanel gp;

    public String[][] dialogues = new String[10][10];
    public int actionLockCounter = 0;
    BufferedImage up;

    public NPC1(GamePanel gp) {
        this.gp = gp;

        setDefaultValuesNpc();
        getImage();
        setDialogue();
    }

    public void setDefaultValuesNpc() {
        worldX = gp.tileSize * 95;
        worldY = gp.tileSize * 2;
        direction = "up";
    }

    public void getImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/yes/npc.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDialogue() {
        dialogues[0][0] = "Hello there!";
        dialogues[0][1] = "It's a nice day to explore, isn't it?";
        dialogues[0][2] = "If you need help, come talk to me again.";
        dialogues[0][3] = "Good luck on your adventure!";
    }

    public void draw(Graphics2D g2) {

        // ✅ convert world position to screen position
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;

        BufferedImage image = up;

        g2.drawImage(
            image,
            screenX,
            screenY,
            gp.tileSize,
            gp.tileSize,
            null
        );
    }
}
