class Solution {
    // Time complexity: O(V + E)
    // Space complexity: O(V)
    // Perform BFS 
    public boolean isBipartite(int[][] graph) {
        // color 0 -> red, 1 -> blue, and -1 -> no color assigned
        int color[] = new int[graph.length];

        // inialize with no color
        for(int i = 0; i < color.length; i++){ 
            color[i] = -1;
        }

        Queue<Integer> q = new LinkedList<>();

        // check every Vertex, this is because the graph can have multiple disconnected components
        for(int i = 0; i < graph.length; i++){
            // if no any color is assigned start bfs with from this vertex
            if(color[i] == -1){
                color[i] = 0;  // assign the color of first vertex as 0
                q.add(i);  // add to the queue that vertex

                // continues BFS until queue becomes empty
                while(!q.isEmpty()){
                    int curr = q.remove();  // current vertex remove to the queue

                    // check all neighbours of current vertex
                    for(int neighbour: graph[curr]){
                        // case 1: if color of current vertex and neighbour vertes is same then return false 
                        if(color[neighbour] == color[curr]){
                            return false;
                        } // if neighbour vertex is not coloured then color the vertex as opposite color of current vertex and then neighbour vertex is added to the queue
                        else if(color[neighbour] == -1){
                            color[neighbour] = (color[curr] == 0) ? 1 : 0;
                            q.add(neighbour);
                        }
                    }
                }
            }
        }
        // If no same-color conflict was found, the graph is bipartite
        return true;
    }
}