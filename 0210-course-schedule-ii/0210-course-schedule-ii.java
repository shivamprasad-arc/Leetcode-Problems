// topological sort using bfs : Kahn's Algorithm
// Approach: we wan't to find reversed Topological sorting so we create graph in reversed order then apply topological sort using bfs algorithm
class Solution {
    static class Edge{
        int src, dest; 
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] CourseOrder = new int[numCourses];  // ans
        // inDegree tracks the inDegree of each Vertes
        int[] inDegree = new int[numCourses];
        ArrayList<Edge>[] graph = new ArrayList[numCourses];
        createGraph(graph, prerequisites);  // createGraph
        calculateInDegree(graph, inDegree); // calculate inDegree's
        Queue<Integer> q = new LinkedList<>();  // queue for dfs

        // add all vertex to the queue whose inDegree is zero 
        boolean isZeroDeg = false;
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
                isZeroDeg = true;  // 
            }
        }
        // if no any element with non Zero inDegree that means cycle is in graph 
        //  so topological sort is not possible for cyclic graph
        if(!(isZeroDeg)) return new int[]{};

        int idx = 0;  // tracks the index of CourseOrder i.e, ans
        
        while(!q.isEmpty()){
            int curr = q.remove();  // remove current vertex from queue
            CourseOrder[idx++] = curr;  // add to course schedule

            // then decrease the inDegree's of each neighbour nodes of current vertex 
            //  and if the inDegree of any neighbour will be zero then add that node to the queue
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        // course schedule
        return idx == numCourses ? CourseOrder : new int[]{};
    }

    // this function calculates the inDegree of every nodes
    public static void calculateInDegree(ArrayList<Edge>[] graph, int[] inDegree){
        for(int i = 0; i < inDegree.length; i++){
            // travese all edges connected to the vertex i
            for(int j = 0; j <graph[i].size(); j++){
                Edge e = graph[i].get(j);  // get the current edge

                // e.dest receives one incoming edge. Therefore, increase its indegree.
                inDegree[e.dest]++;
            }
        }
    }

     // ---------------------------------------------------------
    // FUNCTION: createGraph
    // ---------------------------------------------------------
    // This function creates the adjacency-list representation  of the graph.
    // For prerequisite [u, v]: u depends on v
    // Therefore:  v -> u
    // Example: prerequisites = [[1,0]]
    // Means: Course 0 must be completed before Course 1.
    // Graph: 0 -> 1
    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
             // For [u, v]:
            // u = course that depends on v
            // v = prerequisite course
            int u = edges[i][0]; 
            int v = edges[i][1];

            // Create the edge:  v -> u
            // Because v must be completed before u. i.e., reverse connect the edges
            graph[v].add(new Edge(v, u));
        }
    }
}