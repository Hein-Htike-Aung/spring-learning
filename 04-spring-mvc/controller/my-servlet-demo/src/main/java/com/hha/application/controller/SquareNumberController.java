package com.hha.application.controller;


import com.hha.application.view.SquareNumberView;
import com.hha.framework.controller.ControllerMapping;
import com.hha.framework.controller.IController;
import com.hha.framework.ds.ModelAndView;
import com.hha.framework.model.Model;
import com.hha.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/square-number")
public class SquareNumberController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {

        Model model = new SimpleModel();
        int number = Integer.parseInt(req.getParameter("number"));
        int numberSquare = (int) Math.pow(number, 2);
        model.set("number", String.valueOf(number));
        model.set("numberSquare", String.valueOf(numberSquare));

        return new ModelAndView(
                model,
                new SquareNumberView()
        );

    }
}
