
public class Circulo {

	private double radio;
	
	public Circulo(double r)
	{
		radio = r;
	}
	
	public void setRadio(double r)
	{
		radio = r;
	}
	
	public double getRadio()
	{
		return radio;
	}
	
	public double perimetro()
	{
		return 2 * Math.PI * getRadio();
	}
	
	public double area()
	{
		return Math.PI * Math.pow(getRadio(), 2);
	}
}
