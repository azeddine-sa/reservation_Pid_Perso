package be.iccbxl.pid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.iccbxl.pid.model.RoleService;
import be.iccbxl.pid.model.Role;

@Controller
public class RoleController {
    @Autowired
    RoleService service;

    @GetMapping("/roles")
    public String index2(Model model) {
        List<Role> roles = service.getAllRoles();

        model.addAttribute("roles", roles);
        model.addAttribute("title", "Liste des roles");

        return "role/index";
    }

    @GetMapping("/roles/{id}")
    public String show(Model model, @PathVariable("id") String id) {
        Role role = service.getRole(id);

        model.addAttribute("role", role);
        model.addAttribute("title", "Fiche d'un role");

        return "role/show";
    }
}
