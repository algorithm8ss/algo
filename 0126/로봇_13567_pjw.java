package test;
import java.util.Scanner;
public class 로봇_13567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M  = sc.nextInt();
		int n =  sc.nextInt();
		String instruction;
		boolean check=true;
		int num, way=1, position_x=0, position_y=0;	//way:1 동 / way:2 북 / way:3 서 / way :4 남
		//int arr[][] = new int[M][M];
		for(int i=0; i<n; i++) {
			instruction = sc.next();
			num = sc.nextInt();
			
//			System.out.println(instruction);
//			System.out.println(num);
			
			if(instruction.equals("MOVE")) {
				switch(way) {
				case 1: position_x+=num;
						break;
				case 2: position_y+=num;
						break;
				case 3: position_x-=num;
						break;
				case 4: position_y-=num;
						break;
				default:
					
				}
			}else if(instruction.equals("TURN")) {
				switch(num) {
				case 0: 
					if(way==4)
						way=1;
					else
						way=way+1;
					break;
				case 1:
					if(way==1)
						way=4;
					else
						way=way-1;
					break;
				default:
				}
				
			}
			
			if(position_x<0 || position_y<0 || position_x>M || position_y>M) {
				//System.out.println("-1");
				check=false;
				break;
			}
				
		}
		
		if(check) {
			System.out.println(position_x + " " + position_y);		
		}
		else 
			System.out.println("-1");
	}

}
