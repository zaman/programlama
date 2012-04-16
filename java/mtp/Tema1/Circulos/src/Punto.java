
public class Punto {

	private int x;
	private int y;
	
	public Punto(int nuevoX, int nuevoY)
	{
		x = nuevoX;
		y = nuevoY;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}

	public void setX(int nuevoX)
	{
		x = nuevoX;
	}
	
	public void setY(int nuevoY)
	{
		y = nuevoY;
	}	
	
	public static double distancia(Punto a, Punto b)
	{
		return Math.sqrt(
				Math.pow(a.getX()-b.getX(), 2) + Math.pow(a.getY()-b.getY(), 2));
	}
	
	@Override
	public String toString()   
	{
		return "["+getX()+","+getY()+"]";
	}
}
