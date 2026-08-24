// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    // create edge class
    static class Edge{
        int src, dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;  // number of vertex in the graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, prerequisites);
        boolean[] visited = new boolean[n];
        boolean[] stack = new boolean[n];  //stack tells whether a vertex is currently present in the current DFS or not

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                // if cycle exists then the course can;t be completed so it return false
                if(canFinishUtil(graph, i, visited, stack)){
                    return false;
                }
            }
        }
        return true;  // no cycle found -> all courses are completed
    }

    // DFS function for detecting cycle in directed graph
    // return true  -> cycle found
    // return false -> no cycle
    public static boolean canFinishUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack){
        visited[curr] = true;  // mark current vertex as true
        stack[curr] = true; // Put current vertex into current DFS path

        // Visit all neighbour of current list
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);  
            // if the neighbour is already in the current DFS path that is cycle exists
            if(stack[e.dest]){
                return true;
            }

            // If destination vertex has not been visited, perform DFS on that vertex
            if(!visited[e.dest]){
                if(canFinishUtil(graph, e.dest, visited, stack)){
                    return true;
                }
            }
        }
        // Current vertex's DFS is completed.
        // Remove it from the current DFS path.
        //
        // Important:
        // visited remains true, but stack becomes false.
        stack[curr] = false;
        return false; // no cycle found from the vertex
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
        }
    }
}