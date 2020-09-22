import Agents.SimpleAgent;
import Utility.ReturnRandomAgentName;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class Application {
    
    public static void main(String[] args) {
        //setup jade environment
        Profile myProfile = new ProfileImpl();
        Runtime myRuntime = Runtime.instance();
        ContainerController myContainer = myRuntime.createMainContainer(myProfile);
        
        try {
            //start agent controller (also an agent (rma)
            AgentController rma = myContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();

//            AgentController threeAgent = myContainer.createNewAgent("13step", Agents.ThreeStepAgent.class.getCanonicalName(), null);
//            threeAgent.start();
//

//
//            AgentController sequentialAgent = myContainer.createNewAgent("sequential", Agents.SequentialAgent.class.getCanonicalName(), null);
//            sequentialAgent.start();

//            for (int i = 0; i < 10; i++) {
//                AgentController newAgent = myContainer.createNewAgent(ReturnRandomAgentName.returnRandomAgentName(), SimpleAgent.class.getCanonicalName(), null);
//                newAgent.start();
//            }
            
            AgentController timeAgent = myContainer.createNewAgent("time", Agents.TimeAgent.class.getCanonicalName(), null);
            timeAgent.start();
            
            
        } catch (Exception e) {
            System.out.println("Exception starting agent: " + e.toString());
            e.printStackTrace();
            
        }
        
    }
    
    
}
