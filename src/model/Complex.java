package model;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    Complex sub(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    Complex square() {
        return new Complex(real * real - imaginary * imaginary, 2 * real * imaginary);
    }

    double abs() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }
}
