package bridge.pago;

import bridge.abstracta.IPago;

public class ContadoTarjeta implements IPago {

    @Override
    public double getInteres(int plazo) {
        return 1.0;
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
        double payment = precio /100;
        return payment;
    }

    @Override
    public double getPrecioTotal (double cuota, int plazo, int precioInicial) {
        double payment = precioInicial /100;
        return precioInicial + payment;
    }
}