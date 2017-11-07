//package Kattis;

import java.util.*;

public class PokemonGoGo
{

    static HashMap<Integer, HashMap<Integer, Integer>> memo;
    static Set<PokeStop> pokestops;
    static int n;

    static class PokeStop
    {

        int r;
        int c;

        Set<String> pokemons = new HashSet<>();

        public PokeStop(int r, int c)
        {

            this.r = r;
            this.c = c;

        }

        public String toString()
        {

            return "R: " + r + " C: " + c + " " + pokemons.toString();

        }
        
        public boolean equals(PokeStop ps) {
        	if (ps.r == this.r && ps.c == this.c)
        	{
        		this.pokemons.addAll(ps.pokemons);
        		return true;
        	}
        	return false;
        }

    }

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        
        
        memo = new HashMap<>();
        pokestops = new HashSet<>();
        for (int i = 0; i < n; i++)
        {
        	PokeStop temp = new PokeStop(sc.nextInt(), sc.nextInt());
        	temp.pokemons.add(sc.nextLine().trim());
            pokestops.add(temp);
        }


        Set<String> caught = new HashSet<>();
        int dist = traveling_pokemon(0, 0, caught);
        System.out.println(dist);
//        System.out.println(memo);

//        System.out.println((1 << n) - 1);
//        System.out.println(pokestops.toString());


    }
static int m = 0;
    static int traveling_pokemon(int pos, int mask, Set<String> caught)
    {
    	System.out.println("travel_pokemon: " + m++ + " Mask: " + Integer.toBinaryString(mask) + " Pos: " + pos);

        if (mask == (1 << n) - 1)
        {
//            System.out.println("Visited all");
            PokeStop ps4 = (PokeStop)pokestops.toArray()[pos];
            return Math.abs(ps4.r) + Math.abs(ps4.c);
        }

//        if (memo.containsKey(pos))
//            if (memo.get(pos).containsKey(mask))
//                return memo.get(pos).get(mask);

        int d = 5000;
        for (int i = 0; i < n; i++)
        {

            int visited = mask & (1 << i);
//            System.out.println(visited);
//            System.out.println(Integer.toBinaryString(mask));
            if (visited == 0)
            {
                PokeStop ps4 = (PokeStop)pokestops.toArray()[i];

            	
                if (!caught.isEmpty() && !shouldVisit(caught, new HashSet<>(ps4.pokemons)))
                {
                		mask |= (1 << i);
                		continue;
                }
                Set<String> new_caught = new HashSet<>(caught);
                new_caught.addAll(ps4.pokemons);
                //            System.out.print(new_caught);
                
                
                
                int dist_to = dist(pos, i);
                d = Math.min(d, traveling_pokemon(i, mask | (1 << i), new_caught) + dist_to);

            }
            
        }

        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.put(mask, d);
        memo.put(pos, temp);
        return d;

    }

    static int dist(int pos,int i) {
        PokeStop ps4 = (PokeStop)pokestops.toArray()[pos];
        PokeStop psi = (PokeStop)pokestops.toArray()[i];
    	return Math.abs(ps4.r - psi.r) + Math.abs(ps4.c - psi.c);
    }
    
    public static boolean shouldVisit(Set<String> caught, Set<String> pokemons)
    {

//        System.out.println(caught + " " + pokemons);
        pokemons.removeAll(caught);

        if (pokemons.isEmpty()) return false;
        else return true;

    }



    /*

    public static int traveling_pokemon(ArrayList<PokeStop> pokestops, Set<String> caught, int r, int c)
    {

        if (pokestops.isEmpty()) return Math.abs(r) + Math.abs(c);

        int d = Integer.MAX_VALUE;
        for (int i = 0; i < pokestops.size(); i++)
        {


            PokeStop temp = pokestops.get(i);
            if (!caught.isEmpty() && !shouldVisit(caught, new HashSet<>(temp.pokemons))) continue;
            Set<String> new_caught = new HashSet<>(caught);
            new_caught.addAll(temp.pokemons);
//            System.out.print(new_caught);
            pokestops.remove(i);

            d = Math.min(d, traveling_pokemon(pokestops, new_caught, temp.r, temp.c) + Math.abs(r - temp.r) + Math.abs(c - temp.c));
//            System.out.println(pokestops);
            pokestops.add(i, temp);
//            System.out.println(new_caught + " R: " + temp.r + " C: " + temp.c);
//            System.out.println(pokestops);


        }
//        System.out.println(d);

        return (d == Integer.MAX_VALUE) ? Math.abs(r) + Math.abs(c) : d;

    }
*/
}