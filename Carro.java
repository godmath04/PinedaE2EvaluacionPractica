public class Carro {
    // Aqui voy a crear varios carro
    private String placa;
    private int horaEntrada;

    // Constructor para los valores
    public Carro(String placa, int horaEntrada) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
    }

    // Metodos solo para leer
    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }
}
