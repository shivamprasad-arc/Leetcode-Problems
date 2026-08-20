// Time complexity: O(V^2)
// Space complexity: O(V^2)
class Solution {
    static class Edge{
        int src, dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<Edge>[] graph = new ArrayList[isConnected.length];
        // create adjacency matrix to adjacency list
        createGraph(isConnected, graph);
        boolean[] visited = new boolean[graph.length];
        int count = 0;  // count the number of connected components

        // traverse the each vertex
        for(int i = 0; i < graph.length; i++){
            // if any vertex is not visited
            if(!visited[i]){

                // then call BFS traversal function that traverse all connected vertes in a component
                BFS(graph, visited, i);
                count++; // count the number of connected components
            }
        }
        return count;
    }

// code of BFS Traversal
    public static void BFS(ArrayList<Edge>[] graph, boolean visited[], int src){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int curr = q.remove();
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    visited[e.dest] = true;
                    q.add(e.dest);
                }
            }
        }
    }

    // change the Adjacency matrix to adjacency list
    public static void createGraph(int[][] isConnected, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] =  new ArrayList<>();
        }

        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    graph[i].add(new Edge(i, j));
                }
            }
        }
    }
}