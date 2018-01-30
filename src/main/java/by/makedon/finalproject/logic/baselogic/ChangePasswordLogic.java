package by.makedon.finalproject.logic.baselogic;

import by.makedon.finalproject.dao.basedao.ChangePasswordDAO;
import by.makedon.finalproject.dao.basedao.BaseDAO;
import by.makedon.finalproject.entity.User;
import by.makedon.finalproject.exception.DAOException;
import by.makedon.finalproject.validator.UserValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChangePasswordLogic {
    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordLogic.class);
    private static final String ERROR_MESSAGE = "input error";

    public String doAction(String usernameValue, String password1Value, String password2Value) {
        if (!(UserValidator.validatePassword(password1Value)&& UserValidator.arePasswordsEqual(password1Value, password2Value))) {
            return ERROR_MESSAGE;
        }
        BaseDAO dao = ChangePasswordDAO.getInstance();
        String result;
        try {
            User user = new User();
            user.setUsernameValue(usernameValue);
            user.setPasswordValue(password1Value);
            dao.changePassword(user);
            result = "password changed successfully";
        } catch (DAOException e) {
            LOGGER.log(Level.ERROR, e);
            result = e.getMessage();
        }
        return result;
    }
}