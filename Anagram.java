//anagram 
import java.util.*;
class Anagram{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
	if(x.length() == y.length()){
		x = x.toLowerCase();
		y = y.toLowerCase();
		int loda = 0;
		int lasan = 0;
		for(int i = 0; i<y.length(); i++){
			if(x.contains(y.charAt(i)+" ")){
				loda++;
			}
			if(y.contains(x.charAt(i)+" ")){
				lasan++;
			}
		}
		System.out.println(loda==x.length() && lasan == y.length()? "ANAGRAM" : "NT ANAGRAM");
	}
		else{
				System.out.println("not ANANGRAM GND MARAO");
			}
	}
}




