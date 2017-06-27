package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.ifsul.edu.modelo.Especialidade;
import br.ifsul.edu.modelo.Professor;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirProfessor {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Professor p = new Professor();
        
        p.setEmail("professor@hotmail.com");
        p.setEspecialidade(em.find(Especialidade.class, 1));
        p.setNascimento(new GregorianCalendar(1991, Calendar.AUGUST, 9));
        p.setNome("Nome do professor");
        p.setTitulacao("Titulação do professor");
        p.setTopicoInteresse("topico de interesse");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        
    }
    
}
