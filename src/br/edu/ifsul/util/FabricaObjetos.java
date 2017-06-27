
package br.edu.ifsul.util;

import br.ifsul.edu.modelo.Curso;
import br.ifsul.edu.modelo.Disciplina;
import br.ifsul.edu.modelo.Especialidade;
import br.ifsul.edu.modelo.Instituicao;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {

    public static List<Especialidade> carregaEspecialidade(){
        List<Especialidade> lista = new ArrayList<>();
        
        Especialidade e = new Especialidade();
        e.setId(999);
        e.setNome("Especialidade A");
        
        Especialidade e2 = new Especialidade();
        e2.setId(999);
        e2.setNome("Especialidade A");
        
        lista.add(e);
        lista.add(e2);
        return lista;
    }
    
    public static List<Curso> carregaCurso(){
        List<Curso> lista = new ArrayList<>();
        
        Curso c = new Curso();
        Instituicao i = new Instituicao();
        Disciplina d = new Disciplina();
        
        i.setId(908098);
        i.setNome("NOme da instituição");
        i.setAnoFundacao(Calendar.getInstance());
        
        d.setCargaHoraria(2.0);
        d.setConhecimentosMinimos("conhecimentos minimos");
        d.setCurso(c);
        d.setDescricao("descrição");
        d.setId(872);
        d.setNome("Nome disciplina");
        
        c.setInicioAtividades(Calendar.getInstance());
        c.setAtivo(true);
        c.setDescricao("descrição");
        c.setId(878787);
        c.setInstituicao(i);
        c.setNome("Nome curso");
        c.setSigla("sigla");
        c.adicionarDisciplina(d);
        
        lista.add(c);
        
        
        
        return lista;
    }
    
    
    
    
}
