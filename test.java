import java.util.Scanner;

public class test
{
	
	char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
					   'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
					   'Y', 'Z', ' ', '\''};
	
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		//System.out.println((int)'A');
		int n = sc.nextInt();
		sc.nextLine();
		double secs_to_letter = 60.0 / 28.0 * Math.PI / 15.0;
		for (int i = 0; i < n; i++)
		{
			
			char[] aphorism = sc.nextLine().toCharArray();
			char current = aphorism[0];
			double time = 1;
			for (int j = 1; j < aphorism.length; j++)
			{
				
				time++;
				char next = aphorism[j];
				double dist_to_letter = getShortestDist(current, next);
				//System.out.println(dist_to_letter);
				time += secs_to_letter * dist_to_letter;
				current = next;
				
				
			}
			
			System.out.printf("%.10f\n", time);
			
			
		}
		
	}
	
	static int getShortestDist(char current, char next)
	{
		int index_curr;
		int index_next;
		if (current == ' ')
			index_curr = 27;
		else if (current == '\'')
			index_curr = 28;
		else
			index_curr = current - 64;
		
		if (next == ' ')
			index_next = 27;
		else if (next == '\'')
			index_next = 28;
		else
			index_next = next - 64;
		
		if (index_next == index_curr)
			return 0;
		
		int left, right;
		if (index_next > index_curr)
		{
			right = index_next - index_curr;
			left = index_curr + 28 - index_next;
		}
		else
		{
			left = index_curr - index_next;
			right = index_next + 28 - index_curr;
		}
			
		
		return Math.min(left, right);
		
	}
	
}