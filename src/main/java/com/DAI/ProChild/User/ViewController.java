package com.DAI.ProChild.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    @RequestMapping(path = "/login")
    public String getLogin() throws Exception {
        return "Login.html";
    }

    @RequestMapping(path = "/complaint")
    public String getComplaint() throws Exception {
        return "DenunciaMenu.html";
    }
}
