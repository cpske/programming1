/**
 * Complex numbers and operations on complex numbers.
 * Complex number are immutable. Operations on complex numbers 
 * don't change the existing complex number objects.
 * 
 * @author
 */
public class Complex {
	private final double real;
	private final double imag;
	
	/**
	 * Constructor for a complex number with a real and imaginary part.
	 * @param real the real part
	 * @param imag the imaginary part
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	/**
	 * Constructor for complex number with only a real part (imaginary part is 0).
	 * @param real the real part
	 */
	public Complex(double real) {
		this(real, 0.0);
	}
	
	/**
	 * Create and return a complex number that is the sum of this one
	 * and the parameter. Does not modify the existing complex numbers.
	 * 
	 * @param z the Complex number to add to this one.
	 * @return the sum of this and z, as a Complex number
	 */
	public Complex add(Complex z) {
		return new Complex(this.real+z.real, this.imag+z.imag);
	}
	
	/**
	 * Create and return a complex number that is the product of this one
	 * and the parameter. Does not modify the existing complex numbers.
	 * 
	 * @param z the Complex number to multiply by this one.
	 * @return the product of this and c, as a Complex number
	 */
	public Complex multiply(Complex z) {
		return new Complex(this.real*z.real-this.imag*z.imag, 
				this.real*z.imag+this.imag*z.real);
	}

	public Complex multiply(double d) {
		return new Complex(this.real*d, this.imag*d);
	}

	
	/**
	 * Return the real part of this complex number
	 */
	public double real() { return real; }
	
	/**
	 * Return the imaginary part of this complex number
	 */
	public double imag() { return imag; }
	
	/**
	 * Two complex numbers are equal if both the real and imaginary parts
	 * are the same.
	 * @return true if the parameter is Complex and has same value is this Complex.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj.getClass() != this.getClass()) return false;
		Complex z = (Complex) obj;
		return this.real==z.real && this.imag==z.imag;
	}
	
	/**
	 * Return a String representation of a complex number.
	 * There are several cases: 
	 * If the imaginary part is zero,
	 * toString returns the real part as a string, e.g. "4.0".
	 * If the real part is zero, returns the imaginary part followed by "i"
	 * as a string, e.g. "2.5i".
	 * If both real and imaginary parts are non-zero, then
	 * returns a string such as "2+3i" or "2-0.5i", with NO SPACE.
	 *
	 * @return String representation of the complex number
	 */
	@Override
	public String toString() {
		if (imag==0) return String.format("%g", real);
		if (real==0) return String.format("%gi", imag);
		if (imag > 0) return String.format("%g+%gi", real, imag);
		return String.format("%g%gi", real, imag);
	}
}
