package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Especialidade;
import br.edu.ifsul.modelo.Instituicao;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Mateus
 */
public class TestePersistirInstituicao {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Instituicao i = new Instituicao();
        i.setNome("Nome da instituição");
        i.setAnoFundacao(new GregorianCalendar(1991, Calendar.AUGUST, 9));

        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();
        
        
    }
    
}
