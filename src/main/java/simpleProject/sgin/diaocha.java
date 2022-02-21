package simpleProject.sgin;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.*;

public class diaocha extends JFrame{
    JCheckBox jcb1,jcb2,jcb3;
    JRadioButton jrb1,jrb2;
    JLabel jLabel1,jLabel2;
    JPanel jp1,jp2;
    public diaocha(){
        jcb1 = new JCheckBox("华商报");
        jcb2 = new JCheckBox("三秦都市报");
        jcb3 = new JCheckBox("西安晚报");
        jrb1 = new JRadioButton("男");
        jrb2 = new JRadioButton("女");
        jLabel1 = new JLabel("您最常读的报纸");
        jLabel2 = new JLabel("您的性别");
        jp1 = new JPanel();
        jp2 = new JPanel();
        //设置布局
        this.setLayout(new GridLayout(2, 1));
        //添加组件
        jp1.add(jLabel1);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jcb3);
        jp2.add(jLabel2);
        //现在这样的话，最后还是会对性别进行全部选择的。所以添加按钮对象，对同一组单选按钮惊醒分组
        ButtonGroup bGroup = new ButtonGroup();
        bGroup.add(jrb1);
        bGroup.add(jrb2);
        jp2.add(jrb1);
        jp2.add(jrb2);
        this.add(jp1);
        this.add(jp2);

        //设置展示面板
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(200, 200);
    }
    public static void main(String[] args){
        new diaocha();
    }
}