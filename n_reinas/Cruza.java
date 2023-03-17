package n_reinas;

public class Cruza {

    public static Individuo cruzaMascara(int mascara[], Individuo i1, Individuo i2){
        int geno1 [] = new int[i2.getGenotipo().length];
        int geno2 [] = new int[i2.getGenotipo().length];
        // recorrer la mascara
        
        for(int x =0;x<mascara.length;x++){
            if(mascara[x]==1){
                geno1[x] = i1.getGenotipo()[x];
                geno2[x] = i2.getGenotipo()[x];
            }else{
                geno1[x] =i2.getGenotipo()[x];
                geno2[x] =i1.getGenotipo()[x];
            }
        }
        Individuo h1 = new Individuo(geno1);
        Individuo h2 = new Individuo(geno2);

        if(h1.getFitness()<h2.getFitness()) return h1;
        
        return h2;
    
    }
    

}
