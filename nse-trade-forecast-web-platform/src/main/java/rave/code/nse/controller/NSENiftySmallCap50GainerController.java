package rave.code.nse.controller;

import rave.code.moneycontrol.model.MoneyControlGainerModel;
import rave.code.moneycontrol.parser.html.MoneyControlNSENiftySmallCap50GainerParser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class NSENiftySmallCap50GainerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MoneyControlNSENiftySmallCap50GainerParser moneyControlNSENiftySmallCap50GainerParser = new MoneyControlNSENiftySmallCap50GainerParser();
        List<MoneyControlGainerModel> moneyControlGainerModels =  moneyControlNSENiftySmallCap50GainerParser.parse();

        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("NSE_NIFTY_SMALL_CAP_50_GAINERS", moneyControlGainerModels);

        response.sendRedirect("");
    }
}