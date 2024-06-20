import javax.swing.*;
import java.util.List;

public class Parqueadero {
    //Creacion de una lista que almacena el objeto de Puesto
    private List<Puesto> puestos;
    private float tarifaInicial;
    private int horaInicial;
    private float ingresos;

    // Constructor
    public Parqueadero(float tarifaInicial, int horaInicial){
        this.puestos = null;
        this.tarifaInicial = tarifaInicial;
        if (horaInicial >= 8 && horaInicial <= 18){
            this.horaInicial = horaInicial;
            JOptionPane.showMessageDialog(null, "El parqueadero se abre a las: " + horaInicial + " con una tarifa de: $ " + tarifaInicial);
        }else {
            JOptionPane.showMessageDialog(null, "Se encuentra fuera de la hora de funcionamiento.");
        }
        this.ingresos = 0;
        //Creacion de la lista
        for (int i = 0; i <5 ; i++){
            puestos.add(new Puesto(i));
        }

    }



    //Metodo para mostrar informacion
    public String info(){
        StringBuilder sb = new StringBuilder();
        sb.append("La tarifa inicial es: " + tarifaInicial);
        sb.append("\nLa hora inicial es: " + horaInicial);
        return   sb.toString();
    }

    //Metodo para ingresar carro la parqueadero
    public void ingresoCarro(String placa, int horaEntrada) {
        if (horaEntrada < 8 || horaEntrada > 18) {
            JOptionPane.showMessageDialog(null, "Hora invalida. Vuelva en horario disponible.");
            return;
        }

    //Verifica disponibidlidad y placa igual
        for (int i = 0; i < puestos.size(); i++){
        // Nos referimos a la clase Puesto y scamos el nombre de la variable puesto para referirse a un objeto de esa clase
        Puesto puesto = puestos.get(i);

        //Si el puesto no esta disponible
        if( !puesto.estaDisponible() && puesto.getCarro().getPlaca().equals(placa)){
            JOptionPane.showMessageDialog(null, "Ya hay un carro con esa placa");
            return;
        }

        }
    }

}
