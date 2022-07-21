package bridge.abstracta;

public interface IPago {
    public double getInteres(int plazo);

    public double getCuota(double interes, int plazo, int precio);

    public double getPrecioTotal (double cuota, int plazo, int precio);

    public double getGananciaEntidad(double interes, int plazo, int precio);

    public double getCuotaRegular( int plazo, int precio);
}