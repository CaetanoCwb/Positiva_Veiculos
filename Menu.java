import java.util.List;
import java.util.Scanner;

public class Menu {
    private Sistema sistema;
    private Scanner scanner;

    public Menu() {
        this.sistema = new Sistema();
        this.scanner = new Scanner(System.in);

    }

    public void iniciar() {

        System.out.println("\nBem vindo a Positiva Veículos!!!\n");

        while (true) {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Login Administrador");
            System.out.println("3. Login Cliente");
            System.out.println("4. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    loginAdministrador();
                    break;
                case 3:
                    loginCliente();
                    break;
                case 4:
                    System.out.println("\nObrigado por utilizar nosso sistema! Até a próxima!\n");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    private void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        Cliente cliente = new Cliente(nome, cpf, email);
        sistema.cadastrarCliente(cliente);
    }

    private void loginAdministrador() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        if (sistema.loginAdministrador(login, senha)) {
            administradorMenu();
        } else {
            System.out.println("Login ou usuário incorretos\n");
        }
    }

    private void administradorMenu() {
        while (true) {
            System.out.println("\n-------Menu do Administrador--------\n");
            System.out.println("1. Cadastrar Carro");
            System.out.println("2. Cadastrar Moto");
            System.out.println("3. Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 3) {
                System.out.println("\nSaindo do menu do administrador...\n");
                break;
            }

            System.out.print("\nMarca do veículo: ");
            String marca = scanner.nextLine();
            System.out.print("Modelo do veículo: ");
            String modelo = scanner.nextLine();
            System.out.print("Placa do veículo: ");
            String placa = scanner.nextLine();

            Veiculo veiculo = null;

            switch (opcao) {
                case 1:
                    System.out.print("Número de portas: ");
                    int numeroPortas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ano do carro: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Valor da diária: ");
                    double valorDiariaCarro = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new Carro(modelo, placa, numeroPortas, marca, ano, valorDiariaCarro);
                    break;
                case 2:
                    System.out.print("Cilindradas: ");
                    int cilindradas = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Valor da diária: ");
                    double valorDiariaMoto = scanner.nextDouble();
                    scanner.nextLine();
                    veiculo = new Moto(modelo, placa, cilindradas, valorDiariaMoto);
                    break;
                default:
                    System.out.println("\nOpção inválida.\n");
                    break;
            }

            if (veiculo != null) {
                sistema.adicionarVeiculo(veiculo);
                System.out.println("\nVeículo cadastrado com sucesso!\n");
            }
        }
    }

    private void loginCliente() {
        System.out.print("\nCPF do Cliente: ");
        String cpfCliente = scanner.nextLine();
        Cliente clienteEncontrado = null;
        for (Cliente c : sistema.getClientes()) {
            if (c.getCpf().equals(cpfCliente)) {
                clienteEncontrado = c;
                break;
            }
        }
        if (clienteEncontrado != null) {
            clienteMenu(clienteEncontrado);
        } else {
            System.out.println("\nCliente não encontrado.\n");
        }
    }

    private void clienteMenu(Cliente cliente) {
        while (true) {
            System.out.println("\n----------Menu do Cliente----------\n");
            System.out.println("1. Alugar Veículo");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 2) {
                System.out.println("\nSaindo do menu do cliente...\n");
                break;
            }

            if (opcao == 1) {
                List<Veiculo> veiculosDisponiveis = sistema.listarVeiculosDisponiveis();
                if (veiculosDisponiveis.isEmpty()) {
                    System.out.println("\nNenhum veículo disponível para aluguel.\n");
                } else {
                    System.out.println("\nVeículos disponíveis:\n");
                    for (int i = 0; i < veiculosDisponiveis.size(); i++) {
                        Veiculo veiculo = veiculosDisponiveis.get(i);
                        System.out.print((i + 1) + ". ");
                        veiculo.mostrarDetalhes();
                    }
                    System.out.print("\n\nEscolha o número do veículo para alugar: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    if (escolha > 0 && escolha <= veiculosDisponiveis.size()) {
                        Veiculo veiculoEscolhido = veiculosDisponiveis.get(escolha - 1);
                        System.out.print("\nQuantos dias deseja alugar o veículo?\n");
                        int dias = scanner.nextInt();
                        scanner.nextLine();
                        sistema.alugarVeiculo(cliente, veiculoEscolhido, dias);
                    } else {
                        System.out.println("\nEscolha inválida.");
                    }
                }
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }
}
