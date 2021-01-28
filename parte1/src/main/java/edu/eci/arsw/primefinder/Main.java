package edu.eci.arsw.primefinder;

public class Main {

	public static void main(String[] args) {
		
		PrimeFinderThread pftp1=new PrimeFinderThread(0, 9999999);
		PrimeFinderThread pftp2=new PrimeFinderThread(10000000, 19999999);
		PrimeFinderThread pftp3=new PrimeFinderThread(20000000, 30000000);
		
		pftp1.run();
		pftp2.run();
		pftp3.run();
		
		
	}
	
}
