# Currency Converter

Este proyecto es un convertidor de monedas que permite realizar conversiones de diferentes divisas utilizando la API de ExchangeRate. El programa está implementado en Java y utiliza una interfaz de consola para recibir las entradas del usuario y mostrar los resultados de las conversiones.

## Funcionalidades
- Conversión de monedas entre diferentes divisas.
- Entrada de usuario para seleccionar la moneda base, la moneda de destino y la cantidad a convertir.
- Consulta en tiempo real de tasas de cambio utilizando la API de ExchangeRate.
- Menú interactivo con opciones para realizar múltiples conversiones o salir del programa.

## Requisitos
- **Java 17** o superior.
- Conexión a Internet para realizar las consultas a la API de ExchangeRate.
- Cuenta en [ExchangeRate API](https://app.exchangerate-api.com/) para obtener una clave API.

## Estructura del Proyecto

El proyecto se organiza en las siguientes clases:

### 1. `CurrencyConverter`
Esta es la clase principal que ejecuta el programa. Contiene un menú que permite al usuario seleccionar opciones numéricas para realizar conversiones o salir del programa. Utiliza la clase `Scanner` para capturar la entrada del usuario y controla el flujo principal de la aplicación.

### 2. `ConsultaTasasCambio`
Esta clase realiza la solicitud HTTP a la API de ExchangeRate para obtener las tasas de cambio. Utiliza la clase `HttpClient` para realizar la solicitud y convierte la respuesta JSON a un objeto manejable en Java usando `Gson`.

### 3. `TasaCambio`
Es una `record class` que encapsula la tasa de cambio entre dos monedas. Contiene los campos:
- `monedaBase`: La moneda desde la que se realiza la conversión.
- `monedaDestino`: La moneda a la que se desea convertir.
- `tasa`: La tasa de cambio entre las dos monedas.

### 4. `ConvertidorDeMoneda`
Esta clase se encarga de realizar la conversión de una cantidad de dinero de la moneda base a la moneda de destino, utilizando la tasa proporcionada por `TasaCambio`.

## Instalación y Ejecución

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/LilyVaz/CurrencyConverer.git

