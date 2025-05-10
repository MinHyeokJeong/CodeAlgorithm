package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class beakjoon_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputCount = sc.nextInt();
        sc.nextLine();

        List<Integer> anyList = new ArrayList<>();
        List<Character> resultList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < inputCount; i++) {
            anyList.add(sc.nextInt());
            //sc.nextLine();
        }

        int max = 1;

        for (int value : anyList) {
            if (max <= value) {
                for (int i = max; i <= value; i++) {
                    stack.push(i);
                    resultList.add('+');
                }
                max = value + 1;
            }

            if (stack.peek() == value) {
                stack.pop();
                resultList.add('-');
            } else {
                //resultList.clear();
                System.out.println("NO");
                return;
            }
        }

        for (Character ch : resultList) {
            System.out.println(ch);
        }

    }
}
