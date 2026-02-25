public class Math {
    // Attributes
    double number1;
    double number2;
    double number3;
    
    public Math(double number1, double number2, double number3) {
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    //fuction for adding method
    public double add() {
        return number1 + number2 + number3;
    }

    //function for multiplying method
    public double multiply() {
        return number1 * number2 * number3;
    }

    // function for finding the average
    public double average() {
        return (number1 + number2 + number3) / 3;
    }  
}
