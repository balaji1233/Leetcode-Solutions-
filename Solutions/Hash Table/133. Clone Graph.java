class Solution {
    private Node vis[]=new Node[100];
    public Node cloneGraph(Node node) {
        if(node==null)      return null;
        Node root=new Node(node.val);
        List<Node> neighbors=root.neighbors;
        vis[node.val-1]=root;
        for(Node con:node.neighbors){
            neighbors.add(vis[con.val-1]==null?cloneGraph(con):vis[con.val-1]);
        }
        return root;
    }
}
