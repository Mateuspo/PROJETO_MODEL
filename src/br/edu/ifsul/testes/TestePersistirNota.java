package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Nota;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirNota {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Nota n = new Nota();
        n.setAluno(em.find(Aluno.class, 1));
        n.setDisciplina(em.find(Disciplina.class, 1));
        n.setNota01(9.0);
        n.setNota02(10.0);
        n.calcularMedia();

        em.getTransaction().begin();
        em.persist(n);
        em.getTransaction().commit();
        
        
    }
    
}
