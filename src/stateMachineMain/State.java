package stateMachineMain;

public abstract class State extends HSMBase{
	public State[] getStates(){
		return new State[]{this};
	}
	public abstract action getAction();
	public abstract action getEntryAction();
	public abstract action getExitAction();
	public abstract HierachicalStateMachine getParent();
	public abstract Transition[] getTransitions();
}
