class Solution {
    static class Edge{
        int src, dest;
        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graphs) {
        int n = graphs.length;
        ArrayList<Edge>[] graph =  new ArrayList[n];
        createGraph(graph,graphs);
        List<List<Integer>> path = new ArrayList<>();
        getAllPath(graph, 0, n-1, path, new ArrayList<>());
        return path;
    }
    // this function find all Paths...........
    public static void getAllPath(ArrayList<Edge>[] graph, int src, int target, List<List<Integer>> path, List<Integer> currPath){
        // add src node to the currPath
        currPath.add(src);

        // if target is reached 
        if(src == target){
            // add the copy of currPath to the path 
            path.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1); // then backtrack and return 
            return;
        }

        // visit all neighbours 
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            // next src is the next neighbour's i.e., e.dest
            getAllPath(graph, e.dest, target,path, currPath);
        }
        
        // backtrack
        currPath.remove(currPath.size() - 1);

    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int src = i;
            for(int j = 0; j < edges[src].length; j++){
                int dest = edges[src][j];

                graph[src].add(new Edge(src, dest));
            }
        }
    }
}