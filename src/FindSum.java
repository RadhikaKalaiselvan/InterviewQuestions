import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class FindSum
{
	ArrayList<Node> dp;
	int n;
	
	FindSum(int n){
		this.n=n;
		this.dp=new ArrayList();
	}
	
	class Node
	{

		int length=0;
		LinkedList<Integer> seq;
		Node(int length){
			this.length=length;
			this.seq=new LinkedList<Integer>();
		}


		void setLength(int length){
			this.length=length;
		}
		
		void addNumberToSeq(int num){
			//System.out.println("added to seq "+num);
			this.seq.add(num);
		}
		
		void printSeq(){
			if(seq.size()<=3){
				for(int i:seq){
					System.out.println(i);
				}
			}else{
				
			int prev=seq.get(seq.size()-1);
			for(int k=seq.size()-2;k>=0;k--){
				int val=seq.get(k);
				System.out.println(prev-val);
				prev=val;
			}
			}
		}
		
		void setList(LinkedList<Integer> ll){
			this.seq.clear();
			for(Integer k:ll){
				seq.add(k);
			}
		}

	}
	// Returns count of minimum squares that sum to n
	 Node getMinSquares(int n)
	{
		// Create a dynamic programming table
		// to store sq
		

		// getMinSquares table for base case entries
		dp.add(new Node(0));
		dp.get(0).addNumberToSeq(0);
		
		dp.add(1,new Node(1));
		dp.get(1).addNumberToSeq(1);
		
		dp.add(2,new Node(2));
		dp.get(2).addNumberToSeq(2);
		
		dp.add(3,new Node(3));
		dp.get(3).addNumberToSeq(3);
		
//		System.out.println(dp.size());
//		for(Node node:dp){
//		node.printSeq();
//		}
		// getMinSquares rest of the table using recursive
		// formula
		for (int i = 4; i <= n; i++)
		{
			// max value is i as i can always be represented
			// as 1*1 + 1*1 + ...
			
			dp.add(i,new Node(i));
			// Go through all smaller numbers to
			// to recursively find minimum
			for (int x = 1; x <= i; x++) {
				int temp = x*x;
				if (temp > i)
					break;
				else 
					{
					Node newNode=new Node(Math.min(dp.get(i).length, 1+dp.get(i-temp).length));
				//	System.out.println("new node created ");
					if(dp.get(i).length<(1+dp.get(i-temp).length)){
						newNode.setList(dp.get(i).seq);
					}else{
						newNode.setList(dp.get(i-temp).seq);
						newNode.addNumberToSeq(i);
					}
					dp.add(i,newNode);
					}
			}
		}


		return dp.get(n);
	}
	public static void main(String args[])
	{
		System.out.println("Enter the number :");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		FindSum f=new FindSum(n);
		Node result=f.getMinSquares(n);
		System.out.println("Min No of Squares: "+result.length);
		System.out.println("Numbers: ");
		result.printSeq();
		
	}
}