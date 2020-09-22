package Agents;

import Behaviours.ThreeStepBehaviour;
import jade.core.Agent;

public class ThreeStepAgent extends Agent {
    protected void setup(){
        addBehaviour(new ThreeStepBehaviour(this));
    }
    
}
