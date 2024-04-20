package states;

public abstract class State {

	private static State currentState = null;
	
	
	//GETTER
	public static State getCurrentState() {
		return currentState;
	}
	
	//SETTER
	public static void changeState(State newState) {
		currentState = newState;
	}
	
	public abstract void update();
	public abstract void draw();
	
}
