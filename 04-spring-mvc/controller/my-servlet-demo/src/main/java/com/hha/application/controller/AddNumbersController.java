package com.hha.application.controller;


import com.hha.application.view.AddNumbersView;
import com.hha.framework.controller.ControllerMapping;
import com.hha.framework.controller.IController;
import com.hha.framework.ds.ModelAndView;
import com.hha.framework.model.Model;
import com.hha.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;

@ControllerMapping("/add-numbers")
public class AddNumbersController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {

        Model model = new SimpleModel();
        int numberA = Integer.parseInt(req.getParameter("numberA"));
        int numberB = Integer.parseInt(req.getParameter("numberB"));

        model.set("numberA", String.valueOf(numberA));
        model.set("numberB", String.valueOf(numberB));
        model.set("result", String.valueOf(numberA + numberB));


        return new ModelAndView(
                model,
                new AddNumbersView()
        );
        
    }
}
