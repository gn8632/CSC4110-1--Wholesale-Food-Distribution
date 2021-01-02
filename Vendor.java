package sample;

public class Vendor {
    public String businessName = " "; // Business name
    public String ownerName = " "; // manager name
    public String businessNum = " "; // company number
    public String BusinessAddress= " "; // company address
    public String businessEmail = " "; // Company email
    public String businessTaxID= " "; // tax id
    public String vendorInput = " "; // delete vendor


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getBusinessAddress() {
        return BusinessAddress;
    }

    public void setBusinessAddress(String businessAddress) {
        BusinessAddress = businessAddress;
    }

    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }

    public String getBusinessTaxID() {
        return businessTaxID;
    }

    public void setBusinessTaxID(String businessTaxID) {
        this.businessTaxID = businessTaxID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVendorInput() {
        return vendorInput;
    }

    public void setVendorInput(String vendorInput) {
        this.vendorInput = vendorInput;
    }

}

