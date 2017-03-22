package br.edu.ufcg.computacao.si1.controllers;

import br.edu.ufcg.computacao.si1.factories.AdvertisingFactory;
import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.forms.AdvertisingForm;
import br.edu.ufcg.computacao.si1.model.user.LoggedUser;
import br.edu.ufcg.computacao.si1.services.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by gersonsales on 16/03/17.
 */
@Controller
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @RequestMapping(value = "ad/list/advertising", method = RequestMethod.GET)
    public String listAdvertising() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(advertisingService.getAll());
        modelAndView.setViewName("ad/advertising_list");

        return modelAndView.getViewName();
    }

    @RequestMapping(value = "ad/add/advertising", method = RequestMethod.GET)
    public ModelAndView createNewAdvertising(LoggedUser loggedUser) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("types", loggedUser.getPostPermisions());

        modelAndView.setViewName("ad/advertising_register");

        return modelAndView;

    }

    @RequestMapping(value = "ad/add/advertising", method = RequestMethod.POST)
    public ModelAndView addNewAdvertising(LoggedUser loggedUser, @Valid AdvertisingForm advertisingForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return createNewAdvertising(loggedUser);
        }

        Advertising advertising= AdvertisingFactory.createNewAdvertising(advertisingForm);
        advertisingService.add(advertising);

        redirectAttributes.addFlashAttribute("message", "Message to show");//TODO

        return new ModelAndView("redirect:/ad/add/advertising");
    }

}
