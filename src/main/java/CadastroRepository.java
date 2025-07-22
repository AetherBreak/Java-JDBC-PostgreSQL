import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CadastroRepository {

    private Connection conexao;

    public CadastroRepository(){
        conexao = FabricaConexao.getConexao();
    }
    public void incluir(Cadastro cadastro){
        try {
            String instrucaoSQL = "INSERT INTO public.tab_cadastro (nome, idade) VALUE";
            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setString(parameterindex: 1, cadastro.getNome());
            pst.setInt(parameterindex: 2, cadastro.getIdade());

            pst.execute();
            System.out.println("Sucess CNX");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void alterar(Cadastro cadastro){
        try {
            String instrucaoSQL = "UPDATE public.tab_cadastro SET nome=?, idade=? WHERE id=?";
            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setString(parameterindex:1, cadastro.getNome());
            pst.setInt(parameterindex: 2, cadastro.getIdade());
            pst.setInt(parameterindex: 3, cadastro.getId());

            pst.execute();
            System.out.println("Sucess CNX");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void excluir(Integer id){
        try {
            String instrucaoSQL = "DELETE FROM public.tab_cadastro WHERE id=?";
            PreparedStatement pst = conexao.prepareStatement(instrucaoSQL);
            pst.setInt(parameterindex: 1, cadastro.getId());

            pst.execute();
            System.out.println("Sucess CNX");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public List<Cadastro> listar(){
        try {
            String instrucaoSQL = "SELECT column1, column2, column3 FROM table_name WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(instrucaoSQL);
            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String id = result.getString("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();

                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                lista.add(cadastro);
            }
        } catch (Exception ex) {
            Exception.printStackTrace();
        }
        return List.of();
    }
    public Cadastro buscar(Integer id){
        try {
            String instrucaoSQL = "SELECT column1, column2, column3 FROM table_name WHERE id = ?";
            PreparedStatement statement = conexao.prepareStatement(instrucaoSQL);
            statement.setInt(1, 1);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                String id = result.getString("id");
                String nome = result.getString("nome");
                int idade = result.getInt("idade");

                Cadastro cadastro = new Cadastro();

                cadastro.setId(id);
                cadastro.setNome(nome);
                cadastro.setIdade(idade);

                return cadastro;
            }
        } catch (Exception ex) {
            Exception.printStackTrace();
        }
        return cadastro;
    }

}
