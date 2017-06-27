package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Mateus
 */
@Entity(name = "Aluno")
@Inheritance(strategy = InheritanceType.JOINED)
public class Aluno implements Serializable{

    @Id
    @SequenceGenerator(name = "seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "nome")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ficar em branco")
    private String nome;
    @Column(name = "email")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ficar em branco")
    @Email
    private String email;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Calendar nascimento;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "aluno_disciplina", 
            joinColumns = @JoinColumn(
                    name = "aluno", 
                    referencedColumnName = "id", 
                    nullable = false),
            inverseJoinColumns = @JoinColumn(
                    name = "disciplina", 
                    referencedColumnName = "id", 
                    nullable = false)
    
    )
    private List<Disciplina> disciplinas = new ArrayList<>();
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
