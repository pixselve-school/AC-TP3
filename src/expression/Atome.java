package expression;

import java.util.HashSet;
import java.util.Set;

public class Atome extends Expression {

	private String name;

	public Atome(String s) {
		this.name = new String(s);
	}

	public boolean evalue() throws RuntimeException {
		throw new RuntimeException("L'expression ne peut pas être évaluée car elle contient (au moins) l'atome "+name);
	}

	public Set<String> atomes() {
		//TODO
		return null;
	}

	public Expression remplace(String s, boolean b) {
		//TODO
		return null;
	}

	public Expression simplifier(){
		return this;
	}

}
