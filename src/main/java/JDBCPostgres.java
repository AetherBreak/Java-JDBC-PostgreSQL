import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBCPostgres {

    public static void main(String[] args) {
        try {

            String url = "jdbc:postgresql://localhost:5432/JDBCPostgres";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            //props.setProperty("ssl", "true");
            Connection conn = DriverManager.getConnection(url, props);

            String instrucaoSQL = "INSERT INTO public.tab_cadastro (nome, idade) VALUE(?,?);";

            PreparedStatement pst = conn.prepareStatement(instrucaoSQL);
            pst.setString(parameterindex: 1, nome);
            pst.setInt(parameterindex, idade);

            pst.execute();
            System.out.println("Sucess CNX");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Failed CNX");
        }
    }

}
