package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.iccbxl.pid.model.TypeService;
import be.iccbxl.pid.model.Type;

@Controller
public class TypeController {
    @Autowired
    TypeService service;

    @GetMapping("/types")
    public String index2(Model model){
        List<Type> types = service.getAllTypes();
        model.addAttribute("types", types);
        model.addAttribute("title", "Liste des types");
        return "type/index";
    }

    @GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") String id){
        Type type = service.getType(id);
        
        model.addAttribute("type", type);
        model.addAttribute("title", "Fiche d'un type");

        return "type/show";
    }
}
