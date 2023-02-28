public class Toy {
    int customerId;
    String brand,name,size,colour,material,location,date;
    double price;
    // right click on space --> source action --> generate getters and setters / constructors
    
    public int getCustomerId() {
        return customerId;
    }
    public Toy(int customerId, String brand, String name, String size, String colour, String material, String location,
             double price,String date) {
        this.customerId = customerId;
        this.brand = brand;
        this.name = name;
        this.size = size;
        this.colour = colour;
        this.material = material;
        this.location = location;
        this.date = date;
        this.price = price;
    }
    @Override
    public String toString() 
    {
        return "Toy [customerId=" + customerId + ", brand=" + brand + ", name=" + name + ", size=" + size + ", colour="
            + colour + ", material=" + material + ", location=" + location + ", date=" + date + ", price=" + price
            + "]";
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    void display()
    {
        System.out.println("Customer Id : "+customerId+"\nCompany brand : "+brand+"\nToy name : "+name+"\nSize : "+size+"\nColour : "+colour+"\nMaterial type : "+material+"\nLocation : "+location+"\nPrice of toy : "+price+"\nPurchase date : "+date);
        System.out.println("------------------");
    }
}
