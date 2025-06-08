package com.ecoalert.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecoalert.entity.Ocorrencia;
import com.ecoalert.service.OcorrenciaService;

@RestController
@RequestMapping("/api/ocorrencias")
public class OcorrenciaController {
    private OcorrenciaService ocorrenciaService;

    public OcorrenciaController(OcorrenciaService ocorrenciaService){
        this.ocorrenciaService = ocorrenciaService;
    }

    @PostMapping
    public Ocorrencia registOcorrencia(@RequestBody Ocorrencia ocorrencia){
        return ocorrenciaService.registrar(ocorrencia);
    }

    @GetMapping
    public List<Ocorrencia> listarOcorrencias(){
        return ocorrenciaService.listarTodas();
    }

    @PutMapping("/{id}/status")
    public Ocorrencia atualizarStatus(@PathVariable Long id, @RequestParam String status) {
        return ocorrenciaService.atualizarStatus(id, status);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        ocorrenciaService.deletar(id);
    }

}
