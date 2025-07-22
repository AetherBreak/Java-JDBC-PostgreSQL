import java.util.List;

public class SistemaCadastro {
    public static void main(String[] args) {
        FabricaConexao.conectar();
        CadastroRepository repository = new CadastroRepository();
        Cadastro cadastro = new Cadastro();
        cadastro.setNome("XX XX");
        cadastro.setIdade(20);
        List<Cadastro> cadastros = repository.listar();
        for (Cadastro c: cadastros){
            System.out.println(c.getId() + " " + c.getNome());
        }

        repository.incluir(cadastro);
    }
}
