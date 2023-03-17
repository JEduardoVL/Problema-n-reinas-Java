package n_reinas;

import java.util.Random;

public class Individuo {
    //el grado de bondad
    private int fitness;
    private int genotipo[];
    int n;

    public Individuo(int n){
        ///000000
        this.genotipo = generarGenotipoAleatorio(n);
        this.n = n;
        calcularFitness();

    }
    public Individuo(int fitness, int[] genotipo){
        this.fitness = fitness;
        this.genotipo = genotipo;
        this.n = genotipo.length;
    }
    public Individuo(int[] genotipo){
        this.genotipo = genotipo;
        this.n = genotipo.length;
        calcularFitness();
    }

    public void calcularFitness() {
        this.fitness = 0;
        // recorremos el genotipo
        for(int x=0;x<this.n-1;x++){
            for(int y=x+1;y<this.n;y++){
                // evaluamos los ataques
                int a = this.genotipo[x];
                int b = this.genotipo[y];
                int auxx = this.genotipo[x]-x;
                int auxy = this.genotipo[y]-y;
                int aux2x = this.genotipo[x]+x;
                int aux2y = this.genotipo[y]+y;
                if(a==b||auxx==auxy||aux2x==aux2y){
                    this.fitness+=2;
                }
            
            }
         }

    }
    
    public int getFitness() {
        return fitness;
    }
    public int[] getGenotipo() {
        return genotipo;
    }
    private int[] generarGenotipoAleatorio(int n)
    {
        int aux[] = new int[n];
        Random ran = new Random();
        for(int x =0;x<n;x++){
            aux[x] = ran.nextInt(n);
        }
        return aux;
    }

    public String toString(){
     //   String aux = ""+this.genotipo.toString()+"F :"+this.fitness;
     String aux = "F :"+this.fitness;
        return aux; 
    }

    
}
