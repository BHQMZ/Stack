import javax.swing.*;
import java.awt.*;

class Cube extends JPanel {

    int x=0,y=100;
    int[] X={x,x+150,x+300,x+150};
    int[] Y={y,y-100,y,y+100};
    //    Random rd=new Random();
//    int Cr=rd.nextInt(255);
    int Cr=30;
    int Cg=120;
    int Cb=255;
    public void setXY(int[] x,int[] y){
        this.X=x;
        this.Y=y;
    }
    public void paintComponent(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// 执行超类方法
        int[] x={X[0],X[0],X[3],X[3]};
        int[] y={Y[0],Y[0]+75,Y[3]+75,Y[3]};
        int[] a={X[2],X[2],X[3],X[3]};
        int[] b={Y[2],Y[2]+75,Y[3]+75,Y[3]};
        super.paintComponent(g);
        Polygon po = new Polygon();
        for (int i = 0; i < X.length; i++)
            po.addPoint(X[i], Y[i]);
        g.setColor(new Color(Cr,Cg,Cb));
        g.fillPolygon(po);

        Polygon po1 = new Polygon();
        for (int i = 0; i < x.length; i++)
            po1.addPoint(x[i], y[i]);
        g.setColor(new Color(Cr,Cg+20,Cb));
        g.fillPolygon(po1);

        Polygon po2 = new Polygon();
        for (int i = 0; i < x.length; i++)
            po2.addPoint(a[i], b[i]);
        g.setColor(new Color(Cr,Cg+40,Cb));
        g.fillPolygon(po2);
        g.dispose();
    }
}
