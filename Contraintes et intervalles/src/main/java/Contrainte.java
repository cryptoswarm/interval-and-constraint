/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;

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
 * @author -- Remplacer par vos noms --
 * @author -- Remplacer par vos noms --
 * @author Bruno Malenfant
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
    private Intervalle start;
    private Intervalle end;

    public Contrainte(){
        this.start =null;
        this.end =null;
        //Contrainte  = new ArrayList();
    }
    //public Range(T start, T end) {  this(start, end, null); }

    /**
     * Constructeur
     * Construit une liste d'Intervalle contenant tous les éléments de la Collection.
     * Les éléments de la Collection ne respecte pas nécessairement les invariants d'une Contrainte.
     * Il faut donc, s'assurer que le résultat de la construction respecte les invariants d'une Contrainte.
     *
     * @param collection collection - La Collection contenant les éléments utilisés pour construire la Contrainte.
     *
     * @throws java.lang.NullPointerException - si l'argument collection est null.
     */
    public Contrainte( Collection< Intervalle > collection ) { // the collection is an interface, cant be instantiated
            collection;

        if(start == null){
            throw new NullPointerException("collection est vide");
        }
        // Constructeur Construit une liste d'Intervalle contenant tous les éléments de la Collection.
    }


    /**
     * public boolean add(Intervalle intervalle)
     * Ajoute un Intervalle dans la Contrainte.
     * Ajoute un Intervalle. Cet ajout ne doit pas briser les invariants de la Constrainte.
     *
     * Toutes les valeurs qui appartenaient à la Contrainte avant l'ajout doivent encore appartenir à la Contrainte après l'ajout.
     * Toutes les valeurs qui appartiennent à l'Intervalle ajouté doivent appartenir à la Contrainte résultante.
     * Specified by:
     * add in interface java.util.Collection<Intervalle>
     * Specified by:
     * add in interface java.util.List<Intervalle>
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
        // A FAIRE
        //appeler la methode de l'array list en utilisant le super par ex : super.add parcequ'il herite de l'array list
        //
        return true;
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
    public void remove( Intervalle intervalle ){
        // A FAIRE
    }


    /**
     * Vérifie si une valeur est incluse dans une contrainte.
     * Soit une contrainte c={[d0..f0[,[d1..f1[,…,[dn−1..fn−1[}
     * , alors l'appartenance (v∈c) est définie comme suit : v∈c↔∃i∈[0..n−1],v∈[di..fi[.
     * Parameters:
     * v - la valeur à tester.
     * Returns:
     * true si la valeur est incluse dans la contrainte, false sinon.
     */
    public boolean appartient( int v ){
        // A FAIRE
        return false;
    }


    /**
     Calcule le nombre d'éléments différents appartenant à la Contrainte.
     Remarque : utilisez la méthode size pour obtenir le nombre d'Intervalle que contient la Contrainte.

     Soit c la Contrainte référé par this.

     Returns: |[v|v∈c]|
     */
    public int taille(){
        // A FAIRE
        return 0;
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
        // A FAIRE
        return null;
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
        // A FAIRE
        return null;
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
    public Contrainte soustraction( Contrainte contrainte ){
        // A FAIRE
        return null;
    }
}
