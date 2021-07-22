package intervalls;/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import constraintes.Contrainte;

import java.util.ArrayList;
import java.util.List;

/**
 * public class intervalls.Intervalle
 * extends java.lang.Object
 * La classe intervalls.Intervalle permet la construction d'intervalle de nombre.
 * Les intervalles, représentés par cette classe, dénotent des sous-ensembles de Z. Plus particulièrement, les valeurs possibles pour un intervalle sont de type int. Un intervalle (dénoté par [d..f[
 * [d..f[ ) comprend deux bornes. Une borne inférieure (dénoté par d ) et une borne supérieure (dénoté par f).
 *  La borne inférieure est incluse dans l'intervalle et la borne supérieure est exclus de l'intervalle.
 * invariant : d<f
 * remarque : Il est donc impossible de construire un intervalle vide.
 * Author:
 * -- Remplacer par vos noms --, -- Remplacer par vos noms --, Bruno Malenfant
 */
public class Intervalle {
    /**
     * Constructeur
     * <p>
     * Construit un nouvel intervalle de {@code debut} &agrave; {@code fin}.
     * </p>
     * @param debut La borne inf&eacute;rieure de l'intervalle.  Cette valeur
     *              appartient &agrave; l'intervalle.
     * @param fin La borne sup&eacute;rieur de l'intervalle.  Cette valeur
     *            n'appartient pas &agrave; l'intervalle.
     *            <p>
     *            pr&eacute;alable : debut < fin
     *            </p>
     */
    private      int debut; // debut doit appartenir a l'intervalle
    private   int fin;   // fin n'appartient pas a l'intervalle

    public  Intervalle( int debut, int fin ){
        // A FAIRE
        this.debut = debut;
        this.fin = fin;
    }

    public int getDebut() {
        return this.debut;
    }

    public int getFin() {
        return this.fin;
    }

    public void setDebut(int debut) {
        this.debut = debut;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }


    /**
     * Vérifie si une valeur est incluse dans un intervalle.
     * Soit un intervalle a = [d..f[ alors l'appartenance (v ∈ a) est définie comme suit :
     * v ∈ a ↔ d ≤ v < f
     * @param v  - la valeur à tester.
     * @return true si la valeur est incluse dans l'intervalle, false sinon.
     */

    public boolean appartient( int v ){
        // A FAIRE
        if (v >= debut && v < fin){
            return true;
        }
        return false;
    }

/**
    class CompareIV implements Comparator<intervalls.Intervalle>{
        public int compare(intervalls.Intervalle a1, intervalls.Intervalle a2) {
            return  a1.getDebut() - a2.getDebut();
        }
    }
**/




    /**
     * Construis l'union de deux intervalles.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une constraintes.Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n ,n ∈ c ↔ ( n ∈ a1 ∨ n ∈ a2)
     * @param intervalle l'intervalle avec laquelle l'union est faite.
     *                  préalable : null != intervalle
     * @return une Constrainte contenant le résultat. Cette constraintes.Contrainte peut contenir 1 ou 2 intervalles.
**/
    public Contrainte union( Intervalle intervalle ){

        List < Intervalle > list = new ArrayList<>();

        if ( this.appartient(intervalle.debut ) &&  this.appartient(intervalle.fin)){
            list.add(this);
        }else if (!(this.appartient(intervalle.debut)) &&  this.appartient(intervalle.fin)){

            list.add(new Intervalle(intervalle.getDebut(), this.getFin()));
        }else if (!(this.appartient(intervalle.debut)) && !(this.appartient(intervalle.fin))){
            list.add(this);
            list.add(intervalle);
        }else if ((this.appartient(intervalle.debut)) && !(this.appartient(intervalle.fin))){

            list.add( new Intervalle(this.getDebut(), intervalle.getFin()) );
        }else if ((intervalle.appartient(this.debut)) && (intervalle.appartient(this.fin))){
            list.add(intervalle);
        }
        return new Contrainte(list);
    }
    /**
     * Construis l'intersection de deux intervalles.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une constraintes.Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n , n ∈ c ↔ ( n ∈ a1 ∧ n ∈ a2 )
     *
     * @param intervalle l'intervalle avec laquelle l'intersection est faite.
     *
     *                  préalable : null != intervalle
     *
     * @return une Constrainte contenant le résultat. Cette constraintes.Contrainte peut contenir 0 ou 1 intervalle.
     */




    public Contrainte intersection( Intervalle intervalle ){

        int l=0;
        int max=0;
        Contrainte c = new Contrainte();
        List < Intervalle > list = new ArrayList<>();
        Intervalle i = new Intervalle(0,0);
        Intervalle i1 = this;
        Intervalle i2 = intervalle;
        if (i2!= null) {
            /*if (c1.equals(c2)) {
                i2 = i1;
            } else if (!i1. || i2.isEmpty()) {
                i2 = c2;
            } else if (c1.isEmpty() || !c2.isEmpty()) {
                i2 = c1;
                else if ((i2.getFin() >= i1.getFin()) && i2.appartient(i1.getDebut())) {
                    i = new intervalls.Intervalle(i1.getDebut(), i2.getFin());
                }
                else if ((i1.getFin() >= i2.getFin()) && i1.appartient(i2.getDebut())){
                    i = new intervalls.Intervalle(i2.getDebut(), i2.getFin());
            }*/
            if (i2.appartient(i1.getDebut())){
                if (i1.getFin() > i2.getFin()){
                    i = new Intervalle(i1.getDebut(), i2.getFin());
                    list.add(i);
                }else {
                    i = new Intervalle(i1.getDebut(), i1.getFin());
                    list.add(i);
                }
                //list.add(i);
            }
            if (i1.appartient(i2.getFin())){
                if (i2.getFin() > i1.getFin()){
                    i = new Intervalle(i2.getDebut(), i1.getFin());

                    list.add(i);
                }else {
                    i = new Intervalle(i2.getDebut(), i2.getFin());

                    list.add(i);
                }
                //list.add(i);
            }

            if( this.getDebut() < intervalle.getDebut() && this.getFin() == intervalle.getFin()){

                //l= intervalle.getDebut();
                l= intervalle.getDebut();


                //max = intervalle.getFin();
                max = intervalle.getFin();
               // max = 0;

                i = new Intervalle(l,max);

                list.add(i);
            }

            if( this.getDebut() < intervalle.getDebut() && this.getFin() <intervalle.getFin()){

                //l= intervalle.getDebut();
                l= intervalle.getDebut();


                //max = intervalle.getFin();
                max = this.getFin();
                // max = 0;

                i = new Intervalle(l,max);

                list.add(i);
            }






        }
        c= new Contrainte(list);
        System.out.println(c);

        c= new Contrainte(list);
        System.out.println(c);

        return c;
    }

    /**
     * Soustrais un intervalle à l'intervalle courant.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une constraintes.Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     *
     * ∀ n , n ∈ c ↔ (n ∈ a1 ∧ n ∉ a2)
     * @param intervalle - l'intervalle soustrait de l'intervalle courant.
     * préalable : null != intervalle
     *@return  une Constrainte contenant le résultat. Cette constraintes.Contrainte peut contenir 0, 1 ou 2 intervalles.
*/

    public Contrainte soustraction( Intervalle intervalle ){




        int l=0;
        int max=0;
        Contrainte c = new Contrainte();
        List < Intervalle > list = new ArrayList<>();
        Intervalle i = new Intervalle(l,max);
        Intervalle i1 = this;
        Intervalle i2 = intervalle;
        if (i2!= null) {
/**
            if( this.getDebut() == intervalle.getDebut() && this.getFin() == intervalle.getDebut()){
                i = new intervalls.Intervalle(0, 0);

                list.add(i);
            }
**/
            if( this.getDebut() < intervalle.getDebut() && this.getFin() == intervalle.getFin()){

                l= this.getDebut();
                max = this.getFin();

                i = new Intervalle(l,max);

                list.add(i);
            }

            if( this.getDebut() < intervalle.getDebut() && this.getFin() < intervalle.getFin()){

                l= this.getDebut();
                max = intervalle.getDebut();

                i = new Intervalle(l,max);

                list.add(i);
            }

            if( this.getDebut() == intervalle.getDebut() && this.getFin() > intervalle.getFin()){

                l= intervalle.getFin();
                max = this.getFin();

                i = new Intervalle(l,max);

                list.add(i);
            }

            if( this.getDebut() > intervalle.getDebut() && this.getFin() > intervalle.getFin()){

                l= intervalle.getFin();
                max = this.getFin();

                i = new Intervalle(l,max);

                list.add(i);
            }

            if( this.getDebut() < intervalle.getDebut() && this.getFin() > intervalle.getFin()){

                //l= this.getDebut();
                l= intervalle.getFin();
                //max = intervalle.getFin();
                max = this.getFin();

                i = new Intervalle(l,max);

                list.add(i);
            }



        }


        c= new Contrainte(list);


        return c;
    }



    @Override
    public boolean equals(Object intervalle) {
        if (this == intervalle) {
            return true;
        }
        if (intervalle == null) {
            return false;
        }
        if (!(intervalle instanceof Intervalle)) {
            return false;
        }
        Intervalle other = (Intervalle) intervalle;
        return true;
    }

    public boolean equals(Intervalle intervalle) {

        boolean res = false;

        if (null != this && null != intervalle) {
            if (this.getDebut() == intervalle.getDebut() && this.getFin() == intervalle.getFin()) {
                res = true;
            }else {
                res = false;
            }
        }
        return res;

    }



    public String toString(){

        return  "[" + debut + ","+
                fin+ "[";
    }


}
