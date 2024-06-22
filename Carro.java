public class Carro extends Veiculo {
    private int numeroPortas;
    private static String marca;
    private int ano;

    public Carro(String modelo, String placa, int numeroPortas, String marca, int ano, double valorDiaria) {
        super(modelo, placa, valorDiaria);
        this.numeroPortas = numeroPortas;
        this.marca = marca;
        this.ano = ano;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public static String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Carro - Modelo: " + getModelo() + ", Placa: " + getPlaca() +
            ", Marca: " + getMarca() + ", Ano: " + getAno() + ", Portas: " + getNumeroPortas() +
            ", Valor da Diária: R$" + getValorDiaria());
    }
}
