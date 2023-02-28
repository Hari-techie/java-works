public class Toy {
    String toyName,customerName,purchaseDate;

    public Toy(String toyName, String customerName, String purchaseDate) {
        this.toyName = toyName;
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Toy [toyName=" + toyName + ", customerName=" + customerName + ", purchaseDate=" + purchaseDate + "]";
    }
    
}
