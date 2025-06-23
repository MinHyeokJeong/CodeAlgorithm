package Map;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class baekjoon_17219 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //사이트 주소 수 (N), 비밀번호 찾을 주소 수 (M) 입력
        String[] input = br.readLine().split(" ");

        //Key,Value 구조
        Map<String, String> savePassword = new HashMap<>();

        for (String s : input) {
            int r = Integer.parseInt(s);

            for (int i = 0; i < r; i++) {
                String[] addressPassword = br.readLine().split(" ");

                //사이트 주소 및 Password 생성 또는 Find Password
                if (addressPassword.length > 1) {
                    savePassword.put(addressPassword[0], addressPassword[1]);
                } else {
                    //output
                    bw.write(savePassword.get(addressPassword[0]));
                    bw.newLine();
                }
            }
        }
        //write파일 닫기
        bw.flush();
    }
}
