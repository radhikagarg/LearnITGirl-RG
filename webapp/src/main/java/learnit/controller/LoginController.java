package learnit.controller;

import learnit.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printHello(LoginModel loginModel) {
        loginModel.setMessage("hello world");
        return new ModelAndView("login","pqr", loginModel);
    }
}