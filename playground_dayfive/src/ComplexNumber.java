public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexNumber copy(){
        return new ComplexNumber(this.real,this.imaginary);
    }
    public ComplexNumber add(ComplexNumber c1){
        double newReal = this.real + c1.getReal();
        double newImage = this.imaginary + c1.getImaginary();
        return new ComplexNumber(newReal,newImage);
    }

    public ComplexNumber subtract(ComplexNumber c1){
        double newReal = this.real - c1.getReal();
        double newImage = this.imaginary - c1.getImaginary();
        return new ComplexNumber(newReal,newImage);
    }
}