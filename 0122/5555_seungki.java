import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Main {
 
    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String output;
        int count = 0;
        int N = Integer.parseInt(bf.readLine());
        System.out.println(N);
        for (int i = 0; i < N; i++) {
            output = bf.readLine();
            output += output;
 
            if (output.contains(str)) {
                count++;
            }
        }
        System.out.println(count);
 
    }
}
