/*
 * javadoc g&eacute;n&eacute;r&eacute; avec :
 * -locale fr -header '<script type="text/javascript" src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML"></script>'
 */

import java.util.*;

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
 * @see Intervalle
 */
@SuppressWarnings("serial")
public class Contrainte extends ArrayList< Intervalle > {

    private Collection<Intervalle> collection;
    private Collection<Intervalle> uneCollection ;
    private List < Intervalle> list = new  ArrayList<>();
    List < Intervalle > list1 ;
    List < Intervalle > list2 ;
    //protected Iterator<Intervalle> run= this.iterator();

    /**
     * Constructeur
     * <p>
     * Construis une liste vide.
     * </p>
     */
    //private ArrayList <Intervalle> list = new ArrayList<>();
    public Contrainte(){
        super();
    }


    /**
     * Constructeur
     * <p>
     * Construit une liste d'{@code Intervalle} contenant tous les &eacute;l&eacute;ments de
     * la {@code Collection}.  Les &eacute;l&eacute;ments de la {@code Collection} ne respecte
     * pas n&eacute;cessairement les invariants d'une {@code Contrainte}.  Il faut
     * donc, s'assurer que le r&eacute;sultat de la construction respecte les
     * invariants d'une {@code Contrainte}.
     * </p>
     * @param collection La {@code Collection} contenant les &eacute;l&eacute;ments utilis&eacute;s
     *                   pour construire la {@code Contrainte}.
     * @throws NullPointerException si l'argument {@code collection} est
     *         {@code null}.
     */
     public Contrainte( Collection< Intervalle > collection ) throws  NullPointerException {
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
                        Intervalle temp1 = list.get(i);
                        Intervalle temp2 = list.get(j);
                        list.set(i, temp2);
                        list.set(j ,temp1);
                    }
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
     * Ajoute un {@code Intervalle} dans la {@code Contrainte}.
     * <p>
     * Ajoute un {@code Intervalle}.  Cet ajout ne doit pas briser les
     * invariants de la {@code Constrainte}.
     * </p>
     * <ul>
     * <li> Toutes les valeurs qui appartenaient &agrave; la {@code Contrainte} avant
     * l'ajout doivent encore appartenir &agrave; la {@code Contrainte} apr&egrave;s l'ajout.
     * </li>
     * <li>Toutes les valeurs qui appartiennent &agrave; l'{@code Intervalle} ajout&eacute;
     * doivent appartenir &agrave; la {@code Contrainte} r&eacute;sultante.
     * </li>
     * </ul>
     * @param intervalle l'intervalle ajout&eacute; dans la liste.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     * @return {@code true}.
     */
    public boolean add( Intervalle intervalle )throws NullPointerException{
        // A FAIRE
        //Intervalle intervalle1 = new Intervalle(debut,fin);

        if (intervalle != null){
            super.add(intervalle);
        }
        return true;
    }



    /*public Contrainte ajoutDeContraite( Intervalle intervalle )throws NullPointerException{
        // A FAIRE
        //Intervalle intervalle1 = new Intervalle(debut,fin);
        Contrainte contrainte = new Contrainte();
        if (intervalle != null){
            super.add(intervalle);
            }
        return contrainte;
        }*/




    /**
     * Enl&egrave;ve un {@code Intervalle} de la {@code Contrainte}.
     * <p>
     * Enl&egrave;ve un {@code Intervalle}.  Cette suppression ne doit pas briser les
     * invariants de la {@code Constrainte}.
     * </p>
     * <ul>
     * <li> Toutes les valeurs qui appartenaient &agrave; la {@code Contrainte} avant
     * et qui n'appartiennent pas &agrave; l'{@code Intervalle} supprim&eacute; doivent encore
     * appartenir &agrave; la {@code Contrainte} apr&egrave;s la suppression.
     * </li>
     * </ul>
     * @param intervalle l'intervalle supprim&eacute; de la liste.
     *                   <p>
     *                   pr&eacute;alable : {@code null != intervalle}
     *                   </p>
     */
    public void remove( Intervalle intervalle )throws NullPointerException{
        // A FAIRE
        Intervalle intervalle1 = new Intervalle(0,0);
        Contrainte c= new Contrainte();
        if (intervalle != null){
            if ( intervalle1.getDebut() < intervalle.getDebut()){
                if ( intervalle.getDebut() < intervalle1.getFin() && intervalle.getFin() == intervalle1.getFin()){

                }
            }
            super.remove(intervalle);

        }
    }


    /**
     * V&eacute;rifie si une valeur est incluse dans une contrainte.
     * <p>
     * Soit une contrainte \(c = \{[d_0..f_0[, [d_1..f_1[, \ldots, [d_{n-1}..f_{n-1}[\}\),
     * alors l'appartenance (\(v \in c\))
     * est d&eacute;finie comme suit :
     * </p><p>
     * \(v \in c \leftrightarrow \exists i \in [0..n-1], v \in [d_i..f_i[\).
     * </p>
     * @param v la valeur &agrave; tester.
     * @return {@code true} si la valeur est incluse dans la contrainte,
     *         {@code false} sinon.
     */
    public boolean appartient( int v ){
        boolean inclu = false;
        for (int i = 0; i< list.size(); i++){
            Intervalle intervalle = list.get(i);
            if (intervalle.appartient(v)){
                inclu = true;
            }
        }
        return inclu;
    }


    /**
     * Calcule le nombre d'&eacute;l&eacute;ments diff&eacute;rents appartenant &agrave; la
     * {@code Contrainte}.
     * <p>
     * Remarque : utilisez la m&eacute;thode {@code size} pour obtenir le nombre
     * d'{@code Intervalle} que contient la {@code Contrainte}.
     * </p><p>
     * Soit \(c\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this}.
     * </p>
     * @return \(|[v|v \in c]|\)
     */
    public int taille(){
        // A FAIRE
        list = this;
        int temp = 0;
        int taille = 0;
        for (int i = 0; i < list.size(); i++){
            temp = list.get(i).getFin() - list.get(i).getDebut();
            taille = taille + temp;
        }

        return taille;
    }


    /**
     * Construis l'union de deux contraintes.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \vee n \in c_2 )\)
     * </p>
     * @param contrainte La {@code Contrainte} avec laquelle l'union est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte union( Contrainte contrainte )throws NullPointerException{
        // A FAIRE
        /*Contrainte c = contrainte;
        Contrainte contrainte1 = new Contrainte(list);
        if ((contrainte1.isEmpty())){
            c = contrainte;
        }else if (contrainte.isEmpty()){
            c = contrainte;
        }*/
        list = new ArrayList<>();
        Contrainte c1 = this;
        Contrainte c2 = contrainte;
        Contrainte c = c2;
        Intervalle resultat = new Intervalle(0,0);
        if (!(c1.isEmpty()) && c2.isEmpty()){
            c = c1;
        }
        /*if ((c1.size() == 1) && (c2.size() == 1) && !(c1.isEmpty()) && !(c2.isEmpty())){
            if (c1.equals(c2)){
                c = this;
            }else {
                c = null;
            }

        }*/
        for (int i = 0; i < c1.size(); i++){
            Intervalle i1 = c1.get(i);
            for (int j = 0; j < c2.size(); j++){
                Intervalle i2 = c2.get(j);
                //if (i2.appartient(i1.getDebut()) && i1.appartient(i2.getFin())){
                /*if (i1.equals(i2)){
                    resultat = i1;
                    list.add(resultat);
                    c = new Contrainte(list);
                }*/
                if ((i1.getDebut() > i2.getDebut()) && (i1.getFin() > i2.getFin())){
                   resultat.setDebut(i2.getDebut());
                   resultat.setFin(i1.getFin());
                   list.add(resultat);
                    //System.out.println("liste"+list);
                   c = new Contrainte(list);
                    //System.out.println("c"+c);
                }else if ((i1.getDebut() < i2.getDebut()) && (i1.getFin() < i2.getFin())){
                    resultat.setDebut(i1.getDebut());
                    resultat.setDebut(i2.getFin());
                    list.add(resultat);
                    //System.out.println("liste"+list);
                    c = new Contrainte(list);
                    //System.out.println("c"+c);
                }/*else if ((i1.getDebut() > i2.getDebut()) && (i1.getFin() < i2.getFin())){
                    resultat.setDebut(i2.getDebut());
                    resultat.setDebut(i2.getFin());
                    list.add(resultat);
                    //System.out.println("liste"+list);
                    c = new Contrainte(list);
                    //System.out.println("c"+c);
                }else if ((i1.getDebut() < i2.getDebut()) && (i1.getFin() > i2.getFin())){
                    resultat.setDebut(i1.getDebut());
                    resultat.setDebut(i1.getFin());
                    list.add(resultat);
                    //System.out.println("liste"+list);
                    c = new Contrainte(list);
                    //System.out.println("c"+c);
                }*/else {
                    resultat.setDebut(i1.getDebut());
                    resultat.setDebut(i1.getFin());
                    list.add(resultat);
                    resultat.setDebut(i2.getDebut());
                    resultat.setDebut(i2.getFin());
                    list.add(resultat);
                }
            }
        }


        System.out.println("c: "+c);
        return c;
    }





    /**
     * Construis l'intersection de deux contraintes.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \wedge n \in c_2 )\)
     * </p>
     * @param contrainte La {@code Contrainte} avec laquelle l'intersection est faite.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte intersection( Contrainte contrainte ){
        // A FAIRE
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
            /*for (int i = 0; i < c1.size(); i++){
                Intervalle i1 = c1.get(i);
                for (int j = 0; j < c2.size(); j++){
                    Intervalle i2 = c2.get(j);
                    if (!((i1.appartient(i2.getDebut()) && i1.appartient(i2.getFin())) ||
                            i2.appartient(i1.getDebut()) && i2.appartient(i1.getFin()))){
                        c = new Contrainte();
                    }
                }
            }*/
        }

        return c;
    }



    /**
     * Soustrais la contrainte en argument.
     * <p>
     * Soit \(c_1\) la {@code Contrainte} r&eacute;f&eacute;r&eacute; par {@code this} et
     * \(c_2\) la {@code Contrainte} en argument.
     * Une {@code Contrainte} \(c\) est construite de telle sorte que le pr&eacute;dicat
     * suivant, soit vrai :
     * </p><p>
     * \(\forall n, n \in c \leftrightarrow ( n \in c_1 \wedge n \notin c_2 )\)
     * </p>
     * @param contrainte La {@code Contrainte} soustraite de {@code this}.
     *                   <p>
     *                   pr&eacute;alable : {@code null != contrainte}
     *                   </p>
     * @return une {@code Constrainte} contenant le r&eacute;sultat.
     */
    public Contrainte soustraction( Contrainte contrainte ){
        // A FAIRE
        return null;
    }

    @Override
    public String toString() {
        return "Contrainte{" +
                "uneCollection=" + uneCollection +
                ", list=" + list +
                ", modCount=" + modCount +
                '}';
    }
}
