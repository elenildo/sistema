package com.youtan.sistema.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.youtan.sistema.models.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("api/sistema")
public class SiteController {

    @GetMapping
    public ModelAndView index() throws JsonProcessingException {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Ravena");
        cliente.setEmail("ravena@email.com");
        ObjectMapper objectMapper = new ObjectMapper();

        return new ModelAndView("index")
                .addObject("cliente", objectMapper.writeValueAsString("Mensagem"));
    }
}
