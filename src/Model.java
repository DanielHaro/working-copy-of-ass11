import java.util.Vector;

public class Model {

	private int recLength;
	private int recWidth;
	private Vector myPropertyChangeListeners = new Vector();
	
	//constructor
	public void Model(int l, int w){
		recLength = l;
		recWidth = w;
	}

	//generate getters and setters
	public int getRecLength() {
		return recLength;
	}

	public void setRecLength(int recLength) {
		MyPropertyChangeEvent ev = new MyPropertyChangeEvent("length", this.recLength, recLength); //create event
		fireMyPropertyChanged(ev); //call fire method
		this.recLength = recLength; //set recLength
	}

	public int getRecWidth() {
		return recWidth;
	}

	public void setRecWidth(int recWidth) {
		MyPropertyChangeEvent ev = new MyPropertyChangeEvent("width", this.recWidth, recWidth); //create event
		fireMyPropertyChanged(ev); //call fire method
		this.recWidth = recWidth; //set recWidth
	}
	
	public synchronized void addMyPropertyChangeListener(MyPropertyChangeListener l){
		if (!myPropertyChangeListeners.contains(l))
			myPropertyChangeListeners.addElement(l);
	}
	
	public synchronized void removeMyPropertyChangeListener(MyPropertyChangeListener l){
		if (myPropertyChangeListeners.contains(l))
			myPropertyChangeListeners.removeElement(l);
	}
	
	public synchronized void fireMyPropertyChanged(MyPropertyChangeEvent ev){
		for (int i = 0; i < myPropertyChangeListeners.size(); i++){
			((MyPropertyChangeListener)myPropertyChangeListeners.elementAt(i)).myPropertyChanged(ev);
		}
	}
	
}
