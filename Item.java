//Giorgi Nozadze
package sample;

public class Item {
    private String iType;
    private double iPrice;
    private double quantity;
    private double netAmt;
    private String iD;
    double subTotal = 0.0D;
    double taxRate = 0.06D;
    double shippingRate = 10.0D;
    double totalShipping = 0.0D;
    private String cliMail;

    public Item() {
    }

    public String getCliMail() {
        return this.cliMail;
    }

    public String getiType() {
        return this.iType;
    }

    public double getiPrice() {
        return this.iPrice;
    }

    public double getSubTotal() {
        return this.subTotal;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public double getShippingRate() {
        return this.shippingRate;
    }

    public double getTotalShipping() {
        return this.totalShipping;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    public String getiD() {
        return this.iD;
    }

    public String getIType() {
        return this.iType;
    }

    public double getIPrice() {
        return this.iPrice;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public double getNetAmt() {
        return this.netAmt;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public void setIPrice(double iPrice) {
        this.iPrice = iPrice;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setNetAmt(double netAmt) {
        this.netAmt = netAmt;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setiPrice(double iPrice) {
        this.iPrice = iPrice;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public void setShippingRate(double shippingRate) {
        this.shippingRate = shippingRate;
    }

    public void setTotalShipping(double totalShipping) {
        this.totalShipping = totalShipping;
    }
}
