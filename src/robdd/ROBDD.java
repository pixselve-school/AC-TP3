package robdd;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//Représente un ROBDD sous forme de liste de Noeud_ROBDD
public class ROBDD {

  //Constantes pour les numéros des "feuilles" VRAI et FAUX
  public static final int idFalse = 0;
  public static final int idTrue = 1;

  //liste représentant le ROBDD
  private List<Noeud_ROBDD> R;

  //construit un ROBDD vide
  public ROBDD() {
    R = new LinkedList<Noeud_ROBDD>();
  }

  //ajoute le Noeud_ROBDD n au ROBDD courant
  public void ajouter(Noeud_ROBDD n) {
    R.add(n);
  }


  //renvoie le nombre de noeuds du ROBDD
  public int nb_noeuds() {
    return R.size() + 2; // longueur de la liste R + les 2 noeuds correspondants à VRAI et FAUX
  }

  @Override
  public String toString() {
    return R.toString();
  }

  // renvoie l'index, dans la liste R,  du noeud BDD associé à la variable nom et dont les fils droit et gauche sont d'indices respectifs fd et fg.
  // Si ce noeud n'existe pas dans le diagramme, la fonction renvoie -1.
  public int obtenirROBDDIndex(String nom, int fg, int fd) {
    for (Noeud_ROBDD noeud_robdd : R) {
      if (noeud_robdd.getNom().equals(nom) && noeud_robdd.getIdFilsGauche() == fg && noeud_robdd.getIdFilsDroit() == fd) {
        return noeud_robdd.getId();
      }
    }
    return -1;
  }

  public Noeud_ROBDD findNodeWithChildId(int id) {
    for (Noeud_ROBDD noeud_robdd : R) {
      if (noeud_robdd.getIdFilsGauche() == id || noeud_robdd.getIdFilsDroit() == id) {
        return noeud_robdd;
      }
    }
    throw new RuntimeException("No node found with child id " + id);
  }

  public String trouve_sat() {
    int id = 1;
    StringBuilder sat = new StringBuilder();
    while (id != this.nb_noeuds() - 1) {
      Noeud_ROBDD noeud_robdd = findNodeWithChildId(id);
      if (noeud_robdd.getIdFilsGauche() == id) {
        sat.append("¬").append(noeud_robdd.getNom()).append(" ");
      } else {
        sat.append(noeud_robdd.getNom()).append(" ");
      }
      id = noeud_robdd.getId();
      if (id == 0) {
        return "Le ROBDD est faux";
      }
    }
    return sat.toString();
  }
}
