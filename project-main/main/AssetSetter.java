package main;

import object.Obj_Boots;
import object.Obj_Chest;
import object.Obj_Door;
import object.Obj_Key;

public class AssetSetter {

    GamePanel gp;

    public AssetSetter(GamePanel gp)
    {
        this.gp = gp;
    }
    
    public void setObject(){
    	gp.obj[0] = new Obj_Key();
        gp.obj[0].worldX = 23 * gp.tileSize;
        gp.obj[0].worldY = 7 * gp.tileSize;
        
        gp.obj[1] = new Obj_Chest();
        gp.obj[1].worldX = 24 * gp.tileSize;
        gp.obj[1].worldY = 8 * gp.tileSize;
        
        gp.obj[2] = new Obj_Door();
        gp.obj[2].worldX = 68 * gp.tileSize;
        gp.obj[2].worldY = 29 * gp.tileSize;

        gp.obj[2] = new Obj_Boots();
        gp.obj[2].worldX = 57 * gp.tileSize;
        gp.obj[2].worldY = 52 * gp.tileSize;


    }
}
