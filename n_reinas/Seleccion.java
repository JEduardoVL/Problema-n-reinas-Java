package n_reinas;

import java.util.ArrayList;
import java.util.Random;

public class Seleccion {
    public static Individuo seleccionAleatoria(ArrayList<Individuo>pob){
        Random ran = new Random();
        int i = ran.nextInt(pob.size());
        return new Individuo(pob.get(i).getFitness(),pob.get(i).getGenotipo());
    } 

    public static Individuo seleccionTorneo(ArrayList<Individuo>pob){
        int mejor =0;
        for(int x =1; x<pob.size();x++){
            if(pob.get(x).getFitness()<pob.get(mejor).getFitness()){
                mejor = x;
            }
        }
        return new Individuo(pob.get(mejor).getFitness(),pob.get(mejor).getGenotipo());
    }

}
