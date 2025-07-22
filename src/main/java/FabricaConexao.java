import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FabricaConexao {
    private static Connection conexao;

    public static void conectar(){
        try {
            if (conexao==null) {
                String url = "jdbc:postgresql://localhost:5432/JDBCPostgres";
                Properties props = new Properties();
                props.setProperty("user", "postgres");
                props.setProperty("password", "postgres");
                //props.setProperty("ssl", "true");
                Connection conn = DriverManager.getConnection(url, props);
                System.out.println("Sucess CNX");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Connection getConexao() {
        return conexao;
    }
}
