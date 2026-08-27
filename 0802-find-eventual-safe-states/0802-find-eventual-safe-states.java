// Time complexity: O(V + E)
// Space complexity: O(V + E)
class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<Edge>[] graphs = new ArrayList[graph.length];
        createGraph(graphs, graph);

        boolean[] visited =  new boolean[graph.length];

        // stack[i] = true means node i is currently present in the current DFS recursion path
        // This array is used to detect a cycle
        boolean[] stack = new boolean[graph.length];

        // checkSafe[i] = true means node i is a safe node
        boolean[] checkSafe = new boolean[graph.length];

        for(int i = 0; i < graphs.length; i++){
            if(!visited[i]){
                dfs(graphs, i, visited, stack, checkSafe);
            }
        }
        // stores all safeNodes answers
        ArrayList<Integer> safeStates = new ArrayList<>();
        for(int i = 0; i < graph.length; i++){
            // if current node is safe then add to the safeStates
            if(checkSafe[i]){
                safeStates.add(i);
            }
        }

        return safeStates;
    }

    // this code is of detect cycle in directed graph
    public static boolean dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stack, boolean[] checkSafe){
        visited[curr] = true;
        stack[curr] = true;  // Put current node into the current DFS path

        // check for all neighbour of current node
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            // if the neighbour of current is already present in the stack 
            if(stack[e.dest]){ 
                return true;  // cycle detected
            }

            // if neighbour is not visited and after recrusive call the function returns true then the cycle exists return true
            if(!visited[e.dest] && dfs(graph, e.dest, visited, stack, checkSafe)){
                return true;
            }
        }
        // Current node is no longer part of the current DFS recursion path
        stack[curr] = false;
        checkSafe[curr] = true;  // if no cycle detected then the current node is safe State 
        return false;
    }
    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int u = i;
            for(int j = 0; j < edges[i].length; j++){
                int v = edges[i][j];
                graph[u].add(new Edge(u,v));
            }

        }
    }
}