import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = 0;
        double tarifa = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa inicial"));
        int horaInicio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la hora inicial"));
        Parqueadero parkob = new Parqueadero(tarifa, horaInicio);

        if (horaInicio >= 8 && horaInicio <= 18) {
            while (option != 6) {
                option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su opcion: \n1. Ingresar carro" +
                        "\n2. Sacar un carro" + "\n3. Mostrar puestos e ingresos" +
                        "\n4. Adelantar hora" +
                        "\n5. Cambiar tarifa" +
                        "\n6. Salir"));
                switch (option) {
                    case 1:
                        //Ahora una vez que esta funcionando el parqueadero vamos a ingresar carros
                        String placa = JOptionPane.showInputDialog(null, "Ingrese la placa del carro:");
                        int horaEntrada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la hora de entrada:"));
                        if (horaEntrada < 8 || horaEntrada > 18) {
                            JOptionPane.showMessageDialog(null, "Hora de entrada no permitida. Debe ser entre 8:00 y 18:00.");
                            return;
                        }
                        parkob.ingresoCarro(placa, horaEntrada);
                        break;

                    case 2:
                        String placa2 = JOptionPane.showInputDialog(null, "Ingrese la placa del carro a sacar:");
                        parkob.darSalidaCarro(placa2);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Puestos disponibles: " + parkob.consultarPuestosDisponibles() +
                                "\ningresos totales: $" + parkob.getIngresos());
                        break;
                    case 4:
                        int horas = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese las horas a avanzar:"));
                        parkob.avanzarReloj(horas);
                        break;
                    case 5:
                        double nuevaTarifa = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la nueva tarifa:"));
                        parkob.cambiarTarifa(nuevaTarifa);
                        break;
                    case 6:
                        break;

                }
            }

        }
    }

}
