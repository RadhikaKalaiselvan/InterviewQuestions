package Arrays;

public class RotatedArraySearch {

	
		public static void main(String[] args) {
	        System.out.println(RotatedArraySearch.find(new int[] {8,9,10, 0, 1, 3 ,5,6}, 10));
	    }

		//returns -1 if cannot find the given number in the array
		private static int find(int[] arr, int k) {
			int pos=binarySearch(0,arr.length-1,arr,k);
			return pos;
		}
		
		public static int binarySearch(int p,int q,int[] arr,int value){
			   if(p>q) {
		        	return -1;
		        }
		        int mid=(p+q)/2;
		        if(arr[mid]==value){
		        	return mid;
		        }
		       
		        //first element is less the mid element, therefore first half of array is sorted
		        if(arr[p]<=arr[mid]){
		        	//value is between p and mid
		        	if(arr[p]<=value && arr[mid]>=value){
		        		return binarySearch(p,mid-1,arr,value);
		        	}
		        	return binarySearch(mid+1,q,arr,value);
		        	
		        }else{
		        	//second half must be sorted mid to q
		        	//value is between mid and q
		        	if(arr[mid]<=value && arr[q]>=value){
		        		return binarySearch(mid+1,q,arr,value);
		        	}
		        	return binarySearch(p,mid-1,arr,value);
		    }
		}
		}