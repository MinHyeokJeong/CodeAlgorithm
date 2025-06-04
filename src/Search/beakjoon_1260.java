package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class beakjoon_1260 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 정점 수
        int M = Integer.parseInt(input[1]); // 간선 수
        int V = Integer.parseInt(input[2]); // 시작 정점

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] inNum = br.readLine().split(" ");
            int a = Integer.parseInt(inNum[0]);
            int b = Integer.parseInt(inNum[1]);

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 오름차순 정렬 (정점 번호가 작은 것부터 방문)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // DFS 수행
        visited = new boolean[N + 1];
        DFS(V);
        System.out.println(); // 줄바꿈

        // BFS 수행
        visited = new boolean[N + 1];
        BFS(V);
    }

    private static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                DFS(neighbor);
            }
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }
}
