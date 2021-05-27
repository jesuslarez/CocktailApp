package commands;

import entities.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesus Larez
 */
public class CmdViewBar extends FrontCommand {

    @Override
    public void process() {
        HttpSession session = request.getSession(true);
        String barName = (String) request.getParameter("barName");
        ArrayList<Bar> barList = (ArrayList<Bar>) session.getAttribute("barList");
        for (Bar bar : barList) {
            if (bar.getName().equals(barName)) {
                session.setAttribute("bar", bar);
            }
        }
        forward("/view_bar.jsp");
    }
}
