package robdd;

//représente un noeud d'un ROBDD
public class Noeud_ROBDD {
  private static int currentid = 2;
  //index du noeud
  private final int id;
  //étiquette du noeud
  private final String nom;
  //index du fils gauche, index du fils droit
  private final int fg;
	private final int fd;

  //constructeur
  public Noeud_ROBDD(String name, int fg, int fd) {
    this.id = currentid++;
    this.nom = name;
    this.fg = fg;
    this.fd = fd;
  }

  /* accesseurs */

  public int getIdFilsGauche() {
    return fg;
  }

  public int getIdFilsDroit() {
    return fd;
  }

  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }


  @Override
  public String toString() {
    return "" + id + ":bdd(" + nom + "," + fg + "," + fd + ")";
  }
}
