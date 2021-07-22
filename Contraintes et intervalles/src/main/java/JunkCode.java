
/**
public class JunkCode {
}


 //**/
/**

 public constraintes.Contrainte union( intervalls.Intervalle intervalle ){
 // A FAIRE
 constraintes.Contrainte c = new constraintes.Contrainte();
 ArrayList < intervalls.Intervalle > ar = new ArrayList<>();
 intervalls.Intervalle a1 = new intervalls.Intervalle(debut,fin);
 intervalls.Intervalle a2 = intervalle;
 if (a1.appartient(a2.debut) &&
 a1.appartient(a2.fin)){
 //c = ar.add(a1);
 }else if (!(a1.appartient(a2.debut)) &&
 a1.appartient(a2.fin)){
 // return une intervalle qui contient le debut de l'intervalle a2 et la fin de l'intervalle a1)

 }else if (!(a1.appartient(a2.debut)) &&
 !(a1.appartient(a2.fin))){
 // return soit les deux intervalles
 }else if ((a1.appartient(a2.debut)) &&
 !(a1.appartient(a2.fin))){
 // return une intervalle qui contient le debut de l'intervalle a1 et la fin de l'intervalle a2
 }else if ((a2.appartient(a1.debut)) &&
 (a2.appartient(a1.fin))){
 // return l'intervalle a2.
 }
 return null;
 }
 **/

/**
 * /**
 *     public boolean intersects(intervalls.Intervalle intervalle) {
 *
 *         if (this.fin < intervalle.debut){
 *             return false;
 *         }
 *         if (intervalle.fin < this.debut) {
 *             return false;
 *         }
 *
 *         if((this.debut == intervalle.getFin()) && (this.fin > intervalle.getFin() )) {
 *             return false;
 *         }
 *
 *         return true;
 *     }
 *
 *
 *     public constraintes.Contrainte intersection( intervalls.Intervalle intervalle ){
 *
 *
 *         List<intervalls.Intervalle> list = new ArrayList<>();
 *
 *         constraintes.Contrainte c = new constraintes.Contrainte(list);
 *
 *         int start=0;
 *         int end=0;
 *
 *
 *         if(!intersects(intervalle)){
 *             return null;
 *         }
 *
 *         if(intervalle!=null) {
 *
 *             if (intervalle.fin < this.debut || intervalle.debut > this.fin) {
 *                 // il n ya pas d'intersection
 *
 *                 list.add(new intervalls.Intervalle(start, end));
 *                 c.addAll(0, list) ;
 *             }
 *
 *             // }else
 *             if (this.debut <= intervalle.fin && intervalle.debut <= this.fin) {
 *
 *                 start = this.debut;
 *                 end = intervalle.debut;
 *                 list.add(new intervalls.Intervalle(start, end));
 *                 c.addAll(0, list);
 *
 *             }
 *         }
 *
 *         return c;
 *
 *     }
 *
 *
 *
 *
 /**
 * @param
 * @return


public boolean equals(intervalls.Intervalle a2) {
if (a2 == this) return true;
if (a2 == null) return false;
if (a2.getClass() != this.getClass()){
return false;
}

intervalls.Intervalle a1 = (intervalls.Intervalle) a2;
return this.debut == a1.debut && this.fin == a1.fin;
}
 **/

/**
 *
 * @return
 */
/**
 @Override
 public boolean equals(Object o) {
 if (o == null || !(o instanceof  intervalls.Intervalle))
 return false;
 if(this == o)
 return true;
 intervalls.Intervalle that = (intervalls.Intervalle)o;
 return left.val == that.left.val && left.isClosed == that.left.isClosed;
 }

 public String toString(){

 return  "["+getDebut()+","+getFin()+"[";
 }

 **/
/**
 @Override
 public boolean equals(Object intervalle) {
 if (this == intervalle) {
 return true;
 }
 if (intervalle instanceof Intervallle) {
 Intervallle other = (Intervallle) intervalle;
 return start.equals(other.start) && end.equals(other.end);
 }
 return false;
 }


 /**
 public  constraintes.Contrainte union(intervalls.Intervalle intervalle ) {

 List<intervalls.Intervalle> list = new ArrayList<>();

 constraintes.Contrainte c = new constraintes.Contrainte();

 //intervalls.Intervalle i = new intervalls.Intervalle(0,0);


 if (intervalle!= null){

 int l = 0;
 int max = 0;

 if (this.getDebut()==intervalle.debut && this.getFin() == intervalle.fin) {

 list.add(this);
 // c.addAll(0, list);
 // c.add(0, this);
 }


 if (this.getDebut() < intervalle.getDebut() && this.getFin() > intervalle.getFin()) {

 list.add(this);
 // c.addAll(0, list);
 }




 if (this.getDebut() < intervalle.debut && this.getFin() < intervalle.fin && intervalle.debut < this.getFin()) {

 list.add(new intervalls.Intervalle(this.getDebut(), intervalle.fin));
 // c.addAll(0, list);
 }



 if (this.getDebut() == intervalle.getDebut()) {
 if (this.getFin() > intervalle.getFin()) {
 list.add(new intervalls.Intervalle(this.getDebut(), this.getFin()));
 } else {
 list.add(new intervalls.Intervalle(this.getDebut(), intervalle.getFin()));
 }

 // c.addAll(0, list);
 }


 if (this.getDebut() < intervalle.debut) {
 l = this.getDebut();
 } else {
 l = intervalle.debut;
 }

 if (this.getFin() > intervalle.fin) {
 max = this.getFin();
 } else {
 max = intervalle.fin;
 }


 list.add(new intervalls.Intervalle(l, max));

 // c.addAll(0, list);

 }
 c = new constraintes.Contrainte(list);

 return c;

 /**
 class CompareIv implements Comparator<intervalls.Intervalle>{
 public int compare (intervalls.Intervalle a, intervalls.Intervalle b){
 return  a.getDebut() - b.getDebut();
 }
 }
 /**
 public boolean appartient( int v ){
 //boolean siAppartient;

 if(v>= debut && v< fin){

 //siAppartient = true;
 return  true;
 //}else{
 //siAppartient =false;
 }
 //return siAppartient;
 return false;
 }
 /**
 public constraintes.Contrainte( Collection< intervalls.Intervalle > collection ) throws  NullPointerException { // the collection is an interface, cant be instantiated


 //Collection< intervalls.Intervalle > collection = Arrays.asList( intervalle);

 //this.contrainte = collection;

 if (collection == null) {
 throw new NullPointerException("collection est vide");
 }


 collection = new ArrayList<intervalls.Intervalle>();        //Arrays.asList( intervalle);

 constraintes.Contrainte c = new constraintes.Contrainte(collection);


 collection = new ArrayList<intervalls.Intervalle>(collection.size());

 Iterator<intervalls.Intervalle> collectionIterator = collection.iterator();


 for (int i = 0; collectionIterator.hasNext(); i++) {
 c.set(i, collectionIterator.next());
 }



 public constraintes.Contrainte( Collection< intervalls.Intervalle > collection ) throws  NullPointerException { // the collection is an interface, cant be instantiated
 super();

 //super( Objects.requireNonNull( collection ) );
 if (collection != null) {
 list = new ArrayList<>(collection);
 for (int i = 0; i < list.size(); i++) {
 for (int j = i + 1; j < list.size(); j++) {
 if (list.get(j).getDebut() < list.get(i).getFin()) {
 intervalls.Intervalle temp1 = list.get(i);
 intervalls.Intervalle temp2 = list.get(j);
 list.set(i, temp2);
 list.set(j, temp1);
 }
 }
 }


 collection = list;
 uneCollection = collection;
 super.addAll(uneCollection);
 }

 /**

 public constraintes.Contrainte( Collection< intervalls.Intervalle > collection ) {


 this.intervalles = new intervalls.Intervalle[10];
 for (int i = 0; i < collection.size(); i++) {
 if(collection.toArray()[i] == null) {
 throw new NullPointerException();
 }else{
 super.add((intervalls.Intervalle) collection.toArray()[i]);
 }
 }
 }

 // Constructeur Construit une liste d'intervalls.Intervalle contenant tous les éléments de la Collection.
 //    }


 /**
 public void sortHelper(List<intervalls.Intervalle> intervals) {
 int len = intervals.size();
 // Only this way works
 List<intervalls.Intervalle> aux = new ArrayList<intervalls.Intervalle>(intervals);
 // This way NOT work ?
 //List<Interval> aux = new ArrayList<Interval>(len);
 sort(intervals, aux, 0, len - 1);
 }

  * public ArrayList(Collection<? extends E> c)
  * Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
  * Parameters:
  * c - the collection whose elements are to be placed into this list
  * Throws:
  * NullPointerException - if the specified collection is null
 *
 *
 *  public boolean add( intervalls.Intervalle intervalle ) {
  *         // A FAIRE
  *         //appeler la methode de l'array list en utilisant le super par ex : super.add parcequ'il herite de l'array list
  *         //
  *         //return  super.add(intervalle);
  *
  *         //return contrainte.add(intervalle);
  *         //if (intervalle != null) {
  *             return super.add(intervalle);
  *
  *
  *
  *
 /**

 @Override
 public boolean add(E element) {
 if (head == null) {
 head = new Node(element);
 } else {
 Node node = head;
 // loop until the last node
 for ( ; node.next != null; node = node.next) {}
 node.next = new Node(element);
 }
 size++;
 return true;
 }


 public int taille(){



 if(size() == 0) {
 return 0;
 }else{
 return size();
 }
 /**
 for(intervalls.Intervalle interval: contrainte){
 if(interval.fin < contrainte.debut){
 result.add(interval);
 }else if(interval.debut > contrainte.fin){
 result.add(contrainte);
 newInterval = interval;
 }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
 newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
 }
 }
 result.add(newInterval);
 }
 **/




















