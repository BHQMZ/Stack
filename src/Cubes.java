import javax.swing.*;
import java.awt.*;

public class Cubes extends JPanel{      //移动的方块
    int[] X={50,200,350,200};
    int[] Y={330,230,330,430};
    int[] rpg={30,120,255};
    public void setXY(int[] x,int[] y){
        this.X=x;
        this.Y=y;
    }
    public void paintComponent(Graphics g) {
        Pol pol=new Pol();
        pol.setXY(X,Y);
        pol.setRPG(rpg);
        pol.getpo(g);
    }
    public void setRPG(int[] rpg){
        this.rpg=rpg;
    }
}
