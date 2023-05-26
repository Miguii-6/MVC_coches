public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        //instacio a clase ObsExceso e mias agrego un observer no miModelo co obxecto obsExceso
        ObsExceso obsExceso = new ObsExceso();
        miModelo.addObserver(obsExceso);
        IU.crearVentana();
    }
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }

    public static void bajarVelocidad(String matricula){
        miModelo.bajarVelocidad(matricula);

    }

    public static void aumentarVelocidad(String matricula){
         miModelo.subirVelocidad(matricula);

    }
}