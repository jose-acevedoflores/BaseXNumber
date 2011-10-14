//package baseXNumber;


/**
 * This class saves a number of any of the four following bases: 2, 8, 10 ,16.
 * @author 
 *
 */
public class BaseXNumber {
	
	private long numberDecimal;
	private String originalNumber;
	private boolean binary=false;
	private boolean hexadecimal=false;
	private boolean decimal=false;
	private boolean octal=false;
	
	
	
	/**
	 * Creates a new number, saves the original input, save the base the user gave and changes the number to a decimal.
	 * An example would be the user said it wanted a hexadecimal number and gave "e4" as an input. The original input is saved 
	 * and "e4" is converted to decimal for the methods to operate.
	 * @param base the base the user wants to save.
	 */
	public BaseXNumber(String base, String number)
	{
		originalNumber = number;
		
		
		if(base.equalsIgnoreCase("hexadecimal"))
		{
			hexadecimal = true;
			numberDecimal = this.hexadecimalToDecimal();
		}
		
		else if(base.equalsIgnoreCase("binary"))
		{
			binary = true;
			numberDecimal = this.binaryToDecimal();
		}
		
		else if(base.equalsIgnoreCase("octal"))
		{
			octal = true;
			numberDecimal= this.octalToDecimal();
		}
		
		else if(base.equalsIgnoreCase("decimal"))
		{
			decimal = true;
			numberDecimal = Long.parseLong(originalNumber);
		}
	}
	

	
	
	/** 
	 * Method 1
	 * @author-Wesley O. Martinez Camacho
	 * 
	 *  A method that verifies if the number entered by the user is or it is not prime 
	 * @return  if the number is or it is not prime. 
	 */
	public boolean isPrime()
	{ 
		boolean result=false; 
		for ( int i = 2; i<numberDecimal; i++)
		{ 
			long prime = numberDecimal%i;
			if (prime == 0)
			{
				result = false; 
			    break;
			}
			
			else if (prime != 0)
				result = true;
		}
		return result; 
	}
	
	
	/** 
	 * Method 2
	 * @author-Wesley O. Martinez Camacho 
	 * 
	 * A method that verifies if the number given by the user is a power of two. 
	 * @return if the number is a power of two.
	 */
	public boolean isPowerOfTwo()
	{ 
		boolean result =false; 
		double power = 0; 
		
		for (int i = 0; i<numberDecimal; i++)
		{ 
		  power = Math.pow(2,i);
		 
		 if (numberDecimal % power ==0 && power != 1 )
		 {
			 result = true;
			 break;    
		 }
		 
		 else if (numberDecimal % power != 0 && power != 1)
			 result = false;
		}
		return  result; 
	}
	
	/** 
	 * Method 3
	 * @author-Wesley O. Martinez Camacho 
	 * 
	 * A method that calculated the greatest common divisor between the first number and a new input number. 
	 * @param number the number that is going to be used to look for the GCD
	 * @return the greatest common divisor between the numbers 
	 */
	public int getGCD(long number) 
	{ 
	  int gcd = 0;
	  
	  long minNumber = Math.min(number, numberDecimal);
	  
	  for (int i = 1; i<= minNumber; i++)
	  { 
		  if (numberDecimal % i ==0 && number % i ==0)
			  gcd=i; 
	  }
	  return gcd; 
	}
	
	/** 
	 * Method 4
	 * @author-Wesley O. Martinez Camacho
	 * 
	 * A method that verifies if the originalNumber and a new number (both entered by the user) are co-prime.
	 * The method first has to calculate if the new number is prime or not. After it verifies that it follows 
	 * to see if both numbers are co-primes.
	 * @param number the number that the user wants to verifies if its co-prime
	 * @return if both numbers are coprime 
	 */
	public boolean isCoPrime(long number)
	{ 
		if(this.getGCD(number) == 1)
		{
			return true;
		}
		else 
			return false;
		/*boolean prime = false;
		boolean coprime = false; 
		
		for (int i = 2; i < number; i++)
		{ 
		 
		 if (number%i == 0)
		 { 
			prime = false; 
			break; 
		 }
		 
		 else if (number%i != 0)
			 prime = true; 
		}
		
		if (isPrime()==true && prime == true)
			coprime = true; 
		
		else if (isPrime()==false && prime == false)
			coprime = false;
		
		return coprime;
		*/ 
	}
	
	
	
	
	
	/** 
	 * Method 5
	 * @author-Wesley O. Martinez Camacho
	 * 
	 * A method that calculates the amount of times a given digit  (given by the user)  repeats. 
	 * @param digit The number that the user wants to know how many times it repeats 
	 * @return the amount of times the number repeats 
	 */
	public int getTimesitRepeats(String digit)
	{ 
	   int repeats = 0; 
	   
	   for (int i = 0 ; i < originalNumber.length() ; i++)
	   { 
		  if (originalNumber.substring(i, i+1).equals(digit))
			  repeats++;
	   }
	  
	   return repeats;
	}
	

	/**
	 * Method 6
	 * @author Jose L. Acevedo Flores
	 * Computes the binary representation of the given number.
	 * @return the binary representation.
	 */
	public String toBinary()
	{
		if(binary)
			return originalNumber;
		else
		{
			String binaryRepReversed =""; 
			int res = 0;
			long num = numberDecimal;
			// Since this while loop gets the binary representation in reverse order
			// where 2^0 is the leftmost digit not the rightmost the for loop below 
			// is used to correct this.
			while(num>0) 			
			{			
				res = (int) num%2;
				binaryRepReversed += res;
				num /= 2; 
			}
			
			String binaryRep = "";
			for(int i = binaryRepReversed.length() -1 ; i>=0; i--) //Reverse the number
			{
				binaryRep += binaryRepReversed.charAt(i);
			}
			
			return binaryRep;		
		}
	}

	
	/**
	 * Method 7
	 * @author Jose L. Acevedo Flores
	 * Computes the octal representation of the given number.
	 * @return the octal representation.
	 */
	public String toOctal()
	{
		if(octal)
			return originalNumber;
		else
		{
			String octalReversed = "";
			int res = 0;
			long num = numberDecimal;
			while(num>0)
			{
				res = (int) num%8;
				octalReversed += res;
				num /= 8;
			}
			
			String octalRep="";
			for(int i = octalReversed.length()-1; i >=0 ; i--)
			{
				octalRep += octalReversed.charAt(i);
			}
			
			return octalRep;
		}
	}
	
	/**
	 * Method 8
	 * @author Jose L. Acevedo Flores
	 * Computes the decimal representation of the given number.
	 * @return the decimal representation.
	 */
	public String toDecimal()
	{
		return String.valueOf(numberDecimal);
	}
	
	/**
	 * Method 9
	 * @author Jose L. Acevedo Flores
	 * Computes the hexadecimal representation of the given number.
	 * @return the hexadecimal representation.
	 */
	public String toHexadecimal()
	{
		if(hexadecimal)
			return originalNumber;
		else
		{
			char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			String hexReversed ="";
			long num = numberDecimal;
			int res=0;
			while(num>0)
			{
				res = (int) num%16;
				hexReversed += hex[res];
				num /=16;
			}
			
			String hexRep="";
			for(int i = hexReversed.length()-1; i >=0 ; i--)
			{
				hexRep += hexReversed.charAt(i);
			}
			
			return hexRep;
		}
	}
	
	
	/**
	 * Method 10
	 * @author Jose L. Acevedo Flores
	 * Gets the digits of the decimal representation of the given number in reverse order.
	 * @return the decimal representation in reverse.
	 */
	public String reverse()
	{
		String numberDecimal = String.valueOf(this.numberDecimal);
		String reverse = "";
		for(int i =  numberDecimal.length() -1 ; i>=0; i--)
		{
			reverse += numberDecimal.charAt(i);
		}
		
		return reverse;
	}
	
		
	/** 
	 * Mehotd 11
	 * @author-Wesley O. Martinez Camacho 
	 * 
	 * A method that calculates the sum of all the odd numbers up to the  the user input number 
	 * @return the sum of all odd numbers. 
	 */
	public long getSumofOddNumbers()
	{ 
	  long sum = 0; 
	  
	  for (int i = 0; i < numberDecimal; i++)
	  { 
		  if ( i % 2 != 0)
			  sum += i; 
	  }
	  return sum; 
	}
	
	
	/** 
	 * Method 12
	 * @author-Wesley O. Martinez Camacho
	 * 
	 * A method that calculates the sum of all the even numbers up to the user input number.
	 * @return the sum of all even numbers.
	 */
	public long getSumofEvenNumbers()
	{ 
	  long sum = 0; 
	  
	  for (int i = 0; i < numberDecimal; i++)
	  { 
		  if (i % 2 == 0)
			  sum += i; 
	  }
	  return sum; 	
	}
	
	
	
	/**
	 * Gets the number in the decimal representation. 
	 * @return the number in the decimal representation.
	 */
	public long getNumberDecimal()
	{
		return numberDecimal;
	}
	
	/*
	 * From here on the methods are private. This is to convert the number the user gave as in input 
	 * and save it's decimal representation for all the methods.
	 */
	
	/**
	 * Convert the number form binary to decimal. Private because it's for the internal representation.
	 * @return the binary number in decimal form.
	 */
	private long binaryToDecimal()
	{
		long result=0;
		
		int counter=0;
		for(int i = originalNumber.length()-1; i >= 0  ; i--)
		{
			if(originalNumber.charAt(i)== '1')
			{
				result +=  Math.pow(2, counter);
			}
			counter++;
		}
		
		return result;
	}
	
	
	/**
	 * Convert the number form octal to decimal. Private because it's for the internal representation. 
	 * @return the octal number in decimal form.
	 */
	private long octalToDecimal()
	{
		long result=0;
		long number;
		char[] octal = {'0','1','2','3','4','5','6','7'};
		
		int u;
		int counter=0;
		for(int i = originalNumber.length()-1; i >= 0  ; i--)
		{
			for(u =0; originalNumber.charAt(i) != octal[u]; u++)
			{}//Loops through the octal array. The index represents the decimal representation. 
			number = u;  
			result += number*Math.pow(8, counter);
			counter++;
		}
		
		return result;
	}
	
	
	/**
	 * Convert the number form hexadecimal to decimal. Private because it's for the internal representation. 
	 * @return the hexadecimal number in decimal form.
	 */
	private long hexadecimalToDecimal()
	{
		long result=0;
		long number;
		char[] hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
		int u;
		int counter=0;
		for(int i = originalNumber.length()-1; i >= 0  ; i--)
		{
			for(u =0; originalNumber.charAt(i) != hex[u]; u++)
			{}//Loops through the hex array. The index represents the decimal representation. 
			number = u;  
			result += number*Math.pow(16, counter);
			counter++;
		}
	
		return result;
	}
	

}
