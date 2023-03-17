package aulas.mock.test;

import aulas.mock.dao.ClienteDAO;
import aulas.mock.dao.ClienteDAOMock;
import aulas.mock.service.ClienteService;
import org.junit.Assert;
import org.junit.Test;

public class ClienteServiceTest {
    @Test
    public void salvarTest() {
        ClienteDAOMock mock = new ClienteDAOMock();
        ClienteService service = new ClienteService(mock);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        ClienteDAO mockDao = new ClienteDAO();
        ClienteService service = new ClienteService(mockDao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

}
