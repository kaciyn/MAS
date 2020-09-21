import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.core.Runtime;

public class Application
{

    public static void main(String[] args)
    {
        //setup jade environment
        Profile myProfile = new ProfileImpl();
        Runtime myRuntime = Runtime.instance();
        ContainerController myContainer = myRuntime.createMainContainer(myProfile);

        try {
            //start agent controller (also an agent (rma)
            AgentController rma = myContainer.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();

//ok well it is just not liking this
            AgentController threeAgent = myContainer.createNewAgent("13step", ThreeStepAgent.class.getCanonicalName(), null);
            threeAgent.start();
    
//            AgentController threeVerbatimAgent = myContainer.createNewAgent("13vstep", ThreeStepVerbatim.class.getCanonicalName(), null);
//            threeAgent.start();


            
        } catch (Exception e) {
            System.out.println("Exception starting agent: " + e.toString());
            e.printStackTrace();
    
        }

    }
}
