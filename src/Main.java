import java.util.LinkedList;
import java.util.List;

import robdd.ROBDD;
import expression.*;

public class Main {

  public static void main(String[] args) {
//    exerice1();
    exercice2();
  }

  private static void exerice1() {
    //EXEMPLE
    Expression exp = new Et(new Atome("x"), new Atome("y")); // représente (x ^ y)
    System.out.println(exp.atomes()); // affiche la liste des atomes (=variables booléennes) présents dans exp
    exp = exp.remplace("x", true); // exp vaut maintenant (true ^ y)
//		System.out.println(exp.evalue()); // <- erreur car (true ^ y) ne peut pas être évalué
    exp = exp.remplace("y", false); // exp vaut maintenant (true ^ false)
    System.out.println(exp.evalue());


    //Affichage de l'arbre associé à l'expression exp pour l'ordre x > y
    List<String> ordre_atomes = new LinkedList<String>();
    ordre_atomes.add("x");
    ordre_atomes.add("y");
    System.out.println("Arbre de exp : \n" + exp.arbre(ordre_atomes)); // <- que se passe-t-il ?
    Expression exp2 = new Et(new Atome("x"), new Atome("y")); // représente (x ^ y)
    System.out.println("Arbre de exp2 : \n" + exp2.arbre(ordre_atomes));
  }

  public static void exercice2() {
    Expression expression = new Et(new Equiv(new Atome("x_1"), new Atome("y_1")), new Equiv(new Atome("x_2"), new Atome("y_2")));
    System.out.println(expression.atomes());

    // afficher arbre (ordre 1)
    List<String> ordre_atomes = new LinkedList<String>();
    ordre_atomes.add("x_1");
    ordre_atomes.add("y_1");
    ordre_atomes.add("x_2");
    ordre_atomes.add("y_2");
    System.out.println("Arbre de f avec ordre x_1 > y_1 > x_2 > y_2 : \n" + expression.arbre(ordre_atomes));
    // afficher arbre (ordre 2)
    ordre_atomes = new LinkedList<String>();
    ordre_atomes.add("x_1");
    ordre_atomes.add("x_2");
    ordre_atomes.add("y_1");
    ordre_atomes.add("y_2");
    System.out.println("Arbre de f avec ordre x_1 > x_2 > y_1 > y_2 : \n" + expression.arbre(ordre_atomes));

    expression = expression.remplace("x_1", true);
    expression = expression.remplace("y_1", true);
    expression = expression.remplace("x_2", true);
    expression = expression.remplace("y_2", true);
    System.out.println(expression.evalue());
  }
}
