package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.WakerBehaviour;


public class RandomTimeDeleteBehaviour extends WakerBehaviour {
    
    public RandomTimeDeleteBehaviour(Agent a, long timeout) {
        super(a, timeout);
    }
    
    @Override
    protected void onWake() {
//        super.onWake();
        System.out.println("Deleting "+myAgent.getLocalName());
    
        myAgent.doDelete();
    }
}




