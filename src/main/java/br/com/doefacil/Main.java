package br.com.doefacil;

import br.com.doefacil.facade.DoacaoFacade;
import br.com.doefacil.model.Doacao;
import br.com.doefacil.model.TipoDoacao;
import br.com.doefacil.strategy.DistribuicaoStrategy;
import br.com.doefacil.strategy.MaiorQuantidadeStrategy;
import br.com.doefacil.strategy.OrdemCadastroStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoacaoFacade facade = new DoacaoFacade();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== DOE FÁCIL =====");
            System.out.println("1 - Cadastrar doação");
            System.out.println("2 - Consultar doações");
            System.out.println("3 - Distribuir por maior quantidade");
            System.out.println("4 - Distribuir por ordem de cadastro");
            System.out.println("5 - Exibir resumo");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        System.out.print("Nome do doador: ");
                        String nome = scanner.nextLine();

                        System.out.println(
                                "Tipo: 1-Alimento, 2-Roupa, 3-Higiene");
                        System.out.print("Escolha o tipo: ");

                        int tipo = Integer.parseInt(scanner.nextLine());

                        TipoDoacao categoria;

                        switch(tipo) {
                            case 1:
                                categoria = TipoDoacao.ALIMENTO;
                                break;
                            case 2:
                                categoria = TipoDoacao.ROUPA;
                                break;
                            case 3:
                                categoria = TipoDoacao.HIGIENE;
                                break;
                            default:
                                throw new IllegalArgumentException(
                                    "Tipo de doação inválido.");
                    }
                    System.out.print("Quantidade: ");
                    int quantidade = Integer.parseInt(scanner.nextLine());

                    facade.cadastrar(
                            new Doacao(nome, categoria, quantidade));
                    System.out.println("Doação cadastrada com sucesso!");
                    break;

                    case 2:
                        List<Doacao> doacoes = facade.listar();

                        if (doacoes.isEmpty()) {
                            System.out.println("Nenhuma doação cadastrada.");
                        } else {
                            for (Doacao doacao : doacoes) {
                                System.out.println(doacao);
                            }
                        }
                        break;

                    case 3:
                        exibirDistribuicao(
                                facade, new MaiorQuantidadeStrategy());
                        break;

                    case 4:
                        exibirDistribuicao(
                                facade, new OrdemCadastroStrategy());
                        break;

                    case 5:
                        System.out.println(facade.gerarResumo());
                        break;

                    case 0:
                        System.out.println("Até logo!");
                        break;

                    default:
                        System.out.println("Opção inválida!");

                }


            } catch (NumberFormatException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void exibirDistribuicao(
            DoacaoFacade facade,
            DistribuicaoStrategy estrategia) {

        List<Doacao> doacoes = facade.distribuir(estrategia);

        if (doacoes.isEmpty()) {
            System.out.println("Nenhuma doação para distribuir.");
            return;
        }

        System.out.println("\nOrdem de distribuição: ");

        for (Doacao doacao : doacoes) {
            System.out.println(doacao);
        }
    }
}