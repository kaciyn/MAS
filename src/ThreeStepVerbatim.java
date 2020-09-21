import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class ThreeStepVerbatim extends Behaviour {
    private int step = 1;
    private int result = 0;
    private boolean finished = false;
    
    public ThreeStepVerbatim(Agent a) { //call the parent constructor , //to set the myAgent reference
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
                finished = true;
                break;
        }
    }
    
    @Override
    public boolean done() {
        return finished;
    }
    
    @Override
    public int onEnd() {
        System.out.println("Terminating behaviour");
        return 0;
    }
}