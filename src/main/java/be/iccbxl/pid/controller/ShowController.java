package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.iccbxl.pid.model.ShowService;
import be.iccbxl.pid.model.Show;

@Controller
public class ShowController {
    @Autowired
    ShowService service;

    @GetMapping("/Shows")
    public String index2(Model model){
        List<Show> shows = service.getAllShows();
        
        model.addAttribute("shows", shows);
        model.addAttribute("title", "Liste des spectacles");
        
        return "show/index";
    }

    @GetMapping("/shows/{id}")
    public String show(Model model, @PathVariable("id") String id){
        Show show = service.getShow(id);
        
        model.addAttribute("show", show);
        model.addAttribute("title", "Fiche d'un spectacle");

        return "show/show";
    }
}
