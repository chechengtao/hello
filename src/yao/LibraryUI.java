package yao;

import java.util.Scanner;

/**
 * @ClassName: book.Ui
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: tommy
 * @create: 2021-12-24 14:20
 */

public class LibraryUI {

    Bo bo = new Bo();

    public static void main(String[] args) {
        LibraryUI ui = new LibraryUI();
        ui.welcome();// 欢迎界面
    }

    // 欢迎界面
    public void welcome() {
        System.out.println("********医药进销存管理系统********");
        //loginBoundary();//登录界面
        showMenu();// 登录成功后跳转至菜单功能管理
    }

    // 管理员登录界面
    public void loginBoundary() {
        System.out.print("管理员账号：");//admin 123456
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("登 录 密 码 ：");
        Scanner scanner1 = new Scanner(System.in);
        String password = scanner1.nextLine();
        int flag = bo.login(username, password);// 登录验证
        switch (flag) {
            case 0:// 密码错误
                System.out.println("密码错误，请重新输入。");
                loginBoundary();
                break;

            case 1:// 验证通过
                System.out.println("登录成功！");
                showMenu();// 登录成功后跳转至菜单功能管理
                break;
            case -1:// 账户不存在
                System.out.println("您输入的管理员账号不存在，请确认后再输入。");
                loginBoundary();
                break;
        }
    }

    // 菜单功能展示列表
    public void showMenu() {
        System.out.println("请输入功能编号进入相应的功能：");
        System.out.println("库存药品信息：1");
        System.out.println("录入新药品：2");
        System.out.println("修改药品信息：3");
        System.out.println("删除药品信息：4");
        System.out.println("修改药品价格：5");
        System.out.println("入库药品：6");
        System.out.println("退出系统——编号：7");
        System.out.print("请输入功能编号：");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();//
        switch (a) {
            case 1:// 信息
                showBook();
                returnMethod();// 返回主菜单
                break;
            case 2:// 录入新
                addBook();
                break;
            case 3:// 修改
                modBookInfo();
                break;
            case 4:// 删除
                delete();
                break;
            case 5:// 还
                returnBook();
                break;
            case 6:// 借
                borrowBook();
                break;
            case 7:// 退出登录
                welcome();
                scanner.close();
                break;
        }
    }

    // 返回主菜单功能
    public void returnMethod() {
        System.out.print("按下ENTER键返回到功能主菜单：");
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        showMenu();
    }

    // 图书信息展示功能
    public void showBook() {

        bo.showBook();
    }

    // 录入新书籍功能
    public void addBook() {
        System.out.print("请输入要增加的药品名：");//名
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        System.out.print("请输入" + bookname + "的厂商：");// 厂商
        Scanner scanner1 = new Scanner(System.in);
        String author = scanner1.nextLine();
        System.out.print("请输入" + bookname + "的生产日期（格式如2000-01-01）：");// 出版日期
        Scanner scanner2 = new Scanner(System.in);
        String pubdate = scanner2.nextLine();
        System.out.print("请输入" + bookname + "的总数（页）：");// 总数
        Scanner scanner3 = new Scanner(System.in);
        String sumpagination = scanner3.nextLine();
        int flag = bo.addBook(bookname, author, pubdate, sumpagination);
        // 1为成功，0为图书馆已经存在该新书，-1为仓库爆满
        switch (flag) {
            case 1:
                System.out.println("新书籍" + bookname + "添加成功，目前图书馆还有" + bo.remainSpace() + "个位置可以存放新书籍。");
                returnMethod();// 书籍添加界面中的返回功能，可选择继续添加或者回到主菜单
                break;
            case 0:
                System.out.println("添加书籍失败，" + bookname + "已存在该图书馆中！");
                returnMethod();// 书籍添加界面中的返回功能，可选择继续添加或者回到主菜单
                break;
            case -1:
                System.out.println("添加失败，图书馆已经存储量已经爆满了，请删除部分书籍后再进行添加。");
                showMenu();
                break;
        }
    }

    // 修改书籍信息
    public void modBookInfo() {
        System.out.print("请输入您要操作的书名：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        // 根据书名查找相关的书籍信息
        int flag = bo.selectBook(bookname);
        switch (flag) {
            case 0:
                System.out.print("未找到相关书籍，输入0回车进入该层功能，输入1回车返回到功能主菜单。");
                int a = scanner.nextInt();
                if (a == 0) {
                    modBookInfo();
                } else if (a == 1) {

                    showMenu();
                }
                break;

            case -1:
                System.out.println("书名为空，输入0回车进入该层功能，输入1回车返回到功能主菜单。");
                int a1 = scanner.nextInt();
                if (a1 == 0) {
                    modBookInfo();
                } else {
                    showMenu();
                }
                break;

            case 1:
                System.out.print("以上信息为相关书名查找的结果，其中（数字“1”代表书名，数字“2”代表厂商，数字“3”代表生产日期，数字“4”代表总数，数字“5”代表借阅者）输入相关数字可以修改相关信息：");
                int a2 = scanner.nextInt();// 1书名 2厂商 3生产日期 4总数 5借阅者
                if (a2 > 0 && a2 < 6) {
                    System.out.print("请输入您想修改的" + sortName(a2) + "：");
                    Scanner scanner2 = new Scanner(System.in);
                    String value = scanner2.nextLine();
                    int index = bo.selectIndex(bookname);
                    bo.modinfo(a2, value, index);
                    System.out.println(bookname + "这本书的相关信息修改成功！");
                    returnMethod();
                } else {
                    System.out.println("您输入的数字不合法。请重试！");
                    modBookInfo();
                }

                break;

        }
    }

    // 修改的分类名称
    public String sortName(int flag) {
        if (flag == 1)
            return "药名";
        if (flag == 2)
            return "厂商";
        if (flag == 3)
            return "生产日期";
        if (flag == 4)
            return "总数";
        else
            return "借阅者";
    }

    // 删除书籍功能
    public void delete() {
        System.out.print("请输入要被删除的书名：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        int flag = bo.testReader(bookname);
        // 存在此书并无人借
        if (flag == 0) {
            bo.deleteBook(bookname);
            System.out.println(bookname + "已成功移除！输入0回到主菜单，输入1则继续删除");
            delReturn();
        } else if (flag == 1) {// 有人借
            System.out.println("此书已借出，请等待归还后再删除。输入0回到主菜单，输入1则继续删除");
            delReturn();
        } else {// 不存在此书
            System.out.println("不存在，请仔细较对。输入0回到主菜单，输入1则继续删除");
            delReturn();
        }

    }

    // 删除的返回操作
    public void delReturn() {

        Scanner scanner1 = new Scanner(System.in);
        int i = scanner1.nextInt();
        if (i == 0) {
            showMenu();
        } else if (i == 1) {
            delete();
        }
    }

    // 还书功能
    public void returnBook() {
        System.out.print("请输入要入库药品名称：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        int flag = bo.testReader(bookname);
        if (flag == 0) {
            System.out.println(bookname + "暂未借出。");
            System.out.print("输入0回车返回至主菜单，输入其他键则继续还书");
            String a = scanner.nextLine();
            if(a.equals("0")){
                showMenu();
            }else {
                returnBook();
            }
        } else if (flag == -1) {
            System.out.println(bookname + "不存在该图书馆中。");
            System.out.print("输入0回车返回至主菜单，输入其他键则继续还书");
            String a = scanner.nextLine();
            if(a.equals("0")){
                showMenu();
            }else {
                returnBook();
            }
        } else if (flag == 1) {

            System.out.println(bo.getBorrowReader(bookname) + "已经还书成功！");
            bo.setBorrowReader(bookname);
            System.out.print("输入0回车返回至主菜单，输入其他键则继续还书");
            String a = scanner.nextLine();
            if(a.equals("0")){
                showMenu();
            }else {
                returnBook();
            }
        }
    }

    // 书籍借阅功能
    public void borrowBook() {
        System.out.print("请输入要借的书名：");
        Scanner scanner = new Scanner(System.in);
        String bookname = scanner.nextLine();
        int flag = bo.testReader(bookname);
        switch (flag) {
            case 0://存在此书并无人借的情况

                System.out.println("请输入借阅者的名字：");
                String readername = scanner.nextLine();
                bo.borrow(bookname,readername);
                System.out.println(readername+"从该图书馆里借出了以"+bookname+"为名的书籍。");
                System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
                int a0 = scanner.nextInt();
                if(a0==0)
                    showMenu();
                if(a0==1)
                    borrowBook();
                break;

            case 1://存在此书被借的情况
                System.out.println("借书失败，" + bookname + "已被借！");
                System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
                int a = scanner.nextInt();
                switch (a) {
                    case 0:
                        showMenu();
                        break;

                    case 1:
                        borrowBook();
                        break;

                }
            case -1://不存在此书的情况
                System.out.println("借书失败，" + bookname + "不存在该图书馆中。");
                System.out.print("输入0回车返回至主菜单，输入1回车则继续借书：");
                int a1 = scanner.nextInt();
                switch (a1) {
                    case 0:
                        showMenu();
                        break;

                    case 1:
                        borrowBook();
                        break;

                }
        }
    }
}
