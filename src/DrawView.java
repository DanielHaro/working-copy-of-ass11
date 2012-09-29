import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawView extends JPanel implements MyPropertyChangeListener, MouseListener, MouseMotionListener{

	private Model model;
	private int xCoor;
	private int yCoor;
	
	public DrawView() {
		setBackground(Color.YELLOW);
		//register with yourself, by passing "this", the mouse listener methods
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	//generate setter for model
	public void setModel(Model model) {
		//register with listener
		this.model = model;
		model.addMyPropertyChangeListener(this);	
	}
	
	public void myPropertyChanged(MyPropertyChangeEvent ev) {
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(Math.min(xCoor, model.getRecLength()+ xCoor), Math.min(yCoor, model.getRecWidth()+ yCoor), Math.abs(model.getRecLength()), Math.abs(model.getRecWidth()));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent ev) {
		//save original coordinates, when mouse is first pressed, as shared variables
		xCoor = ev.getX();
		yCoor = ev.getY();
		System.out.println(""+xCoor+","+yCoor);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent ev) {
		int newXCoor = ev.getX();
		int newYCoor = ev.getY();
		int length = newXCoor - xCoor;
		model.setRecLength(length);
		int width = newYCoor - yCoor;
		model.setRecWidth(width);
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
