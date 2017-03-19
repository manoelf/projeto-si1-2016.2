package br.edu.ufcg.computacao.si1.model.controllers;

import br.edu.ufcg.computacao.si1.model.advertising.Advertising;
import br.edu.ufcg.computacao.si1.model.factories.AdvertisingFactory;
import br.edu.ufcg.computacao.si1.model.forms.AdvertisingForm;
import br.edu.ufcg.computacao.si1.model.services.AdvertisingService;
import br.edu.ufcg.computacao.si1.model.user.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.ws.rs.POST;

/**
 * Created by gersonsales on 16/03/17.
 */
@Controller
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @RequestMapping(value = "ad/list/advertising", method = RequestMethod.POST)
    public ModelAndView listAdvertising() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(advertisingService.getAll());
        modelAndView.setViewName("ad/list_advertising");

        return modelAndView;
    }

    @RequestMapping(value = "ad/add/advertising", method = RequestMethod.GET)
    public ModelAndView createNewAdvertising(LoggedUser loggedUser) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("types", loggedUser.getPostPermisions());

        modelAndView.setViewName("ad/register_advertising");

        return modelAndView;
    }

    @RequestMapping(value = "ad/add/advertising", method = RequestMethod.POST)
    public ModelAndView addNewAdvertising(@Valid AdvertisingForm advertisingForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return createNewAdvertising(null);//TODO
        }

        Advertising advertising= AdvertisingFactory.createNewAdvertising(advertisingForm);
        advertisingService.add(advertising);

        redirectAttributes.addFlashAttribute("message", "Message to show");

        return new ModelAndView("redirect:/ad/add/advertising");
    }

}
