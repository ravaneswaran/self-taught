package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.service.SensexService;
import rave.code.bse.web.service.TopDividendService;

@Controller
public class BSESensexController {

    @GetMapping("/bse/sensex")
    public ModelAndView sensex() {
        SensexService sensexService = new SensexService();
        WebPage webPage = sensexService.getPageModel();

        ModelAndView sensexModelAndView = new ModelAndView();
        sensexModelAndView.addObject("page", webPage);
        sensexModelAndView.setViewName("sensex");

        return sensexModelAndView;
    }
}
