package strings;

import java.util.*;
public class Path {
    class Node{
        String value;
        String fullPath;
        Node(String value,String fullPath){
            this.value=value;
            this.fullPath=fullPath;
        }
        
    }
    private String path;
    ArrayDeque<Node> s;

    public Path(String path) {
       this.path = path;
       this.s = new ArrayDeque<Node>();
       String[] dirs=path.split("/");
       for(String dir:dirs) {
           if(s.size()==0){
               Node n=new Node(dir,dir);
               s.addLast(n);
           }else{
               Node n=new Node(dir,s.getLast().fullPath+"/"+dir);
               s.addLast(n);
           }
       }
    }

    public String getPath() {
        return path;
    }

    public void cd(String newPath) {
       String[] dirs=newPath.split("/");
       for(int i=0;i<dirs.length;i++){
    	   String dir=dirs[i];
    	   if(i==0 && dir.equals("")){
    		   s.clear();
    		   path="";
    	   }else{
    	   if(dir.equals("..")){
    		   s.removeLast();
    	   }else{
    		   
    		   Node n=new Node(dir,(s.size()>0)?s.getLast().fullPath+"/"+dir:dir);
    		   s.addLast(n);
    	   }
    	   }
       }
       if(s.size()>0){
       path=s.getLast().fullPath;
       }
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("/x");
        System.out.println(path.getPath());
    }
}
