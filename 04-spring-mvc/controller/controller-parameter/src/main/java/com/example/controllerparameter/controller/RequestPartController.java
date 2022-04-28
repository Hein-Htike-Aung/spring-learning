package com.example.controllerparameter.controller;

import com.example.controllerparameter.storage.InMemoryStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RequestPartController {

    @Autowired
    private InMemoryStorage inMemoryStorage;


    // localhost:8080/requestPart01/gallery -> in browser
    @GetMapping("/requestPart01/gallery")
    public String requestPart01(
            Model model
    ) {
        model.addAttribute("imageNames", inMemoryStorage.getNames());

        return "gallery";
    }

    // Load image
    @GetMapping(value = "/requestPart03/gallery/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] requestPart03(
            @PathVariable String imageName
    ) {

        return inMemoryStorage.getByName(imageName);
    }

    // Store image in InMemoryStorage
    @PostMapping("/requestPart02/gallery")
    public String requestPart02(
            @RequestPart("file") MultipartFile file
    ) throws IOException {

        inMemoryStorage.store(file.getOriginalFilename(), file.getBytes());

        return "redirect:/requestPart01/gallery";
    }

}
