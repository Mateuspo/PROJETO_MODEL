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
public class TestePersistirCurso {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        
        Curso c = new Curso();
        
        c.setAtivo(true);
        c.setDescricao("INFERNO DO CARALHO");
        c.setInicioAtividades(new GregorianCalendar(1991, Calendar.AUGUST, 9));
        c.setNome("INFERNO DO CARALHO");
        c.setSigla("NDC");
        
        Disciplina d = new Disciplina();
        
        d.setNome("asdf");
        d.setCargaHoraria(2.0);
        d.setConhecimentosMinimos("asdf");
        d.setDescricao("des");
        
        c.adicionarDisciplina(d);
        
        System.out.println(c.getListaDisciplinas());
        
        c.setInstituicao(em.find(Instituicao.class, 3));
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        
    }
    
}
