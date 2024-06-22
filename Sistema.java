import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Cliente> clientes;
    private Administrador administrador;
    private List<Veiculo> veiculos;

    public Sistema() {
        this.clientes = new ArrayList<>();
        this.veiculos = new ArrayList<>();
        this.clientes = ArquivoUtil.carregarClientes();
        this.veiculos = ArquivoUtil.carregarVeiculos();
        this.administrador = new Administrador("Administrador Padrão", "12345678900", "admin", "senha123");
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("\nCliente " + cliente.getNome() + " cadastrado com sucesso!\n" );
        ArquivoUtil.salvarClientes(clientes);
    }

    public boolean loginAdministrador(String login, String senha) {
        if (administrador.autenticar(login, senha)) {
            System.out.println("\nAdministrador logado: " + administrador.getNome());
            return true;
        } else {
            System.out.println("\nFalha ao autenticar administrador");
            return false;
        }
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        administrador.adicionarVeiculo(veiculo);
        ArquivoUtil.salvarVeiculos(veiculos);
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        disponiveis.add(new Carro("Gol G4", "ABC-1234", 4, "Volkswagen", 2018, 100.0));
        disponiveis.add(new Carro("Jetta", "ABC-1234", 4, "Volkswagen", 2024, 190.0));
        disponiveis.add(new Carro("Kwid", "ABC-1234", 4, "Renault", 2021, 120.0));
        disponiveis.add(new Carro("HB20", "ABC-1234", 4, "Hyundai", 2020, 150.0));
        disponiveis.add(new Moto("CG Fan", "123-ABC", 160, 90));
        disponiveis.add(new Moto("Yamaha Fazer", "123-ABC", 250, 130));
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }

    public void alugarVeiculo(Cliente cliente, Veiculo veiculo, int dias) {
        if (veiculo.isDisponivel()) {
            veiculo.setDisponivel(false);
            cliente.alugarVeiculo(veiculo);
            double valorTotal = veiculo.getValorDiaria() * dias;
            System.out.println("\nAluguel realizado com sucesso!\n");
            System.out.println("Valor total do aluguel por " + dias + " dias: R$" + valorTotal);
            System.out.println("\nRetirar veículo na Agência Central\nRua Positivo, 123 - Centro");
            System.out.println("\nNF-e e boleto para pagamento enviado para o e-mail: "+ cliente.getEmail());
            System.out.println("\nFicamos à disposição, obrigado por utilizar nossos serviços!");
        } else {
            System.out.println("Veículo não está disponível para aluguel.");
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

}
