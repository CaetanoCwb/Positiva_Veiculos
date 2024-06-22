public class Administrador extends Pessoa implements Autenticavel {
    private String login;
    private String senha;
    
    public Administrador(String nome, String cpf, String login, String senha) {
        super(nome, cpf);
        this.login = login;
        this.senha = senha;
    }
    
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
        System.out.println("Veículo adicionado: " + veiculo.getModelo());
    }
}
