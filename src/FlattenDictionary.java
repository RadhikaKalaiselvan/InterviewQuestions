import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class FlattenDictionary {
	
  static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
    // your code goes here
    //value is a Integer or String
    //Value is a hashMap
    
    HashMap<String,String> output=new HashMap<String,String>();
    for(Entry<String,Object> e:dict.entrySet()){
    flattenDictHelper(output,e.getKey(),e.getValue(),"");
    }
    return output;
  }
 public static void flattenDictHelper(HashMap<String,String> output,String key, Object value,String prefix){
   
   if(value instanceof String){
     
     String newKey=(prefix.length()==0)?"":prefix+".";
     output.put(newKey+key,(String)value);
   } else if(value instanceof Integer){
     String newKey=(prefix.length()==0)?"":prefix+".";
     output.put(newKey+key,String.valueOf(value));
     
   }else{
     //value is hashmap
	 String newKey=(prefix.length()==0)?"":prefix+".";
     for(Entry<String,Object> e:((HashMap<String,Object>) value).entrySet()){
     flattenDictHelper(output,e.getKey(),e.getValue(),newKey+key);
     }
   }
 }
  public static void main(String[] args) {

  }

}