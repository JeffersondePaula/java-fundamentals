import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("=== 🏭 SISTEMA DE WMS (ESTOQUE) vFINAL ===");

        while (opcao != 5) { // Agora vai até 5
            System.out.println("\n--------------------------------");
            System.out.println("1 - 📦 Listar Produtos");
            System.out.println("2 - ➕ Cadastrar Novo");
            System.out.println("3 - ✏️ Atualizar Preço/Qtd");
            System.out.println("4 - 🗑️ Deletar Produto");
            System.out.println("5 - 🚪 Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    repo.carregarProdutos();
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Qtd: ");
                    int qtd = scanner.nextInt();
                    repo.adicionarProduto(nome, preco, qtd);
                    break;
                case 3:
                    System.out.print("Digite o ID do produto para editar: ");
                    int idEdit = scanner.nextInt();
                    System.out.print("Novo Preço: ");
                    double novoPreco = scanner.nextDouble();
                    System.out.print("Nova Quantidade: ");
                    int novaQtd = scanner.nextInt();
                    repo.atualizarProduto(idEdit, novoPreco, novaQtd);
                    break;
                case 4:
                    System.out.print("Digite o ID do produto para EXCLUIR: ");
                    int idDel = scanner.nextInt();
                    repo.deletarProduto(idDel);
                    break;
                case 5:
                    System.out.println("Encerrando sistema... Sucesso! 🚀");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
