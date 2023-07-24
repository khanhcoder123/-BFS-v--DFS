/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication5;

/**
 *
 * @author khanh
 */
import java.util.*;

class Graph {
    private int V; // Số đỉnh của đồ thị
    private LinkedList<Integer>[] adj; // Danh sách kề cho mỗi đỉnh

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    // Thêm một cạnh vào đồ thị
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS từ đỉnh s
    public void BFS(int s) {
        // Mảng boolean để đánh dấu các đỉnh đã duyệt
        boolean[] visited = new boolean[V];
        // Hàng đợi (queue) để duyệt BFS
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> it = adj[s].listIterator();
            while (it.hasNext()) {
                int n = it.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

public class BFSExample {
    public static void main(String[] args) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        System.out.println("BFS starting from vertex 0:");
        g.BFS(0);
        System.out.println();
    }
}

