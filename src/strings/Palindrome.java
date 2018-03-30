package strings;

public class Palindrome {
    public static boolean isPalindrome(String word) {
    char[] arry=word.toLowerCase().toCharArray();
    if(arry.length==1){
    	return true;
    }
    for(int i=0;i<arry.length/2;i++){
    	if(arry[i]!=arry[arry.length-1-i]){
    		return false;
    	}
    }
    return true;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}