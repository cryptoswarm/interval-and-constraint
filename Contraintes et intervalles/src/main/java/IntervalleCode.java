/**
 *public class intervalls.Intervalle {
 *
 *     public intervalls.Intervalle (int debut, int fin){};
 *
 *
 *
 *     public boolean appartient(int n){};
 *
 *
 *     //interval [D...F[   ferme au debut , ferme a la fin , debut est < que fin
 *
 *
 *
 *    /*
 *    [3..6[   this union [3..6[     [3..6[
 *    [5..8[   intervalle [1..9[     [1..2[
 *    -------             -------   -------
 *    [3..8[              [3..9[   [1..2[ [3..6[   //[1..2[ [3..6[   est une forme de contrainte.
 *
 *public constraintes.Contrainte union(intervalls.Intervalle i){}
        *
        *
        *     /*
 *   [3..6[   this union [3..6[     [3..6[  [3..6[   //element n'appartient pas a l'ensemble 1
 *
 *
 *
 *   [5..8[   intervalle [1..9[     [1..2[  [6..8[
 *   -------             -------   ---------------
 *   [5..6[              [3..6[       vide
 *
 *   Exemple :
 *
 *  [3.4.5.6[
 *  [5.8.7.8[
 *  ---------
 *  [3.4.5.6[
        *
        *public constraintes.Contrainte Intersection(intervalls.Intervalle i){return<intervalls.Intervalle>;}
        *
        *
        *
        *
        *
        *       /*
 *   [3..6[   this union [1..9[              [3..6[ [3..6[   //element n'appartient pas a l'ensemble 1
 *   [5..8[   intervalle [3..6[              [1..2[ [2..7[
 *   -------             -------             -------------
 *   [3..5[              [1..3[ [6..9 [      [3..6[
 *
 *
        *
        *public constraintes.Contrainte Soustraction(intervalls.Intervalle i){}
        *
        *
        *}
 *
 */