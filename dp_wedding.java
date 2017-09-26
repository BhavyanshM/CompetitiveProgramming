/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/* Backtracking Algorithm for enumerating all the permutation of the first n natural numbers
 * It can easily be modified to enumerate permutation of any set of elements
 * -Always remember that every recursive call has its on part in the stack
 * -and thus gets a new variable set for its local funciton. 
 * - So always declare any local variables inside the recursive function
 * -Or go through disaster
 * This is much more dynamic than the subset backtracking algorithm, since it
 * has a more dynamic set of possible candidates at each marker in the solution
 * vector.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication1 {

    //Name your memo memo
    static int[][] memo;
    static ArrayList<Integer>[] costs;
    static int M, C;
    
    public static void main(String[] args) {    
    
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            M = scan.nextInt();
            C = scan.nextInt();
            memo = new int[M+1][C];
            costs = new ArrayList[C];
            
            for(int x = 0; x<costs.length; x++){
                costs[x] = new ArrayList();
            }
            
       
            
            for(int x = 0; x<memo.length; x++)
            Arrays.fill(memo[x], -1);

            for(int j = 0; j < C; j++)
            {
                int k = scan.nextInt();
                
                for (int l = 0; l < k; l++)
                {
                    costs[j].add(scan.nextInt());
                }
            }
            
//            System.out.println(costs[0]);
            int score = dp_topdown(M, 0);
            System.out.println(score <0 ? "no solution" : score);
        }
    
    }
    //Return the ANSWER to "THE" PROBLEM, with an extremely specific set of arguments m and c
    //Always remember to have a return type, for the exact same reason as above
    //We need garbage values to return, whenever we have a "NO SOLUTION" to "THE PROBLEM" 
    static final int GARBAGE = Integer.MIN_VALUE;
    static int dp_topdown(int money, int g) {
        //When NO Solution, return garbage
        if (money < 0)
            return GARBAGE;
        
        //Only when the final stage is reached, return the "ACTUAL" solution
        if (g == C)
        {
            return M-money;
        }
        
        //If the solution to "THIS" problem is "KNOWN", return the solution from the memo
        // if the line below is commented, top-down DP will become backtracking!!
        if(memo[money][g]!=-1) return memo[money][g];
        
        int ans = -1;
        
        //Iterate through all the COST-options for "THIS" level in the tree
        for(int model = 0; model < costs[g].size(); model++){
            ans = Math.max(ans, dp_topdown(money-costs[g].get(model), g+1));
        }
        
        return memo[money][g] = ans;
        
    }
    
}