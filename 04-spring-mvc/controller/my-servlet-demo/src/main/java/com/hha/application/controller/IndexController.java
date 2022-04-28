package com.hha.application.controller;


import com.hha.application.view.IndexView;
import com.hha.framework.controller.ControllerMapping;
import com.hha.framework.controller.IController;
import com.hha.framework.ds.ModelAndView;
import com.hha.framework.model.SimpleModel;

import javax.servlet.http.HttpServletRequest;


@ControllerMapping("/")
public class IndexController implements IController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest req) {
        return new ModelAndView(
                new SimpleModel(),
                new IndexView()
        );

    }
}
