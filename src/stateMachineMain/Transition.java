package stateMachineMain;

public abstract class Transition {
	public abstract int getLevel();
	public abstract boolean isTriggered();
	public abstract State getTargetState();
	public abstract State getOriginState();
	public abstract action getAction();

}
