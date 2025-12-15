package main;

import object.*;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {

        // ---------- KEY ----------
        gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;

        // ---------- CHEST ----------
        gp.obj[1] = new Obj_Chest();
        gp.obj[1].worldX = 27 * gp.tileSize;
        gp.obj[1].worldY = 7 * gp.tileSize;

        // ---------- DOOR ----------
        gp.obj[2] = new Obj_Door();
        gp.obj[2].worldX = 94 * gp.tileSize;
        gp.obj[2].worldY = 5 * gp.tileSize;

        // ---------- COINS (QUEST: 6 coins) ----------
        gp.obj[3] = new Obj_Coin();
        gp.obj[3].worldX = 94 * gp.tileSize;
        gp.obj[3].worldY = 6 * gp.tileSize;

        gp.obj[4] = new Obj_Coin();
        gp.obj[4].worldX = 21 * gp.tileSize;
        gp.obj[4].worldY = 10 * gp.tileSize;

        gp.obj[5] = new Obj_Coin();
        gp.obj[5].worldX = 22 * gp.tileSize;
        gp.obj[5].worldY = 10 * gp.tileSize;

        gp.obj[6] = new Obj_Coin();
        gp.obj[6].worldX = 23 * gp.tileSize;
        gp.obj[6].worldY = 10 * gp.tileSize;

        gp.obj[7] = new Obj_Coin();
        gp.obj[7].worldX = 24 * gp.tileSize;
        gp.obj[7].worldY = 10 * gp.tileSize;

        gp.obj[8] = new Obj_Coin();
        gp.obj[8].worldX = 25 * gp.tileSize;
        gp.obj[8].worldY = 10 * gp.tileSize;
    }
}
