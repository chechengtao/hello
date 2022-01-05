package yiyao;

/**
 * @ClassName: yiyao.test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: tommy
 * @create: 2021-12-31 18:14
 */
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        do{Scanner input=new Scanner(System.in);//打印对象

            FlowerManager f=new FlowerManager();
            f.mainMenu();
            System.out.println("请选择");
            int num=input.nextInt();
            //方法的选用
            switch(num){
                case 1:f.searchAll();break;//查询销售订单
                case 2:f.updateSale();break;//修改订单功能
                case 3:f.deleteSale();break;//删除功能
                case 4: return;
            }}while(true);
    }
}
