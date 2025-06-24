package Search;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class baekjoon_2346 {
    static class Ballon {
        int index;
        int value;

        public Ballon(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //입력값 N
        Integer N = Integer.valueOf(br.readLine());
        //입력값
        String[] inputNum = br.readLine().split(" ");
        //Deque
        Deque<Ballon> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            deque.add(new Ballon(i+1, Integer.parseInt(inputNum[i])));
        }

        while (!deque.isEmpty()) {
            Ballon current = deque.pollFirst();
            bw.write(current.index + " ");

            if(deque.isEmpty())
                break;

            int findNum = current.value;

            if (findNum > 0) {
                for (int i = 0; i < findNum - 1; i++) {
                    deque.addLast(deque.pollFirst()); //오른쪽 회전
                }
            } else {
                for (int i = findNum; i < 0; i++) {
                    deque.addFirst(deque.pollLast()); //왼쪽회전
                }
            }
        }

        bw.flush();
        bw.close();



    }
}

