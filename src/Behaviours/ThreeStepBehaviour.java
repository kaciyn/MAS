package Behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class ThreeStepBehaviour extends CyclicBehaviour {
    private int step = 1;
    private int result = 0;
//    private boolean finished = false;
    //no need with cyclic
    
    
    public ThreeStepBehaviour(Agent a) {
        //call parent constructor to set myAgent reference
        super(a);
    }
    
    @Override
    public void action() {
        switch (step) {
            case 1:
                result += 10;
                System.out.println(result);
                step++;
                break;
            case 2:
                result += 100;
                System.out.println(result);
                step++;
                break;
            case 3:
                result += 200;
                System.out.println(result);
                reset();
                break;
        }
    }
    
    //no need with cyclic
//    @Override
//    public int onEnd() {
//        System.out.println("Terminating behaviour");
//        reset(); //need to call before adding behaviour again
//        myAgent.addBehaviour(this);//add behaviour back to queue
//        return 0;
//    }
    
    @Override
    public void reset() {
        step = 1;
        result = 0;
    }
//no need with cyclic
//    @Override
//    public boolean done(){
//        return finished;
//    }
    
    
}

