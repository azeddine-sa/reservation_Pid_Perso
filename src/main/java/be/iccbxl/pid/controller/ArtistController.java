package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistService;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index(Model model){
        List<Artist> artists = service.getAllArtists();

        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");       
        
        return "artist/index";
    }

}
