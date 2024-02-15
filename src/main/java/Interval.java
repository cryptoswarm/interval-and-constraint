/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.Objects;

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
public class Interval {
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
    private final int start; // Start is inclusive
    private final int end;   // end is not inclusive

     public Interval(int start, int end ){
        this.start = start;
        this.end = end;
    }

    /**
     * Vérifie si une valeur est incluse dans un intervalle.
     * Soit un intervalle a = [d..f[ alors l'appartenance (v ∈ a) est définie comme suit :
     * v ∈ a ↔ d ≤ v < f
     * @param v  - la valeur à tester.
     * @return true si la valeur est incluse dans l'intervalle, false sinon.
     */
    public boolean appartient( int v ){
        return v >= this.start && v < this.end;
    }

    /**
     * Construis l'union de deux intervalles.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n ,n ∈ c ↔ ( n∈ a1 ∨ n∈ a2)
     * @param interval l'intervalle avec laquelle l'union est faite.
     *                  préalable : null != intervalle
     * @return a Constraint that contains the result. This Contraint can contains 1 or 2 interval.
     */

    public Constraint union(Interval interval){
        Constraint result = new Constraint();

        //[3..6[ union [3..6[ =  [3..6[
        if(this.equals(interval)){
            result.add(this);
            return result;
        }

        if(!this.appartient(interval.start) &&
                !interval.appartient(this.end) &&
                !this.appartient(interval.end)){
            if(this.start < interval.start){
                result.add(this);
                result.add(interval);
            }else{
                result.add(interval);
                result.add(this);
            }
            return result;
        }

        result.add(new Interval(Math.min(this.start, interval.start),
                                Math.max(this.end, interval.end)));

        return result;
    }

    /**
     * Construis l'intersection de deux intervalles.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     * ∀ n , n ∈ c ↔ ( n ∈ a1 ∧ n ∈ a2 )
     *
     * @param interval l'intervalle avec laquelle l'intersection est faite.
     *
     *                  préalable : null != intervalle
     *
     * @return une Constrainte contenant le résultat. Cette Contrainte peut contenir 0 ou 1 intervalle.
     */
    public Constraint intersection(Interval interval){

        Constraint c = new Constraint();

        if(this.equals(interval)){
            c.add(this);
            return c;
        }

        if(this.appartient(interval.start) ||
                interval.appartient(this.start)){
            c.add(new Interval(Math.max(this.start, interval.start),
                               Math.min(this.end, interval.end)));
        }

        return c;
    }


    /**
     * Soustrais un intervalle à l'intervalle courant.
     * Soit a1 l'intervalle référé par this et a2 l'intervalle en argument.
     * Une Contrainte c est construite de telle sorte que le prédicat suivant, soit vrai :
     *
     * ∀ n , n ∈ c ↔ (n ∈ a1 ∧ n ∉ a2)
     * @param interval - l'intervalle soustrait de l'intervalle courant.
     * préalable : null != intervalle
     *@return  une Constrainte contenant le résultat. Cette Contrainte peut contenir 0, 1 ou 2 intervalles.
     */
    public Constraint soustraction(Interval interval){
        Constraint c = new Constraint();

        if(this.equals(interval) ||
           interval.appartient(this.start) && !this.appartient(interval.end)){
            return c;
        }

        if(this.appartient(interval.start) && interval.appartient(this.end)){
            c.add(new Interval(this.start, interval.start));
            return c;
        }

        if(!interval.appartient(this.start) && this.end == interval.end){
            c.add(new Interval(this.start, interval.start));
            return c;
        }

        if(this.appartient(interval.start) && this.appartient(interval.end)){
            if(this.start < interval.start) {
                c.add(new Interval(this.start, interval.start));
            }
            if(interval.end < this.end){
                c.add(new Interval(interval.end, this.end));
            }

            return c;
        }

        if(this.end == interval.start){
            if(this.start < interval.start){
                c.add(new Interval(this.start, interval.start));
            }
        }

        if(!interval.appartient(this.start) && !interval.appartient(this.end)){
            c.add(this);
            c.add(interval);
            return c;
        }

        if(interval.appartient(this.start) && this.appartient(interval.end)){
            c.add(new Interval(interval.end, this.end));
        }

        return c;
    }

    public String toString(){
        return  "[" + start + ","+ end + "[";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval interval = (Interval) o;
        return start == interval.start && end == interval.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}


