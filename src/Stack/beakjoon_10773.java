package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class beakjoon_10773 {
    public static void main(String[] args) throws IOException {

        /*//입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] brInput = br.readLine().split(" ");

        //저장소
        Stack<Integer> brStack = new Stack<>();
        //결과 값
        int brSum = 0;

        for (int i = 0; i < Integer.parseInt(brInput[0]); i++) {
            String[] brK = br.readLine().split(" ");
            int brKParse = Integer.parseInt(brK[0]);

            if (brKParse == 0) {
                if (!brStack.isEmpty())
                    brStack.pop();
            } else {
                brStack.add(brKParse);
            }
        }

        for (Integer b : brStack) {
            brSum += b;
        }

        //출력
        System.out.println(brSum);*/

        //입력
        Scanner sc = new Scanner(System.in);
        int scInput = sc.nextInt();

        //저장소
        Stack<Integer> scStack = new Stack<>();
        //결과 값
        int scSum = 0;

        for (int i = 0; i < scInput; i++) {
            int scK = sc.nextInt();
            sc.nextLine();

            if (scK == 0) {
                if (!scStack.isEmpty())
                    scStack.pop();
            } else {
                scStack.add(scK);
            }
        }

        for (Integer s : scStack) {
            scSum += s;
        }

        //출력
        System.out.println(scSum);
    }
}
