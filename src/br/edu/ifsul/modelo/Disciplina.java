package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mateus
 */

@Entity
@Table(name = "Disciplina")
public class Disciplina implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_disciplina", sequenceName = "seq_disciplina_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_disciplina", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    @NotNull(message = "o nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    private String nome;
    
    @Column(name = "descricao", columnDefinition = "text")
    @NotNull(message = "A descricao não pode ser nulo")
    @NotBlank(message = "A descricao não pode ser em branco")
    private String descricao;
    
    @NotNull(message = "A carga horária não pode ser nula")
    private Double cargaHoraria;
    
    @Column(name = "conhecimentos_minimos")
    private String conhecimentosMinimos;
    
    @ManyToOne
    @JoinColumn(name = "curso", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_curso")
    private Curso curso;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "aluno_disciplina", 
            joinColumns = @JoinColumn(
                    name = "disciplina", 
                    referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "aluno", 
                    referencedColumnName = "id", 
                    nullable = false)
    )
    
    private List<Aluno> alunos = new ArrayList<>();
    
    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Nota> listaNotas  = new ArrayList<>();
    
    public void adicionarNota(Nota obj){
        obj.setDisciplina(this);
        this.listaNotas.add(obj);
    }
    
    public void removerNota(int index){
        this.listaNotas.remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Double cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getConhecimentosMinimos() {
        return conhecimentosMinimos;
    }

    public void setConhecimentosMinimos(String conhecimentosMinimos) {
        this.conhecimentosMinimos = conhecimentosMinimos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Disciplina other = (Disciplina) obj;
        if(!Objects.equals(this.id, other.id)) {
            return false;
        }else{
        return true;
        }
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
}
