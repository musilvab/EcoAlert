package com.ecoalert.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecoalert.entity.Ocorrencia;
import com.ecoalert.repository.OcorrenciaRepository;


@Service
public class OcorrenciaService {

    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public List<Ocorrencia> listarTodas(){
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia registrar(Ocorrencia ocorrencia){
        ocorrencia.setStatus("Aberta");
        return ocorrenciaRepository.save(ocorrencia);
    }

    public Ocorrencia atualizarStatus(Long id, String novoStatus){
        Optional<Ocorrencia> encontrada = ocorrenciaRepository.findById(id);
        if (encontrada.isPresent()) {
        Ocorrencia oc = encontrada.get();
        oc.setStatus(novoStatus);
        return ocorrenciaRepository.save(oc);
    }
        throw new RuntimeException("Ocorrência não encontrada");
    }

    public void deletar(Long id) {
        ocorrenciaRepository.deleteById(id);
    }

}
