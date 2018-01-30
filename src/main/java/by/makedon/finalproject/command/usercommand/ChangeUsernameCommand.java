package by.makedon.finalproject.command.usercommand;

import by.makedon.finalproject.command.Command;
import by.makedon.finalproject.constant.LoginState;
import by.makedon.finalproject.constant.PageConstant;
import by.makedon.finalproject.controller.Router;
import by.makedon.finalproject.exception.LogicException;
import by.makedon.finalproject.logic.userlogic.ChangeUsernameLogic;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeUsernameCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ChangeUsernameCommand.class);
    private static final String NEW_USERNAME = "newusername";
    private static final String USERNAME = "username";
    private static final String LOGIN = "login";
    private ChangeUsernameLogic logic;

    public ChangeUsernameCommand(ChangeUsernameLogic logic) {
        this.logic = logic;
    }

    @Override
    public Router execute(HttpServletRequest req) {
        String usernameValue = req.getParameter(USERNAME);
        String newUsernameValue = req.getParameter(NEW_USERNAME);

        Router router = new Router();
        router.setRoute(Router.RouteType.REDIRECT);

        try {
            if (logic.doAction(usernameValue, newUsernameValue)) {
                HttpSession session = req.getSession();
                String loginState = (String) session.getAttribute(LOGIN);
                if (loginState != null && loginState.equals(LoginState.TRUE)) {
                    session.removeAttribute(USERNAME);
                    session.setAttribute(USERNAME, newUsernameValue);
                }
                router.setPagePath(PageConstant.MESSAGE_PAGE + "?message=username changed successfully");
            } else {
                router.setPagePath(PageConstant.MESSAGE_PAGE + "?message=user was deleted from the system");
            }
        } catch (LogicException e) {
            LOGGER.log(Level.ERROR, e);
            router.setPagePath(PageConstant.MESSAGE_PAGE + "?message=" + e);
        }
        return router;
    }
}