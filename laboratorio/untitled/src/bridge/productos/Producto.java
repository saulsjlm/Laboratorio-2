package bridge.productos;

import bridge.abstracta.AbstractaProducto;
import bridge.abstracta.IPago;

public class Producto extends AbstractaProducto {

    public Producto(IPago pPago, int pType, String nombreProducto, int precio, int tipoPago, int plazo) {
        this.nombreProducto = nombreProducto;
        this.precioInicial = precio;
        this.tipoFinanciamiento = tipoPago;
        this.plazo = plazo;
    }

    @Override
    public String get_info_producto() {
        String message = "";

        message += "Nombre del producto: " + this.nombreProducto + "\n";
        message += "Precio inicial: " + this.precioInicial + "\n";
        message += "Cantidad de meses escojidos: " + generarPlazo(this.plazo) + "\n";
        message += "Tipo de financiamiento: " + generarTipoFinanciamiento(this.tipoFinanciamiento) + "\n";
        message += "Cuota regular: " + this.cuotaRegular + "\n";
        message += "Cuota financiada: " + this.cuotaFinanciada + "\n";
        message += "Precio total: " + this.precioTotal + "\n";
        message += "Ganancia de la entidad: " + this.gananciaEntidad + "\n";

        return message;
    }

    private int generarPlazo(int opcion) {
        int pPlazo = 0;

        switch (opcion) {
            case 1:
                pPlazo = 12;
                break;
            case 2:
                pPlazo = 18;
                break;
            case 3:
                pPlazo = 24;
                break;
            default:
                break;
        }

        return pPlazo;
    }

    private String generarTipoFinanciamiento(int opcion) {
        String pPago = "";

        switch (opcion) {
            case 1:
                pPago = "Contado";
                break;
            case 2:
                pPago = "Contado con tarjeta";
                break;
            case 3:
                pPago = "CenfoCuotas";
                break;
            case 4:
                pPago = "ChoriCuotas";
                break;
            default:
                break;
        }

        return pPago;
    }
}