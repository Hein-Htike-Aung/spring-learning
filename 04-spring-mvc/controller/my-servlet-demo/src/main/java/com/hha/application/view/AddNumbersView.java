package com.hha.application.view;


import com.hha.framework.model.Model;
import com.hha.framework.view.View;

public class AddNumbersView implements View {

    @Override
    public String render(Model model) {

        return String.format(
                "Result of adding numberA = [%s] and numberB = [%s] is [%s]",
                model.get("numberA"), model.get("numberB"), model.get("result")
        );

    }
}
