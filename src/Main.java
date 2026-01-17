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
        }
}