import java.util.Comparator;

public class Rational{
	private int numer, denom;
	private double ratDouble;
	private String RatString, Name;
	
	public Rational(int num, int den){ //creates the numerator with @num and denominator with @denom.  Automatically simplifies
		numer=num;
		denom=den;
		simplify();
		ratDouble=((double)numer)/((double)denom);
		if (denom==1)
			RatString= "" + numer;
		else
			RatString = numer + "/" + denom;
	}
	
	public Rational(int num, int den, String name){ //creates the numerator with @num and denominator with @denom.  Automatically simplifies.  Creates a non unique name for reference to later
		numer=num;
		denom=den;
		simplify();
		ratDouble=((double)numer)/((double)denom);
		if (denom==1)
			RatString= "" + numer;
		else
			RatString = numer + "/" + denom;
		this.Name=name;
	}
	
	public Rational(Rational Rat, String Name){ //creates the numerator with @num and denominator with @denom.  Automatically simplifies
		numer=Rat.getNumerator();
		denom=Rat.getDenominator();
		simplify();
		ratDouble=Rat.getRationalDouble();
		RatString=Rat.toString();
		this.Name=Name;
	}
	
	private void simplify(){  //simplifies rational.  Is automatically invoked during construction.  All operations should construct new Rationals
		if (numer==0){
			return;
		}
		if (numer==denom){
			numer=1;
			denom=1;
			return;
		}
		int max=Math.max(numer, denom);
		int gCF=1;
		
		for (int i=1;i<max;i++){
			if (numer%i==0 && denom%i==0)
				gCF=i;
		}
		
		numer/=gCF;
		denom/=gCF;
	}
	
	public int getNumerator(){  //return @num
		return numer;
	}
	public int getDenominator(){  //return @denom
		return denom;
	}
	public double getRationalDouble(){  //Returns the double of the rational
		return ratDouble;
	}
	public String toString(){ //Returns a string version of the rational of the form "n/d"
		return RatString;
	}
	public static String getRationalString(Rational Rat){  //Returns a string version of the rational of the form "n/d"
		return Rat.getNumerator() + "/" + Rat.getDenominator();
	}
	public String getName(){  //returns the name
		return Name;
	}
	
	public Rational add(Rational R2){ //add two rationals
		return new Rational (R2.getDenominator()*numer+denom*R2.getNumerator(),
				denom*R2.getDenominator());
	}
	public Rational sub(Rational R2){ //subract rational R2 from this rational
		
		return new Rational (R2.getDenominator()*getNumerator()-getDenominator()*R2.getNumerator(),
				getDenominator()*R2.getDenominator());
	}
	public Rational mult(Rational R2){ //multiply two rationals
		return new Rational (getNumerator()*R2.getNumerator()
				, getDenominator()*R2.getDenominator());
	}
	public Rational divide(Rational R2){ //divide this rational by R2
		return new Rational (R2.getDenominator()*getNumerator(), getDenominator()*R2.getNumerator());
	}
	
	public String chooseOperation (Rational R2, char operation){ //allows the user to implement add, sub, mult, and divide from a single method
		if (operation=='+')
			return Rational.getRationalString(this.add(R2));
		if (operation=='-')
			return Rational.getRationalString(this.sub(R2));
		if (operation=='*')
			return Rational.getRationalString(this.mult(R2));
		if (operation=='*')
			return Rational.getRationalString(this.divide(R2));
		else throw new UnsupportedOperationException();
	}
}

class RationalCompareSmallFirst implements Comparator<Rational>{ //Sorts smallest to largest via the double form of the rationals
	
	@Override
	public int compare(Rational A, Rational B) {
		if (A.getRationalDouble()>B.getRationalDouble())
			return 1;
		if (A.getRationalDouble()<B.getRationalDouble())
			return -1;
		return 0;
	}

}
class RationalCompareLargeFirst implements Comparator<Rational>{  //Sort largest to smallest via the double form of the rationals
	
	@Override
	public int compare(Rational A, Rational B) {
		if (A.getRationalDouble()>B.getRationalDouble())
			return -1;
		if (A.getRationalDouble()<B.getRationalDouble())
			return 1;
		return 0;
	}

}

