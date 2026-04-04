public class Main {
    public static void main(String[] args) {

        SavingAccount acc1 = new SavingAccount("Adam", 1000, 0.05);

        acc1.displayInfo();

        System.out.println("\nDeposit 500:");
        acc1.deposit(500);

        System.out.println("\nTambah bunga:");
        acc1.addInterest();

        acc1.displayInfo();

        System.out.println("\nSaldo sekarang: " + acc1.getBalance());
    }
}