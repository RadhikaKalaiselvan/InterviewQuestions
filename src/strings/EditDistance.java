package strings;

import java.util.Scanner;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner in =new Scanner(System.in);
	     System.out.println("Enter the two sequence");
	     String seq1=in.next();
	     String seq2=in.next();
	     System.out.println("Edit distance :"+getEditDistance(seq1,seq2));
	}
//Distance is related to length
//Given two strings edit distance is dependent on length of the 2 sequences
	private static int getEditDistance(String seq1, String seq2) {
		// TODO Auto-generated method stub
		int dp[][]=new int[seq1.length()+1][seq2.length()+1];
		for(int i=0;i<seq1.length();i++){
			dp[i][0]=i;
		}
		
		for(int j=0;j<seq2.length();j++){
			dp[0][j]=j;
		}
		
		char[] c1=seq1.toCharArray();
		char[] c2=seq2.toCharArray();
		
		for(int i=1;i<=seq1.length();i++){
			
			for(int j=1;j<=seq2.length();j++){
				if(c1[i-1]==c2[j-1]){
					dp[i][j]=dp[i-1][j-1];
				}else{
				int min=Math.min(dp[i][j-1]+1, dp[i-1][j]+1);
				dp[i][j]=Math.min(min, dp[i-1][j-1]+1);
				}
			}
		}
		return dp[seq1.length()][seq2.length()];
	}

}
