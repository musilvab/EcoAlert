package com.ecoalert.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;
    private String local;
    private String status;  
    
    
    public Ocorrencia(){}

    public int getId(){
        return id;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getLocal(){
        return local;
    }

    public String getStatus(){
        return status;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public void setStatus(String status){
        this.status = status;
    }

}
