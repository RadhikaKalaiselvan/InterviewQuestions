package Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
    	if(sortedArray.length>5){
    		 int n=binarySearch(0,sortedArray.length-1,sortedArray,lessThan);
    		 System.out.println("result. of binary search "+n);
    		 if(sortedArray[n]==lessThan){
    			 return n;
    		 }else{
    			 return n+1; 
    		 }
    	       
    	}else{
    		for(int i=sortedArray.length-1;i>=0;i--){
    			if(sortedArray[i]<lessThan){
    				return i+1;
    			}
    		}
    	}
    	return 0;
     
    }
    
    public static int binarySearch(int p,int q,int[] arr,int value){
        while(p<=q){
        int mid=(p+q)/2;
        if(arr[mid]==value){
            return mid;
        }else if(arr[mid]<value){
            p=mid+1;
        }else{
            q=mid-1;
        }
        }
        return q;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] {0, 1, 3 ,5,6,7,8,10}, 9));
    }
}