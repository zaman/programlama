import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class Ventana{

	private MiPanel panel;
	private JFrame aplicacion;
	public Ventana()
	{
		// creamos el objeto JFrame que representa la ventana
		aplicacion = new JFrame("Circulando");
		
		// creamos un panel
		panel = new MiPanel();		
		
		// accion a realizar cuando se cierra la ventana -> se finaliza la aplicacion
		aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
		// se añade el panel a la ventana
		aplicacion.add(panel);
		// establecemos las dimensiones de la ventana
		aplicacion.setSize(350, 350);
		// hacemos visible la ventana
		aplicacion.setVisible(true);
	}

	public void muestraCirculos(CirculoConCentro [] cirs)
	{
		//panel.circulos = cirs;
		panel.setCirculos(cirs);
		panel.repaint();
	}
	
}

class MiPanel extends JPanel 
{
	// esto evita un warning referido a clases serializables
	private static final long serialVersionUID = 1L;
	protected CirculoConCentro[] circulos = null;
	
	public void setCirculos(CirculoConCentro[] cirs){
		circulos = cirs;
	}
	
	private void muestraCirculo(String etiqueta, CirculoConCentro c, Graphics g)
	{
		int offset = 0;
		g.drawOval(
				(int)c.getCentro().getX()-(int)c.getRadio()+offset,
				(int)c.getCentro().getY()-(int)c.getRadio()+offset,
				2 * (int)c.getRadio(), 2 * (int)c.getRadio());
		g.drawString(etiqueta, c.getCentro().getX()-3, c.getCentro().getY()+4);
	}
	
	public void paintComponent(Graphics g)
	{
		Integer x2 = 0;
		super.paintComponent(g);
		if (circulos != null)
		for(CirculoConCentro c: circulos){
			muestraCirculo(x2.toString(),c,g);
			x2++;
		}		
	}
	
}
