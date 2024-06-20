public class Puesto {
    private int numero;
    private Carro carro;

    // Constructor
    // Cuando se indica
    public Puesto(int numero) {
        this.numero = numero;
        this.carro = null;
    }

    //Metodos para mostrar los datos
    public int getNumero() {
        return numero;
    }

    public Carro getCarro() {
        return carro;
    }

    //Metodo para asignar un carro al puesto
    public void asignarCarro(Carro carro){
        this.carro = carro;
    }

    //Metodo para liberar el carro
    public void liberarCarro(){
        this.carro = null;
    }

    //Metodo para saber si estaDisponible
    public boolean estaDisponible(){
        return this.carro == null;
    }


}