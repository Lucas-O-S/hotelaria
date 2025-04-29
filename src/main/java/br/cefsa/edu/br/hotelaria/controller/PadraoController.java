/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefsa.edu.br.hotelaria.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.cefsa.edu.br.hotelaria.model.Padrao;
import br.cefsa.edu.br.hotelaria.service.PadraoService;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/hotelaria-fesa/padrao")
public class PadraoController {

    @Autowired
    private PadraoService padraoService;

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        List<Padrao> padroes = padraoService.findAll();

        return "/padrao/listar";
    }

    @GetMapping("/novo")
    public String inserir(Padrao padrao) {
        return "/padrao/inserir";
    }

    @PostMapping("/salvar")
    public String salvar(Padrao padrao) {
        padraoService.save(padrao);
        return "redirect:/hotelaria-fesa/padrao/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("padrao", padraoService.findById(id));
        return "/padrao/editar";
    }

    @PostMapping("/atualizar")
    public String atualizar(@Valid @ModelAttribute Padrao padrao, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("padrao", padrao);
            return "/padrao/editar";
        }
        padraoService.update(padrao);
        return "redirect:/hotelaria-fesa/padrao/listar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable UUID id, ModelMap model) {
        model.addAttribute("padrao", padraoService.findById(id).orElseThrow(() -> new RuntimeException("Padrão não encontrado")));
        return "/padrao/remover";
    }

    @PostMapping("/excluir/{id}")
    public String confirmarExclusao(@PathVariable UUID id, ModelMap model) {
        padraoService.deleteById(id);
        return "redirect:/hotelaria-fesa/padrao/listar";
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Padrao> getPadraoByNome(@PathVariable String nome) {
        Optional<Padrao> padrao = padraoService.findByNome(nome);
        return padrao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/carregar-dados")
    public String carregar() {

        List<Padrao> padroes = Arrays.asList(
                new Padrao("Standard", 1.2),
                new Padrao("Master", 1.4),
                new Padrao("Deluxe", 1.8),
                new Padrao("Executiva", 1.2)
        );

        for (Padrao padrao : padroes) {
            padraoService.save(padrao);
        }
        return "redirect:/hotelaria-fesa/padrao/listar";
    }

}
