import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Atlantis {

	static class Shop
	{
		
		int time;
		int height;
		
		public Shop(int t, int h)
		{
			
			time = t;
			height = h;
			
		}
		
		public String toString()
		{
			
			return "Time: " + time + " Height: " + height;
			
		}
		
	}
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Shop> shops = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
			shops.add(new Shop(sc.nextInt(), sc.nextInt()));
		
		shops.sort(new Comparator<Shop>()
		{
			public int compare(Shop s1, Shop s2)
			{
				
				return s1.time - s2.time;
				
			}
		});
		
		shops.sort(new Comparator<Shop>()
		{
			public int compare(Shop s1, Shop s2)
			{
				
				return s1.height - s2.height;
				
			}
		});
		
		
		
		int count = 0;
		int time = 0;
		
		for (int i = 0; i < n; i++)
		{
			
			if (shops.get(i).height >= shops.get(i).time + time)
			{
				
				count++;
				time += shops.get(i).time;
				
			}
			
		}
		
		System.out.println(shops.toString());
		System.out.println(count);
		
	}
	
}
