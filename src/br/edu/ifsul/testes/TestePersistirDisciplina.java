package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.ifsul.edu.modelo.Curso;
import br.ifsul.edu.modelo.Disciplina;
import br.ifsul.edu.modelo.Especialidade;
import br.ifsul.edu.modelo.Instituicao;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirDisciplina {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Disciplina d3 = new Disciplina();
        
        d3.setCargaHoraria(3.20);
        d3.setConhecimentosMinimos("Conhecimentos mínimos");
        d3.setDescricao("descrição da disciplina");
        d3.setNome("Disciplina");
        d3.setCurso(em.find(Curso.class, 1));
        
        em.getTransaction().begin();
        em.persist(d3);
        em.getTransaction().commit();
        
        
    }
    
}
