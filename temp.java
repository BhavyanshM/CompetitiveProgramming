

//import java.util.*;
//
//class Main{
//	static Scanner scan = new Scanner(System.in);
//	static int n,m,d;
////	isPrime[n] stores the boolean for whether n is prime or not. 
////	Use N-1 if want to find if N is a prime or not.
//	static boolean[] seiveP(int n){
//		boolean[] temp = new boolean[n];		
//		Arrays.fill(temp, true);
//		temp[0] = false;
//		for (int i = 2; i<n; i++){
//			if(temp[i-1]!=false){
//				for(int j = 2; j*i<n+1; j++){
//					temp[j*i-1]= false;			
//				}
//			}				
//		}	
//		return temp;
//	}
//	
//	static boolean isGood(Stack<Integer> s, int deg, int next, boolean[] isPrime){
//		boolean b = false;
//		int sum = 0;
//		if(s.size()<deg){
//			System.out.println("above");
//			b = true;
//		}
//		else{
//			System.out.println("below");
//			sum+=next;
//			System.out.println(sum);
//			
//			for(int j = 0; j<deg-1; j++){
//				sum += s.pop();
//			}
//			System.out.println(sum);
//			if(!(isPrime[sum-1])){
//				b = true;
//			}
//		}
//
//
//		return b;
//	}
//	
//	public static void main(String[] args){
//		while((n = scan.nextInt())!=0 && (m = scan.nextInt())!=0 && (d = scan.nextInt())!=0){
//			boolean isPrime[] = seiveP(10000);
//			boolean notUsed[] = new boolean[m-n+1];
//			int prev[] = new int[notUsed.length];
////			System.out.println(isPrime[3-1]);
//			int cur = 0;
//			Stack<Integer> ap = new Stack<Integer>();
////			ap.push(1);
////			ap.push(2);
////			ap.push(3);
////			ap.push(5);
////			System.out.println(isGood(ap,3,5,isPrime));
////			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
////			for(int i = 0; i<=m; i++)
////				q.add(i);
////			ap.push(n);
//			
//			while(ap.size()!= (m-n+1)){
//				if(isGood(ap,d,prev[cur]+1,isPrime)){
//					ap.push(prev[cur]+1);
//				}
//				else {
//					
//				}
//			}
//			
//		}
//	}
//	
//}

