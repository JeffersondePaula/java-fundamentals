
public class Main {

    public static void main(String[] args) {
        // 1. Ferramentas (Scanner e Lista)
        // System.in = Teclado
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        java.util.List<Product> warehouse = new java.util.ArrayList<>();

        System.out.println("--- SYSTEM ONLINE: WAITING FOR INPUT ---");

        // 2. O Loop Infinito (O Menu)
        while (true) {
            System.out.println("\nOptions: [1] Register Product  [2] Finish & Print Report");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // <--- O TRUQUE DO FANTASMA (Limpa o "Enter" que sobrou na memória)

            if (option == 2) {
                break; // QUEBRA O LOOP. Sai do while e vai para o relatório.
            }

            if (option == 1) {
                // Coletando dados reais do usuário
                System.out.print("Product Name: ");
                String name = scanner.nextLine(); // Lê a linha inteira (aceita espaços)

                System.out.print("Price (use comma or dot depending on PC): ");
                double price = scanner.nextDouble();

                System.out.print("Quantity: ");
                int quantity = scanner.nextInt();

                // Criando e adicionando
                Product newProduct = new Product(name, price, quantity);
                warehouse.add(newProduct);

                System.out.println(" >> Product registered successfully!");
            }
        }

        // 3. O Relatório Final (Sua tabela bonita)
        System.out.println("\n--- FINAL INVENTORY REPORT ---");
        System.out.printf("%-30s | %-10s | %-10s%n", "PRODUCT NAME", "PRICE", "STOCK");
        System.out.println("----------------------------------------------------------------");

        for (Product p : warehouse) {
            System.out.printf("%-30s | R$ %-7.2f | %-5d units", p.getName(), p.getPrice(), p.getQuantityInStock());
            if (p.getQuantityInStock() < 500) {
                System.out.print("  <-- [LOW STOCK WARNING]");
            }
            System.out.println();
        }

        scanner.close(); // Boa prática: fechar o scanner no fim
    }
}
