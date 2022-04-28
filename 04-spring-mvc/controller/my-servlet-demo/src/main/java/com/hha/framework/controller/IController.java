package com.hha.framework.controller;


import com.hha.framework.ds.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface IController {

    ModelAndView handleRequest(HttpServletRequest req);
}
