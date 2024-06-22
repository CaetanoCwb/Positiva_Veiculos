public abstract class Veiculo {
    private String modelo;
    private String placa;
    private boolean disponivel;
    private double valorDiaria;

    public Veiculo(String modelo, String placa, double valorDiaria) {
        this.modelo = modelo;
        this.placa = placa;
        this.disponivel = true;
        this.valorDiaria = valorDiaria;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public abstract void mostrarDetalhes();
}
