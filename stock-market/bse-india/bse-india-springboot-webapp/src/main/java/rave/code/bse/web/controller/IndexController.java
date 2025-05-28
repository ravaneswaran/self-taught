package rave.code.bse.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.setViewName("index.html");
        return indexModelAndView;
    }

}
