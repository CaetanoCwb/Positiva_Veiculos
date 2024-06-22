import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    private static final String ARQUIVO_CLIENTES = "Dados/clientes.txt";
    private static final String ARQUIVO_VEICULOS = "Dados/veiculos.txt";

    public static void salvarClientes(List<Cliente> clientes) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CLIENTES))) {
            outputStream.writeObject(clientes);
            System.out.println("Clientes salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static List<Cliente> carregarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_CLIENTES))) {
            clientes = (List<Cliente>) inputStream.readObject();
            System.out.println("Clientes carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
        return clientes;
    }

    public static void salvarVeiculos(List<Veiculo> veiculos) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_VEICULOS))) {
            outputStream.writeObject(veiculos);
            System.out.println("Veículos salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar veículos: " + e.getMessage());
        }
    }

    public static List<Veiculo> carregarVeiculos() {
        List<Veiculo> veiculos = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_VEICULOS))) {
            veiculos = (List<Veiculo>) inputStream.readObject();
            System.out.println("Veículos carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar veículos: " + e.getMessage());
        }
        return veiculos;
    }
}
