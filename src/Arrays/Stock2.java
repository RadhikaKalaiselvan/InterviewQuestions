package Arrays;

public class Stock2 {
	 public static void main(String[] args) {
	        System.out.println(Stock2.getMaxProfit(new int[]{0,2,1,5,3,9,7}));
	    }

	private static int getMaxProfit(int[] stockPrice) {
		// TODO Auto-generated method stub
		int[] profits=new int[stockPrice.length];
		for(int i=0;i<profits.length;i++){
		profits[i]=0;	
		}
		int maxP=stockPrice[stockPrice.length-1];
		for(int j=stockPrice.length-2;j>=0;j--){
			
			profits[j]=Math.max(profits[j+1], maxP-stockPrice[j]);
			if(maxP<stockPrice[j]){
				maxP=stockPrice[j];
			}
		}
		printArray(stockPrice);
		printArray(profits);
		
		int minP=stockPrice[0];
		for(int i=1;i<=stockPrice.length-1;i++){
			
			profits[i]=Math.max(profits[i-1], profits[i]+(stockPrice[i]-minP));
			if(minP>stockPrice[i]){
				minP=stockPrice[i];
			}
		}
		printArray(profits);
		return profits[stockPrice.length-1];
	}

	static void printArray(int[] arr){
		
		for(int k:arr){
			System.out.print(k+" -> ");
		}
		System.out.println("");
	}
	
}
