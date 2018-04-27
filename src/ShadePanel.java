import javax.swing.*;
import java.awt.*;
class ShadePanel extends JPanel {

    public ShadePanel() {
        super();
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g1) {// 重写绘制组件外观
        Graphics2D g = (Graphics2D) g1;
        super.paintComponent(g);// 执行超类方法
        int width = getWidth();// 获取组件大小
        int height = getHeight();
        // 创建填充模式对象
        Color randomcolor = new Color(
                (new Double(Math.random() * 128)).intValue() + 128,
                (new Double(Math.random() * 128)).intValue() + 128,
                (new Double(Math.random() * 128)).intValue() + 128
        );
        Color randomcolor2 = new Color(
                (new Double(Math.random() * 128)).intValue() + 128,
                (new Double(Math.random() * 128)).intValue() + 128,
                (new Double(Math.random() * 128)).intValue() + 128
        );

        GradientPaint paint = new GradientPaint(0, 0,randomcolor, 0, height,randomcolor2);
        g.setPaint(paint);// 设置绘图对象的填充模式
        g.fillRect(0, 0, width, height);// 绘制矩形填充控件界面
    }
}
