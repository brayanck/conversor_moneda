# Conversor de Moneda

## Descripción del Proyecto

Este proyecto es un conversor de moneda basado en consola desarrollado en Java. Permite a los usuarios convertir una cantidad de una moneda a otra utilizando tasas de cambio actuales obtenidas de la API de ExchangeRate-API. Además, el programa mantiene un historial de conversiones que incluye detalles como las monedas involucradas, la cantidad convertida, el resultado, el precio unitario y la fecha y hora de la conversión.

## Funcionalidades

1. **Selección de Moneda Base**: El usuario puede seleccionar una moneda base de una lista de monedas populares.
2. **Selección de Moneda Objetivo**: El usuario puede seleccionar una moneda objetivo a la cual convertir la moneda base.
3. **Conversión de Cantidad**: El usuario ingresa la cantidad a convertir y el programa realiza la conversión utilizando las tasas de cambio actuales.
4. **Historial de Conversiones**: El programa guarda un historial de todas las conversiones realizadas, incluyendo la fecha y hora, las monedas involucradas, la cantidad convertida, el resultado y el precio unitario.
5. **Interacción Continua**: El usuario puede elegir realizar múltiples conversiones y cambiar la moneda base según sea necesario.
6. **Control de Errores**: El programa maneja entradas inválidas y errores de manera robusta, solicitando al usuario que ingrese datos correctos.

## Uso

### Ejecución del Programa

1. Clona este repositorio en tu máquina local.
2. Asegúrate de tener Java instalado.
3. Compila y ejecuta el programa desde la línea de comandos o tu IDE favorito.

### Interacción

1. El programa solicitará al usuario que seleccione una moneda base de una lista.
2. Luego, el usuario seleccionará una moneda objetivo para convertir.
3. El usuario ingresa la cantidad a convertir.
4. El programa realiza la conversión y muestra el resultado.
5. Se le pregunta al usuario si desea realizar otra conversión o salir del programa.
6. Si el usuario desea cambiar la moneda base, se le da la opción de hacerlo.
7. Al salir, el programa muestra el historial de todas las conversiones realizadas.

### Ejemplo de Uso

[![Ejemplo de Uso](https://github.com/brayanck/conversor_moneda/assets/86504383/de2e0cb9-32c1-4d53-bb39-1c10a5e808d2)

## Código Fuente

### Clase Principal (`Main.java`)

Esta clase contiene la lógica principal del programa, incluyendo la interacción con el usuario y la gestión del flujo del programa.

### Clase `Moneda`

Esta clase representa una moneda con un código y un país asociado.

### Clase `Historial`

Esta clase almacena la información de cada conversión realizada, incluyendo las monedas involucradas, la cantidad, el resultado, el precio unitario y la fecha y hora de la conversión.

### Clase `Convertidor`

Esta clase contiene métodos para obtener las tasas de cambio desde la API y realizar la conversión de moneda.

### Clase `Cambios`

Esta clase representa la respuesta de la API de tasas de cambio.
# Autor
Brayan Mampaso Romero

