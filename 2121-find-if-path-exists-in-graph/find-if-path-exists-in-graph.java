class Solution {
    static class Edge{
        int src;
        int nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph [] = new ArrayList [n];
        for(int i = 0 ; i< n ; i++){
            graph[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<edges.length ; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            Edge e1 = new Edge(v1,v2);
            Edge e2 = new Edge(v2,v1);
            graph[v1].add(e1);
            graph[v2].add(e2);
        }
        boolean visited[] = new boolean[n];
        return hasPath(graph,source,destination,visited);
       
        
    }
    public boolean hasPath(ArrayList<Edge>[] graph, int src,int dest,boolean[] visited){
            visited[src] = true;
        if(src == dest){
            return true;
        }
        for(Edge edge: graph[src]){
            if(!visited[edge.nbr]){
            boolean ans = hasPath(graph,edge.nbr,dest,visited);
            if(ans == true){
                return true;
            }
            }
        }
        return false;
    }
}