package aulas.mock.dao;

public class ContratoDao implements IContratoDao {
    @Override
    public void salvar() {
        throw new  UnsupportedOperationException("N�o funciona o banco");
    }

    @Override
    public void buscar() {
        throw new  UnsupportedOperationException("N�o tem como buscar sem o banco!");
    }

    @Override
    public void excluir() {
        throw new  UnsupportedOperationException("N�o tem como excluir sem o banco!");
    }

    @Override
    public void atualizar() {
        throw new  UnsupportedOperationException("N�o tem como atualizar sem o banco!");
    }
}
