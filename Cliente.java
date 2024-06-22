public class Cliente extends Pessoa {

    private String email;
    
    public Cliente(String nome, String cpf, String email) {
        super(nome, cpf);
        
        this.email = email;
    }
    
    public void alugarVeiculo(Veiculo veiculo) {
        System.out.println("\nCliente " + getNome() + " alugou o veículo " + Carro.getMarca() +" "+ veiculo.getModelo());
        veiculo.setDisponivel(false);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
