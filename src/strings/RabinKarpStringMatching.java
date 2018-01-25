package strings;

import java.util.Scanner;

public class RabinKarpStringMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner in =new Scanner(System.in);
     String text=in.nextLine();
     String pattern=in.next();
     System.out.println(rabinKarpStringMatching(text,pattern));
    // System.out.println(rabinKarpStringMatching("11234112356","123"));
     in.close();
	}
	
	static int getHashValue(String pattern){
		return Integer.parseInt(pattern);
	}
	
	//Assumption both the string contains only numbers
	static int rabinKarpStringMatching(String text,String pattern){
		int patternHashValue=getHashValue(pattern);
		int hashval=0;
		for(int i=0;i<pattern.length();i++){
			int digit=Integer.parseInt(text.charAt(i)+"");
			hashval=(hashval*10)+digit;
		}
		if(hashval==patternHashValue){
			return 1;
		}
		for(int i=pattern.length();i<text.length();i++){
			int val=(int) (hashval%Math.pow(10,pattern.length()-1));
			hashval= (val*10)+Integer.parseInt(text.charAt(i)+"");
			if(hashval==patternHashValue){
				return 1;
			}
		}
		return 0;
		
	}

}
