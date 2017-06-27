package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "Curso")
public class Curso implements Serializable{
    
    //LIST DE DISCPLINA DENTRO DO CURSO
    
    @Id
    @SequenceGenerator(name = "seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_curso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    @NotNull(message = "o nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    private String nome;
    
    @Column(name = "sigla")
    @NotNull(message = "o sigla não pode ser nulo")
    @NotBlank(message = "O sigla não pode ser em branco")
    private String sigla;
    
    @Column(name = "descricao")
    @NotNull(message = "A descrição não pode ser nulo")
    @NotBlank(message = "A descrição não pode ser em branco")
    private String descricao;
    
    @NotNull(message = "O status não pode ser nulo")
    private Boolean ativo;
    
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar inicioAtividades;
    
    @ManyToOne
    @JoinColumn(name = "instituicao", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_instituicao")
    private Instituicao instituicao;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)//Informar o nome do ATRIBUTO na tabela, do ATRIBUTO, Mateus!
    private List<Disciplina> listaDisciplinas  = new ArrayList<>();
    
    public Curso(){
        
    }
    
     public void adicionarDisciplina(Disciplina obj){
        obj.setCurso(this);
        this.listaDisciplinas.add(obj);
    }
    
    public void removerDisciplina(int index){
        this.listaDisciplinas.remove(index);
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getInicioAtividades() {
        return inicioAtividades;
    }

    public void setInicioAtividades(Calendar inicioAtividades) {
        this.inicioAtividades = inicioAtividades;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(List<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }
    
}
