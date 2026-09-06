// Time complexity: O(V + E log V)
class Solution {
    static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            this.src = s; 
            this.dest = d;
            this.wt = w;
        }
    }

    // Pair stores:
    // node = current node
    // dist = shortest distance found so far
    static class Pair implements Comparable<Pair>{
        int node, dist;
        public Pair(int n, int d){
            this.node = n;
            this.dist = d;
        }

        @Override
        // PriorityQueue will keep the Pair with minimum distance first
        // sort the pair based on min dist
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int src = k;

        // Nodes are numbered from 1 to n, so we create n+1 size array.
        // Index 0 remains unused.
        ArrayList<Edge>[] graph = new ArrayList[n+1];
        createGraph(graph, times); // create adjacency list

        boolean[] visited = new boolean[graph.length];
        int[] timeDelay = new int[n+1];   // timeDelay[i] = shortest time required to reach node i

        //  initialize each node with infinity except the 'src' node
        for(int i = 1; i < timeDelay.length; i++){
            if(i != src){
                timeDelay[i] = Integer.MAX_VALUE;
            }
        }

        // Distance from source to itself is 0  and add source to min heap
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        // Dijkstra's Algorithm
        while(!pq.isEmpty()){
            Pair curr = pq.remove();  // remove current pair

            // if current node is not visited then visit that node
            if(!visited[curr.node]){
                visited[curr.node] = true;

                // Traverse all neighbours of current node
                for(int i = 0; i < graph[curr.node].size(); i++){
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt; // time delay from u to v

                    // Check whether going through u gives a shorter path to v.
                    if((timeDelay[u] + wt) < timeDelay[v]){
                        timeDelay[v] = timeDelay[u] + wt;  // update the time delay of v
                        pq.add(new Pair(v, timeDelay[v]));  // add to priority queue
                    }

                }
            }
        }
        
        // We need the maximum shortest delay,
        // because the signal must reach ALL nodes.
        int maxDelay = 0; 
        for(int i = 1; i < timeDelay.length; i++){
            if(timeDelay[i] == Integer.MAX_VALUE){
                return - 1;
            }
            maxDelay = Math.max(maxDelay, timeDelay[i]);
        }
        return maxDelay;
    }
   
    public static void createGraph(ArrayList<Edge>[] graph, int[][] times){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < times.length; i++){
            int src = times[i][0];
            int dest = times[i][1];
            int wt = times[i][2];

            graph[src].add(new Edge(src, dest, wt));
        }
    }
}