import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class TimerAgent extends Agent{
int w=15;
public void setup(){
    //create new TickerBehaviour
    addBehaviour(new TickerBehaviour(this, 1000) {
        @Override
        //call onTick every 1000ms
        protected void onTick() {
            //countdown
            if (w>0){
                System.out.println(w+" seconds left");
                w--;
            }
            else {
                System.out.println("Bye!");
                myAgent.doDelete(); //delete agent
            }
        }
    });
}
}
