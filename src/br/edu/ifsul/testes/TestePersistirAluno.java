package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirAluno {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Aluno a = em.find(Aluno.class, 1);
        Disciplina d = em.find(Disciplina.class, 1);
        a.getDisciplinas().add(d);
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        
        
    }
    
}
