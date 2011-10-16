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
		BaseXNumber baseXNum = null;


		while(true)
		{
			//base selection
			System.out.print("Select a base: \n1.Binary \n2.Octal \n3.Decimal \n4.Hexadecimal \nQ. to quit\n-->");
			input = in.nextLine().toUpperCase();

			//Sentinel value
			if(input.equals("Q"))
			{
				return;
			}

			System.out.print("\nProvide a positive number \n-->");
			String number = in.nextLine();

			//Negative number checkpoint
			if(number.charAt(0) == '-')
			{
				System.out.println("Is not a valid positive number. Please, insert a non-negative number");
				continue;
			}

			//Object creation
			boolean validInput = true;
			switch(input.charAt(0))
			{

			case '1': baseXNum = new BaseXNumber("binary", number); break;

			case '2': baseXNum = new BaseXNumber("octal", number); break;

			case '3': baseXNum = new BaseXNumber("decimal", number); break;

			case '4': baseXNum = new BaseXNumber("hexadecimal",number); break;

			default: System.out.println("Option not recognized"); validInput= false; break;

			}
			
			/*	Skip over function selection if there was an illegal option.
				The -1 part is a flag. If the numberDecimal is -1 then the user gave an incorrect 
				input for the given base. Example: "e" is right in hexadecimal but not correct in decimal, if a
				case like this arises then BaseXNumber class catches this and sets the numberDecimal to -1
			*/
			if(!validInput | baseXNum.getNumberDecimal() == -1)
			{
				if(validInput) // If validInput is true then we got here because of the invalid number.
					System.out.println("Invalid number for the given base.");
				continue;
			}

			//Method selection
			System.out.print("\n1. Determine if the number is prime or not \n2. Determine if it is power of two or not \n" +
					"3. Determine GDC \n4. Determines if the number is co-prime with an specific number\n" +
					"5. Determines how many time a specific digit is repeated in its base x representation \n6. Provide its binary representation \n" +
					"7. Provide octal representation \n8. Provide decimal representation \n" +
					"9. Provide hexadecimal representation \n10. Provide decimal representation, its digits in reverse order \n" +
					"11. The sum of all odd numbers that are lesser than it (decimal representation) \n" +
					"12. The sum of all even numbers that are lesser than it\n-->");

			option = in.nextLine();

			//Here we validate the user input is a number from 1-12
			String[] validOptions = {"1","2","3","4","5","6","7","8","9","10","11","12"};
			int flag = 1;
			for(int i = 0 ; i < 12 ; i++)
			{
				if(validOptions[i].equals(option))
					flag=0;
			}
			if(flag==1)
			{
				System.out.println("Invalid option");
				continue;
			}
			
			//Present options to the user.
			switch (Integer.parseInt(option))
			{

			case 1:  if(baseXNum.isPrime()) System.out.println("It is a prime number"); else System.out.println("It is not a prime number"); break;

			case 2:  if(baseXNum.isPowerOfTwo()) System.out.println("It is a power of two"); else System.out.println("It is no a power of two"); break;

			case 3:  System.out.print("Insert number \n-->"); System.out.println(baseXNum.getGCD(in.nextInt())); break;

			case 4:  System.out.print("Insert number \n-->"); if(baseXNum.isCoPrime(in.nextInt())) System.out.println("The numbers are coprime"); 
					 else System.out.println("The numbers are not coprime"); break;

			case 5:  System.out.print("Insert number \n-->"); System.out.println("It is repeated " +baseXNum.getTimesitRepeats(in.nextLine())+ " times"); break;

			case 6:  System.out.println(baseXNum.toBinary()); break;

			case 7:  System.out.println(baseXNum.toOctal()); break;

			case 8:  System.out.println(baseXNum.toDecimal()); break;

			case 9:  System.out.println(baseXNum.toHexadecimal()); break;

			case 10: System.out.println(baseXNum.reverse()); break;

			case 11: System.out.println(baseXNum.getSumofOddNumbers()); break;

			case 12: System.out.println(baseXNum.getSumofEvenNumbers()); break;

			default: System.out.println("Option not recognized"); break;

			}
			System.out.println("\nPress any key to continue");
			in.nextLine();
		}

	}

}