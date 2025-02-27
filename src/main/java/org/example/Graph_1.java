package org.example;

import java.util.Arrays;

class Graph_1 {
    public static void main(String[] args) {
        System.out.println();
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] graph = new boolean[n][n];
        for(boolean[] row : graph){
            Arrays.fill(row,false);
        }

        for(int[] edge : edges){
            graph[edge[0]][edge[1]] = true;
            graph[edge[1]][edge[0]] = true;
        }
        boolean[] vis = new boolean[n];
        return dfs(graph,vis,n,source,destination);
    }

    public boolean dfs(boolean[][] graph,  boolean[] vis, int n,int source, int destination) {
        if(source == destination)
            return true;
        vis[source]=true;

        for(int i=0;i<n;i++){
            if(graph[source][i]== true && !vis[i]){
                if(dfs(graph,vis,n,i,destination))
                    return true;
            }
        }
        return false;
    }
}