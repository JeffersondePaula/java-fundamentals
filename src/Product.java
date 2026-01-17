public class Product {
    // ATRIBUTOS (As características da máquina)
    // "private" significa: Só a própria fábrica mexe nisso. Ninguém de fora põe a mão direto.

    private String name;
    private double price;
    private int quantityInStock;

    // CONSTRUTOR (O Molde)
    // É o procedimento que roda quando damos o comando "new Product()"
    public Product(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Lógica de Proteção (Validation Logic)
        if (price < 0) {
            System.out.println("ERROR: Price cannot be negative. Update cancelled.");
        } else {
            this.price = price; // Só atualiza se for válido
        }
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}