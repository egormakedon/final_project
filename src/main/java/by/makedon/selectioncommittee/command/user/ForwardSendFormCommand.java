package by.makedon.selectioncommittee.command.user;

import by.makedon.selectioncommittee.command.Command;
import by.makedon.selectioncommittee.constant.Page;
import by.makedon.selectioncommittee.controller.Router;

import javax.servlet.http.HttpServletRequest;

public class ForwardSendFormCommand implements Command {

    @Override
    public Router execute(HttpServletRequest req) {
        Router router = new Router();
        router.setRoute(Router.RouteType.FORWARD);
        router.setPagePath(Page.SEND_FORM);
        return router;
    }
}