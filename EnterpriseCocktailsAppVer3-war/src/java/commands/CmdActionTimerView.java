package commands;

/**
 *
 * @author Jesus Larez
 */
public class CmdActionTimerView extends FrontCommand{

    @Override
    public void process() {
        /*TO-DO 
        Get action timer results to show in JSP page
        */
        
        forward("/action_timer.jsp");
    }
}
