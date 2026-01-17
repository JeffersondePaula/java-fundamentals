public class Main {
        public static void main(String[] args) {
            // 1. Declarando as variaveis (Criando os containers)
            String productName = "Ajinomoto MSG Pack";
            int quantity = 5000;
            double weightPerUnit = 0.5; // Em Java usamos PONTO, não virgula

            // 2. Processamento (Cálculo simples)
            double totalWeigth = quantity * weightPerUnit;

            // 3. Saída (Mostrando no painel)
            System.out.println("Product: " + productName);
            System.out.println("Total Batch Weight: " + totalWeigth + " kg");

            // NOVO: Definindo o limite de segurança
            int minimumStock = 2000;

            System.out.println("--- Quality Control Report ---");

            // Lógica de Decisão
            if (quantity < minimumStock) {
                System.out.println("CRITICAL: Stock is low! Replenish immediately.");
            } else {
                System.out.println("STATUS: Stock levels are normal.");
            }
            System.out.println("\n--- Starting Automatic Audit ---");

            // O Robô de Auditoria
            // for (INICIO; CONDIÇÃO DE PARADA; PASSO)
            for (int i = 1; i <= 5; i++) {
                System.out.println("Scanning Pallet ID: #" + i + " [OK]");
            }

            System.out.println("Audit Finished.");

        }
}