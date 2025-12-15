package main;

import java.awt.Rectangle;
import entity.Entity;
import entity.NPC1;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    // ----------------- TILE COLLISION -----------------
    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gp.tileSize;
        int entityRightCol = entityRightWorldX / gp.tileSize;
        int entityTopRow = entityTopWorldY / gp.tileSize;
        int entityBottomRow = entityBottomWorldY / gp.tileSize;

        int tileNum1 = 0, tileNum2 = 0;

        switch (entity.direction) {
            case "up":
                entityTopRow = (entityTopWorldY - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX - entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                break;
            case "right":
                entityRightCol = (entityRightWorldX + entity.speed) / gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;
        }

        if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
            entity.collisionOn = true;
        }
    }

    // ----------------- OBJECT COLLISION -----------------
    public int checkObject(Entity entity, boolean player) {
        int index = 999;

        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // Get entity solid area position
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                // Get object solid area position
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                // Check direction
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        break;
                }

                if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                    if (gp.obj[i].collision) entity.collisionOn = true;
                    if (player) index = i;
                }

                // Reset solidArea positions
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }
        return index;
    }

    // ----------------- NPC COLLISION CHECK -----------------
    public void checkNPCCollision(Entity entity) {
        if (gp.npc != null) {
            entity.solidArea.x = entity.worldX + entity.solidArea.x;
            entity.solidArea.y = entity.worldY + entity.solidArea.y;
            
            gp.npc.solidArea.x = gp.npc.worldX + gp.npc.solidArea.x;
            gp.npc.solidArea.y = gp.npc.worldY + gp.npc.solidArea.y;
            
            // Check direction for predictive collision
            switch (entity.direction) {
                case "up":
                    entity.solidArea.y -= entity.speed;
                    break;
                case "down":
                    entity.solidArea.y += entity.speed;
                    break;
                case "left":
                    entity.solidArea.x -= entity.speed;
                    break;
                case "right":
                    entity.solidArea.x += entity.speed;
                    break;
            }
            
            if (entity.solidArea.intersects(gp.npc.solidArea) && gp.npc.collisionOn) {
                entity.collisionOn = true;
            }
            
            // Reset
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.npc.solidArea.x = gp.npc.solidAreaDefaultX;
            gp.npc.solidArea.y = gp.npc.solidAreaDefaultY;
        }
    }

    // ----------------- NPC INTERACTION CHECK -----------------
    public boolean checkNPCInteraction(Entity player, NPC1 npc) {
        // Create a larger area AROUND the player (2 tiles radius)
        int interactionRange = gp.tileSize * 2;
        
        Rectangle playerArea = new Rectangle(
            player.worldX + player.solidAreaDefaultX - interactionRange / 2,
            player.worldY + player.solidAreaDefaultY - interactionRange / 2,
            player.solidArea.width + interactionRange,
            player.solidArea.height + interactionRange
        );
        
        Rectangle npcArea = new Rectangle(
            npc.worldX + npc.solidAreaDefaultX,
            npc.worldY + npc.solidAreaDefaultY,
            npc.solidArea.width,
            npc.solidArea.height
        );
        
        return playerArea.intersects(npcArea);
    }
}