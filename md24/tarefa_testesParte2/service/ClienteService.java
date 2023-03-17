package aulas.mock.service;

import aulas.mock.dao.ClienteDAO;
import aulas.mock.dao.IClienteDAO;

public class ClienteService {

    private IClienteDAO clienteDao;

    public ClienteService(IClienteDAO clienteDao) {
        this.clienteDao = clienteDao;
    }

    public String salvar() {
        clienteDao.salvar();
        return "Sucesso";
    }

}
