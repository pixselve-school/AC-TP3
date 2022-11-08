package expression;

import java.util.HashSet;
import java.util.Set;

public class Equiv extends Expression {

	private Expression e1, e2;
	
	public Equiv(Expression e1, Expression e2) {
			this.e1 = e1;
			this.e2 = e2;
	}
		
	public Expression simplifier(){
		e1 = e1.simplifier();
		e2 = e2.simplifier();
		if (e1.estVrai())
			return e2;
		if (e2.estVrai())
			return e1;
		if (e1.estFaux())
			return (new Non(e2)).simplifier();
		if (e2.estFaux())
			return (new Non(e1)).simplifier();
		return this;
	}

	public boolean evalue() throws RuntimeException {
		//TODO
		return false;
	}

	public Set<String> atomes() {
		//TODO
		return null;
	}

	public Expression remplace(String s, boolean b) {
		//TODO
		return null;
	}

}
