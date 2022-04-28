package com.hha.application.view;


import com.hha.framework.model.Model;
import com.hha.framework.view.View;

public class SquareNumberView implements View {

    @Override
    public String render(Model model) {
        
        return String.format(
                "Square number of [%s] is [%s]",
                model.get("number"), model.get("numberSquare")
        );

    }
}
