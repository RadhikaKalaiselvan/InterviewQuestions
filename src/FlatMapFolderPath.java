import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class FlatMapFolderPath {
	class Node{
		String value;
		String path;
		int spaceCount;
		Node(String value,String path,int spaceCount){
			this.value=value;
			this.path=path;
			this.spaceCount=spaceCount;
		}
		Node(String value,int spaceCount){
			this.value=value;
			this.spaceCount=spaceCount;
		}
	}
	Stack<Node> stk=new Stack<Node>();
    LinkedList<String> result=new LinkedList<String>();
	
	public void insertIntoStack(Node n){
		while(!stk.isEmpty() && stk.peek().spaceCount>=n.spaceCount){
			stk.pop();
		}
		if(stk.isEmpty()){
				n.path="/"+n.value.trim();
				stk.push(n);
			
		}else{
				n.path=stk.peek().path+"/"+n.value.trim();
				stk.push(n);
			}
	}
	
	public void process(String line){
	//	System.out.println(" process called for "+line);
		int i=0;
		int n=line.length();
		int count=0;
		while(i<n){
			 char c=line.charAt(i);
			 if(c ==' ' ){
				 count++;
			 }else {
				 break;
			 }
			 i++;
		}
		Node node=new Node(line,"",count);
		if(node.value.contains(".")){
		if(node.value.contains("jpeg")){
			if(stk.isEmpty()){
				result.add("/"+node.value.trim());
			}else{
				Node peek=stk.peek();
				if(peek.spaceCount<node.spaceCount){
					result.add(peek.path+"/"+node.value.trim());
				}else{
					//System.out.println("find path called for "+node.value);
					result.add(findPathFromStack(node));
				}
			}
		}
		}else{
		insertIntoStack(node);
		}
		//System.out.println(line +" "+count);
	}

	private String findPathFromStack(Node node) {
		while(!stk.isEmpty() && stk.peek().spaceCount>=node.spaceCount){
			stk.pop();
		}
		if(!stk.isEmpty()){
			return stk.peek().path+"/"+node.value.trim();
		}else{
			return "/"+node.value.trim();
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		FlatMapFolderPath sq=new FlatMapFolderPath();
		List<String> ll=new LinkedList<String>();
		int n=in.nextInt();
		in.nextLine();
		while(n>0 && in.hasNextLine()){
			ll.add(in.nextLine());
			n--;
		}
		in.close();
		for(String line:ll){
			sq.process(line);
		}
//		for(Node r:sq.stk){
//			System.out.println(r.path+" "+r.value+" "+r.spaceCount);
//		}
		System.out.println("result");
		int totallength=0;
		for(String s:sq.result){
			System.out.println(s);
			totallength+=s.length();
		}
		System.out.println(totallength);
	}

}
