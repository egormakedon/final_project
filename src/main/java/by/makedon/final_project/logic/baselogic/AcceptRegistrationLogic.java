package by.makedon.final_project.logic.baselogic;

import by.makedon.final_project.dao.basedao.BaseDAO;
import by.makedon.final_project.dao.basedao.RegistrationDAO;
import by.makedon.final_project.entity.User;
import by.makedon.final_project.exception.DAOException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AcceptRegistrationLogic {
    private static final Logger LOGGER = LogManager.getLogger(AcceptRegistrationLogic.class);
    public String doAction(String emailValue, String usernameValue, String password) {
        BaseDAO dao = RegistrationDAO.getInstance();
        try {
            User user = new User();
            user.setEmailValue(emailValue);
            user.setUsernameValue(usernameValue);
            user.setPasswordValue(password);
            dao.addUser(user);
            return usernameValue + " register successfully";
        } catch (DAOException e) {
            LOGGER.log(Level.ERROR, e);
            return e.getMessage();
        }
    }
}
