
package Agents;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.FSMBehaviour;

public class MeAsAFSMAgent extends Agent
{
    // i am sorry for these State names
    private static final String AWAKE = "I awake";
    private static final String ASLEEP = "I sleep";
    private static final String EATING = "I'm gonna munch, I'm gonna CRUNCH";
    private static final String DEAD = "boy i die!!! shit boy ";
    
    protected void setup() {
        FSMBehaviour fsm = new FSMBehaviour(this)
        {
            public int onEnd() {
                System.out.println("FSM behaviour completed.");
                myAgent.doDelete();
                return super.onEnd();
            }
        };
        
        //register states, min inclusive max exclusive
        fsm.registerFirstState(new RandomGenerator(0,3),AWAKE);
        fsm.registerState(new RandomGenerator(4,6),ASLEEP);
        fsm.registerState(new RandomGenerator(7,8),EATING);
        fsm.registerLastState(new NamePrinter(),DEAD);
    
        // Register the transitions
        fsm.registerTransition(AWAKE, AWAKE,0);
        fsm.registerTransition(AWAKE, ASLEEP, 1);
        fsm.registerTransition(AWAKE, EATING, 2);
        fsm.registerTransition(AWAKE, DEAD, 3);
        fsm.registerTransition(ASLEEP, AWAKE,4);
        fsm.registerTransition(ASLEEP, AWAKE, 5);
        fsm.registerTransition(ASLEEP, DEAD, 6);
        fsm.registerTransition(EATING, AWAKE, 7);
        fsm.registerTransition(EATING, DEAD, 8);
    
        addBehaviour(fsm);
    
    }
    
    /**
     * Inner class NamePrinter.
     * This behaviour just prints its name
     */
    private class NamePrinter extends OneShotBehaviour
    {
        public void action() {
            System.out.println("Executing behaviour " + getBehaviourName());
        }
    }
    
    /**
     * Inner class RandomGenerator.
     * This behaviour prints its name and exits with a random value
     * between 0 and a given integer value
     */
    private class RandomGenerator extends NamePrinter
    {
        private int minExitValue;
        private int maxExitValue;
        private int exitValue;
        
        private RandomGenerator(int min,int max) {
            super();
            minExitValue=min;
            maxExitValue = max;
        }
        
        public void action() {
            System.out.println("Executing behaviour " + getBehaviourName());
            exitValue = (int) (Math.random() * (maxExitValue - minExitValue + 1) + minExitValue);
            System.out.println("Exit value is " + exitValue);
        }
        
        public int onEnd() {
            return exitValue;
        }
    }
}


