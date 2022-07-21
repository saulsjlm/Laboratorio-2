package bridge.pago;

import bridge.abstracta.IPago;

public class Contado implements IPago {

    @Override
    public double getInteres(int plazo) {
        return 0.0;
    }

    @Override
    public double getCuotaRegular( int plazo, int precio) {
        return 0.0;
    }

    @Override
    public double getCuota(double interes, int plazo, int precio) {
        return 0.0;
    }

    @Override
    public double getGananciaEntidad(double interes, int plazo, int precio) {
        return 0.0;
    }

    @Override
    public double getPrecioTotal (double cuota, int plazo, int precioInicial) {
        return precioInicial;
    }

}