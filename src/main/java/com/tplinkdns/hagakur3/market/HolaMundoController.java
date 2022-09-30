package com.tplinkdns.hagakur3.market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludar")
public class HolaMundoController {

    @GetMapping("/hi")
    public String saludar(){
        return "Nunca dejes de ser mejor cada día 🤓";
    }
}
