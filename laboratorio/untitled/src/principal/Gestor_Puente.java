package principal;

import java.util.ArrayList;

import bridge.abstracta.AbstractaProducto;
import bridge.abstracta.IPago;
import bridge.productos.Producto;

public class Gestor_Puente {
    private static ArrayList <AbstractaProducto> gobal_array_productos;
    public String Mensaje;


    public Gestor_Puente() {
        setGobal_array_productos(new ArrayList<AbstractaProducto>());
        Mensaje="";
    }
    /****************************************************************************************
     * Nombre: Datos a Imprimir
     * Descripción: Esta funcion imprime un text en un formato especifico.
     * @param	pText (String) Texto a imprimir
     * @return
     * @return	n/A
     ****************************************************************************************/
    public String datos_Imprimir(String pText) {
        return "\n-------------------------------------------------------\n"
                + pText
                +"\n-------------------------------------------------------";
    }

    /****************************************************************************************
     * Nombre: instanciar Figura
     * Descripción: Esta funcion permite crear una nueva figura, de un color específico. .
     * @param	pPago (IPago) contiene las funciones que calculan las cuotas (puede venir en null)
     * 			pID  (int)	ID del producto.
     * @return	n/A
     ****************************************************************************************/
    public void instanciarProducto(IPago pPago, int pID, String nombreProducto, int precio, int tipoPago, int plazo) {
        AbstractaProducto loca_abstract_producto = new Producto(pPago, pID, nombreProducto, precio, tipoPago, plazo);
        getGobal_array_productos().add(loca_abstract_producto);
        Mensaje = loca_abstract_producto.get_info_producto();
    }

    /****************************************************************************************
     * Nombre: instanciar Figura
     * Descripción: Esta funcion permite crear una nueva figura, de un color específico. .
     * @param	pPago (IPago) tipo de pago para el producto (puede venir en null)
     * 			pType  (int)	Opcion para determinar el tipo de figura.
     * @return	n/A
     ****************************************************************************************/
    public void aplicarFinanciamiento(IPago pPago, int pId) {
        AbstractaProducto loca_abstract_producto = get_Producto(pId);
        loca_abstract_producto.setGlobal_interes_aplicado(pPago);
        Mensaje = loca_abstract_producto.get_info_producto();
    }

    /****************************************************************************************
     * 							Seccion para GETS y SETS
     ****************************************************************************************/
    public static ArrayList <AbstractaProducto> getGobal_array_productos() {
        return gobal_array_productos;
    }

    public static AbstractaProducto get_Producto(int pId) {
        return gobal_array_productos.get(pId);
    }

    public static void setGobal_array_productos(ArrayList <AbstractaProducto> gobal_array_productos) {
        Gestor_Puente.gobal_array_productos = gobal_array_productos;
    }
}
