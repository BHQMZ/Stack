

import javax.swing.*;
import java.awt.*;

public class BottomCubes extends JPanel{    //底层方块
    int[] X={50,200,350,200};
    int[] Y={350,250,350,450};
    int[] rpg={25,115,250};
    int fs=0;
    boolean over=false;
    boolean perfect=false;
    boolean isdraw=true;
    public void paintComponent(Graphics g) {    //绘制方块
        Pol pol=new Pol();
        pol.setXY(X,Y);
        pol.setRPG(rpg);
        pol.getpo(g);
    }

    public void setXY(int[] x,int[] y){     //获取方块坐标
        this.X=x;
        this.Y=y;
        this.isdraw = true;
    }
    public void setRPG(int[] rpg){
        this.rpg=rpg;
    }
    public int[] getx(){
        return X;
    }
    public int[] gety(){
        return Y;
    }
    public void setIsdraw(boolean isdraw){
        this.isdraw=isdraw;
    }
    public void setfs(int fs){this.fs=fs;}
    public void setover(boolean over){this.over=over;}
    public void setperfect(boolean perfect){this.perfect=perfect;}
}
