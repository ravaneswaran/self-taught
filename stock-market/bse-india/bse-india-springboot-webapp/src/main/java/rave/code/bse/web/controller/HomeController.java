package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.model.Page;
import rave.code.bse.web.service.Active100Service;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {
        Active100Service active100Service = new Active100Service();
        Page active100Page = active100Service.getPage();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("active_100");

        return indexModelAndView;
    }
}
