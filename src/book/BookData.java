package book;

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
                        booknames[i]="神级强者在都市";
                        authors[i]="日当午";
                        pubdates[i]="2016-03-31";
                        sumpaginations[i]="1320";
                        break;
                    case 1:
                        booknames[i]="都市修仙高手";
                        authors[i]="雪无泪";
                        pubdates[i]="2017-07-25";
                        sumpaginations[i]="656";
                        break;
                    case 2:
                        booknames[i]="护花神兵";
                        authors[i]="鸡飞蛋打";
                        pubdates[i]="2016-01-31";
                        sumpaginations[i]="1120";
                        break;
                    case 3:
                        booknames[i]="七界仙尊 ";
                        authors[i]="无良书生";
                        pubdates[i]="2017-04-04";
                        sumpaginations[i]="1310";
                        break;
                    case 4:
                        booknames[i]="恋上调皮公主";
                        authors[i]="残落筱筱";
                        pubdates[i]="2012-08-20";
                        sumpaginations[i]="954";
                        break;
                }
            }

        }
    }

    public String[] booknames = new String[10];// 书名
    public String[] authors = new String[10];// 作者
    public String[] pubdates = new String[10];// 出版日期
    public String[] sumpaginations = new String[10];// 总页数
    public String[] borrowreaders = new String[10];// 借阅人

}
