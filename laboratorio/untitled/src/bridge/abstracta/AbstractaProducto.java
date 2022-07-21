package bridge.abstracta;

public abstract class AbstractaProducto {
    public String nombreProducto;
    public int precioInicial;
    public int tipoFinanciamiento;
    public int plazo;
    public double cuotaRegular;
    public double cuotaFinanciada;
    public double precioTotal;
    public double gananciaEntidad;

    public AbstractaProducto() {};

    //Funciones que los hijos deben de implementar

    public abstract String get_info_producto();


    /*******************************************************************************
     *Estas funciones se agregan en el momento que agregamos la interface de color.
     *******************************************************************************/
    private IPago interes_aplicado;

    //Funciones relaciones puente
    public AbstractaProducto(IPago pIc){
        this.setGlobal_interes_aplicado(pIc);
    }

    public IPago getGlobal_interes_aplicado() {
        return interes_aplicado;
    }

    public void setGlobal_interes_aplicado(IPago tPago) {

        this.cuotaRegular = tPago.getCuotaRegular(this.plazo, this.precioInicial);
        this.cuotaFinanciada = tPago.getCuota(tPago.getInteres(this.plazo), this.plazo, this.precioInicial);
        this.precioTotal = tPago.getPrecioTotal(this.cuotaFinanciada, this.plazo, this.precioInicial);
        this.gananciaEntidad = tPago.getGananciaEntidad(tPago.getInteres(this.plazo), this.plazo, this.precioInicial);

    }

    public String get_info_financiamiento() {
        if(getGlobal_interes_aplicado() != null)
            return " Interes aplicado: "+getGlobal_interes_aplicado().getInteres(plazo);

        return "No aplica financiamiento.";
    }
}

