package com.aluracurso.conversorMoneda.principal;

import com.aluracurso.conversorMoneda.model.Cambios;
import com.aluracurso.conversorMoneda.model.Convertidor;
import com.aluracurso.conversorMoneda.model.Historial;
import com.aluracurso.conversorMoneda.model.Pais;

import java.io.IOException;
import java.util.*;

public class main {
    private static Pais[] populares = {
            new Pais("USD", "Estados Unidos"),
            new Pais("EUR", "Eurozona"),
            new Pais("GBP", "Reino Unido"),
            new Pais("JPY", "Japón"),
            new Pais("AUD", "Australia"),
            new Pais("CAD", "Canadá"),
            new Pais("CHF", "Suiza"),
            new Pais("CNY", "China"),
            new Pais("ARS", "Peso argentino"),
            new Pais("BOB", "Boliviano boliviano"),
            new Pais("CLP", "Peso chileno"),
            new Pais("COP", "Peso colombiano"),
            new Pais("BRL", "Real brasileño"),
    };

    private static List<Historial> historial = new ArrayList<>();
    public static void main(String[] args){
        Scanner lectura = new Scanner(System.in);
        String baseMonetaria = null;
        boolean continuar = true;
        while (continuar) {
            try{
            if (baseMonetaria == null) {
                baseMonetaria = seleccionarMoneda(lectura, "base");
            }
            String aconvertir = seleccionarMoneda(lectura, "objetivo");

            double monto = 0;
            boolean validAmount = false;
            while (!validAmount) {
                try {
                    System.out.print("Ingrese la cantidad a convertir: ");
                    monto = lectura.nextDouble();
                    lectura.nextLine();
                    if (monto <= 0) {
                        System.out.println("Por favor, ingrese una cantidad positiva.");
                    } else {
                        validAmount = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Por favor, ingrese un número válido.");
                    lectura.next();
                }
            }

            String URL = "https://v6.exchangerate-api.com/v6/ab259a06897035dd6b70be20/latest/"+baseMonetaria;

                Cambios valor = Convertidor.getValorCambios(URL);

                double cantidadConvertida = Convertidor.convertirMoneda(valor, baseMonetaria, aconvertir, monto);
                System.out.printf("%.2f %s a %s: %.2f%n", monto, baseMonetaria, aconvertir, cantidadConvertida);
                double precioUnitario = valor.getPrecioMoneda(aconvertir);
                historial.add(new Historial(baseMonetaria,aconvertir,monto,cantidadConvertida,precioUnitario));
                int response;
                do {
                    System.out.println("¿Desea continuar? \n1. Sí\n2. No");
                    try {
                        response = lectura.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Respuesta inválida. Por favor, ingrese 1 o 2.");
                        lectura.next();
                        response = -1;
                    }
                    if (response != 1 && response != 2) {
                        System.out.println("Respuesta inválida. Por favor, seleccione 1 para continuar o 2 para salir.");
                    }
                } while (response != 1 && response != 2);
                if (response == 2) {
                    continuar = false;
                } else {
                    do {
                        System.out.println("¿Desea cambiar la moneda base? \n1. Sí\n2. No");
                        try {
                            response = lectura.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Respuesta inválida. Por favor, ingrese 1 o 2.");
                            lectura.next();
                            response = -1;
                        }
                        if (response != 1 && response != 2) {
                            System.out.println("Respuesta inválida. Por favor, seleccione 1 para cambiar la moneda base o 2 para continuar.");
                        }
                    } while (response != 1 && response != 2);
                    if (response == 1) {
                        baseMonetaria = null;
                    }
                }

            }catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

        }
        System.out.println("\nHistorial de conversiones:");
        for (Historial entry : historial) {
            System.out.println(entry);
        }
    }

    private static String seleccionarMoneda(Scanner scanner, String type) {
        while (true) {
            System.out.printf("Seleccione la moneda %s de las siguientes opciones:%n", type);
            for (int i = 0; i < populares.length; i++) {
                System.out.printf("%d. %s (%s)%n", i + 1, populares[i].getBase(), populares[i].getPais());
            }

            int choice = 0;
            try {
                System.out.print("Ingrese el número de la moneda " + type + ": ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
                continue;
            }

            if (choice >= 1 && choice <= populares.length) {
                return populares[choice - 1].getBase();
            } else {
                System.out.println("Selección inválida. Por favor, intente de nuevo.");
            }
        }
    }
}
