/**
 * import java.util.ArrayList;
 * import java.util.Collection;
 *
 * public class constraintes.Contrainte extends ArrayList<intervalls.Intervalle> {
 *     //Contructeur  vide
 *     public constraintes.Contrainte(){}  //un paquet d'intervalle place en ordre.
 *
 *     //constructeur qui prenne une Collection des intervalles
 *     public constraintes.Contrainte(Collection<intervalls.Intervalle> c){
 *         //faut pas depasser 6 construction du genre : for, if, while, switch, try
 *     }
 *
 *
 *     public boolean add (intervalls.Intervalle i){} //ajouter une intervalle  // faire l'union de deux intervalles qui englobent deux intervalles
 *
 *     public void remove(intervalls.Intervalle i){}  //enleve une intervalle   //puis placer le resultat de l'union
 *
 *     public boolean appartient (int n){}
 *
 *     public boolean taille (){} // nombre de valeur appartiennent a contrainte
 *
 *     /*
 *     *l'union des contraintes
 *     *                    [1..6[, [12..18[
 *            *             [5..8[, [11..16[, [21..27[
 *            *             ----------------------------
 *            *             [1..8[,[11..18[,[21..27[  //trouver tjs l'intervalle le plus petit puis continuer
 *            *
 *            *             le suivant union des contraintes donne
 *            *
 *            *             [5..8[ [11..16[ [24..27[
 *            *             [1..2[ [12..23[
 *            *             ------------------------
 *            *             [1..2[ [5..8[ [11..27[
 *

         *public constraintes.Contrainte union(constraintes.Contrainte c){}
        *
        *
 *     l'intersection des contraintes
 *
        *public constraintes.Contrainte intersection(constraintes.Contrainte c){}
        *
        *
        *     /*
 *     soustraction des contraintes
 *
        *public constraintes.Contrainte soustraction(constraintes.Contrainte c){}
        *
        *
        *
        *
        *}
 */
