// DFS-based Reverse Topological Sort + Cycle Detection in Directed Graph
//
// Time Complexity: O(V + E)
// Space Complexity: O(V + E)
class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Queue<Integer> q = new LinkedList<>();  // queue used for reverse topological sorting
        boolean[] visited = new boolean[numCourses];

        // stack[i] = true means vertex i is currently present in the current DFS recursion path.
        // It is used to detect a cycle in a directed graph
        boolean[] stack = new boolean[numCourses]; // for detecting cycle in directed
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, prerequisites);

        // traverse all vertex of the graph if vertices are disconnected
        for(int i = 0; i < graph.length; i++){
            // if current vertex is not visited then perform topological sort
            if(!visited[i]){
                if(topologicalSort(graph, i, visited, q, stack)){
                    return new int[0]; // if cycle found then return empty array
                }
            }
        }

        int ans[] = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            ans[i] = q.remove();
            i++;
        }
        return ans;
    }

    // DFS function for:
    // 1. Topological sorting
    // 2. Cycle detection
    //
    // return true  -> cycle found
    // return false -> no cycle
    public static boolean topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] visited, Queue<Integer> q, boolean[] stack){
        visited[curr] = true;
        stack[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(stack[e.dest]){
                return true;
            }
            if(!visited[e.dest]){
                if(topologicalSort(graph, e.dest, visited, q, stack)){
                    return true;
                }
            }
        }
        q.add(curr);
        stack[curr] = false;
        return false;
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