package yiyao;

/**
 * @ClassName: yiyao.flower
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: tommy
 * @create: 2021-12-31 18:12
 */
public class Flower {
    private int number;
    private String name;
    private int count;
    private double price;
    private String date;
    private String saler;

    public Flower(int number, String name, int count, double price, String date, String saler) {
        super();
        this.number = number;
        this.name = name;
        this.count = count;
        this.price = price;
        this.date = date;
        this.saler = saler;
    }

    public Flower() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getSaler() {
        return saler;
    }
    public void setSaler(String saler) {
        this.saler = saler;
    }

}
