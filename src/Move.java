import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Move implements Runnable{
    private volatile boolean isClick = false;   //是否点击
    private volatile boolean lowLeft = true;   //是否向右下移动
    private volatile boolean isexecute= false;  //是否执行过变形
    private volatile int fractions = 0;         //分数
    private volatile int[] cX={50,200,350,200};     //移动菱形初始坐标
    private volatile int[] cY={330,230,330,430};
    private volatile int[] crpg={30,120,255};     //Cubes初始颜色
    private volatile int[] bcrpg={25,115,250};     //BottomCubes初始颜色
    Cubes cubes;
    BottomCubes bottomCubes;JFrame jFrame;
    public Move(Cubes cubes, BottomCubes bottomCubes, JFrame jFrame) {
        this.cubes=cubes;
        this.bottomCubes=bottomCubes;
        this.jFrame=jFrame;
        Thread thread =new Thread(this);
        thread.start();
//        jFrame.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {    //鼠标点击事件
//                if(e.getButton()==e.BUTTON1) {
//                    isexecute=false;
//                    if(lowLeft==true){
//                        lowLeft=false;
//                    }else {
//                        lowLeft=true;
//                    }
//                    isClick=true;
//
//                }
//            }
//        });
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    isexecute=false;
                    if(lowLeft==true){
                        lowLeft=false;
                    }else {
                        lowLeft=true;
                    }
                    isClick=true;
                }
            }
        });
    }
    private volatile int x = -207, y = -138;    //cubes初始位置
    public void run() {
        int p = 1;
        while (true) {
            if (isClick) {
                if (lowLeft == false && isexecute==false) {    //向右下移动
                    int cx = cubes.getX();      //获取当前x坐标
                    int cy = cx/3*2;            //计算出相应的y坐标
                    if (cx > 0 && cx < cX[3]-cX[0]) {   //判断是否超出范围
                        int[] X = {cX[0] + cx, cX[1] + cx, cX[2], cX[3]};
                        int[] Y = {cY[0] + cy, cY[1] + cy, cY[2], cY[3]};
                        cubes.setXY(X, Y);      //改变菱形的4点坐标来改变菱形的形状
                        cX = X;
                        cY = Y;
                    } else if(cx > cX[0]-cX[3] && cx < 0){
                        int[] X = {cX[0], cX[1], cX[2] + cx, cX[3] + cx};
                        int[] Y = {cY[0], cY[1], cY[2] + cy, cY[3] + cy};
                        cubes.setXY(X, Y);
                        cX = X;
                        cY = Y;
                    }else if(cx==0){    //完美重合
                        fractions++;
                        System.out.println("完美");
                        bottomCubes.setperfect(true);
                    }else {     //超出范围
                        System.out.println("游戏结束");
                        bottomCubes.setover(true);
                        break;
                    }
                    fractions++;
                    isexecute = true;
                    x=207;y=-138;   //重置位置
                }
                if(lowLeft  == true && isexecute==false) {      //向左下移动
                    int cx = cubes.getX();
                    int cy = -cx/3*2;
                    if (cx > 0 && cx < cX[1]-cX[0]) {
                        int[] X = {cX[0] + cx, cX[1], cX[2], cX[3] + cx};
                        int[] Y = {cY[0] + cy, cY[1], cY[2], cY[3] + cy};
                        cubes.setXY(X, Y);
                        cX = X;
                        cY = Y;
                    } else if(cx > cX[0]-cX[1] && cx < 0){
                        int[] X = {cX[0], cX[1] + cx, cX[2] + cx, cX[3]};
                        int[] Y = {cY[0], cY[1] + cy, cY[2] + cy, cY[3]};
                        cubes.setXY(X, Y);
                        cX = X;
                        cY = Y;
                    }else if(cx==0){
                        fractions++;
                        System.out.println("Perfection");
                        bottomCubes.setperfect(true);
                    }else {
                        System.out.println("Game Over");
                        bottomCubes.setover(true);
                        break;
                    }
                    fractions++;
                    isexecute = true;
                    x=-207;y=-138;
                }
                for (int i = 0; i < 3 ; i++) {
                    if(crpg[i]<=250){
                        crpg[i]+=5;
                    }else {
                        crpg[i]+=-250;
                    }
                }
                if(crpg[1]>215){crpg[1]-=215;}

                for (int i = 0; i < 3 ; i++) {
                    if(bcrpg[i]<=250){
                        bcrpg[i]+=5;
                    }else {
                        bcrpg[i]+=-250;
                    }
                }
                if(bcrpg[1]>215){bcrpg[1]-=215;}

                int[] bcY={cY[0]+20,cY[1]+20,cY[2]+20,cY[3]+20};
                bottomCubes.setXY(cX,bcY);
                bottomCubes.setRPG(bcrpg);
                cubes.setRPG(crpg);
                bottomCubes.setfs(fractions);
                isClick=false;
            }

            try {
                Thread.sleep(15);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            if (lowLeft == true) {      //向左下移动
                if (x < -210) p = 1;
                if (x >= 210) p = -1;
                if (p == 1) {
                    x += 3;
                    y += 2;
                } else {
                    x -= 3;
                    y -= 2;
                }
            } else {                  //向右下移动
                if (x < -210) p = 1;
                if (x >  210) p = -1;
                if (p == -1) {
                    x -= 3;
                    y += 2;
                } else {
                    x += 3;
                    y -= 2;
                }
            }
            cubes.setBounds(x, y, 400, 647);    //重置位置
            jFrame.repaint();       //刷新面板
        }
    }
}
