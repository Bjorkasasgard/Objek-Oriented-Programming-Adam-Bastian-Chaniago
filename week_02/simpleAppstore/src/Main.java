public class Main {
    public static void main(String[] args) {

        // Buat objek produk baru
        Product laptop = new Product("P001", "Laptop Asus", 8500000.00, 10, "Elektronik");

        // Tampilkan detail
        laptop.displayDetile();

        // Tambah stok
        laptop.addStock(5);

        // Jual produk
        laptop.sellProduct(3);

        // Cek ketersediaan stok
        System.out.println("Stok tersedia untuk 20 item? " + laptop.isStockAvailable(20));

        // Terapkan diskon 10%
        laptop.applyDiscount(10);
    }
}
