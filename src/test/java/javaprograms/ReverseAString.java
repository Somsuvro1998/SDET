package javaprograms;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String str=sc.nextLine();
	
		//using String Concatenation operator
		String rev="";
		
		int len = str.length();
		for(int i=len-1;i>=0;i--)
		{
			rev=rev+str.charAt(i);
			
		}
		System.out.println(rev);
		
////		//using StringBuffer class
		System.out.println("Enter another String");
		String str1 = sc.nextLine();	
		StringBuffer sb=new StringBuffer(str1);
		System.out.println(sb.reverse());
	}

}
