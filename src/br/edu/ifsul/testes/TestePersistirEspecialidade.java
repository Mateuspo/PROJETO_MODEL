package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirEspecialidade {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Especialidade e = new Especialidade();
        e.setNome("testando :(");
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        
        
    }
    
}
