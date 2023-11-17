import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListaEmpleados {
private List<RolEmpleado> lEmpleado;
Impuesto impuesto = new Impuesto();

    public ListaEmpleados(){
        lEmpleado=new ArrayList<RolEmpleado>();
    }

    public void agregarEmpleado(RolEmpleado nuevoEmpleado){
        lEmpleado.add(nuevoEmpleado);
    }

    public RolEmpleado eliminarEmpleado() throws Exception{
    //actualice el método para eliminar el elemento del inicio
            if(lEmpleado.isEmpty())
                throw new Exception("No hay elementos");
            return lEmpleado.remove(lEmpleado.size()-1);
    }
    //ELIMINAR EMPLEADO EXACTO
    public RolEmpleado eliminarEmpleadoExacto(int poscicion) throws Exception{
        //actualice el método para eliminar el elemento del inicio
        if(lEmpleado.isEmpty())
            throw new Exception("No hay elementos");
        return lEmpleado.remove(poscicion);
    }
    //ANADIR EMPLEADOS EXACTOS
    public void nuevoEmpleadoExacto(RolEmpleado nuevoEmpleado){
        lEmpleado.add(nuevoEmpleado);
    }
    public boolean soloNumerosComando(String texto) throws Exception {
        for(int i=0 ; i<10; i++){
            if (!Character.isDigit(texto.charAt(i))) {
                throw new Exception("LA CEDULA NO DEBE TENER LETRAS");
            }
        }
        return true;
    }
//LISTAR EMPLEADO CON DEUDAS
    public String listarEmpleado(){
        String resultado="";
        for( RolEmpleado rolempleado: lEmpleado){
            resultado+=rolempleado.toString();
        }
        return lEmpleado.size()>0?resultado:"No hay elementos";
    }
    //LISTAR EMPLEADOS
    public String listarEmpleadoSinDeuda(){
        String resultado="";
        for( RolEmpleado rolempleado: lEmpleado){
            resultado+=rolempleado.listarEmpleados2();
        }
        return lEmpleado.size()>0?resultado:"No hay elementos";
    }
    //llenar Jlist
    public List<RolEmpleado> jList(){
        return lEmpleado.stream().collect(Collectors.toList());
    }

    //BUSQUEDA DE CODIGO--------------------------------------------------
    public RolEmpleado buscarCedula(int cedula) throws Exception {
        int i =0;
        int s=lEmpleado.size()-1;
        int c=0;
        while((i<=s)){
            c=(i+s)/2;
            RolEmpleado aux=lEmpleado.get(c);
            if(cedula==aux.getCedula()){
                return aux;
            } else if(cedula<aux.getCedula()){
                s=c-1;
            }else{
                i=c+1;
            }
        }
        throw new Exception("No existe un empleado con esta cedula ");
    }
    //----------------------------------------------------------------------------
    //Encontrar la posicion del objeto buscado
    public int hallarPosicion(RolEmpleado empleado){
        return lEmpleado.indexOf(empleado);
    }
    //REMPLAZAR INFORMACION DE EMPLEADO
    public RolEmpleado remplazarNombre(String nombre2, int posicion){
        int cedula=lEmpleado.get(posicion).getCedula();
        float sueldo=lEmpleado.get(posicion).getSueldoMensual();
        float seguro=lEmpleado.get(posicion).getAporteAlSeguro();
        float impuestos=lEmpleado.get(posicion).getImpuestoALaRenta();
        RolEmpleado empleadoNuevo=new RolEmpleado(cedula,nombre2,sueldo,seguro,impuestos);
        return empleadoNuevo;
    }
    public RolEmpleado remplazarSueldo(Float sueldo2, int posicion){
        int cedula=lEmpleado.get(posicion).getCedula();
        String nombre2=lEmpleado.get(posicion).getNombreEmpleado();
        float seguro=impuesto.seguroSocial(sueldo2);
        float impuestos=impuesto.calcularImpuestoRenta(sueldo2);
        RolEmpleado empleadoNuevo=new RolEmpleado(cedula,nombre2,sueldo2,seguro,impuestos);
        return empleadoNuevo;
    }
    public RolEmpleado remplazarAmbas(String nombre2,float sueldo2,int posicion){
        int cedula=lEmpleado.get(posicion).getCedula();
        float seguro=impuesto.seguroSocial(sueldo2);
        float impuestos=impuesto.calcularImpuestoRenta(sueldo2);
        RolEmpleado empleadoNuevo=new RolEmpleado(cedula,nombre2,sueldo2,seguro,impuestos);
        return empleadoNuevo;
    }

}
