import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UrbanDesign {
	
	static HashMap<String, Character> map;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int size = scan.nextInt();
		int points = 0;
		
		//map = new HashMap<>();
		
		//gray("",size); 
		
//		System.out.println(map);
		
		int sArr[] = new int[4];
		
		ArrayList<Line2D> lines = new ArrayList<>();
		
		for(int i = 0; i < size; i++) {
				Line2D line = new Line2D.Float(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
				lines.add(line);
		}
		
		
		
		points = scan.nextInt();
		Point2D p1;
		Point2D p2;
		
		for(int j = 0; j < points; j++) {
			String id1 = "";
			String id2 = "";
				p1 = new Point2D.Float(scan.nextInt(), scan.nextInt());
				p2 = new Point2D.Float(scan.nextInt(), scan.nextInt());
				for(int i = 0; i<lines.size(); i++){
					if(lines.get(i).relativeCCW(p1)<0) {
						id1 += "0";
					}else {
						id1 += "1";
					}
					//System.out.println("Line: " + i);
					if(lines.get(i).relativeCCW(p2)<0) {
						id2 += "0";
					}else {
						id2 += "1";
					}
				}
				
				//System.out.println(id1 + ":" + id2);
				
				if(Integer.bitCount(Integer.parseInt(id1, 2) + Integer.parseInt(id2, 2)) % 2 == 1) {
					System.out.println("different");
				}else {
					System.out.println("same");
				}
				
		}
	}
	
    public static void yarg(String prefix, int n) {
        if (n == 0) map.put(prefix, 'R');
        else {
            gray(prefix + "1", n - 1);
            yarg(prefix + "0", n - 1);
        }
    }  

    // append order n gray code to end of prefix string, and print
    public static void gray(String prefix, int n) {
        if (n == 0) map.put(prefix, 'C');
        else {
            gray(prefix + "0", n - 1);
            yarg(prefix + "1", n - 1);
        }
    }  
    

	

}
