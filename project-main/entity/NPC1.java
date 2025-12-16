package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import main.GamePanel;

public class NPC1 extends Entity {

    GamePanel gp;

    public NPC1(GamePanel gp) {
        this.gp = gp;

        worldX = gp.tileSize * 95;
        worldY = gp.tileSize * 2;
        speed = 0;
        solidArea = new Rectangle(8, 8, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        collisionOn = true;

        try {
            down1 = ImageIO.read(getClass().getResourceAsStream("/yes/npc1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Simplified interact method - assumes Player already checked proximity
    public void interact() {
        if (!gp.player.questCompleted) {
            if (gp.player.coinCount < 6) {
                gp.ui.notif("Collect 6 coins first!");
            } else {
                gp.ui.notif("Quest complete! Reward is 1x Key!.");
                gp.player.questCompleted = true;
                gp.player.hasKey++;
            }
        } else {
            gp.ui.notif("You may open the door now.");
        }
    }

    public void draw(Graphics2D g2) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;
        g2.drawImage(down1, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}