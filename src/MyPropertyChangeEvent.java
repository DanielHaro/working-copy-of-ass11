
public class MyPropertyChangeEvent {

	private String propertyName;
	private int oldValue;
	private int newValue;
	
	//constructor
	public MyPropertyChangeEvent(String pn, int ov, int nv){
		propertyName = pn;
		oldValue = ov;
		newValue = nv;
	}

	//generate getters
	public String getPropertyName() {
		return propertyName;
	}

	public int getOldValue() {
		return oldValue;
	}

	public int getNewValue() {
		return newValue;
	}
	
}
