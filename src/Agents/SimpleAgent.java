package Agents;

import Behaviours.NamePrinterBehaviour;
import Behaviours.RandomTimeDeleteBehaviour;
import Utility.GetRandomNumber;
import jade.core.Agent;

public class SimpleAgent extends Agent {

    protected void setup(){
        System.out.println("Hello! Agent "+ getAID().getName()+" is ready.");
        
        addBehaviour(new NamePrinterBehaviour(this,10000));
        addBehaviour(new RandomTimeDeleteBehaviour(this, GetRandomNumber.getRandomNumber(60000,120000)));
    }


}

