import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[]args){
        boolean continuar=true;
        int opcion=0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (continuar){
                System.out.println("*********************");
                System.out.println("Seleccione una opcion");
                System.out.println("1 Convertir moneda");
                System.out.println("2 Cerrar programa");
                System.out.println("*********************");
                opcion= scanner.nextInt();
                scanner.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("**************************************");
                        System.out.println("Ingrese la mondeda que desea convertir");
                        String baseCurrency = scanner.nextLine().toUpperCase();
                        System.out.println("Ingrese la moneda de destino");
                        String targetCurrency = scanner.nextLine().toUpperCase();
                        System.out.println("Ingree el monto a convertir");
                        double cantidad = scanner.nextDouble();

                        ConsultasTasaCambio consultasTasaCambio = new ConsultasTasaCambio();
                        TasaCambio tasaCambio = consultasTasaCambio.obtenerTasaCambio(baseCurrency, targetCurrency);
                        ConvertidorDeMoneda convertidorDeMoneda = new ConvertidorDeMoneda();
                        double montoConvertido = convertidorDeMoneda.convertir(cantidad, tasaCambio);
                        System.out.printf("El monto convertido de %s a %s es: %.2f %s\n", baseCurrency, targetCurrency, montoConvertido, targetCurrency);
                        System.out.println("*********************************************************************************");
                        break;
                    case 2:
                        continuar = false;
                        System.out.println("Cerrando programa");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Ingrese una opcion valida");
                        break;

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}








