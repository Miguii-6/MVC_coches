public class Controller {
    static Model miModelo = new Model();
    static View miVista = new View();
    public static void main(String[] args) {
        IU.crearVentana();
    }
    /**
     * Método para crear un nuevo coche
     * @param modelo -> modelo del coche
     * @param matricula -> matricula que tiene el coche
     */
    public static void crearCoche(String modelo, String matricula){
        Coche aux = miModelo.crearCoche(modelo,matricula);
        if(aux!=null){
            miVista.muestraVelocidad(aux.matricula, aux.velocidad);
        }
    }
    /**
     * Método bajar velocidad de un coche
     * @param matricula -> matricula del coche a disminuir su velocidad
     */
    public static void bajarVelocidad(String matricula){
        int aux = miModelo.bajarVelocidad(matricula);
        miVista.muestraVelocidad(matricula, aux);
    }
    /**
     * Método aumentar velocidad de un coche
     * @param matricula -> matricula del coche a aumentar su velocidad
     */
    public static void aumentarVelocidad(String matricula){
        int aux = miModelo.subirVelocidad(matricula);
        miVista.muestraVelocidad(matricula,aux);
    }

    //empezamos o examen

    /**
     * Método buscar coche que mostre o coche si existe
     * ou que mostre que non haxa coche
     * @param matricula -> matricula do coche
     * Colle o metodo getCoche do Model e ao mostrarCoche da Viw
     */
    public static void buscarCoche(String matricula){
        //recolle el coche do modelo
        Coche aux = miModelo.getCoche(matricula);
        //chama a vista para que mostre o coche
        miVista.mostrarCoche(aux, matricula);
    }

}