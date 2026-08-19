    // Time complexity: O(V + E)
    // Space complexity: O(V + E)
class Solution {
    static class Edge{
        int src;
        int dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // create an adjacency list graph[i] will store the all vertex
        ArrayList<Edge>[] graph = new ArrayList[n];

        // create graph using given edges
        createGraph(graph, edges);

        // start dfs from the source check whether we can reach the destination
        return hasPath(graph, source, destination, new boolean[n]);
    }

    // DFS function check whether a path exist or not 
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        // when source is equal to destination i.e, path exists then return true
        if(src == dest) return true;
        
        // current node marked as visited
        visited[src] = true;
        
        // visit all neighbour of current vertex
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            // if neighbour of current vertex is not visited and
            // recursively perform dfs from this neighbour if the destination is found then return true
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        // if all possible path are checked and destination is not found then return true
        return false;
    }

    // create graph using given edges
    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }
    }
}