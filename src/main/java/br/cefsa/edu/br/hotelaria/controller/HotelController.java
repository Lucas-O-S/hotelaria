/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.br.hotelaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/hotelaria-fesa")
public class HotelController {

    @GetMapping({"", "/", "/home", "/inicio"})
    public String principal() {
        return "/index";
    }

    @GetMapping("/acomodacoes")
    public String acomodacoes() {
        return "/hotel/acomodacoes";
    }

    @GetMapping("/bares")
    public String bares() {
        return "/hotel/bares";
    }

    @GetMapping("/lazer/externa")
    public String lazerExterno() {
        return "/hotel/area-lazer-externa";
    }

    @GetMapping("/lazer/interna")
    public String lazerInterno() {
        return "/hotel/area-lazer-interna";
    }

    @GetMapping("/fitness")
    public String fitness() {
        return "/hotel/area-fitness";
    }

    @GetMapping("/business-recepcao")
    public String recepacao() {
        return "/hotel/business-recepcao";
    }

    @GetMapping("/business-salas-reuniao")
    public String business() {
        return "/hotel/business-salas-reuniao";
    }

    @GetMapping("/restaurante")
    public String restaurante() {
        return "/hotel/restaurante";
    }

    @GetMapping("/spa")
    public String spa() {
        return "/hotel/area-spa-relaxamento";
    }
    
    @GetMapping("/business-teatros")
    public String teatros() {
        return "/hotel/business-teatros";
    }
}
