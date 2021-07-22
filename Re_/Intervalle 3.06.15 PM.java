/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.*;

/**
 * La classe {@code Intervalle} permet la construction d'intervalle de nombre.
 * <p>
 * Les intervalles, repr&eacute;sent&eacute;s par cette classe, d&eacute;notent des sous-ensembles
 * de Z.  Plus particuli&egrave;rement, les valeurs possibles pour un intervalle sont
 * de type {@code int}.  Un intervalle (d&eacute;not&eacute; par \([d..f[\)) comprend deux
 * bornes.  Une borne inf&eacute;rieure (d&eacute;not&eacute; par \(d\)) et une borne sup&eacute;rieure
 * (d&eacute;not&eacute; par \(f\)).  La borne inf&eacute;rieure est incluse dans l'intervalle et la
 * borne sup&eacute;rieure est exclus de l'intervalle.
 * </p><p>
 * invariant : \(d < f\)
 * </p><p>
 * remarque : Il est donc impossible de construire un intervalle vide.
 * </p>
 * @author -- Remplacer par vos noms --
 * @author -- Remplacer par vos noms --
 * @author Bruno Malenfant
 *
 * @see Contrainte
 */
public class Intervalle {

    public Collection<Intervalle> uneCollection ;
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
    private int debut, fin;
    public Intervalle( int debut, int fin ){
        if (debut < fin){
            this.debut = debut;
            this.fin = fin;
        }

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
     * V&eacute;rifie si une valeur est incluse dans un intervalle.
     * <p>
     * Soit un intervalle \(a = [d..f[\), alors l'appartenance (\(v \in a\))
     * est d&eacute;finie comme suit :
     * </p><p>
     * \(v \in a \leftrightarrow d \leq v < f \).
     * </p>
     * @param v la valeur &agrave; tester.
     * @return {@code true} si la valeur est incluse dans l'intervalle,
     *         {@code false} sinon.
     */
    public boolean appartient( int v ){
        // A FAIRE
        if (v >= debut && v < fin){
            return true;
        }
        return false;
    }


    /**
     * Construis l'union de deux intervalles.
     * <p>
     * Soit \(a_1\) l'intervalle r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(a_2\) l'intervalle en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in a_1 \vee n \in a_2 )\)
     * </p>
     * @param intervalle l'intervalle avec laquelle l'union est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.  Cette
     *         {@code Contrainte} peut contenir 1 ou 2 intervalles.
     */
    public Contrainte union( Intervalle intervalle ){
        Contrainte c = new Contrainte();
        List < Intervalle > list = new ArrayList<>();
        Intervalle a1 = new Intervalle(debut,fin);
        Intervalle a2 = intervalle;
        Intervalle i = new Intervalle(0,0);
        if (a1.appartient(a2.debut) &&
            a1.appartient(a2.fin)){
            list.add(a1);
            //c = c.ajoutDeContraite(a1);
        }else if (!(a1.appartient(a2.debut)) &&
                a1.appartient(a2.fin)){
            i = new Intervalle(a2.getDebut(), a1.getFin());
            list.add(i);
        }else if (!(a1.appartient(a2.debut)) &&
                !(a1.appartient(a2.fin))){
            list.add(a1);
            list.add(a2);
        }else if ((a1.appartient(a2.debut)) &&
                !(a1.appartient(a2.fin))){
            i = new Intervalle(a1.getDebut(), a2.getFin());
            list.add(i);
        }else if ((a2.appartient(a1.debut)) &&
                (a2.appartient(a1.fin))){
            list.add(a2);
        }
        c = new Contrainte(list);
        return c;
    }


    /**
     * Construis l'intersection de deux intervalles.
     * <p>
     * Soit \(a_1\) l'intervalle r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(a_2\) l'intervalle en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in a_1 \wedge n \in a_2 )\)
     * </p>
     * @param intervalle l'intervalle avec laquelle l'intersection est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.  Cette
     *         {@code Contrainte} peut contenir 0 ou 1 intervalle.
     */
    public Contrainte intersection( Intervalle intervalle ){
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
                    i = new Intervalle(i1.getDebut(), i2.getFin());
                }
                else if ((i1.getFin() >= i2.getFin()) && i1.appartient(i2.getDebut())){
                    i = new Intervalle(i2.getDebut(), i2.getFin());
            }*/
            if (i2.appartient(i1.getDebut())){
                if (i1.getFin() > i2.getFin()){
                    i = new Intervalle(i1.getDebut(), i2.getFin());
                }else {
                    i = new Intervalle(i1.getDebut(), i1.getFin());
                }
                list.add(i);
            }
            if (i1.appartient(i2.getFin())){
                if (i2.getFin() > i1.getFin()){
                    i = new Intervalle(i2.getDebut(), i1.getFin());
                }else {
                    i = new Intervalle(i2.getDebut(), i2.getFin());
                }
                list.add(i);
            }/*else {
                i = new Intervalle(0,0);
            }*/
        }
        c= new Contrainte(list);
        System.out.println(c);

        return c;
    }


    /**
     * Soustrais un intervalle à l'intervalle courant.
     * <p>
     * Soit \(a_1\) l'intervalle r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(a_2\) l'intervalle en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in a_1 \wedge n \notin a_2 )\)
     * </p>
     * @param intervalle l'intervalle soustrait de l'intervalle courant.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.  Cette
     *         {@code Contrainte} peut contenir 0, 1 ou 2 intervalles.
     */
    public Contrainte soustraction( Intervalle intervalle ){
        // A FAIRE
        return null;
    }


    //@Override
    /*public boolean equals(Intervalle intervalle) {
        boolean egal = false;
       if (intervalle.debut == this.debut &&
                intervalle.fin == this.fin){
           egal = true;
       }

       return egal;
    }*/
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
