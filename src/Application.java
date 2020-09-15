import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class Application {

    public static void main(String[] args){
        //setup jade environment
        Profile myProfile=new ProfileImpl();
        Runtime myRuntime= Runtime.instance();
        ContainerController myContainer= myRuntime.createMainContainer(myProfile);

        try{
            //start agent controller (also an agent (rma)
            AgentController rma = myContainer.createNewAgent("rma","jade.tools.rma.rma",null);
            rma.start();

            //start SimpleAgent
            AgentController myAgent = myContainer.createNewAgent("Anne Tifa",SimpleAgent.class.getCanonicalName(),null);
            myAgent.start();

//            AgentController timerAgent=myContainer.createNewAgent("Timer",TimerAgent.class.getCanonicalName(),null);
//            timerAgent.start();

//            AgentController tickerAgent=myContainer.createNewAgent("Ticker",TickerAgent.class.getCanonicalName(),null);
//            tickerAgent.start();
        }
        catch (Exception e){
            System.out.println("Exception starting agent: "+e.toString());
        }

    }
}
