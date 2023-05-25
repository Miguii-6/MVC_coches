public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        OVelocidad oVelocidad = new OVelocidad();
        miModelo.addObserver(oVelocidad);
        IU.crearVentana();
    }

    /**
     * @param modelo
     * @param matricula
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    /**
     * @param matricula
     */
    public static void bajarVelocidad(String matricula){
        miModelo.bajarVelocidad(matricula);
    }

    /**
     * @param matricula
     */
    public static void aumentarVelocidad(String matricula){
        miModelo.subirVelocidad(matricula);
    }

    //empezamos o examen

    /**
     * Devolve os datos do coche pola matricula
     * @param matricula
     * @return

     */
    public static void buscarCoche(String matricula) {

        Coche aux = miModelo.getCoche(matricula);
        if (aux != null) {
            miVista.mostrarCoche(aux.matricula, aux.modelo, aux.velocidad);
        } else {
            Dialog.msjDialog("Coche no encontrado.");
        }
    }

}