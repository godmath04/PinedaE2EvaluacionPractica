import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    //Creacion de una lista que almacena el objeto de Puesto
    private List<Puesto> puestos;
    private double tarifa;
    private int hora;
    private double ingresos;

    //Constructor para que se asginen los valores
    public Parqueadero(double tarifaInicial, int horaInicial){
        this.tarifa = tarifaInicial;
        if (horaInicial >= 8 && horaInicial <= 18){
            this.hora = horaInicial;
        }else {

            JOptionPane.showMessageDialog(null, "La hora de inicio es incorrecta.");
        }
        this.puestos = new ArrayList<>();
        for (int i = 1; i<=3; i++){
            this.puestos.add(new Puesto(i));
        }
        this.ingresos = 0.0;
    }


    // Metodo de ingreso de vehiculo
    public void ingresoCarro(String placa, int horaEntrada){
            if (horaEntrada < 8 || horaEntrada > 18) {
                JOptionPane.showMessageDialog(null, "Se encuentra fuera de horario.");
                return;
            }

            //Verifica disponibidlidad y placa igual
            for (int i = 0; i < puestos.size(); i++) {
                Puesto puesto = puestos.get(i);

                //Si el puesto no esta disponible
                if (!puesto.estaDisponible() && puesto.getCarro().getPlaca().equals(placa)) {
                    JOptionPane.showMessageDialog(null, "Ya hay un carro con esa placa");
                    return;
                }

            }

            for (int i = 0; i < puestos.size(); i++) {
                Puesto puesto = puestos.get(i);
                if (puesto.estaDisponible()) {
                    puesto.asignarCarro(new Carro(placa, horaEntrada));
                    JOptionPane.showMessageDialog(null, "Carro ingresado en el puesto: " + puesto.getNumero());
                    return;
                }
            }

            JOptionPane.showMessageDialog(null, "No hay puestos");
    }

    ///Metodo para que salga el carro
    public void darSalidaCarro(String placa) {
        for (int i = 0; i < puestos.size(); i++) {
            Puesto puesto = puestos.get(i);
            if (!puesto.estaDisponible() && puesto.getCarro().getPlaca().equals(placa)) {
                int horaActual = hora;
                int horaEntrada = puesto.getCarro().getHoraEntrada();

                //Calculo en horas
                int horasEstacionado;
                if (horaActual >= horaEntrada) {
                    horasEstacionado = horaActual - horaEntrada;
                } else {
                    horasEstacionado = (24 - horaEntrada) + horaActual;
                }
                double costo = horasEstacionado * tarifa;
                JOptionPane.showMessageDialog(null, "El costo por estacionamiento es: $" + costo);
                ingresos += costo; // Actualiza los ingresos
                puesto.liberarCarro();
                return;
            }
        }
    }


    //Metodo para mostrar informacion
    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("La tarifa inicial es: " + tarifa);
        sb.append("\nLa hora inicial es: " + hora);
        sb.append("\nCarros en el parqueadero:" + puestos.size());
    return toString();
    }

    //Metodo para mostrar puestos disponibles
    public int consultarPuestosDisponibles(){
        int disponibles = 0;
        for (int i = 0; i < puestos.size(); i++){
            Puesto puesto = puestos.get(i);
            if (puesto.estaDisponible()){
                disponibles++;
            }
        }
        return disponibles;
    }

    public double getIngresos(){
        return ingresos;
    }


    //Metodo para avanzar el relok
    // Avanzar el reloj
    public void avanzarReloj(int horas) {
        if (hora + horas > 18) {
            JOptionPane.showMessageDialog(null, "No se puede avanzar el reloj más allá de las 21:00.");
        } else {
            hora += horas;
            JOptionPane.showMessageDialog(null,"La hora actual es: " + hora + ":00.");
        }
    }

    public int getHora() {
        return hora;
    }
}
