package javaprograms;

import java.util.Scanner;

public class ReverseANumber {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("enter a number");
int num=sc.nextInt();

//using Stringbuilder class

StringBuilder sb=new StringBuilder();
sb.append(num);
StringBuilder rev = sb.reverse();
System.out.println("Reverse of given no: "+rev);

	}

}
