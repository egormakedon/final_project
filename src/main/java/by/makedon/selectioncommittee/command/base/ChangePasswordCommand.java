package by.makedon.selectioncommittee.command.base;

import by.makedon.selectioncommittee.command.Command;
import by.makedon.selectioncommittee.constant.Page;
import by.makedon.selectioncommittee.controller.Router;
import by.makedon.selectioncommittee.exception.LogicException;
import by.makedon.selectioncommittee.logic.Logic;
import org.apache.logging.log4j.Level;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ChangePasswordCommand implements Command {
    private static final String USERNAME = "username";
    private static final String PASSWORD1 = "password1";
    private static final String PASSWORD2 = "password2";

    private Logic logic;

    public ChangePasswordCommand(Logic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest req) {
        String usernameValue = req.getParameter(USERNAME);
        String password1Value = req.getParameter(PASSWORD1);
        String password2Value = req.getParameter(PASSWORD2);

        List<String> parameters = new ArrayList<String>();
        parameters.add(usernameValue);
        parameters.add(password1Value);
        parameters.add(password2Value);

        Router router = new Router();
        router.setRoute(Router.RouteType.REDIRECT);
        try {
            logic.doAction(parameters);
            router.setPagePath(Page.MESSAGE + "?message=password changed successfully");
        } catch (LogicException e) {
            LOGGER.log(Level.ERROR, e);
            router.setPagePath(Page.MESSAGE + "?message=" + e.getMessage());
        }
        return router;
    }
}