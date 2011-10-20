package baseXNumber;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseXNumberTest {

	@Test
	public void testBaseXNumber() {
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "b6f");
		BaseXNumber numberOct = new BaseXNumber("octal", "76534");
		BaseXNumber numberBinary = new BaseXNumber("binary", "010110");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "34567");
		
		assertTrue(
				numberHex.getNumberDecimal() == 2927 &&
				numberOct.getNumberDecimal() == 32092 &&
				numberBinary.getNumberDecimal() == 22 &&
				numberDecimal.getNumberDecimal() == 34567 
				);
	}
	
	@Test
	public void testIsPrime()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "1010101011");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "22522");
		BaseXNumber numberOct = new BaseXNumber("octal", "17000");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "11d1");
		
		BaseXNumber numberBinary2 = new BaseXNumber("binary", "11001010");
		
		assertTrue(
				
				numberBinary.isPrime() == true &&
				numberDecimal.isPrime() == false &&
				numberOct.isPrime() == false &&
				numberHex.isPrime() == true &&
				
				numberBinary2.isPrime() == false
				
				);
		
	}
	
	
	@Test
	public void testIsPowerOfTwo()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "100000000");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "282321");
		BaseXNumber numberOct = new BaseXNumber("octal", "4000000");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "4000");
		
		assertTrue(
				
				numberBinary.isPowerOfTwo() == true &&
				numberDecimal.isPowerOfTwo() == false &&
				numberOct.isPowerOfTwo() == true &&
				numberHex.isPowerOfTwo() == true
				
				);
		
	}
	
	@Test
	public void testGetGCD()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "01110011");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "920");
		BaseXNumber numberOct = new BaseXNumber("octal", "5173");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "efa");
		
		BaseXNumber numberHex2 = new BaseXNumber("hexadecimal", "3ed");

		assertTrue(
				
				numberBinary.getGCD(78) == 1 &&
				numberDecimal.getGCD(17940) == 460 &&
				numberOct.getGCD(8049) == 2683	&&
				numberHex.getGCD(11502) == 3834 &&
				
				numberHex2.getGCD(250) == 5
				
				);
	}
	

	@Test
	public void testIsComprime()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "1110011110");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "6237");
		BaseXNumber numberOct = new BaseXNumber("octal", "3175");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "92e");
		
		assertTrue(
				
				numberBinary.isCoPrime(26) == false &&
				numberDecimal.isCoPrime(901) == true &&
				numberOct.isCoPrime(68) == true &&
				numberHex.isCoPrime(24) == false 
				
				
				);
		
	}
	
	@Test
	public void testGetTimeItRepeats()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "10000011110");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "6111");
		BaseXNumber numberOct = new BaseXNumber("octal", "31213");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "eee");
		
		assertTrue(
				
				numberBinary.getTimesitRepeats("1") == 5 &&
				numberDecimal.getTimesitRepeats("6") == 1 &&
				numberOct.getTimesitRepeats("4") == 0 &&
				numberHex.getTimesitRepeats("e") == 3 
				
				);
	}
	

	@Test
	public void testToBinary()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "01111011");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "1293");
		BaseXNumber numberOct = new BaseXNumber("octal", "567");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "ef9a");
		
		BaseXNumber numberDecimal2= new BaseXNumber("decimal", "61338");
		
		assertTrue(
				
				numberBinary.toBinary().equals("01111011") &&
				numberDecimal.toBinary().equals("10100001101") &&
				numberOct.toBinary().equals("101110111") &&
				numberHex.toBinary().equals("1110111110011010") &&
				
				numberDecimal2.toBinary().equals("1110111110011010")
				
				);
		
	}
	
	@Test
	public void testToOctal()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "111001010");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "601");
		BaseXNumber numberOct = new BaseXNumber("octal", "1131");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "ff3A");
		
		assertTrue(
				
				numberBinary.toOctal().equals("712") &&
				numberDecimal.toOctal().equals("1131") &&
				numberOct.toOctal().equals("1131") &&
				numberHex.toOctal().equals("177472")
				
				);	
		
	}
	
	@Test
	public void testToDecimal()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "1110001110");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "222");
		BaseXNumber numberOct = new BaseXNumber("octal", "17620");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "33AF");
		
		BaseXNumber numberBinary2 = new BaseXNumber("binary", "11001010");
		
		assertTrue(
				
				numberBinary.toDecimal().equals("910") &&
				numberDecimal.toDecimal().equals("222") &&
				numberOct.toDecimal().equals("8080") &&
				numberHex.toDecimal().equals("13231") &&
				
				numberBinary2.toDecimal().equals("202")
				
				);	
		
	}
	
	@Test
	public void testToHexadecimal()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "1110101011");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "222");
		BaseXNumber numberOct = new BaseXNumber("octal", "173110");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "5fF");
		
		assertTrue(
				
				numberBinary.toHexadecimal().equals("3ab") &&
				numberDecimal.toHexadecimal().equals("de") &&
				numberOct.toHexadecimal().equals("f648") &&
				numberHex.toHexadecimal().equals("5ff")
				
				);
		
	}
	
	@Test
	public void testReverse()
	{
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "5ae3f");
		BaseXNumber numberOct = new BaseXNumber("octal", "6345");
		BaseXNumber numberBinary = new BaseXNumber("binary", "01101");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "4539");
		
		
		assertTrue(
				numberOct.reverse().equals("1033") &&
				numberDecimal.reverse().equals("9354") &&
				numberBinary.reverse().equals("31") &&
				numberHex.reverse().equals("782273") 
				
				);
	}
	
	@Test
	public void testGetSumOfOddNumbers()
	{

		BaseXNumber numberBinary = new BaseXNumber("binary", "11100");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "17");
		BaseXNumber numberOct = new BaseXNumber("octal", "16");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "31");
		
		assertTrue(
				
				numberBinary.getSumofOddNumbers() == 196 &&
				numberDecimal.getSumofOddNumbers() == 64 &&
				numberOct.getSumofOddNumbers() == 49  &&
				numberHex.getSumofOddNumbers() == 576
				
				);
		
	}
	
	@Test
	public void testGetSumOfEvenNumbers()
	{
		BaseXNumber numberBinary = new BaseXNumber("binary", "1110");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "20");
		BaseXNumber numberOct = new BaseXNumber("octal", "13");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "23");
		
		assertTrue(
				
				numberBinary.getSumofEvenNumbers() == 42 &&
				numberDecimal.getSumofEvenNumbers() == 90 &&
				numberOct.getSumofEvenNumbers() == 30 &&
				numberHex.getSumofEvenNumbers() == 306
				
				
				);
	}
	
	@Test
	public void testInvalidInputs()
	{

		BaseXNumber numberBinary = new BaseXNumber("binary", "1120");
		BaseXNumber numberDecimal= new BaseXNumber("decimal", "239a");
		BaseXNumber numberOct = new BaseXNumber("octal", "1802");
		BaseXNumber numberHex = new BaseXNumber("hexadecimal", "1aT2");
		
		assertTrue(
				
				numberBinary.getNumberDecimal() == -1 &&
				numberDecimal.getNumberDecimal() == -1 &&
				numberOct.getNumberDecimal() ==-1  &&
				numberHex.getNumberDecimal() == -1
				
				);
	}
	

}
