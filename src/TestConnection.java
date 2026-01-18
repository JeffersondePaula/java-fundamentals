import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        // Dados para conectar no "Galpão"
        String url = "jdbc:mysql://localhost:3306/inventory_db";
        String usuario = "root";
        String senha = "root"; // A senha que você definiu

        System.out.println("Tentando conectar ao banco de dados...");

        try {
            // Tenta estabelecer a ponte
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("✅ SUCESSO! Conexão realizada com o MySQL!");

            // Fecha a conexão para não deixar a porta aberta
            conexao.close();
        } catch (SQLException e) {
            System.out.println("❌ FALHA na conexão.");
            e.printStackTrace();
        }
    }
}