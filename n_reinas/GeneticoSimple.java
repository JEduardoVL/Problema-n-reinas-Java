package n_reinas;

import java.util.ArrayList;
import java.util.Random;

public class GeneticoSimple implements Runnable{

    private int tamanoPoblacion;
    private int numeroEpocas;
    private double probMuta;
    private ArrayList<Individuo> poblacionActual;
    private int n;
    private Individuo mejor;

    public GeneticoSimple(int tamanoPoblacion, int numeroEpocas, double probMuta, int n){
        this.tamanoPoblacion = tamanoPoblacion;
        this.numeroEpocas = numeroEpocas;
        this.probMuta = probMuta;
        this.poblacionActual = new ArrayList<>();
        this.n = n;
        this.mejor = null;
    }

    public void evolucionar(){ 
        //crear de manera aleatoria una poblacion inicial
        generarPoblacionInicial();
        for(int e =0;e<this.getNumeroEpocas();e++){
            ArrayList<Individuo>pobAux = new ArrayList<>();
            int mascara [] = generarMascaraCruza();
            for(int i =0;i<this.getTamanoPoblacion();i++){
                //seleccion
                Individuo madre = Seleccion.seleccionAleatoria(this.getPoblacionActual());
                Individuo padre = Seleccion.seleccionTorneo(this.getPoblacionActual());
                //cruza
                Individuo hijo = Cruza.cruzaMascara(mascara, madre, padre);
                //muta (evaluar)
                if(Math.random()<=this.getProbMuta())Muta.mutaSimple(hijo);
                //agregar a la nueva poblacion
                pobAux.add(hijo);
            }
            //actualizar a la poblacion actual
            actualizarPoblacion(pobAux); 
        this.mejor = Seleccion.seleccionTorneo(this.getPoblacionActual());
        System.out.println("E:" +e + "  "+this.mejor.toString() + " - "+this.getProbMuta() + " - "+ this.getTamanoPoblacion());
    }
        }


        //proceso evolutivo

    private void actualizarPoblacion(ArrayList<Individuo> aux) {
        this.setPoblacionActual(new ArrayList<>());
        for(Individuo i :aux){
            this.getPoblacionActual().add(new Individuo(i.getFitness(), i.getGenotipo())); 
        }
    }

    private void generarPoblacionInicial() {
        for(int i = 0; i < this.getTamanoPoblacion();i++){
            this.getPoblacionActual().add(new Individuo(this.getN()));
        }
    }

    private int[] generarMascaraCruza() {
        int mascara[] = new int[this.getN()];
        Random ran = new Random();
        for(int x =0;x<this.getN();x++){
            mascara[x] = ran.nextInt();
        }
        return mascara;
    }
    
    
    
    @Override
    public void run(){
        evolucionar();
    }

    
    /**
     * @return the probMuta
     */
    public double getProbMuta() {
        return probMuta;
    }

    /**
     * @param probMuta the probMuta to set
     */
    public void setProbMuta(double probMuta) {
        this.probMuta = probMuta;
    }

    /**
     * @return the poblacionActual
     */
    public ArrayList<Individuo> getPoblacionActual() {
        return poblacionActual;
    }

    /**
     * @param poblacionActual the poblacionActual to set
     */
    public void setPoblacionActual(ArrayList<Individuo> poblacionActual) {
        this.poblacionActual = poblacionActual;
    }

    /**
     * @return the tamanoPoblacion
     */
    public int getTamanoPoblacion() {
        return tamanoPoblacion;
    }

    /**
     * @param tamanoPoblacion the tamanoPoblacion to set
     */
    public void setTamanoPoblacion(int tamanoPoblacion) {
        this.tamanoPoblacion = tamanoPoblacion;
    }

    /**
     * @return the numeroEpocas
     */
    public int getNumeroEpocas() {
        return numeroEpocas;
    }

    /**
     * @param numeroEpocas the numeroEpocas to set
     */
    public void setNumeroEpocas(int numeroEpocas) {
        this.numeroEpocas = numeroEpocas;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
}
