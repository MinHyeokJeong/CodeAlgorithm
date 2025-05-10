package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class beakjoon_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> deque = new LinkedList<>();
        //Deque<Integer> Leftdeque = new LinkedList<>();
        //Deque<Integer> Rightdeque = new LinkedList<>();

        String[] inputAndCatchCount = br.readLine().split(" ");
        String[] getNumber = br.readLine().split(" ");

        int moveCount = 0;

        int inputCount = Integer.parseInt(inputAndCatchCount[0]);

        for (int i = inputCount; i > 0 ; i--) {
            deque.push(i);
            //Leftdeque.push(i);
            //Rightdeque.push(i);
        }

        List<Integer> numbers = new ArrayList<>();

        for (String getNum : getNumber) {
            numbers.add(Integer.parseInt(getNum));
        }

        for (int findNumber : numbers) {
            if (deque.getFirst() == findNumber) {
                deque.pollFirst();
            } else {
                int rightCount = 0;
                for (int dequeNum : deque) {
                    if (dequeNum == deque.getFirst()) {
                        continue;
                    }
                    rightCount++;
                    if (dequeNum == findNumber) {
                        break;
                    }
                }

                int leftCount = Math.abs(rightCount - deque.size());

                if (leftCount > rightCount) {
                    //rightCount
                    RightMove(deque, findNumber);
                    moveCount += rightCount;

                } else {
                    //leftCount
                    LeftMove(deque, findNumber);
                    moveCount += leftCount;
                }
            }
        }

        System.out.println(moveCount);

    }

    private static void LeftMove(Deque<Integer> deque, int comp) {

        while (true) {
            deque.offerLast(deque.pollFirst());

            if (deque.getFirst() == comp) {
                deque.pollFirst();
                break;
            }
        }
    }
    private static void RightMove(Deque<Integer> deque, int comp) {
        while (true) {
            deque.offerFirst(deque.pollLast());

            if (deque.getFirst() == comp) {
                deque.pollFirst();
                break;
            }
        }
    }
}
