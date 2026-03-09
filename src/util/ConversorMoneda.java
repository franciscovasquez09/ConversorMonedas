package util;

import servicio.ConsultaMoneda;
import java.util.Scanner;

public class ConversorMoneda {

    Scanner scanner = new Scanner(System.in);
    ConsultaMoneda consulta = new ConsultaMoneda();

    public void mostrarMenu() {

        int opcion = 0;

        while (opcion != 7) {

            System.out.println("\n****************************************");
            System.out.println("Sea bienvenido al Conversor de Monedas");
            System.out.println("1) USD -> ARS");
            System.out.println("2) ARS -> USD");
            System.out.println("3) USD -> BRL");
            System.out.println("4) BRL -> USD");
            System.out.println("5) USD -> CLP");
            System.out.println("6) CLP -> USD");
            System.out.println("7) Salir");
            System.out.println("****************************************");

            System.out.print("Elija una opción válida: ");
            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("Programa finalizado.");
                break;
            }

            System.out.print("Ingrese el valor que desea convertir: ");
            double valor = scanner.nextDouble();

            realizarConversion(opcion, valor);
        }
    }

    private void realizarConversion(int opcion, double valor) {

        double tasa = 0;

        switch (opcion) {

            case 1:
                tasa = consulta.obtenerTasa("USD", "ARS");
                break;

            case 2:
                tasa = consulta.obtenerTasa("ARS", "USD");
                break;

            case 3:
                tasa = consulta.obtenerTasa("USD", "BRL");
                break;

            case 4:
                tasa = consulta.obtenerTasa("BRL", "USD");
                break;

            case 5:
                tasa = consulta.obtenerTasa("USD", "CLP");
                break;

            case 6:
                tasa = consulta.obtenerTasa("CLP", "USD");
                break;

            default:
                System.out.println("Opción inválida");
                return;
        }

        double resultado = valor * tasa;

        System.out.println("El valor convertido es: " + resultado);
    }
}