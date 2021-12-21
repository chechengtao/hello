package swing.calendar;

/**
 *界面化
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Ui {

    public static void main(String[] args)  {
//throws InterruptedException
        //得到当前的年份和月份，后期会用到
        Calendar cale = null;
        cale = Calendar.getInstance();
        final int[] year = {cale.get(Calendar.YEAR)};
        final int[] month = {cale.get(Calendar.MONTH) + 1};
        System.out.println(year[0]);
        System.out.println(month[0]);
        JFrame jf=new JFrame("万年历（此万年历在1900-2050年有效）");
        jf.setSize(700,400);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel=new JPanel(null);
        JTextField jTextField=new JTextField();
        JLabel jLabel1=new JLabel(year[0] +"年"+ month[0] +"月");//实时的年份/月份
        jLabel1.setFont(new Font(null,Font.PLAIN,18));
        JButton jButton1=new JButton("↑");//上一月
        jButton1.setFont(new Font(null,Font.PLAIN,18));
        JButton jButton2=new JButton("↓");//下一月
        jButton2.setFont(new Font(null,Font.PLAIN,18));
        JLabel jLabel2=new JLabel("输入年份");//年份的标签
        jLabel2.setFont(new Font(null,Font.PLAIN,15));
        JTextField jTextField1=new JTextField();//输入年份
        JLabel jLabel3=new JLabel("输入月份");//月份的标签
        jLabel3.setFont(new Font(null,Font.PLAIN,15));
        JTextField jTextField2=new JTextField();//输入月份
        JButton jButton3=new JButton("跳转到该月");//开始按钮
        jButton3.setFont(new Font(null,Font.PLAIN,15));
        String[] weekDays = { "星期一\t\t", "星期二\t\t", "星期三\t\t", "星期四\t\t", "星期五\t\t", "星期六\t\t", "星期日\t\t" };


        String[][] testdays=Dates2.weekday(2018,12);
        jTextField.setText(NowTime.Now());
        jTextField.setFont(new Font(null,Font.PLAIN,22));
        JTable table=new JTable(testdays,weekDays);
        table.getTableHeader().setReorderingAllowed(false);   //不可整列移动
        table.getTableHeader().setResizingAllowed(false);   //不可拉动表格
        jTextField.setBounds(0,0,700,50);
        jLabel1.setBounds(0,50,100,50);
        jButton1.setBounds(100,50,50,50);
        jButton2.setBounds(150,50,50,50);
        jLabel2.setBounds(200,50,85,50);
        jTextField1.setBounds(285,50,110,50);
        jLabel3.setBounds(395,50,85,50);
        jTextField2.setBounds(470,50,110,50);
        jButton3.setBounds(580,50,120,50);
        table.getTableHeader().setBounds(0,100,700,50);
        table.setBounds(0,150,700,350);
        table.setRowHeight(35);
        table.setFont(new Font(null,Font.PLAIN,18));
        jf.setVisible(true);
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year[0]=Integer.parseInt(jTextField1.getText());
                month[0]=Integer.parseInt(jTextField2.getText());
                jLabel1.setText(year[0]+"年"+month[0]+"月");
                table.setModel(new DefaultTableModel(Dates2.weekday(year[0],month[0]),weekDays));
                System.out.println(year[0]);
                System.out.println(month[0]);
            }
        });
        //上一月功能
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(month[0]==1)
                {
                    year[0]-=1;
                    month[0]=12;
                    jLabel1.setText(year[0] + "年" + (month[0] ) + "月");
                    table.setModel(new DefaultTableModel(Dates2.weekday(year[0], month[0] ), weekDays));

                }
                else
                {
                    month[0]-=1;
                    jLabel1.setText(year[0] + "年" + (month[0] ) + "月");
                    table.setModel(new DefaultTableModel(Dates2.weekday(year[0], month[0] ), weekDays));
                }
                System.out.println(year[0]+"年"+(month[0] )+"月");
            }

        });
        //下一月功能
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(month[0]<12)
                {
                    month[0] +=1;
                    jLabel1.setText(year[0] + "年" + (month[0] ) + "月");
                    table.setModel(new DefaultTableModel(Dates2.weekday(year[0], month[0] ), weekDays));

                }
                else
                {
                    year[0]+=1;
                    month[0]=1;
                    jLabel1.setText(year[0] + "年" + (month[0] ) + "月");
                    table.setModel(new DefaultTableModel(Dates2.weekday(year[0], month[0] ), weekDays));
                }
                System.out.println(year[0]+"年"+(month[0] )+"月");
            }
        });
        //设置文本框内容：当前的时间和日期
        panel.add(jTextField);
        panel.add(jLabel1);
        panel.add(jButton1);
        panel.add(jButton2);
        panel.add(jLabel2);
        panel.add(jTextField1);
        panel.add(jLabel3);
        panel.add(jTextField2);
        panel.add(jButton3);
        panel.add(table.getTableHeader());
        panel.add(table);
        jf.add(panel);
        while(true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jTextField.setText(NowTime.Now());
        }

    }


}