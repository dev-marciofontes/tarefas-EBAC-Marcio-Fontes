package aulas.mock.service;

import aulas.mock.dao.IContratoDao;

public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        contratoDao.buscar();
        return "Busca feita com sucesso!";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Excluido com sucesso!";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
        return "Registro atualizado com sucesso";
    }
}
