/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

/**
 * public class Intervalle
 * extends java.lang.Object
 * La classe Intervalle permet la construction d'intervalle de nombre.
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
    private  int debut; // debut doit appartenir a l'intervalle
    private  int fin;   // fin n'appartient pas a l'intervalle

    public Intervalle( int d, int f ){
        // A FAIRE
        this.debut = d;
        this.fin = f;
    }

    /**
     * Vérifie si une valeur est incluse dans un intervalle.
     * Soit un intervalle a = [d..f[ alors l'appartenance (v ∈ a) est définie comme suit :
     * v ∈ a ↔ d ≤ v < f
     * @param v  - la valeur à tester.
     * @return true si la valeur est incluse dans l'intervalle, false sinon.
     */
    public boolean appartient( int v ){
        boolean siAppartient;

        if(v>= debut && v< fin){

            siAppartient = true;
        }else{
            siAppartient =false;
        }
        return siAppartient;
    }

    public void setDebut(int d){
        this.debut = d;
    }

    public void setFin(int f){
        this.fin = f;
    }


    /**
     * Construis l'union de deux intervalles.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n ,n ∈ c ↔ ( n∈ a1 ∨ n∈ a2)
     * @param intervalle l'intervalle avec laquelle l'union est faite.
     *                  préalable : null != intervalle
     * @return une Constrainte contenant le résultat. Cette Contrainte peut contenir 1 ou 2 intervalles.
     */

    public Contrainte union( Intervalle intervalle ){

        int start=0;
        int end=0;
        Contrainte c = new Contrainte(start, end);

        intervalle = new Intervalle(debut, fin);


        Intervalle a1 = new Intervalle(this.debut, this.fin);

        if(a1.debut < intervalle.debut) {
            start = a1.debut;
        }else {
            start = intervalle.debut;
        }

        if(a1.fin > intervalle.fin) {
            end = a1.fin;
        }else {
            end= intervalle.fin;
        }
        return  new Intervalle(start, end);
    }


    Intervalle union(Intervalle a, Intervalle b) {
        int l = (a.debut < b.fin) ? a.debut : b.fin;
        int max = (a.fin > b.fin) ? a.fin : b.fin;
        return new Intervalle(l, max);
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
        // A FAIRE
        return null;
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


    public static boolean equal(Intervalle i1, Intervalle i2){

        Intervalle i1 = new Intervalle(debut, fin);

        boolean resultat;

        return resultat;
    }



public String toString(){

        return  "[" + debut + ","+
                fin+ "]";
    }

}


//ajouter une methode equal qui compare deux intervalles
//ajouter un toString

