// Approach: Topological sorting Using BFS : Kahn's algorithm
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
        createGraph(graph, prerequisites);  // creating graph using prerequisites

        // stores number of incomoing edges of all nodes
        int[] inDegree = new int[n];
        calculateInDegree(graph, inDegree);  // calculate inDegree of all nodes

        // Queue for BFS
        Queue<Integer> q = new LinkedList<>();
        // add all nodes with 0 inDegree into the queue
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        int courseCompleted = 0;  // tracks number of course completed

        while(!q.isEmpty()){
            int curr = q.remove();  // remove current node
            courseCompleted++;  // update courseCompleted by 1

            // find all neighbour nodes of current node and reduce the inDegree of all neighbours by 1 
            //  and if the inDegree becomes 0 then the neighbour add to the queue
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        // if number of courses is equal to the number of completed courses then return true otherwise return false;
        return courseCompleted == numCourses;
    }

    public static void calculateInDegree(ArrayList<Edge>[] graph, int[] inDegree){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){
                Edge e = graph[i].get(j);
                inDegree[e.dest]++;
            }
        }
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