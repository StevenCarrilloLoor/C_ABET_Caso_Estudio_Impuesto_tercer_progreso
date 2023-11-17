public class RolEmpleado {
    //Problema:
    //
    //El rol de pagos de un empleado para una empresa está constituido por los siguientes atributos:
    //
    //-Cédula
    //
    //-Nombre del empleado
    //
    //-Sueldo mensual
    //
    //-Aporte al Seguro Social (9.35% del sueldo)
    //
    //-Impuesto a la renta, de acuerdo con el siguiente cuadro:

    private int cedula;
    private String nombreEmpleado;
    private float sueldoMensual;
    private float aporteAlSeguro;
    private float impuestoALaRenta;

    public float getAporteAlSeguro() {
        return aporteAlSeguro;
    }

    public void setAporteAlSeguro(float aporteAlSeguro) {
        this.aporteAlSeguro = aporteAlSeguro;
    }

    public float getImpuestoALaRenta() {
        return impuestoALaRenta;
    }

    public void setImpuestoALaRenta(float impuestoALaRenta) {
        this.impuestoALaRenta = impuestoALaRenta;
    }

    public RolEmpleado(int cedula, String nombreEmpleado, float sueldoMensual, float aporteAlSeguro, float impuestoALaRenta) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.sueldoMensual = sueldoMensual;
        this.aporteAlSeguro = aporteAlSeguro;
        this.impuestoALaRenta = impuestoALaRenta;
    }

    public RolEmpleado(int cedula, String nombreEmpleado, float sueldoMensual) {
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.sueldoMensual = sueldoMensual;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    @Override
    public String toString() {
        return "==========INFORME DEL EMPLEADO "+nombreEmpleado+"=========\n"+
                "Cedula: " + cedula +
                "\nNombre del Empleado: " + nombreEmpleado +
                "\nSueldo Mensual: " + sueldoMensual +
                "\nAporte al Seguro Social: " + aporteAlSeguro +
                "\nImpuesto a la Renta: " + impuestoALaRenta + "\n"
                +"---------------------------------------------------\n";
    }
    public String listarEmpleados2(){
        return "==========================================\n"+
                "\nCedula: " + cedula +
                "\nNombre del Empleado: " + nombreEmpleado +
                "\nSueldo Mensual: " + sueldoMensual+"\n==========================================="+ "\n";
    }


}
