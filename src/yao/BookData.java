package yao;

/**
 * @ClassName: book.BookData
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: tommy
 * @create: 2021-12-24 14:19
 */

public class BookData {
    //书库
    public BookData() {
        {
            String noreaders= "无";
            for (int i = 0; i < borrowreaders.length; i++) {
                borrowreaders[i]=noreaders;
            }
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0:
                        booknames[i]="胃康灵";
                        authors[i]="哈药集团";
                        pubdates[i]="2016-03-31";
                        sumpaginations[i]="132";
                        break;
                    case 1:
                        booknames[i]="头孢颗粒";
                        authors[i]="制药6厂";
                        pubdates[i]="2017-07-25";
                        sumpaginations[i]="66";
                        break;
                    case 2:
                        booknames[i]="葵花肝药";
                        authors[i]="葵花药业";
                        pubdates[i]="2016-01-31";
                        sumpaginations[i]="120";
                        break;
                    case 3:
                        booknames[i]="感冒灵";
                        authors[i]="999制药";
                        pubdates[i]="2017-04-04";
                        sumpaginations[i]="131";
                        break;
                    case 4:
                        booknames[i]="眼药水";
                        authors[i]="博士伦";
                        pubdates[i]="2012-08-20";
                        sumpaginations[i]="9";
                        break;
                }
            }

        }
    }

    public String[] booknames = new String[100];// 药品名
    public String[] authors = new String[100];// 厂商
    public String[] pubdates = new String[100];// 出厂日期
    public String[] sumpaginations = new String[100];// 总数
    public String[] borrowreaders = new String[100];// 价格
    public String[] ids = new String[100];//编号

}
