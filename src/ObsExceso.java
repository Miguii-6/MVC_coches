import java.util.Observable;
import java.util.Observer;
public class ObsExceso implements Observer{
    View miVista = new View();

    /**
     * oberva cuando cambia la velocidad
     * @param o     the observable object.
     * @param arg   an argument passed to the {@code notifyObservers}
     *                 method.
     */

    @Override
    public void update(Observable o, Object arg) {
        Coche coche = (Coche) arg;
        if(coche.velocidad>120) {
            miVista.mostrarExceso(coche.matricula, coche.velocidad);
        }else{
            miVista.muestraVelocidad(coche.matricula, coche.velocidad);
        }
    }
}
