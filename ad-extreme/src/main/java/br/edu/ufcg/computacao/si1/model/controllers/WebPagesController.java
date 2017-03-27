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

    @RequestMapping(value = "/html/footer")
    public String footer() {
        return "html/footer";
    }

    @RequestMapping(value = "/html/header")
    public String header() {
        return "html/header";
    }

    @RequestMapping(value = "/advertisement/list")
    public String getAdvertisementList() {
        return "ad/advertising_list";
    }

    @RequestMapping(value = "/advertisement/form")
    public String createNewAdvertisement() {
        return "ad/advertising_form";
    }

    @RequestMapping(value = "/register")
    public String createNewUser() {
        return "register_user";
    }

    @RequestMapping(value = "/user/list")
    public String getUserList() {
        return "user/user_list";
    }

    @RequestMapping(value = "/user/login")
    public String userLogin() {
        return "user/user_login";
    }


}
