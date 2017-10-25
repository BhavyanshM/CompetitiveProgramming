
import java.util.Arrays;
import java.util.Scanner;

public class Problem {
    
    static int left, right, updated;
    
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int nums[] = new int[n];
        for(int i = 0; i<n; i++){
            nums[i] = scan.nextInt();
        }
        int sum = kadaneSum(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(sum + "," + left + "," + right);
    }
    
    static int kadaneSum(int[] nums){
        int maxEndHere = 0;
        int sumSoFar = 0;
        
        updated = 0;
        left = 0;
        right = 0;
        //{1,5,-3, 6, 2, -5}
        for(int i = 0; i<nums.length; i++){
            maxEndHere += nums[i];
            if(maxEndHere<0){
                 maxEndHere = 0;
                updated = i+1;
            }else if(sumSoFar<maxEndHere){
                sumSoFar = maxEndHere;
                right = i;
                left = updated;
            }
        }
        return sumSoFar;
    }
}
