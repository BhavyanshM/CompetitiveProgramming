import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "azced";
		String b = "abcdef";
		
		int[][] edit = edit(a,b);
		
		for(int i = 0; i<a.length()+1; i++){
			System.out.println(Arrays.toString(edit[i]));
		}
		
	}
	
	static int[][] edit(String x, String y){
		x = x.toLowerCase();
		y = y.toLowerCase();
		int m = x.length() + 1;
		int n = y.length() + 1;
		int[][] edit = new int[x.length()+1][y.length()+1];
		for(int i = 0; i<m; i++){
			edit[i][0] = i;
		}
		for(int i = 0; i<n; i++){
			edit[0][i] = i;
		}
		for(int i = 0; i<m-1; i++){
			for(int j = 0; j<n-1; j++){
				if(x.charAt(i) == y.charAt(j)){
					edit[i+1][j+1] = edit[i][j];
				}else{
					int temp = Math.min(edit[i+1][j], edit[i][j]);
					edit[i+1][j+1] = Math.min(edit[i][j+1], temp);
					edit[i+1][j+1]++;
				}
			}
		}
		return edit;
	}

}
