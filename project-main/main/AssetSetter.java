package main;

import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        // Clear existing objects
        for (int i = 0; i < gp.obj.length; i++) {
            gp.obj[i] = null;
        }

        // ---------- KEYS (3 total) ----------
        // Key 1 - Visible early (row 7, col 23 from your original)
        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;
        
        // Key 2 - Middle path (row 40, col 50 - path area)
        gp.obj[1] = new Obj_Key();
        gp.obj[1].worldX = 98 * gp.tileSize;
        gp.obj[1].worldY = 36 * gp.tileSize;
        
        // ---------- DOORS (3 total) ----------
        // Door 1 - Early obstacle (row 10, col 20)
        gp.obj[3] = new Obj_Door();
        gp.obj[3].worldX = 12 * gp.tileSize;
        gp.obj[3].worldY = 29 * gp.tileSize;
        
        // Door 2 - Middle obstacle (row 50, col 45)
        gp.obj[4] = new Obj_Door();
        gp.obj[4].worldX = 14 * gp.tileSize;
        gp.obj[4].worldY = 29 * gp.tileSize;
        
        // Door 3 - Final obstacle (row 5, col 90)
        gp.obj[5] = new Obj_Door();
        gp.obj[5].worldX = 16 * gp.tileSize;
        gp.obj[5].worldY = 29 * gp.tileSize;

        // ---------- COINS (6 coins) - SAFE PATH POSITIONS ----------
        // Coin 1 - Starting area (visible)
        gp.obj[6] = new Obj_Coin();
        gp.obj[6].worldX = 98 * gp.tileSize;
        gp.obj[6].worldY = 35 * gp.tileSize;
        
        // Coin 2 - Behind Door 1
        gp.obj[7] = new Obj_Coin();
        gp.obj[7].worldX = 3 * gp.tileSize;
        gp.obj[7].worldY = 12 * gp.tileSize;
        
        // Coin 3 - Middle maze
        gp.obj[8] = new Obj_Coin();
        gp.obj[8].worldX = 5 * gp.tileSize;
        gp.obj[8].worldY = 13 * gp.tileSize;
        
        // Coin 4 - Right side
        gp.obj[9] = new Obj_Coin();
        gp.obj[9].worldX = 21 * gp.tileSize;
        gp.obj[9].worldY = 36 * gp.tileSize;
        
        // Coin 5 - Bottom-left
        gp.obj[10] = new Obj_Coin();
        gp.obj[10].worldX = 37 * gp.tileSize;
        gp.obj[10].worldY = 70 * gp.tileSize;
        
        // Coin 6 - Near final area
        gp.obj[11] = new Obj_Coin();
        gp.obj[11].worldX = 36 * gp.tileSize;
        gp.obj[11].worldY = 70 * gp.tileSize;

        // ---------- BOOTS ----------
        gp.obj[12] = new Obj_Boots();
        gp.obj[12].worldX = 55 * gp.tileSize;
        gp.obj[12].worldY = 55 * gp.tileSize;

        // ---------- CHEST ----------
        gp.obj[13] = new Obj_Chest();
        gp.obj[13].worldX = 20 * gp.tileSize;
        gp.obj[13].worldY = 29 * gp.tileSize;
    }
}