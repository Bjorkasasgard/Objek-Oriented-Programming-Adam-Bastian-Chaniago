public class Product {
    private String productId;
    private String productName;
    private Double productPrice;
    private Integer productStock;
    private String productCategory;

    // constructor!!!!!!!!!
    public Product(String productId, String productName, Double productPrice, Integer productStock, String productCategory){
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productCategory = productCategory;
    }

    public void addStock(int amount){ // add stoock
        if (amount > 0){
            productStock += amount;
            System.out.println("Stock successedfuly to adding. now stock:"+ productStock);
        } else {
            System.out.println("stock gagal di tambah");
        }
    }

    public void sellProduct(int amount){ // sell product
        if (!isStockAvailable(amount)) {
            System.out.println("Stok tidak cukup! stok tersedia:" + productStock);
        } else {
            productStock -= amount;
            System.out.println("berhasi menjual"+ amount + "item. Sisa stock:" + productStock);
        }
    }   

    public boolean isStockAvailable(int amount) { // check stock availabelity
        return productStock >= amount;
    }

    public double applyDiscount(double percentage) { // discounted  
        if (percentage < 0 || percentage > 100) {
            System.out.println("presentage not valid!");
            return productPrice;
        }
        double discountedPrice = productPrice - (productPrice * percentage / 100);
        System.out.printf("harga setelah diskon %.0f%%: Rp%.2f%n", percentage, discountedPrice);
        return discountedPrice;
    }

    public void displayDetile() {
        System.out.println("= = = SIMPLE STORE STRUCK = = =");
        System.out.println("Id Product: "+ productId);
        System.out.println("Product Name: "+ productName);
        System.out.printf("Price: Rp%.2f%n", productPrice);
        System.out.println("Stock: "+ productStock);
        System.out.println("Categiry: "     + productCategory);
        System.out.println("= = = = = = = = = = = = = = ");
    }

    public String getProductId()   { return productId; }
    public String getProductName() { return productName; }
    public double getPrice()       { return productPrice; }
    public int getStock()          { return productStock; }
    public String getCategory()    { return productCategory; }
}