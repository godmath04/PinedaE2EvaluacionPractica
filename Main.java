import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        float tarifa = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la tarifa inicial"));
        int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora inicial"));
        Parqueadero parkob = new Parqueadero(tarifa, horaInicio);

        parkob.info();
    }

}
