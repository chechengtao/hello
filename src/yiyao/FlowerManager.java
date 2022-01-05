package yiyao;

import java.util.*;
import java.util.Scanner;

/**
 * @ClassName: yiyao.FlowerManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: tommy
 * @create: 2021-12-31 18:12
 */
public class FlowerManager {

        Scanner input1=new Scanner(System.in);
        static Flower[] flower=new Flower[5];
        //public void inital(){
        //初始化，花的数组

        static{
            flower[0]=new Flower(1001,"香槟玫瑰",10,318.0,"2018-12-12","王二");
            flower[1]=new Flower(1002,"白玫瑰",99,538.0,"2018-2-2","张星宇");
            flower[2]=new Flower(1003,"紫色桔梗",40,123.0,"2018-12-16","王二");
            flower[3]=new Flower(1004,"粉色百合",120,188.0,"2016-12-11","王二");
            flower[4]=new Flower(1005,"无声的爱",1000,219.0,"2016-12-15","张星宇");
        }

        //完成功能面板的展示功能
        public void mainMenu(){
            System.out.println("~~~~~~~~~~欢迎光临鲜花管理系统~~~~~~~~~~~");
            System.out.println("\t1.查询销售订单");
            System.out.println("\t2.修改销售订单");
            System.out.println("\t3.删除销售订单");
            System.out.println("\t4.系统退出");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        //查询订单功能
        public void searchAll(){
            System.out.println("这里是全部的订单");

            System.out.println("编号\t鲜花名称\t销售数量\t价格\t销售日期\t\t销售员");
            for(int i=0;i<flower.length;i++){
    if(flower[i]!=null){
                    Flower f=flower[i];
                    System.out.println(f.getNumber()+"\t"+f.getName()+"\t"+f.getCount()+"\t"
                            +f.getPrice()+"\t"
                            +f.getDate()+"\t"+f.getSaler());

                }
            }
        }
        //修改订单功能
        public void updateSale(){
            System.out.println("这里是修改订单功能");
            searchAll();
            System.out.println("请输入要修改编号");

            int  index=-1;
            int  num1=input1.nextInt();
            for(int i=0;i<flower.length;i++){
                Flower f=flower[i];
                int  number=f.getNumber();

                if(num1==number)
                    index=i;
            }
            if(index==-1)System.out.println("输入的编号有误");
            else{System.out.println("请输入改变后的鲜花名称");
                String name=input1.next();
                System.out.println("请输入改变后的销售数量");
                int number=input1.nextInt();
                System.out.println("请输入改变后的价格");
                double price =input1.nextDouble();
                System.out.println("请输入改变后的销售日期");
                String date =input1.next();
                System.out.println("请输入改变后的销售员");
                String saler=input1.next();
                System.out.println("你确定要修改吗?(y/n)");
                String choice=input1.next();
                if("y".equals(choice)){
                    flower[index].setName(name);
                    flower[index].setCount(number);;
                    flower[index].setPrice(price);
                    flower[index].setDate(date);
                    flower[index].setSaler(saler);
                }
                System.out.println("修改后的全部订单");
                searchAll();

            }
        }
        //删除订单功能
        public void deleteSale(){
            System.out.println("这里是删除订单功能");
            searchAll();
            System.out.println("请输入要删除的编号");
            int  number=input1.nextInt();
            int index=-1;
            for(int i=0;i<flower.length;i++){
                Flower f=flower[i];
                if(number==f.getNumber())
                    index=i;
            }
            if(index==-1)System.out.println("你输入的编号有误");
            else{System.out.println("你要修改的订单如下");
                Flower f=flower[index];
                System.out.println("编号\t鲜花名称\t销售数量\t价格\t销售日期\t\t销售员");
                System.out.println(f.getNumber()+"\t"+f.getName()+"\t"+f.getCount()+"\t"
                        +f.getPrice()+"\t"
                        +f.getDate()+"\t"+f.getSaler());
                System.out.println("你确定要删除吗(y/n)");
                System.out.println("请选择");
                String choice=input1.next();
                if("y".equals(choice)){
 for(int i=index;i<flower.length-1;i++){
                        flower[i]=flower[i+1];
                    }
    flower[flower.length-1]=null;
                    System.out.println("删除成功");
                    searchAll();

                }
                else
                {System.out.println("已取消删除");}

            }

        }

    }
