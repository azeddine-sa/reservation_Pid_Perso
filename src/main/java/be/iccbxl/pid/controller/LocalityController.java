package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.iccbxl.pid.model.LocalityService;
import be.iccbxl.pid.model.Locality;

@Controller
public class LocalityController {
    @Autowired
    LocalityService service;

    @GetMapping("/localities")
    public String index2(Model model) {
        List<Locality> localities = service.getAllLocalities();

        model.addAttribute("localities", localities);
        model.addAttribute("title", "Liste des localités");

        return "locality/index";
    }

    @GetMapping("/localities/{id}")
    public String show(Model model, @PathVariable("id") String id){
        Locality locality = service.getLocality(id);

        model.addAttribute("locality", locality);
        model.addAttribute("Title", "Fiche d'une localité");

        return "locality/show";
    }

}
