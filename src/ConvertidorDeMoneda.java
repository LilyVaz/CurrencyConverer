public class ConvertidorDeMoneda {
    public double convertir(double cantidad, TasaCambio tasaCambio){
        return cantidad*tasaCambio.tasa();
    }
}
