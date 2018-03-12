package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SmallestSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s=in.next();
		String s1=in.next();
		findSmallestSubStringWithAllChar(s,s1);
	}

	private static void findSmallestSubStringWithAllChar(String s, String s1) {
		char[] ch=s1.toCharArray();
	    char[] str=s.toCharArray();
	    HashMap<Character,Integer> hs=new HashMap<Character,Integer>();
	    HashSet<Character> h=new HashSet<Character>();
	    for(char c:ch){
	    	h.add(c);
	    }
	    int start=0,end=0;
	    int min=Integer.MAX_VALUE;
	    int max=Integer.MIN_VALUE;
	    int minLeng=Integer.MAX_VALUE;
	    for(int i=0;i<s.length();i++)
	    {
	    	   if(h.contains(str[i])){
	    		hs.put(str[i],i);
	    		min=i;
	    		max=i;
	    		for(Entry<Character, Integer> ce:hs.entrySet()){
	    			min=Math.min(min, ce.getValue());
	    			max=Math.max(max, ce.getValue());
	    			System.out.println(" key: "+ce.getKey()+" "+ce.getValue());
	    		}
	    		System.out.println("For i="+i+" min="+min+" max="+max+" "+minLeng);
	    		if(max-min<minLeng && hs.size()==h.size()){
	    			start=min;
	    			end=max;
	    			minLeng=max-min;
	    		}
	    		
	    	   }
	    }
	    for(int j=start;j<=end;j++)
		System.out.println(str[j]+" "+j);
	}

}
