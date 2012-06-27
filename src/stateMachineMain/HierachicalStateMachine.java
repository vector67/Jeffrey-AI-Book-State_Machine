package stateMachineMain;

import java.util.ArrayList;

public class HierachicalStateMachine extends HSMBase {
	State[] states;
	State initialState;
	HSMBase currentState = initialState;
	private HierachicalStateMachine parent;
	public State[] getStates(){
		if(currentState !=null){
			return currentState.getStates();
		}else{
			return null;
		}
	}
	public UpdateResult update(){
		State targetState;
		if (currentState==null){
			currentState = initialState;
			return null; // Put currentState.getEntryAction()
		}
		
		// Try to find a transition in the current state
		Transition triggeredTransition= null;
		for(Transition transition:currentState.getTransitions()){
			if (transition.isTriggered()){
				triggeredTransition = transition;
				break;
			}
		}
		// If we've found one, make a result structure for it
		UpdateResult result = new UpdateResult();
		if(triggeredTransition!=null){
			result.actions = null;
			result.transition = triggeredTransition;
			result.level = triggeredTransition.getLevel();
		}else {  //Otherwise recurse down for a result
			result = currentState.update();
		}
		// Check if the result contains a transition
		if  (result.transition!=null){
			// Act based on its level
			if(result.level==0){
				// Its on our level: honor it
				targetState = result.transition.getTargetState();
				result.actions.add(currentState.getExitAction());
				result.actions.add(result.transition.getAction());
				result.actions.add(targetState.getEntryAction());
				currentState = targetState;
				result.actions.add(getAction());
				result.transition = null;
			}else if(result.level>0){
				result.actions.add(currentState.getExitAction());
				currentState = null;
				result.level -=1;
			} else{
				targetState = result.transition.getTargetState();
				HierachicalStateMachine targetMachine = targetState.getParent();
				result.actions.add(result.transition.getAction());
				result.actions.addAll(targetMachine.updateDown(targetState, -result.level));
				result.transition = null;
			}
		}else {
			result.actions.add(getAction());
		}
		return result;
	}
	public ArrayList<action> updateDown(HSMBase state, int level){
		ArrayList<action> actions;
		if(level>0){
			actions = parent.updateDown(this,level-1);
		}else {
			actions = new ArrayList<action>();
		}
		if(currentState!=null){
			actions.add(currentState.getExitAction());
		}
		currentState = state;
		actions.add(state.getEntryAction());
		return actions;
	}
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

















