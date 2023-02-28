package aulas.exercicios.md13;

public class PessoaFisica extends Pessoa {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void apresentar() {
        System.out.println("A pessoa cadastrada é " + this.getNome() + ". Cadastrada no CPF : " + this.getCpf());
    }
}
