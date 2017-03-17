package br.edu.ufcg.computacao.si1.model.controllers;

import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.services.UserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by manoel on 16/03/17.
 */
public class UserController {

    private UserService userService;

    public ModelAndView getPageRegister(UserForm userForm) {
        ModelAndView model = new ModelAndView();
        model.setViewName("register");

        return model;
    }

    public ModelAndView register(UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return getPageRegister(userForm);
        }
        if (userService.containsUserEmail(userForm.getEmail())) {

        }
        return null;
    }
}
