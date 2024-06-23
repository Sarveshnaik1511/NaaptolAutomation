package test;

public class logicTest {
public static void main(String[] args) {
	String p = "3,99";
	String price="";
	for(int i =0 ;i<p.length();i++) {
		if(p.charAt(i)==',') {
			continue;
		}
		else {
			price= price+p.charAt(i);
		}
		
	}
	System.out.println(price);
}
}
