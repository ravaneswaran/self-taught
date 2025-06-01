package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.service.SmallCapGainerService;
import rave.code.bse.web.service.TopDividendService;

@Controller
public class BSEInvestorsLoungeController {

    @GetMapping("/bse/top-dividend")
    public ModelAndView bseTopDividend() {
        TopDividendService topDividendService = new TopDividendService();
        WebPage webPage = topDividendService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("top_dividend");

        return indexModelAndView;
    }

    @GetMapping("/bse/small-cap-gainers")
    public ModelAndView bseSmallCapGainers() {
        SmallCapGainerService smallCapGainerService = new SmallCapGainerService();
        WebPage webPage = smallCapGainerService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", webPage);
        indexModelAndView.setViewName("small_cap_gainers");

        return indexModelAndView;
    }
}
