package metody;

public abstract class Unit {
	
	
	private int number;
	UnitState state;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public UnitState getState() {
		return state;
	}
	
	public void setState(UnitState state) {
		this.state = state;
	}
	
	
}
