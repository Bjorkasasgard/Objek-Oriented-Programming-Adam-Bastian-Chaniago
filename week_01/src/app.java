public class App{
    public static void main(String[] args) throws Exception {
        // notegwh: Membuat objek mycalculactor (memanggil mesin Math ke dalam App)
        Math mycalculactor = new Math();

        mycalculactor.no1 = 10;
        mycalculactor.no2 = 2;
        mycalculactor.no3 = 3;

        System.out.println("== Hasil perhitungan ==");
        
        // memanggil method add, multiply dan devide
        System.out.println("Hasil dari 10 + 2 + 3 =" + mycalculactor.add());
        System.out.println("Hasil dari 10 * 2 * 3 =" + mycalculactor.multiply());
        System.out.println("Hasil dari (10 + 2) * 3 =" + mycalculactor.devide());
    }
}