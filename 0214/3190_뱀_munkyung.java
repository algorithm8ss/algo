import java.util.Deque;
import java.util.Scanner;
import java.util.LinkedList;

public class B3190 {
    static class SnakeTail {
        int y;
        int x;
        public SnakeTail(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N, appleSize, L;
    static int starty = 1, startx = 1, direction = 1;
    static int[] turnTime;
    static char[] turnDir;
    static boolean[][] map;
    static boolean[][] snake;
    static int dy[] = {0, 0, -1, 0, 1};
    static int dx[] = {0, 1, 0, -1, 0};
    static int timeCnt = 0;
    static boolean isDone;
    static Deque<SnakeTail> dq;
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        appleSize = sc.nextInt();
        map = new boolean[N + 1][N + 1];
        snake = new boolean[N + 1][N + 1];
        dq = new LinkedList<>();

        for (int i = 0; i < appleSize; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y][x] = true;
        }

        L = sc.nextInt();
        turnTime = new int[L];
        turnDir = new char[L];
        for (int i = 0; i < L; i++) {
            turnTime[i] = sc.nextInt();
            turnDir[i] = sc.next().charAt(0);
        }

        int endtime = 0;
        dq.offer(new SnakeTail(starty, starty));
        for (int i = 0; i < L; i++) {
            if (i != 0) endtime = turnTime[i - 1];
            for (int j = endtime; j < turnTime[i]; j++) {
                goSnake();
                if(isDone) break;
            }
            if (isDone) break;
            if (turnDir[i] == 'L') {
                if (direction + 1 > 4) direction = 1;
                else direction++;
            } else {
                if (direction - 1 < 1) direction = 4;
                else direction--;
            }
        }
        if (!isDone) {
            for (int j = turnTime[L - 1]; ; j++) {
                goSnake();
                if(isDone) break;
            }
        }
        System.out.println(timeCnt);
    }

    private static void goSnake() {
        starty += dy[direction];
        startx += dx[direction];
        timeCnt++;

        //System.out.println(timeCnt + " [" + starty + ", " + startx + "]");
        if (starty <= 0 || starty > N || startx <= 0 || startx > N || snake[starty][startx]) {
            isDone = true;
            return;
        }
        snake[starty][startx] = true;
        dq.offerLast(new SnakeTail(starty, startx));

        if(map[starty][startx]) {
            map[starty][startx] = false;
        } else if (!map[starty][startx]) {
            snake[dq.peekFirst().y][dq.peekFirst().x] = false;
            dq.pollFirst();
        }
    }
}
