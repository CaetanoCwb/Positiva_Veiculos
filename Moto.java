public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String modelo, String placa, int cilindradas, double valorDiaria) {
        super(modelo, placa, valorDiaria);
        this.cilindradas = cilindradas;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Moto - Modelo: " + getModelo() + ", Placa: " + getPlaca() +
            ", Cilindradas: " + getCilindradas() + ", Valor da Diária: R$" + getValorDiaria());
    }
}
