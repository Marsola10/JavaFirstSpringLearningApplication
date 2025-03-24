package com.marsola.first_spring_app.controller;

import com.marsola.first_spring_app.domain.User;
import com.marsola.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
// STATELESS- > a cada nova requisição, eu recebo todas as informações que eu preciso para fazer aquela funcionalidade que o cliente ta pedindo;
// STATEFULL -> O estado de cada cliente é mantido no servidor (pode manter salvo o login e senha do cliente (sempre ,manda um token para o cliente se identificar em toda requisação);
@Controller
@ResponseBody
@RequestMapping("/hello-world")
// post, get, delete, put, patch, options, head
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    /*public HelloWorldController (HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
}
     */




    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Marsola");

    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id, @RequestParam(value = "filter", defaultValue = "nenhum") String filter, @RequestBody User body){
        return "Hello World " + filter; // body.getName() + id (estava antes depois de "Hello World"
    }

}
