public class Main {
    public static void main(String[] args) {

        System.out.println("--- System Initialization ---");

        // INSTANCIAÇÃO (Fabricação)
        // Tipo | NomeVariável = Comando | Molde(Dados Iniciais)
        Product p1 = new Product("Ajinomoto MSG", 10.50, 5000);

        // Vamos tentar ver o que criamos?
        // Cenário 1: O Gerente quer saber SÓ o nome e o preço.
        System.out.println("Product: " + p1.getName());
        System.out.println("Price: R$ " + p1.getPrice());

// Cenário 2: Chegou uma nota fiscal nova. O preço subiu.
// Não podemos fazer p1.price = 12.00 (Proibido/Private)
// Usamos o Setter:
        p1.setPrice(-50.00);

        System.out.println("New Price Updated: R$ " + p1.getPrice());
    }
}