package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Obj_Coin extends SuperObject {

    public Obj_Coin() {
        name = "Coin";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/yes/coin.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = false; 
    }
}
