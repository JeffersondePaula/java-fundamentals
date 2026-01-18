import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    // Configurações do Banco (Constantes)
    private final String URL = "jdbc:mysql://localhost:3306/inventory_db";
    private final String USER = "root";
    private final String PASS = "root"; // Sua senha aqui

    // Método que vai no banco e busca tudo
    public void carregarProdutos() {
        System.out.println("\n--- 📦 CARREGANDO ESTOQUE DO BANCO DE DADOS ---");

        // Tenta conectar e buscar
        try (Connection conexao = DriverManager.getConnection(URL, USER, PASS)) {

            String sql = "SELECT * FROM products";

            // Prepara o comando
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Executa e pega o resultado (O "Excel" que volta do banco)
            ResultSet resultado = statement.executeQuery();

            // Enquanto tiver uma próxima linha na tabela...
            while (resultado.next()) {
                // Pega os dados das colunas
                int id = resultado.getInt("id");
                String nome = resultado.getString("name");
                double preco = resultado.getDouble("price");
                int qtd = resultado.getInt("quantity");

                // Mostra na tela
                System.out.printf("ID: %d | %-20s | R$ %.2f | %d un.%n", id, nome, preco, qtd);
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao buscar produtos: " + e.getMessage());
        }
        System.out.println("------------------------------------------------");
    }
    // Método para salvar um novo produto no banco
    public void adicionarProduto(String nome, double preco, int quantidade) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASS)) {

            // Prepara o pacote para envio
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Substitui as "?" pelos valores reais (Isso protege contra hackers!)
            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setInt(3, quantidade);

            // Executa o comando de escrita (Update)
            int linhasAfetadas = statement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("✅ Produto '" + nome + "' cadastrado com sucesso!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Erro ao salvar: " + e.getMessage());
        }
    }
    // --- MÉTODO ATUALIZAR (UPDATE) ---
    public void atualizarProduto(int id, double novoPreco, int novaQtd) {
        String sql = "UPDATE products SET price = ?, quantity = ? WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Preenchendo os 3 ? (Preço, Quantidade e o ID de quem vai sofrer a mudança)
            statement.setDouble(1, novoPreco);
            statement.setInt(2, novaQtd);
            statement.setInt(3, id);

            int linhas = statement.executeUpdate();

            if (linhas > 0) {
                System.out.println("✅ Produto ID " + id + " atualizado com sucesso!");
            } else {
                System.out.println("⚠️ Produto não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao atualizar: " + e.getMessage());
        }
    }

    // --- MÉTODO DELETAR (DELETE) ---
    public void deletarProduto(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conexao = DriverManager.getConnection(URL, USER, PASS)) {
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setInt(1, id); // Diz qual ID deve ser apagado

            int linhas = statement.executeUpdate();

            if (linhas > 0) {
                System.out.println("🗑️ Produto ID " + id + " removido do sistema!");
            } else {
                System.out.println("⚠️ Produto não encontrado para deletar.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao deletar: " + e.getMessage());
        }
    }
}