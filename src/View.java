public class View {
    /**
     * Método ver velocidad actual del coche
     * @param matricula -> matricula del coche
     * @param v -> velocidad del coche
     */
    void muestraVelocidad(String matricula, Integer v){
        Dialog.msjDialog("El coche " + matricula + " tiene una velocidad de: " + v + "km/h");
    }

    /**
     * Metodo para ver o coche que mostra o coche
     * ou que diga que non existe o coche
     * @param aux -> auxiliar do coche
     * @param matricula -> matricula do coche (por si non existe)
     */
    void mostrarCoche(Coche aux, String matricula){
        if(aux==null){
            Dialog.msjDialog("Non existe o coche ca matrícula: " + matricula);
        }
        else{
            Dialog.msjDialog("O coche co  " + aux.modelo + " coa matrícula: " + aux.matricula + " ten unha velocidad de: " + aux.velocidad +"km/h");
        }
    }
}
    

