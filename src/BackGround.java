import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class BackGround extends JFrame implements ActionListener {
    JButton jb = new JButton();
    private JPanel contentPane;
    private JLabel jLabel= new JLabel();
    int fs=0;
    private  Font f1 = new Font("黑体", 0,40);
    private  Font f2 = new Font("Arial", 0,70);
    public BackGround() {
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
        this.setLayout(null);


        contentPane = new JPanel();// 创建内容面板
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        ShadePanel shadePanel = new ShadePanel();// 创建渐变背景面板
        contentPane.add(shadePanel, BorderLayout.CENTER);// 添加面板到窗体内容面板
        shadePanel.setLayout(null);

        jLabel.setFont(f1);
        jLabel.setForeground(Color.white);
        jLabel.setBounds(320,5,50,50);
        jLabel.setText(String.valueOf(fs));

        shadePanel.add(jLabel);
        ImageIcon lx = new ImageIcon("lx.png");
        JLabel labellx = new JLabel();
        labellx.setIcon(lx);
        labellx.setBounds(360,5,100,50);
        shadePanel.add(labellx);
        JLabel jLabelstack= new JLabel("STACK");
        jLabelstack.setFont(f2);
        jLabelstack.setForeground(Color.white);
        jLabelstack.setBounds(85,40,400,200);
        shadePanel.add(jLabelstack);
        ImageIcon open = new ImageIcon("open.png");
        JLabel labelopen = new JLabel();
        labelopen.setIcon(open);
        labelopen.setBounds(125,255,147,147);
        shadePanel.add(labelopen);
        jb.addActionListener(this); //由于实现了ActionListener接口，所以给jb添加的ActionListener就是实例。
        jb.setBounds(145,270,110,110);
        jb.setBorder(null);
        jb.setBackground(new Color(255,0,0,0));
        jb.setContentAreaFilled(false);
        shadePanel.add(jb);

        int x=0,y=100;
        int[] X={x,x+150,x+300,x+150};
        int[] Y={y,y-100,y,y+100};
        Cube cube =new Cube();
        cube.setXY(X,Y);
        cube.setBounds(50,230,300,280);
        cube.setBackground(new Color(0,0,0,0));
        shadePanel.add(cube);

        JLabel labelbuttom = new JLabel();
        labelbuttom.setBounds(25,500,350,65);
        shadePanel.add(labelbuttom);
        ImageIcon style = new ImageIcon("style.png");
        JLabel labelstyle = new JLabel();
        labelstyle.setIcon(style);
        labelstyle.setBounds(0,0,65,65);
        labelbuttom.add(labelstyle);
        ImageIcon star = new ImageIcon("sounds.png");
        JLabel labelstar = new JLabel();
        labelstar.setIcon(star);
        labelstar.setBounds(90,0,65,65);
        labelbuttom.add(labelstar);
        ImageIcon sounds = new ImageIcon("star.png");
        JLabel labelsounds = new JLabel();
        labelsounds.setIcon(sounds);
        labelsounds.setBounds(180,0,65,65);
        labelbuttom.add(labelsounds);
        ImageIcon rank = new ImageIcon("rank.png");
        JLabel labelrank = new JLabel();
        labelrank.setIcon(rank);
        labelrank.setBounds(270,0,65,65);
        labelbuttom.add(labelrank);

        ImageIcon shadow = new ImageIcon("shadow.png");
        JLabel labelshadow = new JLabel();
        labelshadow.setIcon(shadow);
        labelshadow.setBounds(41,377,350,250);
        shadePanel.add(labelshadow);
    }

    public void actionPerformed(ActionEvent e) {// 实现ActionListener接口的actionPerformed接口。
        setVisible(false);
        new Window();
        dispose();
    }
    public void setbgfs(int fs){
        this.fs=fs;
        jLabel.setText(String.valueOf(fs));
    }
}
