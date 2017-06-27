package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "Nota")
public class Nota implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_nota", sequenceName = "seq_nota_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_nota", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull
    private Double nota01;
    
    @NotNull
    private Double nota02;
    
    @NotNull
    private Double media;
    
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_disciplina")
    private Disciplina disciplina;
    
    public Nota(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota01() {
        return nota01;
    }

    public void setNota01(Double nota01) {
        this.nota01 = nota01;
    }

    public Double getNota02() {
        return nota02;
    }

    public void setNota02(Double nota02) {
        this.nota02 = nota02;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public void calcularMedia(){
        media = (nota01 + nota02) / 2;
        
    }
}
