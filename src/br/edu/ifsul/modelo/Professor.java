/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "Professor")
public class Professor extends Aluno implements Serializable{
    
    
    @NotNull(message = "A titulacao deve ser informada")
    @NotBlank(message = "A titulacao deve ser informada")
    private String titulacao;
    
    @Column(name = "topico_interesse", columnDefinition = "text")
    private String topicoInteresse;
    
    @ManyToOne
    @JoinColumn(name = "especialidade", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_especialidade")
    private Especialidade especialidade;

    public String getTitulacao() {
        return titulacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.titulacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.titulacao, other.titulacao)) {
            return false;
        }
        return true;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getTopicoInteresse() {
        return topicoInteresse;
    }

    public void setTopicoInteresse(String topicoInteresse) {
        this.topicoInteresse = topicoInteresse;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
}
