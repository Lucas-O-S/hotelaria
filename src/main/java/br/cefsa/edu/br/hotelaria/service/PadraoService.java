/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.cefsa.edu.br.hotelaria.service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cefsa.edu.br.hotelaria.model.Padrao;
import br.cefsa.edu.br.hotelaria.repository.PadraoRepository;

@Service
public class PadraoService {

    @Autowired
    private PadraoRepository padraoRepository;

    public List<Padrao> findAll() {
        return padraoRepository.findAll();
    }

    public Optional<Padrao> findById(UUID id) {
        return padraoRepository.findById(id);
    }

    public Padrao save(Padrao padrao) {
        return padraoRepository.save(padrao);
    }

    public void deleteById(UUID id) {
        padraoRepository.deleteById(id);
    }

    public Padrao update(Padrao padrao) {
        return padraoRepository.save(padrao);
    }

    public Optional<Padrao> findByNome(String nome) {
        return padraoRepository.findByNome(nome);
    }
}
