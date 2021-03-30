package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistService;

@RestController
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index(){
        StringBuilder content = new StringBuilder("<ul>");

        List<Artist> artists = service.getAllArtists();
        artists.forEach(artist -> 
            content.append("<li>"+artist+"</li>")
        );
        content.append("</ul>");
    
        return content.toString();
    }

}
