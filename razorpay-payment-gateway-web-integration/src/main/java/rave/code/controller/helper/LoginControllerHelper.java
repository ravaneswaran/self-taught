package rave.code.controller.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.NotImplementedException;

import rave.code.controller.RazorPayController;
import rave.code.models.User;
import rave.code.service.local.UserLocalService;

public class LoginControllerHelper extends RazorPayController {
	
	private static final long serialVersionUID = 1L;

    @Override
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) {
        throw new NotImplementedException("'doprocess()' method should be overridden...");
    }

    protected User login(String emailId, String password){
        return UserLocalService.fetchUserBy(emailId, password);
    }
}
