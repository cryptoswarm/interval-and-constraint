/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * La classe {@code Contrainte} est utilis&eacute; pour construire des ensembles
 * d'{@code Intervalle} exclusif.
 * <p>
 * Cette classe contient une liste de \(n\) {@code Intervalle}.
 * </p><p>
 * \( \{[d_0..f_0[, [d_1..f_1[, \ldots, [d_{n-1}..f_{n-1}[\} \)
 * </p><p>
 * Les &eacute;l&eacute;ments de la liste sont exclusifs, c'est &agrave; dire que l'intersection
 * entre deux intervalles de la m&ecirc;me liste donne un intervalle vide :
 * </p><p>
 * invariant : \( \forall i \in [0..n-1], \forall j \in [0..n-1], i \neq j \rightarrow [d_i..f_i[ \cap [d_j..f_j[ = \emptyset \)
 * </p><p>
 * Les &eacute;l&eacute;ments de cette liste sont en ordre croissant :
 * </p><p>
 * invariant : \( \forall i \in [0..n-2], f_i < d_{i+1} \)
 * </p>
 * @author -- DIALLO, MAMADOU ALIOU "DIAM02079904" --
 * @author -- SAFIR, MOKHTAR  "SAFM14118605" --
 *
 */
@SuppressWarnings("serial")

public class Contrainte extends ArrayList< Intervalle > {
    /**
     * Constructeur
     * <p>
     * Construis une liste vide.
     * </p>
     */



    private  Collection<Intervalle> uneCollection;
    private List<Intervalle> list = new ArrayList<>();
    protected Contrainte(){
        super();
    }


    /**
     * Constructeur
     * Construit une liste d'Intervalle contenant tous les éléments de la Collection.
     * Les éléments de la Collection ne respecte pas nécessairement les invariants d'une Contrainte.
     * Il faut donc, s'assurer que le résultat de la construction respecte les invariants d'une Contrainte.
     *
     * @param collection collection - La Collection contenant les éléments utilisés pour construire la Contrainte.
     *
     * @throws java.lang.NullPointerException - si l'argument collection est null.

     **/



    public Contrainte( Collection< Intervalle > collection ) throws  NullPointerException {
        super();
        if (collection != null) {
            list = new ArrayList<>(collection);
            //Trier l'intervalle
            for (int i = 0; i < list.size(); i++) {
                for ( int j = i+1; j < list.size(); j++){
                    if (list.get(j).getDebut() < list.get(i).getFin()){
                        Intervalle temp1 = list.get(i);
                        Intervalle temp2 = list.get(j);
                        list.set(i, temp2);
                        list.set(j ,temp1);
                    }
                    //Rendre l'intervalle d'isjoint
                    if (list.get(i).appartient(list.get(j).getDebut())){
                        Intervalle inter = new Intervalle(0, 0);
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


    /**
     * Ajoute un Intervalle dans la Contrainte.
     * Ajoute un Intervalle. Cet ajout ne doit pas briser les invariants de la Constrainte.
     *
     * Toutes les valeurs qui appartenaient à la Contrainte avant l'ajout doivent encore appartenir à la Contrainte après l'ajout.
     * Toutes les valeurs qui appartiennent à l'Intervalle ajouté doivent appartenir à la Contrainte résultante.
     * Specified by:
     * add in interface java.util.Collection<Intervalle>
     * Overrides:
     * add in class java.util.ArrayList<Intervalle>
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
        }
        return add;
    }


    /**
     *
     * public void remove(Intervalle intervalle)
     * Enlève un Intervalle de la Contrainte.
     * Enlève un Intervalle. Cette suppression ne doit pas briser les invariants de la Constrainte.
     *
     * Toutes les valeurs qui appartenaient à la Contrainte avant et qui n'appartiennent pas à l'Intervalle supprimé doivent encore appartenir à la Contrainte après la suppression.
     * Parameters:
     * intervalle - l'intervalle supprimé de la liste.
     * préalable : null != intervalle
     */
    public void remove( Intervalle intervalle )throws NullPointerException{
        Contrainte c= new Contrainte();
        list = new ArrayList<>(c);
        if (intervalle != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == intervalle){
                    super.remove(list.get(i));
                    i--;
                }
            }
        }
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
        boolean appartien = false;
        for (int i = 0; i < this.size(); i++) {
            if(this.get(i).appartient(v)) {
                appartien = true;
            }
        }
        return appartien;
    }

    /**
     Calcule le nombre d'éléments différents appartenant à la Contrainte.
     Remarque : utilisez la méthode size pour obtenir le nombre d'Intervalle que contient la Contrainte.
     Soit c la Contrainte référé par this.
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
     * Soit c1 la Contrainte référé par this et c2
     *  la Contrainte en argument. Une Contrainte c
     *  est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀n,n∈c↔(n∈c1∨n∈c2)
     * Parameters:
     * contrainte - La Contrainte avec laquelle l'union est faite.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */
    public Contrainte union( Contrainte contrainte ){
        int debut=0;
        int fin=0;

        Contrainte result = new Contrainte();
        Intervalle a1 = new Intervalle(debut, fin);
        Intervalle a2 = new Intervalle(debut, fin);

        Intervalle a3 = new Intervalle(debut, fin);
        Intervalle a4 = new Intervalle(debut, fin);

        if(a1.getDebut() == a2.getDebut() && a1.getFin() == a2.getFin()){
            a3 = new Intervalle(a1.getDebut(), a1.getFin());
            List< Intervalle > list3 =  Arrays.asList( a3 );
            result = new Contrainte(list3);
            return result;
        }
        if(a1.getDebut() <a3.getDebut() && a1.getFin() < a3.getFin() &&  a2.getDebut() < a4.getDebut() && a2.getFin()<a4.getFin()){
            List< Intervalle > list5 =  Arrays.asList(a1, a3, a2, a4);
            result = new Contrainte(list5);
            return result;
        }
        return result;
    }


    /**
     * Construis l'intersection de deux contraintes.
     * Soit c1 la Contrainte référé par this et c2 la Contrainte en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n , n ∈ c <--> (n ∈ c1 ∧ n ∈ c2)
     * Parameters:
     * contrainte - La Contrainte avec laquelle l'intersection est faite.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */
    public Contrainte intersection( Contrainte contrainte ){
        Contrainte c =new Contrainte();
        Contrainte c1 = this;
        Contrainte c2 = contrainte;
        if (c2 != null){
            if (c1.equals(c2)){
                c = c1;
            }else if (!c1.isEmpty() || c2.isEmpty()){
                c = c2;
            }else if (c1.isEmpty() || !c2.isEmpty()){
                c = c1;
            }
            for (int i = 0; i < c1.size(); i++){
                Intervalle i1 = c1.get(i);
                for (int j = 0; j < c2.size(); j++){
                    Intervalle i2 = c2.get(j);
                    c = i1.intersection(i2);
                }
            }
        }
        return c;
    }


    /**
     *
     * Soustrais la contrainte en argument.
     * Soit c1 la Contrainte référé par this et c2 la Contrainte en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n, n ∈ c <--> (n ∈ c1 ∧ n ∉ c2)
     * Parameters:
     * contrainte - La Contrainte soustraite de this.
     * préalable : null != contrainte
     *
     * Returns:
     * une Constrainte contenant le résultat.
     */
    public Contrainte soustraction( Contrainte contrainte ) {
        Contrainte c =new Contrainte();
        Contrainte c1 = this;
        Contrainte c2 = contrainte;
        if (c2 != null){
            if (c2.isEmpty()){
                c = this;
            }
            for (int i = 0; i < c1.size(); i++){
                Intervalle i1 = c1.get(i);
                for (int j = 0; j < c2.size(); j++){
                    Intervalle i2 = c2.get(j);
                if ((i1.getDebut() > i2.getDebut()) && (i1.getFin() > i2.getFin())){
                    list.add(i1);
                    c = new Contrainte(list);
                }
                    c = i1.soustraction(i2);
                }
            }
        }
        return c;
    }
}