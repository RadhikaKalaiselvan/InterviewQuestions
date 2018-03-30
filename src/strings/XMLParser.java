package strings;
import java.util.*;

public class XMLParser {
	 public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
	        LinkedList<String> nodes=new LinkedList<String>();
	        LinkedList<String> res=new LinkedList<String>();
	        char[] arr=xml.toCharArray();
	        int i=0;
	     while(i<arr.length){
	         if(xml.charAt(i)=='<'){
	             String node="";
	             i++;
	             boolean loop=false;
	            while(i<arr.length && xml.charAt(i)!='>'){
	             node+=arr[i];   
	                i++;
	                loop=true;
	            } 
	           if(loop){
	        	   i--;
	           }
	             node=node.replaceAll("/","");
	             node.trim();
	             nodes.add(node);
	         }
	         i++;
	     }
	     for(String str:nodes){
	    	 if(str.contains("folder name=")){
	    		 String value=str.replace("folder name=","");
	    		 char[] strarr=str.toCharArray();
	    		 int j=0;
	          String foldervalue="";
	    		 while(j<strarr.length){
	    			 if(str.charAt(j)=='"' && j+1<str.length() && str.charAt(j+1)==startingLetter){
	    			 		j++;
	    			 		
	    			 		while(j<strarr.length && strarr[j]!='"'){
	    			 			foldervalue+=strarr[j];	
	    			 			
	    			 			j++;
	    			 		}
	    			 		
	    			 	res.add(foldervalue);
	    			 	break;
	    		  }
	    			 j++;
	    		 }
	    		 
	    	 }
	    	 
	     }
	        return res;
	    }
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<folder name=\"c\">" +
                    "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                    "</folder>" +
                    "<folder name=\"users\" />" +
                "</folder>";

        Collection<String> names = folderNames(xml, 'u');
        for(String name: names)
            System.out.println(name);
    }
}
