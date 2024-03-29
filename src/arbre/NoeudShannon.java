package arbre;

public class NoeudShannon extends ArbreShannon {
  //fils gauche, fils droit
  private final ArbreShannon fg;
  private final ArbreShannon fd;
  //nom de l'atome sur lequel la disjonction est faite
  private final String nom;

  public NoeudShannon(String s, ArbreShannon fg, ArbreShannon fd) {
    this.fg = fg;
    this.fd = fd;
    this.nom = s;
  }

  public String affiche(int prof) {
    String s = "";
    if (prof != 0) {
      s += "|";
      for (int k = 0; k < (prof - 1); k++)
        s += "   |";
      s += "->";
    }
    s += nom + "\n";
    s += fd.affiche(prof + 1);
    s += fg.affiche(prof + 1);
    return s;
  }
}
