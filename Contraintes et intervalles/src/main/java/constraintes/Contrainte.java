package constraintes;

import intervalls.Intervalle;

import java.util.*;


public class Contrainte extends ArrayList<Intervalle> {
    /**
     * Constructeur
     * <p>
     * Construis une liste vide.
     * </p>
     */

    public Contrainte(){
        super();
    }

/**
    private intervalls.Intervalle[] intervalles;
    /**
     * Constructeur
     * <p>
     * Construis une liste vide.
     * </p>
     //*
    public constraintes.Contrainte(){
        intervalles = new intervalls.Intervalle[0];
        // super();
    }
**/

/**
     * Constructeur
     * Construit une liste d'intervalls.Intervalle contenant tous les éléments de la Collection.
     * Les éléments de la Collection ne respecte pas nécessairement les invariants d'une constraintes.Contrainte.
     * Il faut donc, s'assurer que le résultat de la construction respecte les invariants d'une constraintes.Contrainte.
     *
     * @param collection collection - La Collection contenant les éléments utilisés pour construire la constraintes.Contrainte.
     *
     * @throws java.lang.NullPointerException - si l'argument collection est null.

**/

/**

public constraintes.Contrainte( Collection< intervalls.Intervalle > collection ) throws  NullPointerException {
    // A FAIRE
    super();
    if (collection != null) {
        //uneCollection = collection;
        list = new ArrayList<>(collection);
        //list.addAll(uneCollection);
        //Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            for ( int j = i+1; j < list.size(); j++){
                if (list.get(j).getDebut() < list.get(i).getFin()){
                    intervalls.Intervalle temp1 = list.get(i);
                    intervalls.Intervalle temp2 = list.get(j);
                    list.set(i, temp2);
                    list.set(j ,temp1);
                }

                if (list.get(i).appartient(list.get(j).getDebut())){
                    intervalls.Intervalle inter = new intervalls.Intervalle(0, 0);
                    if (list.get(j).getFin() > list.get(i).getFin()){
                        inter.setDebut(list.get(i).getDebut());
                        inter.setFin(list.get(j).getFin());
                        list.set(i, inter);
                        super.remove(list.get(j));
                        j--;
                    }
                }
            }
        }
    }
    collection = list;
    uneCollection = collection;
    super.addAll(uneCollection);


}

**/


    public Contrainte( Collection<Intervalle> collection ) throws  NullPointerException {
        super(collection);
    }


/**

    public constraintes.Contrainte( Collection< intervalls.Intervalle > collection ) {


        this.intervalles = new intervalls.Intervalle[10];
        for (int i = 0; i < collection.size(); i++) {
            if(collection.toArray()[i] == null) {
                throw new NullPointerException();
            }else{
                super.add((intervalls.Intervalle) collection.toArray()[i]);
            }
        }
    }


**/








    /**
     * Ajoute un intervalls.Intervalle dans la constraintes.Contrainte.
     * Ajoute un intervalls.Intervalle. Cet ajout ne doit pas briser les invariants de la Constrainte.
     *
     * Toutes les valeurs qui appartenaient à la constraintes.Contrainte avant l'ajout doivent encore appartenir à la constraintes.Contrainte après l'ajout.
     * Toutes les valeurs qui appartiennent à l'intervalls.Intervalle ajouté doivent appartenir à la constraintes.Contrainte résultante.
     * Specified by:
     * add in interface java.util.Collection<intervalls.Intervalle>
     * Overrides:
     * add in class java.util.ArrayList<intervalls.Intervalle>
     * Parameters:
     * intervalle - l'intervalle ajouté dans la liste.
     * préalable : null != intervalle
     *
     * Returns:
     * true.


     */

    public boolean add( Intervalle intervalle ){
        boolean add = false;

        if (intervalle.getDebut() < intervalle.getFin() ) {
            if(this.size() == 0) {
                super.add(intervalle);
            }

            //1 . verifier si l'intervalle est joint
            //1.1 creer la nouvelle intervalle inf sup

            //2. disjoint --> ajouter a la fin de la liste

            //this.intervalles[intervalles.length - 1] = intervalle;

        }
        return add;
    }


    /**
     *
     * public void remove(intervalls.Intervalle intervalle)
     * Enlève un intervalls.Intervalle de la constraintes.Contrainte.
     * Enlève un intervalls.Intervalle. Cette suppression ne doit pas briser les invariants de la Constrainte.
     *
     * Toutes les valeurs qui appartenaient à la constraintes.Contrainte avant et qui n'appartiennent pas à l'intervalls.Intervalle supprimé doivent encore appartenir à la constraintes.Contrainte après la suppression.
     * Parameters:
     * intervalle - l'intervalle supprimé de la liste.
     * préalable : null != intervalle
     */
    public void removeInterval(Intervalle intervalle ){
        // A FAIRE
        if (intervalle == null){
            throw new NullPointerException();
        }else {

          for(Intervalle i : this)
          {
              if(i.getDebut() == intervalle.getDebut() && i.getFin() == intervalle.getFin())
              {
                  this.remove(i);
              }
          }
        }
/*
        int debut=0;
        int fin=0;

        Intervalle a1 = new Intervalle(debut, fin);
        Intervalle a2 = new Intervalle(debut, fin);
        Intervalle a3 = new Intervalle(debut, fin);
        Intervalle a4 = new Intervalle(debut, fin);
        Intervalle a5 = new Intervalle(debut, fin);



        List<Intervalle> list1 = Arrays.asList( a1, a2 );
        List<Intervalle> list2 = Arrays.asList( a3, a4 );

        Contrainte c = new Contrainte(list1);

        if(list1.get(0).getDebut()== list2.get(0).getDebut() && list1.get(1).getFin()> list2.get(1).getFin()  && a2.equals(a4)){
          a5 =   new Intervalle(a1.getFin()-1, a4.getDebut()-1);


          c.removeInterval(a5);

        }
        */

/**
        List< intervalls.Intervalle > xs = Arrays.asList( i_1_5, i_8_9 );

        constraintes.Contrainte c = new constraintes.Contrainte( xs );
        List< intervalls.Intervalle > r =  Arrays.asList( i_1_4, i_8_9 );

        c.remove( i_4_7 );


        assertIterableEquals( r, c );
**/

    }

    /**
     * enlever les intervalles qui se repetent dans une contrainte
     */

    private  void removeDuplicates(){
        Contrainte ctr = new Contrainte();
        for (int i=0; i<this.size(); i++){
            if (!ctr.contains(this.get(i))){
                ctr.add(ctr.size(), this.get(i));

            }
        }
        this.clear();
        this.addAll(0,ctr);
    }


    /**
     * Vérifie si une valeur est incluse dans une contrainte.
     * Soit une contrainte c={[d0..f0[,[d1..f1[,…,[dn−1..fn−1[}
     * , alors l'appartenance (v∈c) est définie comme suit : v∈c↔∃i∈[0..n−1],v∈[di..fi[.
     * Parameters:
     * v - la valeur à tester.
     * Returns:
     * true si la valeur est incluse dans la contrainte, false sinon.

    public boolean appartient( int v ){
        // A FAIRE
        return false;
    }
     */

    public boolean appartient( int v ){
        // A FAIRE
        boolean appartien = false;
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).appartient(v)) {
                appartien = true;
            }
        }
        return appartien;
    }



    /**
     Calcule le nombre d'éléments différents appartenant à la constraintes.Contrainte.
     Remarque : utilisez la méthode size pour obtenir le nombre d'intervalls.Intervalle que contient la constraintes.Contrainte.
     Soit c la constraintes.Contrainte référé par this.
     Returns: |[v|v∈c]|

  **/

    public int taille(){
        int taille = 0;
        for(int i = 0; i < this.size(); i++) {
            int tailleIntervalle = this.get(i).getFin() - this.get(i).getDebut();
            taille = taille + tailleIntervalle;
        }
        return taille;
    }



    /**
     *
     * Construis l'union de deux contraintes.
     * Soit c1 la constraintes.Contrainte référé par this et c2
     *  la constraintes.Contrainte en argument. Une constraintes.Contrainte c
     *  est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀n,n∈c↔(n∈c1∨n∈c2)
     * Parameters:
     * contrainte - La constraintes.Contrainte avec laquelle l'union est faite.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */
    public Contrainte union( Contrainte contrainte ){
        // A FAIRE
        //return null;
        //public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int debut=0;
        int fin=0;



        Contrainte result = new Contrainte();


        //ArrayList<constraintes.Contrainte> result = new ArrayList<constraintes.Contrainte>();
        Intervalle a1 = new Intervalle(debut, fin);
        Intervalle a2 = new Intervalle(debut, fin);

        Intervalle a3 = new Intervalle(debut, fin);
        Intervalle a4 = new Intervalle(debut, fin);

        List<Intervalle> list1 =  Arrays.asList( a1 );
        List<Intervalle> list2 =  Arrays.asList( a2 );

        Contrainte c1 = new Contrainte(list1);
        Contrainte c2 = new Contrainte(list2);

        if(a1.getDebut() == a2.getDebut() && a1.getFin() == a2.getFin()){
             a3 = new Intervalle(a1.getDebut(), a1.getFin());
            List<Intervalle> list3 =  Arrays.asList( a3 );
            result = new Contrainte(list3);
            return result;
        }

        List<Intervalle> list3 =  Arrays.asList( a1, a2 );
        List<Intervalle> list4 =  Arrays.asList( a3, a4 );


        if(a1.getDebut() <a3.getDebut() && a1.getFin() < a3.getFin() &&  a2.getDebut() < a4.getDebut() && a2.getFin()<a4.getFin()){

            //a5 = new intervalls.Intervalle(a1.getDebut(), a4.getFin());
            List<Intervalle> list5 =  Arrays.asList(a1, a3);
            List<Intervalle> list6 =  Arrays.asList(a2, a4);
            Contrainte c4 = new Contrainte( list5 );
            Contrainte c5 = new Contrainte( list6 );
            Contrainte c7 = new Contrainte( );
            c7.addAll(list6);// = new constraintes.Contrainte( list6 );
            return c7;


            /**
            //List< intervalls.Intervalle > list5 =  Arrays.asList(list3.get(0),list4.get(0),list3.get(1),list4.get(1));
           // List< intervalls.Intervalle > list6 =  Arrays.asList();
            list6.addAll(0, list5 );

            result = new constraintes.Contrainte(list5);

            result.addAll(0, list5);

            result = new constraintes.Contrainte(list6);
            return result;
             **/
        }






        return result;
    }






    /**
     * Construis l'intersection de deux contraintes.
     * Soit c1 la constraintes.Contrainte référé par this et c2 la constraintes.Contrainte en argument.
     * Une constraintes.Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n , n ∈ c <--> (n ∈ c1 ∧ n ∈ c2)
     * Parameters:
     * contrainte - La constraintes.Contrainte avec laquelle l'intersection est faite.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */


    class CompareIV implements Comparator<Intervalle> {
        public int compare(Intervalle a1, Intervalle a2) {
            return  a1.getDebut() - a2.getDebut();
        }
    }

    public Contrainte intersection( Contrainte contrainte ){
        // A FAIRE

            this.retainAll(contrainte);
            this.removeDuplicates();
            this.sort(new CompareIV());

            return this;


        }




    /**
     *
     * Soustrais la contrainte en argument.
     * Soit c1 la constraintes.Contrainte référé par this et c2 la constraintes.Contrainte en argument.
     * Une constraintes.Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n, n ∈ c <--> (n ∈ c1 ∧ n ∉ c2)
     * Parameters:
     * contrainte - La constraintes.Contrainte soustraite de this.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */
    public Contrainte soustraction( Contrainte contrainte ) {

        /**

            int debut = 0;
            int fin = 0;

            constraintes.Contrainte result = new constraintes.Contrainte();
            //ArrayList<constraintes.Contrainte> result = new ArrayList<constraintes.Contrainte>();
            intervalls.Intervalle a1 = new intervalls.Intervalle(debut, fin);
            intervalls.Intervalle a2 = new intervalls.Intervalle(debut, fin);

            intervalls.Intervalle a3 = new intervalls.Intervalle(debut, fin);
            intervalls.Intervalle a4 = new intervalls.Intervalle(debut, fin);

            List<intervalls.Intervalle> list1 = Arrays.asList(a1);
            List<intervalls.Intervalle> list2 = Arrays.asList(a2);
            List<intervalls.Intervalle> list3 = Arrays.asList(a1);
            List<intervalls.Intervalle> list4 = Arrays.asList(a2);
            List<intervalls.Intervalle> list5 = Arrays.asList(a2);

            constraintes.Contrainte c1 = new constraintes.Contrainte(list1);
            constraintes.Contrainte c2 = new constraintes.Contrainte(list2);

            if (a1.getDebut() > a2.getDebut() && a1.getFin() > a2.getFin()){
                a3 = new intervalls.Intervalle(a1.getDebut(), a1.getFin());
                list3 = Arrays.asList(a3);
                result = new constraintes.Contrainte(list3);
                return result;
            }

        if (a1.getDebut() <a3.getDebut() && a1.getFin() < a3.getFin() &&  a2.getDebut() < a4.getDebut() && a2.getFin()<a4.getFin()){
            //a3 = new intervalls.Intervalle(a1.getDebut(), a1.getFin());

            list5 = Arrays.asList(a1, a2);
            result = new constraintes.Contrainte(list5);
            return result;
        }


        //if (a1.getDebut() <a3.getDebut() && a1.getFin() < a3.getFin() &&  a2.getDebut() < a4.getDebut() && a2.getFin()<a4.getFin()){



        return result;

    }
         **/

      //  public constraintes.Contrainte soustraction( constraintes.Contrainte contrainte ){
            this.removeAll(contrainte);
            this.removeDuplicates();
            this.sort(new CompareIV());
            return this;


    }

}


