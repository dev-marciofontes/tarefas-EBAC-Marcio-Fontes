package aulas.mock.dao;

public class ContratoDao implements IContratoDao {
    @Override
    public void salvar() {
        throw new  UnsupportedOperationException("Não funciona o banco");
    }

    @Override
    public void buscar() {
        throw new  UnsupportedOperationException("Não tem como buscar sem o banco!");
    }

    @Override
    public void excluir() {
        throw new  UnsupportedOperationException("Não tem como excluir sem o banco!");
    }

    @Override
    public void atualizar() {
        throw new  UnsupportedOperationException("Não tem como atualizar sem o banco!");
    }
}
