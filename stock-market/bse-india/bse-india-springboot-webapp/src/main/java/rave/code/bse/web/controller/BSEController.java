package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.model.Page;
import rave.code.bse.web.service.Active100Service;

@Controller
public class BSEController {

    @GetMapping("/")
    public ModelAndView home() {
        return this.bseActive100();
    }

    @GetMapping("/bse-active-100")
    public ModelAndView bseActive100() {
        Active100Service active100Service = new Active100Service();
        Page active100Page = active100Service.getPage();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("active_100");

        return indexModelAndView;
    }

    @GetMapping("/bse-active-200")
    public ModelAndView bseActive200() {
        Active100Service active100Service = new Active100Service();
        Page active100Page = active100Service.getPage();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("active_200");

        return indexModelAndView;
    }

    @GetMapping("/bse-active-500")
    public ModelAndView bseActive500() {
        Active100Service active100Service = new Active100Service();
        Page active100Page = active100Service.getPage();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("active_500");

        return indexModelAndView;
    }

    @GetMapping("/bse-price-shockers")
    public ModelAndView bsePriceShockers() {
        Active100Service active100Service = new Active100Service();
        Page active100Page = active100Service.getPage();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("price_shockers");

        return indexModelAndView;
    }
}
