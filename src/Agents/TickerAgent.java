package Agents;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.TickerBehaviour;

public class TickerAgent extends Agent {
    long t0 = System.currentTimeMillis();
    Behaviour loop;

    protected void setup() {
        loop = new TickerBehaviour(this, 300) {
            @Override
            protected void onTick() {
                //print elapsed time since launch
                System.out.println(System.currentTimeMillis() - t0 + ": " + myAgent.getLocalName());
            if (System.currentTimeMillis() - t0>=60000){
                System.out.println("Bye!");
                myAgent.doDelete(); //delete agent
            }
            }
        };
        addBehaviour(loop);
    }
}
