
//import java.util.*;
//import java.math.*;
//
//
//public class mathPrac{
//
//	public static void main(String[] args)
//	{
//		int t =0;
//		int n =0;
//		int j = 0;
//		int cur = 0;
//		int v = 0;
//		boolean istheone = false;
//		Scanner scan = new Scanner(System.in);
//		t = scan.nextInt();
//		for(int i = 0; i<t; i++){
//			istheone = false;
//			n = scan.nextInt();
////			System.out.println(palin(n));
//			for(j = 999; palin(j)>101100; j--)
//			{
//				v = palin(j);
//
//				if(v<n && istheone==false)
//				{
//					System.out.print(v + " ");
//				for(int x = 100; x<(int)Math.sqrt(v); x++){
//					if(v%x == 0 && (v/x)%1000==v/x)
//					{
//						System.out.println(x + "X" + v/x + " ");
////						System.out.println(v);
//
//						istheone = true;
//						cur = v;
//					}
//				}
//				System.out.println();
//
//				}
//			}
//		}
//		scan.close();
//	}
//	public static int palin(int n)
//	{
//		Integer t = new Integer(n);
//		int length = (int)Math.log10(n);
//		StringBuilder sb = new StringBuilder(2*length);
//		String s = t.toString();
//		sb.append(s);
//		sb.reverse();
//		String temp = sb.toString();
//		sb.delete(0, sb.length());
//		sb.append(s);
//		sb.append(temp);
//
//		return Integer.parseInt(sb.toString());
//	}
//}
//
