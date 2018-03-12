package Arrays;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Quadruplets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("How many numbers do you want to enter?");
		int num = input.nextInt();

		int array[] = new int[num];
		for (int i = 0 ; i < array.length; i++ ) {
			array[i] = input.nextInt();
		}
		System.out.println("Enter sum");
		int s= input.nextInt();
		int[] r=findArrayQuadrupletWith1ExtraSpace(array,s);
		System.out.println("["+r[0]+","+r[1]+","+r[2]+","+r[3]+"]");  
   
		printAllUniqueQuadruplets(array,s);

	}

	
	private static int[] findArrayQuadrupletWith1ExtraSpace(int[] arr, int s) {
		Arrays.sort(arr);
		if(arr.length<0){
			return new int[]{};
		}else if(arr.length<4){
			return new int[]{};
		}
		int result[]=new int[4];
		int n=arr.length;
		for(int i=0;i<=n-4;i++){
			for(int j=i+1;j<=n-3;j++){
				int k=j+1;
				int l=n-1;
				while(k<l){
					if(arr[j]+arr[k]+arr[l]+arr[i]>s){
						l--;
					}else if(arr[j]+arr[k]+arr[l]+arr[i]<s){
						k++;
					}else{
						result[0]=arr[i];
						result[1]=arr[j];
						result[2]=arr[k];
						result[3]=arr[l];
						return result;
					}
				}
			}
		}
		return result;

	}

	
	private static void printAllUniqueQuadruplets(int[] arr, int s) {
		ArrayList<LinkedList<Integer>> result=new ArrayList<LinkedList<Integer>>();
		Arrays.sort(arr);
		if(arr.length<0){
			System.out.println("-");
		}else if(arr.length<4){
			System.out.println("-");
		}
		
		int n=arr.length;
		for(int i=0;i<=n-4;i++){
			 if(i!=0 && arr[i]==arr[i-1])
				 continue;
			for(int j=i+1;j<=n-3;j++){
				if(j!=i+1 && arr[j]==arr[j-1])
	                continue;
				int k=j+1;
				int l=n-1;
				while(k<l){
					if(arr[j]+arr[k]+arr[l]+arr[i]>s){
						l--;
					}else if(arr[j]+arr[k]+arr[l]+arr[i]<s){
						k++;
					}else{
						LinkedList<Integer> ll=new LinkedList<Integer>();
						ll.add(arr[i]);
						ll.add(arr[j]);
						ll.add(arr[k]);
						ll.add(arr[l]);
					    result.add(ll);
					    k++;
					    l--;
					    
					    while(k<l && arr[l]==arr[l+1]){
					    	l--;
					    }
					    
					    while(k<l && arr[k]==arr[k-1]){
					    	k++;
					    }
					}
				}
			}
		}
		for(LinkedList <Integer>l:result){
			System.out.println();
			for(Integer i:l){
				System.out.print(i);
			}
		}
	}


}


