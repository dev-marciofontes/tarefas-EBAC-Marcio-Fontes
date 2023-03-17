package aulas.mock.test;

import aulas.mock.dao.ContratoDao;
import aulas.mock.dao.IContratoDao;
import aulas.mock.mock.ContratoDAOMock;
import aulas.mock.service.ContratoService;
import aulas.mock.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDao dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscarTest() {
        IContratoDao dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Busca feita com sucesso!", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Busca feita com sucesso!", retorno);
    }

    @Test
    public void excluirTest() {
        IContratoDao dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido com sucesso!", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluido com sucesso!", retorno);
    }

    @Test
    public void atualizarTest() {
        IContratoDao dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Registro atualizado com sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoAtualizarComBancoDeDados() {
        IContratoDao dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Registro atualizado com sucesso", retorno);
    }

}
