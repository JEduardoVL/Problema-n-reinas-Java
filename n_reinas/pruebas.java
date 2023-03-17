package n_reinas;

 //import java.util.ArrayList;

public class pruebas {
    public static void main(String[] args) {
        /*Individuo i1 = new Individuo(new int[]{2,0,3,1});
        System.out.println(i1.getFitness());

        Individuo i2 = new Individuo(new int[]{0,0,0,0});
        System.out.println(i2.getFitness());

        ArrayList<Individuo>p1 = new ArrayList<>();
        p1.add(i1);
        p1.add(i2);
        ArrayList<Individuo> p2 = (ArrayList<Individuo>p1.clone());*/

/* 
        // prubas F_G
        GeneticoSimple g = new GeneticoSimple(70, 30000, 0.75, 1000);
        g.evolucionar();
         
        System.out.println();*/


        GeneticoSimple g = new GeneticoSimple(70, 30000, 0.75, 1000);
        Thread hilo = new Thread(g);
        //se usa el start para ejecutar el run 
        hilo.start();
        
        Reinas_int frame = new Reinas_int(g);
        frame.setVisible(true);



        /* 
       Muta.mutaSimple(i2);
       System.out.println(null);*/
    }
    
}
