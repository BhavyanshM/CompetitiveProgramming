import java.util.*;

public class Solution {
	static int gcd(int a, int b)
	{
		int in = Math.min(a, b);
		int ax = Math.max(a, b);
		return in==0 ? ax : gcd(in, ax%in);
	}
	static int lcm(int a, int b){
		return a*b/gcd(a,b);
	}
    public static void main(String[] args){
//        try{
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int lcm = 1;
        int gcd = 0;
        for(int i = 0; i<n; i++){
        	lcm = lcm(lcm, scan.nextInt());
        }
        for(int i = 0; i<m; i++){
        	if(i == 0)gcd = scan.nextInt();
        	else gcd = gcd(gcd,scan.nextInt());
        }
        int count = 0;
            for(int i = 0; lcm*(i+1)<=gcd; i++){
            	if(gcd%(lcm*(i+1)) == 0){
//            		System.out.println(lcm*(i+1));
            		count++;
            	}
            }
        System.out.println(count);
//        }catch(Exception e){}
    }
}
