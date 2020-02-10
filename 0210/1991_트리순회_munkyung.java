import java.util.Scanner;

public class Main {

    static int N;
    static int[] leftArr, rightArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        leftArr = new int[27];
        rightArr = new int[27];

        for (int i = 0; i < N; i++) {

            int value = sc.next().charAt(0) - 64;

            char left = sc.next().charAt(0);
            if(left != '.'){
                leftArr[value] = left - 64;
            }

            char right = sc.next().charAt(0);
            if(right != '.'){
                rightArr[value] = right - 64;
            }
        }

        printPreOrder(1);
        System.out.println();
        printInOrder(1);
        System.out.println();
        printPostOrder(1);
    }

    private static void printPostOrder(int i) {
        if(i == 0) return;
        printPostOrder(leftArr[i]);
        printPostOrder(rightArr[i]);
        System.out.print((char)(i + 64));
    }

    private static void printInOrder(int i) {
        if(i == 0) return;
        printInOrder(leftArr[i]);
        System.out.print((char)(i + 64));
        printInOrder(rightArr[i]);
    }

    private static void printPreOrder(int i) {
        if(i == 0) return;
        System.out.print((char)(i + 64));
        printPreOrder(leftArr[i]);
        printPreOrder(rightArr[i]);
    }
}
