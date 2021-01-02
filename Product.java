package sample;


public class Product {

    private String id;
    private String name;
    private int qty;
    private double price;
    private String vendor;
    private String date;

    public Product(String id, String name, int qty, double price, String vendor, String date) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.vendor = vendor;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product(){
        this.name = "";
        this.qty = 0;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
