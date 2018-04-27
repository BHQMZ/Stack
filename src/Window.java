import com.sun.javafx.scene.layout.region.Margins;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Window extends JFrame implements Runnable{     //窗体
    private volatile BottomCubes bottomCubes =new BottomCubes();    //底层方块
    private volatile JLabel jLabescore= new JLabel();
    private volatile JLabel jLabeover= new JLabel();
    private volatile JLabel jLabeshadow= new JLabel();
    private  Font f1 = new Font("黑体", 0,40);
    private  Font f2 = new Font("华文琥珀", 0,50);
//    private JLabel jLabel;
    public Window(){
        setTitle("Stack");// 设置窗体标题
        String iconpath = "/img/icon.png";//指明图片的路径（相对路径）
        try{//异常处理
            Image icon = ImageIO.read(this.getClass().getResource(iconpath));//通过Image类得到图片
            setIconImage(icon);//设置窗口图标
        }catch (IOException e){
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 647);
        setLocationRelativeTo(null);//窗口在屏幕中间显示
        setResizable(false);//设置窗口不能修改
        setBackground(new Color(180,238,180));
        Cubes cubes =new Cubes();   //移动的方块
        cubes.setBounds(0,0,400,647);
        cubes.setBackground(new Color(0,0,0,0));
        bottomCubes.setBounds(0,0,400,647);
        bottomCubes.setBackground(new Color(0,0,0,0));
        this.setLayout(null);
        this.add(cubes);
        this.add(bottomCubes);
        ImageIcon lx = new ImageIcon("lx.png");
        JLabel labellx = new JLabel();
        labellx.setIcon(lx);
        labellx.setBounds(360,5,100,50);
        this.add(labellx);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        jLabeover.setFont(f2);
        jLabeover.setBounds(55,100,300,50);
        jLabeover.setText("");
        this.add(jLabeover);
        jLabeover.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {    //鼠标点击事件
                if(e.getButton()==e.BUTTON1) {
                    setVisible(false);
                    BackGround bg=new BackGround();
                    bg.setbgfs(bottomCubes.fs);
                    bg.setVisible(true);
                    System.out.println(bg.fs);
                    dispose();
                }
            }
        });

        jLabescore.setFont(f1);
        jLabescore.setForeground(Color.white);
        jLabescore.setBounds(320,5,50,50);
        jLabescore.setText(String.valueOf(bottomCubes.fs));
        this.add(jLabescore);

        ImageIcon shadow = new ImageIcon("shadow.png");
        jLabeshadow.setIcon(shadow);
        this.add(jLabeshadow);





        new Move(cubes,bottomCubes,this);   //移动
        Thread thread =new Thread(this);
        thread.start();

    }

    public void run() {     //堆叠
        int i = 0;
        int count=0;
        int shadowy=325;
        int[][] rpg=new int[1000][3];
        rpg[i][0]=20;rpg[i][1]=110;rpg[i][2]=245;
        List<BottomCubes> list =new ArrayList<BottomCubes>();   //定义一个BottomCubes的List
        while (true){
            if(bottomCubes.over==true){
                jLabeover.setForeground(new Color(bottomCubes.rpg[0],bottomCubes.rpg[1],bottomCubes.rpg[2]));
                jLabeover.setText("Game Over !");
                break;
            }
            try {
                Thread.sleep(100);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count>=10){jLabeover.setText("");}
            if (bottomCubes.isdraw == true ) {      //每次点击获取
                System.out.println(bottomCubes.fs);
                jLabeshadow.setBounds(41,shadowy+=20,350,250);
                jLabescore.setText(String.valueOf(bottomCubes.fs));
                if(bottomCubes.perfect==true){
                    jLabeover.setForeground(new Color(bottomCubes.rpg[0],bottomCubes.rpg[1],bottomCubes.rpg[2]));
                    jLabeover.setText("Perfection ！");
                    bottomCubes.setperfect(false);
                    count=0;
                }
                for (int j = 0; j < 3 ; j++) {
                    if(rpg[i][j]<=250){
                        rpg[i+1][j]=rpg[i][j]+5;
                    }else {
                        rpg[i+1][j]=rpg[i][j]-250;
                    }
                }
                if(rpg[i+1][1]>215){rpg[i+1][1]-=215;}
                BottomCubes bottom = new BottomCubes();
                bottom.setXY(bottomCubes.getx(),bottomCubes.gety());
                bottom.setRPG(rpg[i+1]);
                bottom.setBackground(new Color(0, 0, 0, 0));
                list.add(0,bottom);
                i++;
                bottomCubes.setIsdraw(false);
            }
            for (int j = 0; j < i; j++) {       //依次生成
                BottomCubes bottom = list.get(j);
                bottom.setBounds(0, j * 20, 400, 647);
                this.add(bottom);
            }
        }
    }
}
