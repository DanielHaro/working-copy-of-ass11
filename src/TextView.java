import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextView extends JPanel implements MyPropertyChangeListener{
	
	private JTextField jtfRecLength;
	private JTextField jtfRecWidth;
	private Model model;

	public TextView() {
		setBackground(Color.GREEN);
		
		JLabel lblNewLabel = new JLabel("Length:");
		add(lblNewLabel);
		
		jtfRecLength = new JTextField();
		jtfRecLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sLen = jtfRecLength.getText().trim();
				int len = Integer.parseInt(sLen);
				jtfRecLength.setText("");
				model.setRecLength(len);
			}
		});
		add(jtfRecLength);
		jtfRecLength.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Width:");
		add(lblNewLabel_1);
		
		jtfRecWidth = new JTextField();
		jtfRecWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sWid = jtfRecWidth.getText().trim();
				int wid = Integer.parseInt(sWid);
				jtfRecWidth.setText("");
				model.setRecWidth(wid);
			}
		});
		add(jtfRecWidth);
		jtfRecWidth.setColumns(10);
		
	}
	
	//generate setter for model
	public void setModel(Model model) {
			
		//register with listener
		this.model = model;
		model.addMyPropertyChangeListener(this);
			
	}

	public void myPropertyChanged(MyPropertyChangeEvent ev) {
		
		if(ev.getPropertyName().equalsIgnoreCase("length")){ //if length property changed, set new value
			jtfRecLength.setText("" + ev.getNewValue());
		}
			
		else if(ev.getPropertyName().equalsIgnoreCase("width")){ //if width property changed, set new value
			jtfRecWidth.setText("" + ev.getNewValue());
		}
		
	}

}
