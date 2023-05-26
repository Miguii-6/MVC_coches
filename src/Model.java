import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Crea un coche y lo mete en el parking
     * @param modelo del coche
     * @param matricula identificador unico
     * @return el coche creado
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * @param matricula
     * @param v nueva velocidad
     * @return velocidad modificada
     */
    public Integer cambiarVelocidad(String matricula, Integer v) {
        // busca el coche
        getCoche(matricula).velocidad = v;
        // retorna la nueva velocidad
        return getCoche(matricula).velocidad;
        /**
         * Busca coche segun matricula
         * @param matricula a buscar
         * @return chche o null si no existe
         */
    }
    public Coche getCoche(String matricula){
        Coche aux = null;
        // recorre el array buscando por matricula
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }


    /**
     * Ddevuelve la velocidad segun la matricula
     * @param matricula
     * @return
     */

    public Integer getVelocidad(String matricula) {
        return getCoche(matricula).velocidad;
    }

    //Empezo ca tarea
    /**
     * Sube la velocidad del coche y notifica al observer ç
     * @param matricula -> matricula del coche a subir velocidad
     */

    public Integer subirVelocidad(String matricula) {
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad += 40; // Aumenta a velocidad en 40
            setChanged();
            notifyObservers(coche);
            return coche.velocidad;
        }
        return null; // Retorna null si o coche non existe
    }

    /**
     * Baja la velocidad del coche y notifica al observer ç
     * @param matricula -> matricula del coche a subir velocidad
     */

    public Integer bajarVelocidad(String matricula){
        Coche coche = getCoche(matricula);
        if (coche != null) {
            coche.velocidad -= 40; // Disminue a velocidad en 40
            setChanged();
            notifyObservers(coche);
            return coche.velocidad;
        }
        return null; // Retorna null si o coche non existe
    }



}
