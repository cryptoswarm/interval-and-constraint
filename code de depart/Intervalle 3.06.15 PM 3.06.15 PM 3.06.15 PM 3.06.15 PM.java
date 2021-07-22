/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

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
    public Intervalle( int debut, int fin ){
        // A FAIRE
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
        // A FAIRE
        return null;
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
}


//ajouter une methode equal qui compare deux intervalles
//ajouter un toString
