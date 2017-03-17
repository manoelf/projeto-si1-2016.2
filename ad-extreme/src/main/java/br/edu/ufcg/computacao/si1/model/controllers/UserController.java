package br.edu.ufcg.computacao.si1.model.controllers;

import br.edu.ufcg.computacao.si1.model.forms.UserForm;
import br.edu.ufcg.computacao.si1.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by manoel on 16/03/17.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registerUser", method = RequestMethod.GET)
    public ModelAndView getPageRegister(UserForm userForm) {
        ModelAndView model = new ModelAndView();
        model.setViewName("registerUser");

        return model;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView register(UserForm userForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return getPageRegister(userForm);
        }else if (userService.containsUserEmail(userForm.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "This email is being used");
        }
        userService.create(userForm.getName(), userForm.getEmail(), userForm.getPassword(), userForm.getPersonType());

        redirectAttributes.addFlashAttribute("message", "User has been registered successfully!");
        return new ModelAndView("redirect:/registerUser");

    }
}
