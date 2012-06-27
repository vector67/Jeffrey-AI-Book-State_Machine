package stateMachineMain;

import java.util.ArrayList;

public abstract class HSMBase {
	public action getAction(){
		return null;
	}
	public UpdateResult update(){
		UpdateResult result = new UpdateResult();
		ArrayList<action>resultaction = new ArrayList<action>();
		resultaction.add(getAction());
		result.actions = resultaction;
		result.transition = null;
		result.level =0;
		return result;
	}
	public abstract State[] getStates();
	public Transition[] getTransitions() {
		// TODO Auto-generated method stub
		return null;
	}
	public action getExitAction() {
		// TODO Auto-generated method stub
		return null;
	}
	public action getEntryAction() {
		// TODO Auto-generated method stub
		return null;
	}
}
