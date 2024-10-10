import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[]args){
        Scanner scanner= new Scanner(System.in);
        try {
            System.out.println("Ingrese la mondeda que desea convertir");
            String baseCurrency = scanner.nextLine().toUpperCase();
            System.out.println("Ingrese la moneda de destino");
            String targetCurrency = scanner.nextLine().toUpperCase();
            System.out.println("Ingree el monto a convertir");
            double cantidad=scanner.nextDouble();

            ConsultasTasaCambio consultasTasaCambio=new ConsultasTasaCambio();
            TasaCambio tasaCambio= consultasTasaCambio.obtenerTasaCambio(baseCurrency, targetCurrency);
            ConvertidorDeMoneda convertidorDeMoneda=new ConvertidorDeMoneda();
            double montoConvertido=convertidorDeMoneda.convertir(cantidad, tasaCambio);
            System.out.printf("El monto convertido de %s a %s es: %.2f $s\n",baseCurrency, targetCurrency,montoConvertido, targetCurrency);
        } catch (Exception e) {
            System.out.println("Eror: "+e.getMessage());
        }finally {
            scanner.close();
        }
    }
}








