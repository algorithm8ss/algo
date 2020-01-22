import java.util.Scanner;

public class BJ5555 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
	int count = 0;
        String str = sc.next();
        int N = sc.nextInt();
        
        for(int i=0;i<N;i++) {
        	String tStr = sc.next();
        	tStr +=tStr;
        	if(tStr.contains(str))
        		count++;
        }

        System.out.println(count);
	}

}
