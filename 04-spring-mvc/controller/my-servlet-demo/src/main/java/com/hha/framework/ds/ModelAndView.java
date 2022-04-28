package com.hha.framework.ds;

import com.hha.framework.model.Model;
import com.hha.framework.view.View;

public class ModelAndView {

    private Model model;
    private View view;


    public ModelAndView(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }
}
