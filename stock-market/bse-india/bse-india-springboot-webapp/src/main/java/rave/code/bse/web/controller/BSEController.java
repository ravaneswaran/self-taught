package rave.code.bse.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import rave.code.bse.web.model.page.PriceShockersWebPage;
import rave.code.bse.web.model.page.WebPage;
import rave.code.bse.web.service.Active100Service;
import rave.code.bse.web.service.Active200Service;
import rave.code.bse.web.service.Active500Service;
import rave.code.bse.web.service.PriceShockersService;

@Controller
public class BSEController {

    @GetMapping("/bse")
    public ModelAndView home() {
        return this.bseActive100();
    }

    @GetMapping("/bse/active-100")
    public ModelAndView bseActive100() {
        Active100Service active100Service = new Active100Service();
        WebPage active100Page = active100Service.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active100Page);
        indexModelAndView.setViewName("active_100");

        return indexModelAndView;
    }

    @GetMapping("/bse/active-200")
    public ModelAndView bseActive200() {
        Active200Service active200Service = new Active200Service();
        WebPage active200Page = active200Service.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active200Page);
        indexModelAndView.setViewName("active_200");

        return indexModelAndView;
    }

    @GetMapping("/bse/active-500")
    public ModelAndView bseActive500() {
        Active500Service active500Service = new Active500Service();
        WebPage active500Page = active500Service.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", active500Page);
        indexModelAndView.setViewName("active_500");

        return indexModelAndView;
    }

    @GetMapping("/bse/price-shockers")
    public ModelAndView bsePriceShockers() {
        PriceShockersService priceShockersService = new PriceShockersService();
        PriceShockersWebPage priceShockersWebPage = priceShockersService.getPageModel();

        ModelAndView indexModelAndView = new ModelAndView();
        indexModelAndView.addObject("page", priceShockersWebPage);
        indexModelAndView.setViewName("price_shockers");

        return indexModelAndView;
    }
}
