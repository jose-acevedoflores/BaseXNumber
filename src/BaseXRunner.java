//package baseXNumber;

import java.util.Scanner;

/**
 * @author Andres Malines
 *
 */
public class BaseXRunner {

	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String input = "";
		String option = null;
		BaseXNumber baseNumber=null;

		while(!(input.equals("Q")))
		{
			System.out.println("Select a base: \n1.Binary \n2.Octal \n3.Decimal \n4.Hexadecimal");
			input = in.nextLine();

			System.out.println("Provide a positive number");
			String number = in.nextLine();

			//Negative number checkpoint
			if(number.charAt(0) == '-')
			{
				System.out.println("Is not a valid positive number. Please, insert a non-negative number");
				
			}

			else 
			{
				//Binary
				if(input.equals("1"))
				{
					baseNumber = new BaseXNumber("binary", number);
				}

				//Octal
				else if(input.equals("2"))
				{
					 baseNumber = new BaseXNumber("octal", number);

				}

				//Decimal
				else if(input.equals("3"))
				{
					 baseNumber = new BaseXNumber("decimal", number);
				}

				//Hexadecimal
				else if (input.equals("4"))
				{
					baseNumber = new BaseXNumber("hexadecimal",number);
				}

				//
				System.out.println("1. Determine if the number is prime or not \n2. Determine if it is power of two or not \n" +
						"3. Determine GDC \n4. Determines if the number is co-prime with an specific number" +
						"5. Determines how many time a specific digit is repeated in its base x representation \n6. Provide its binary representation \n" +
						"7. Provide octal representation \n8. Provide decimal representation \n" +
						"9. Provide hexadecimal representation \n10. Provide decimal representation, its digits in reverse order \n" +
						"11. The sum of all odd numbers that are lesser than it (decimal representation) \n" +
						"12. The sum of all even numbers that are lesser than it");

				option = in.nextLine();

				switch (Integer.parseInt(option))
				
				{

				case 1:  System.out.println(baseNumber.isPrime()); break;

				case 2:  System.out.println(baseNumber.isPowerOfTwo()); break;

				case 3:  System.out.println(/*number.greatesCommonDivisor*/); break;

				case 4:  System.out.println(); break;

				case 5:  System.out.println(); break;

				case 6:  System.out.println(/*number.getNumberBinary*/); break;

				case 7:  System.out.println(/*number.getNumberOctal*/); break;

				case 8:  System.out.println(/*number.getNumberDecimal*/); break;

				case 9:  System.out.println(/*number.getNumberHexadecimal*/); break;

				case 10: System.out.println(/*number.reverse()*/); break;

				case 11: System.out.println(/*number.getOfSumOfOdd*/); break;

				case 12: System.out.println(/*number.getOfSumOfEven*/); break;
				
				default: System.out.println("Wrong input"); break;

				}

			}
		}

	}

}
