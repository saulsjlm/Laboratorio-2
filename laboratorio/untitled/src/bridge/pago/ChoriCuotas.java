package bridge.pago;

import bridge.abstracta.IPago;

public class ChoriCuotas implements IPago {

    @Override
    public double getInteres(int plazo) {
        double interes = 0.0;

        if (plazo == 12) {
            interes = 11.0;
        } else if (plazo == 18) {
            interes = 16.5;
        } else if (plazo == 24) {
            interes = 21.5;
        }

        return interes;
    }

    @Override
    public double getCuotaRegular( int plazo, int precio) {
        double payment = precio/plazo;
        return payment;
    }

    @Override
    public double getCuota(double interes, int plazo, int precio) {
        double payment = precio/plazo;
        double paymentInterests = (payment * interes)/100;

        return payment + paymentInterests;
    }

    @Override
    public double getGananciaEntidad(double interes, int plazo, int precio) {
        double payment = precio/plazo;
        double paymentInterests = (payment * interes)/100;

        return paymentInterests * plazo;
    }

    @Override
    public double getPrecioTotal (double cuota, int plazo, int precio) {
        return cuota*plazo;
    }

}