import java.awt.*;

public class Pol {      //方块
    int[] X={0,150,300,150};int[] Y={100,0,100,200};    //顶部菱形坐标
    int[] a={X[0],X[0],X[3],X[3]};int[] b={Y[0],Y[0]+20,Y[3]+20,Y[3]};      //左边菱形坐标
    int[] c={X[2],X[2],X[3],X[3]};int[] d={Y[2],Y[2]+20,Y[3]+20,Y[3]};      //右边菱形坐标
    int[] rpg={30,120,255};
    public void setXY(int[] x,int[] y){     //获取顶部坐标，计算出左右菱形坐标
        this.X=x;
        this.Y=y;
        this.a[0]=this.X[0];this.a[1]=this.X[0];this.a[2]=this.X[3];this.a[3]=this.X[3];
        this.b[0]=this.Y[0];this.b[1]=this.Y[0]+20;this.b[2]=this.Y[3]+20;this.b[3]=this.Y[3];
        this.c[0]=this.X[2];this.c[1]=this.X[2];this.c[2]=this.X[3];this.c[3]=this.X[3];
        this.d[0]=this.Y[2];this.d[1]=this.Y[2]+20;this.d[2]=this.Y[3]+20;this.d[3]=this.Y[3];
    }
    public Graphics getpo(Graphics g ){     //绘制各个菱形
        Polygon po = new Polygon();
        for (int i = 0; i < X.length; i++)
            po.addPoint(X[i], Y[i]);
        g.setColor(new Color(rpg[0],rpg[1],rpg[2]));
        g.fillPolygon(po);

        Polygon po1 = new Polygon();
        for (int i = 0; i < a.length; i++)
            po1.addPoint(a[i], b[i]);
        g.setColor(new Color(rpg[0],rpg[1]+20,rpg[2]));
        g.fillPolygon(po1);

        Polygon po2 = new Polygon();
        for (int i = 0; i < c.length; i++)
            po2.addPoint(c[i], d[i]);
        g.setColor(new Color(rpg[0],rpg[1]+40,rpg[2]));
        g.fillPolygon(po2);

        return  g;
    }
    public void setRPG(int[] rpg){
        this.rpg=rpg;
    }
}
