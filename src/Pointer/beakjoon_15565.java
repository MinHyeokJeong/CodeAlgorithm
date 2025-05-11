package Pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class beakjoon_15565 {
    public static void main(String[] args) throws IOException {
        //입력 받기위한 변수 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //라이언 1 / 어피치 2

        //입력 : 1. 첫줄에 N(인형의 수)과 K(라이언인형)가 주어짐 , 2. 둘째 줄에 N개의 인형의 정보가 주어짐.
        //출력 : K개 이상의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집함의 크기를 출력 / 없으면 -1

        String[] input = br.readLine().split(" ");
        int dollCount = Integer.parseInt(input[0]); //N : 인형의 갯수
        int RyanCount = Integer.parseInt(input[1]); //K : 라이언 갯수

        String[] dollInfos = br.readLine().split(" "); //인형의 나열 정보
        int[] arr = new int[dollCount];

        //나열된 배열
        for (int i = 0; i < dollCount; i++) {
            arr[i] = Integer.parseInt(dollInfos[i]);
        }

        int left=0;
        int right;

        int findCount = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dollCount; i++) {
            right = i+1;
            if (arr[i] == 1) {
                findCount++;
            }

            //if (findCount == RyanCount) {
            //    min = right;
            //    System.out.println("Rmin = " + min);
            //}

            while (findCount > RyanCount) {
                //System.out.println("IN");
                //System.out.println("right = " + right);
                int find = 0;

                for (int j = left; j < right; j++) {
                    left = j;
                    if (arr[j] == 1) {
                        find++;
                        //System.out.println("j = " + j);
                    }

                    if (find == 2) {
                        findCount--;
                        //System.out.println("right - left : " + (right-left));
                        //System.out.println("Lmin = " + min);
                        if (min > (right - left)) {
                            min = right - left;
                        }

                        //System.out.println("min : " + min);
                        break;
                    }
                }
            }
        }

        int result = min == Integer.MAX_VALUE ? -1 : min;

        System.out.println(result);


        /*int left = 0, right= dollCount;

        int minCount = Integer.MAX_VALUE;

        boolean rightMove = false;
        boolean conf = true;
        boolean findYN = false;

        while (conf) {
            int findRyan = 0; // 라이언 찾은 갯수

            for (int i = left; i < right; i++) {
                if (arr[i] == 1) {
                    findRyan++;
                }
            }

            if (findRyan >= RyanCount) {
                minCount = Math.min(minCount,(right-left)); //배열안의 갯수

                if ((right - left) == RyanCount) {
                    conf = false;
                    System.out.println(minCount);
                    break;
                }

                if (!rightMove) {
                    left++;
                } else {
                    right--;
                }

                findYN = true;
            } else {
                rightMove = true;

                if (left != 0) {
                    if (arr[right - 1] == 1) {
                        left--;
                    } else {
                        left--;
                        right--;
                    }
                } else {
                    conf = false;
                    System.out.println(minCount);
                }

                findYN = false;
            }

            if (minCount == Integer.MAX_VALUE) {
                conf = false;
                System.out.println(-1);
            }

            if (rightMove && left == 0 && findYN == false) {
                conf = false;
                System.out.println(minCount);
            }
        }*/
    }
}
