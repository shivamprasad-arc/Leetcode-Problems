// Time complexity: O(V + E)
// Space complexity: O(V + E)
// Appraoch: BFS - Topological Sort
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
        // create graph of reverse edges i.e., reverse graph
        createRevGraph(graphs, graph);

        // then calculate indegree of all vertex
        int[] inDegree = new int[graphs.length];
        for(int u = 0; u < graphs.length; u++){
            for(Edge v: graphs[u]){
                inDegree[v.dest]++;
            }
        }

        // queue data structure for BFS 
        Queue<Integer> q = new LinkedList<>();
        // safeNode stores the safe Nodes of the graph
        ArrayList<Integer> safeNode = new ArrayList<>();

        // add the terminal node i.e, node with 0 indegree into the queue
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        // perform BFS 
        while(!q.isEmpty()){
            int curr = q.remove();
            safeNode.add(curr);  // add current node to the safeNode
            //check for the neighbours of current  node 
            for(int i = 0; i < graphs[curr].size(); i++){
                Edge e = graphs[curr].get(i);

                // Remove the edge curr -> e.dest, Therefore decrease indegree of e.dest
                inDegree[e.dest]--;

                // after removal one edge if the indegree of neighbour becomes 0 then the neighbour add to the queue
                if(inDegree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }

        // sort the arrayList
        Collections.sort(safeNode);
        return safeNode;  // return safest node
    }

    
    public static void createRevGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            int u = i;
            for(int j = 0; j < edges[i].length; j++){
                int v = edges[i][j];
                graph[v].add(new Edge(v, u));
            }
        }
    }
}