package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import bridge.abstracta.IPago;
import bridge.pago.*;

public class Principal_Puente {

    private static Gestor_Puente gestor;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] arg) throws IOException {
        gestor = new Gestor_Puente();
        String nombreProducto = "";
        int precio = 0;
        int tipoPago = 0;
        int plazo = 0;

        imprimir(gestor.datos_Imprimir("Informacion del producto:"));
        System.out.println("Ingrese el nombre del producto");
        nombreProducto = br.readLine();
        System.out.println("Ingrese el precio del producto");
        precio = Integer.parseInt(br.readLine());
        System.out.println("Ingrese el tipo de pago");
        System.out.println("1) Contado");
        System.out.println("2) Contado con tarjeta");
        System.out.println("3) CenfoCuotas");
        System.out.println("4) ChoriCuotas");
        tipoPago = Integer.parseInt(br.readLine());

        switch (tipoPago) {
            case 1:
                nuevaProducto(new Contado(), 0, nombreProducto, precio, tipoPago, plazo);
                aplicarFinanciamiento(new Contado(), 0);
                break;
            case 2:
                nuevaProducto(new ContadoTarjeta(), 0, nombreProducto, precio, tipoPago, plazo);
                aplicarFinanciamiento(new ContadoTarjeta(), 0);
                break;
            case 3:
                plazo = askFinancing();
                nuevaProducto(new CenfoCuotas(), 0, nombreProducto, precio, tipoPago, plazo);
                aplicarFinanciamiento(new CenfoCuotas(), 0);
                break;
            case 4:
                plazo = askFinancing();
                nuevaProducto(new ChoriCuotas(), 0, nombreProducto, precio, tipoPago, plazo);
                aplicarFinanciamiento(new ChoriCuotas(), 0);
                break;
            default:
                break;
        }

        System.out.println(gestor.Mensaje);
    }

    private static int askFinancing() throws IOException {
        int plazo = 0;
        System.out.println("Ingrese el plazo de financiamiento");
        System.out.println("1) 12 meses");
        System.out.println("2) 18 meses");
        System.out.println("3) 24 meses");
        int opcion = Integer.parseInt(br.readLine());

        switch (opcion) {
            case 1:
                plazo = 12;
                break;
            case 2:
                plazo = 18;
                break;
            case 3:
                plazo = 24;
                break;
            default:
                break;
        }
        return plazo;
    }

    private static void imprimir(String pText) {
        System.out.println(pText);
    }

    private static void aplicarFinanciamiento(IPago pPago, int pId) {
        gestor.aplicarFinanciamiento(pPago,pId);
    }

    private static void nuevaProducto(IPago pPago, int pId, String nombreProducto, int precio, int tipoPago, int plazo) {
        gestor.instanciarProducto(pPago,pId, nombreProducto, precio, tipoPago, plazo);
    }
}
