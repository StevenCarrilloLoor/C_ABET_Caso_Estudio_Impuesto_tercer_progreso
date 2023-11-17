import java.util.ArrayList;
import java.util.List;

public class Impuesto {

    private  float impuesto ;

    public float calcularImpuestoRenta(float sueldo) {
        if (sueldo <= 5000) {
            return 0; // 0% de impuesto
        } else if (sueldo <= 10000) {
            return (sueldo - 5000) * 0.10f; // 10% del exceso a 5000
        } else if (sueldo <= 18000) {
            return (sueldo - 10000) * 0.20f; // 20% del exceso a 10000
        } else {
            return (sueldo - 18000) * 0.30f; // 30% del exceso a 18000
        }
    }

    public float seguroSocial(float sueldoMensual){
        return sueldoMensual*0.093f;
    }
}

