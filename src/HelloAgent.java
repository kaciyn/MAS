import jade.core.Agent;

public class HelloAgent extends Agent
{
    protected  void setup(){
        System.out.println("Hello! Agent"+getAID().getName()+" is ready.");
    }
}
