package br.edu.ufcg.computacao.si1.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by gersonsales on 20/03/17.
 */
@Controller
public class WebPagesController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/advertisement/list")
    public String getAdvertisementList() {
        return "ad/advertising_list";
    }

    @RequestMapping(value = "/advertisement/form")
    public String createNewAdvertisement() {
        return "ad/advertising_form";
    }

    @RequestMapping(value = "/user/form")
    public String createNewUser() {
        return "user/register_user";
    }

    @RequestMapping(value = "/user/list")
    public String getUserList() {
        return "user/user_list";
    }

}
