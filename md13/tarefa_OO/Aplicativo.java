package aulas.exercicios.md13;

public class Aplicativo {

    public static void main(String[] args) {

        PessoaFisica pf = new PessoaFisica();
        pf.setNome("Kleyton Barbosa");
        pf.setCpf("77777777777");

        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("Escola Kleytiana do Brasil");
        pj.setCnpj("77777777777888");

        pf.apresentar();
        System.out.println();
        pj.apresentar();

    }

}
