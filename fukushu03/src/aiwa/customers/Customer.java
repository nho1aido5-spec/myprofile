package aiwa.customers;

public class Customer {
    private int Customecode;
    private String CustomeName; 
    private String address;

    public int getCustomecode() {
        return Customecode;
    }
    public void setCustomecode(int customecode) {
        Customecode = customecode;
    }

    public String getCustomeName() {
        return CustomeName;
    }
    public void setCustomeName(String customeName) {
        CustomeName = customeName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}