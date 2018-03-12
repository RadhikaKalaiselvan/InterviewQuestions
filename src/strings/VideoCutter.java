package strings;

import java.util.HashSet;
import java.util.Scanner;

public class VideoCutter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		System.out.println("Enter the video sequence");
		String seq=in.next();
		printCutIndex(seq);
	}

	private static void printCutIndex(String seq) {
		// TODO Auto-generated method stub
		char[] s=seq.toCharArray();
		int start=0;
		int end=0;

		HashSet<Character> hs=new HashSet<Character>();
		for(int i=0;i<=s.length-2;i++){
			boolean found=false;
			if(!hs.contains(s[i]) && i>end){
				System.out.println("start "+start+" end "+end);
				start=i;
				end=i;
			}
			if(!hs.contains(s[i])){
				hs.add(s[i]);
				for(int j=s.length-1;j>=i+1;j--){
					if(s[i]==s[j]){
						found=true;
						start=Math.min(start,i);
						end=Math.max(end, j);

					}
				}
				if(!found && i>=end){
					end=i+1;
				}
			}
		}
		System.out.println("start "+start+" end "+end);
	}

}
