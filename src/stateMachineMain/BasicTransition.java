package stateMachineMain;

public class BasicTransition extends Transition {
	public int level;
	public boolean isTriggered;
	public State targetState;
	public State originState;
	public action myaction;
	@Override
	public int getLevel() {
		return level;
	}

	@Override
	public boolean isTriggered() {
		return isTriggered;
	}

	@Override
	public State getTargetState() {
		return targetState;
	}

	@Override
	public action getAction() {
		return myaction;
	}

	@Override
	public State getOriginState() {
		return originState;
	}

}
