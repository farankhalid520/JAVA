import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class CRC {
	public String RandomNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		int s = r.nextInt((max - min) + 1) + min;
		String t = String.valueOf(s);
		return t;
	}
	public static String changeCharacter(String sourceString, int charIndex, char newChar)
	{
		return (charIndex > 0 ? sourceString.substring(0, charIndex) : "")
			+ Character.toString(newChar) + (charIndex < sourceString.length() - 1 ? sourceString.substring(charIndex + 1) : "");
	}

	
	public static String sender(String message, String divisor)
	{
		String Message = message; //Data bits to be transmitted
		String Generator = divisor; //divisor
		String EncodedMessage = ""; //It will be the message sent to the receiver having EDC bits

		int MessageLength = Message.length(); //Takes length of Message
		int GeneratorLength = Generator.length(); //Takes length of the divisor

		EncodedMessage += Message; //Stores the Message bits

			for (int i = 1; i <= GeneratorLength - 1; i++)
			{
			EncodedMessage += '0'; //We append (add) zeros to the EncodedMsg by 1 less than Generator(divisor) length
			}

		for (int x = 0; x <= EncodedMessage.length() - GeneratorLength;) //max. no of times(quotient) XOR will be applied
		{
			for (int y = 0; y < GeneratorLength; y++)
			{
				EncodedMessage = changeCharacter(EncodedMessage, x + y, EncodedMessage.charAt(x + y) == Generator.charAt(y)? '0' : '1'); //Performing bit wise XOR
			}
			for (; x < EncodedMessage.length() && EncodedMessage.charAt(x) != '1'; x++)
			{
				; //checks for the next occurence of '1'
			}
		}

		String EDC = EncodedMessage.substring(EncodedMessage.length() - GeneratorLength + 1);
		System.out.print("The EDC = " + EDC);
		System.out.print("\n");
		System.out.print("Bits sent to the receiver : ");
		System.out.print(Message + EncodedMessage.substring(EncodedMessage.length() - GeneratorLength + 1));
		System.out.print("\n");

		return Message + EncodedMessage.substring(EncodedMessage.length() - GeneratorLength + 1); //prints the message bits + EDC bits to send to the receiver

	}
	
	public static void receiver(String messagereceived, String divisor)
	{
		boolean p = false;
		int GeneratorLength = divisor.length();
		String Generator = divisor;
		String EncodedMessage = messagereceived;
		String EDC = EncodedMessage.substring(EncodedMessage.length() - GeneratorLength + 1);
		char[] chars = EDC.toCharArray();

			for (int x = 0; x <= EncodedMessage.length() - Generator.length();)
			{
			for (int y = 0; y < Generator.length(); y++)
			{
				EncodedMessage = changeCharacter(EncodedMessage, x + y, EncodedMessage.charAt(x + y) == Generator.charAt(y)? '0' : '1');
			}
			for (; x < EncodedMessage.length() && EncodedMessage.charAt(x) != '1'; x++)
			{
				;
			}
			}

		for (char z : chars) //checks EDC bits
		{
			if (z != '0') //if an EDC bit is != 0 there will be an error
			{
				System.out.print("There is an Error !");
				System.out.print("\n");
				p = true;
			}
		}

		System.out.print("There is no Error !");
		System.out.print("\n");


	}
	
	public static String error(String s1, int size, int count)
	{
		Random r = new Random();
	   for (int x = 0; x < count ; x++)
	   {
			   int pos = r.nextInt((size - 0) + 1) + 0;

			if (s1.charAt(pos) == '0')
			{
				s1 = changeCharacter(s1, pos, '1');
			}
			else if (s1.charAt(pos) == '1')
			{
				s1 = changeCharacter(s1, pos, '0');
			}
	   }

	   return s1;
	}




	
	public static void main(String[]args)
	{
		   int MessageLength;
		   int DivisorLength;
		   int Case;
		   int Errors;

		   String Message1 = "";
		   String Divisor1 = "";
		   String Sendercode;
		   String Sendercode1;
		   
		   Scanner inp = new Scanner(System.in);
		   CRC c1 = new CRC();
		   
		   System.out.print("Enter Message Length : ");
		   MessageLength = inp.nextInt();
		   
		   System.out.print("Enter Generator Length : ");
		   DivisorLength = inp.nextInt();
		   
		   System.out.print("Enter no. of errors : ");
		   Errors = inp.nextInt();
		   
		   System.out.print("Enter No. of Cases : ");
		   Case = inp.nextInt();

		   for (int x = 0; x < Case; x++)
		   {
				for (int i = 0; i < MessageLength; i++)
				 {
			      String Message = c1.RandomNumber(0, 1) ;
			      Message1 += Message;
				 }

			    for (int i = 0; i < DivisorLength; i++)
			     {
			      String Message = c1.RandomNumber(0, 1);
			      Divisor1 += Message;
			     }
			System.out.print("*******************SENDER*************************");
			System.out.print("\n");
			System.out.print("Message bits you want to send : ");
			System.out.print(Message1);
			System.out.print("\n");
			System.out.print("Divisor : ");
			System.out.print(Divisor1);
			System.out.print("\n");

			Sendercode = sender(Message1, Divisor1);
			int size = Sendercode.length();
			Sendercode1 = error(Sendercode, size, Errors);

			System.out.print("Bits sent to the receiver after generating errors : ");
			System.out.print(Sendercode1);
			System.out.print("\n");

		   System.out.print("*******************RECEIVER*************************");
		   System.out.print("\n");
			receiver(Sendercode1, Divisor1);

			Sendercode = "";
			Divisor1 = "";
			Message1 = "";
			Sendercode1 = "";


		   }


		}

 
	}
	

