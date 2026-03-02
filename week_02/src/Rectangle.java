public class Rectangle {
    double height;
    double width;

    //constructor bray pake parameter
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    public double Calculate(){
        return height * width;
    }

    public void infoRectangle(){
        System.out.println("HASIL Hitung");
        System.out.println("height =" + height);
        System.out.println("height =" + width);
        System.out.println("Hasil =" + Calculate());
        System.out.println("====================");
    }
}
    