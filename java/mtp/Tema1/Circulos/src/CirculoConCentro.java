
public class CirculoConCentro extends Circulo{

	private Punto centro;
	
	public CirculoConCentro(int x, int y, double r)
	{
		super(r);
		centro = new Punto(x,y);
	}
	
	public Punto getCentro()
	{
		return centro;
	}
	
	void setCentro(int x, int y)
	{
		centro.setX(x);
		centro.setY(y);
	}
	
	void setCentro(Punto p)
	{
		centro = p;
	}
	
	public static boolean solapa(CirculoConCentro c1, CirculoConCentro c2)
	{
		double d = Punto.distancia(c1.getCentro(), c2.getCentro());
		System.out.printf("distancia %f SumaRadios %f\n", d,(c1.getRadio() + c2.getRadio()) );
		return  d < (c1.getRadio() + c2.getRadio()); 
				
	}
	
	public void absorbe(CirculoConCentro c)
	{
		double sup1 = this.area();
		double sup2 = c.area();

		// Calculamos la distancia entre los centros
		double DeltaX = c.getCentro().getX() - this.getCentro().getX();
		double DeltaY = c.getCentro().getY() - this.getCentro().getY();
		double D = Math.sqrt(Math.pow(DeltaX, 2)+Math.pow(DeltaY,2));
		
		// Calculamos la distancia d1 desde el centro actual al nuevo centro y el desplazamiento en X e Y
		double d1 = D*sup2/(sup1+sup2);
		int x = (int)(d1*DeltaX/D);
		int y = (int)(d1*DeltaY/D);
		
		// Calculamos el nuevo centro del circulo
		setCentro(getCentro().getX()+x, getCentro().getY()+y);
		
		// Calculamos el nuevo radio
		double sup = sup1 + sup2; //nueva superficie
		int newRadio = (int)(Math.sqrt(sup/Math.PI));
		setRadio(newRadio);

	
		// anulamos el circulo absorbido
		c.setCentro(new Punto(0,0));
		c.setRadio(0);
		
	}
	
	@Override
	public String toString()   
	{
		return "("+getCentro()+"|"+getRadio()+")";
	}
}
