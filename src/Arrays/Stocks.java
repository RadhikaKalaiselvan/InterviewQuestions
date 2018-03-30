package Arrays;

import strings.Palindrome;
//Only one transaction is allowed
public class Stocks {
	
	 public static void main(String[] args) {
	        System.out.println(Stocks.getMaxProfit(new int[]{4,2,1,5,3,9}));
	    }

	private static int getMaxProfit(int[] stockPrice) {
		// TODO Auto-generated method stub
		int minValue=stockPrice[0];
		int maxProfit=stockPrice[1]-stockPrice[0];
		for(int i=1;i<stockPrice.length;i++){
			int profit=stockPrice[i]-minValue;
			
			if(profit>maxProfit){
				maxProfit=profit;
			}
			if(minValue>stockPrice[i]){
				minValue=stockPrice[i];
			}
		}
		return maxProfit;
	}

}
