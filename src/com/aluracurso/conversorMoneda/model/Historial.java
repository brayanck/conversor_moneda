package com.aluracurso.conversorMoneda.model;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Historial {

        private String baseMonetaria;
        private String objetivo;
        private double monto;
        private double resultado;
        private double precioUnitario;
        private LocalDateTime dateTime;

        private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public Historial(String baseMonetaria, String objetivo, double monto, double resultado, double precioUnitario) {
            this.baseMonetaria = baseMonetaria;
            this.objetivo = objetivo;
            this.monto = monto;
            this.resultado = resultado;
            this.precioUnitario = precioUnitario;
            this.dateTime = LocalDateTime.now();
        }

        public String getBaseMonetaria() {
            return baseMonetaria;
        }

        public String getObjetivo() {
            return objetivo;
        }

        public double getMonto() {
            return monto;
        }

        public double getResultado() {
            return resultado;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public String getDateTimeFormatted() {
            return dateTime.format(dateTimeFormatter);
        }

    @Override
    public String toString() {
        return baseMonetaria + " a " + objetivo +
                "=> cantidad: " +String.format("%.2f", monto) +" " + baseMonetaria +
                "=>" + String.format("%.2f", resultado)+" "+ objetivo+
                " => " + " - Precio unitario: " + String.format("%.4f", precioUnitario) + objetivo+
                " - " + dateTime.format(dateTimeFormatter);
    }


}
