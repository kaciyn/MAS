package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class NamePrinterBehaviour extends TickerBehaviour  {
    public NamePrinterBehaviour(Agent a, long period) {
        super(a, period);
    }
    
    @Override
    protected void onTick() {
        System.out.println(myAgent.getLocalName());
        
    }
    
}




