package n_reinas;

import java.util.Random;

public class Muta {
    public  static void mutaSimple(Individuo aux){
        // modificación genotipica
        Random ran = new Random(); 
        int i = ran.nextInt(aux.getGenotipo().length);
        int nuevoValor = ran.nextInt(aux.getGenotipo().length);
        aux.getGenotipo()[i] = nuevoValor;
        //actualización de fitness
        aux.calcularFitness();

    }
    
}
