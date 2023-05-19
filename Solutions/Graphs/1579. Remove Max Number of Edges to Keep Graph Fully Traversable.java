class Solution {
    // constants for the edge types indices
    static final int 
        TYPE = 0, U = 1, V = 2,
        ALICE = 1, BOB = 2, BOTH = 3;

    public int maxNumEdgesToRemove(final int n, final int[][] edges) {
        // Move all edges of type BOTH to the end of the array
        for (int i = 0, j = edges.length - 1; i < j; ) {
            if (edges[i][TYPE] == BOTH) {
                ++i;
                continue;
            }
            final var temp = edges[i];
            edges[i] = edges[j];
            edges[j] = temp;
            --j;
        }

        // Create two UnionFind data structures, one for Alice and one for Bob
        final UnionFind 
            aliceUf = new UnionFind(n), 
            bobUf = new UnionFind(n);
        int added = 0;

        // Iterate over the edges and add them to the appropriate UnionFind data structure
        for (final var edge : edges) {
            final int type = edge[TYPE];
            final int u = edge[U];
            final int v = edge[V];

            // Add the edge to both UnionFind data structures if it is of type BOTH
            added += switch (type) {
                case BOTH -> 
                    aliceUf.union(u, v) | bobUf.union(u, v);
                case ALICE -> aliceUf.union(u, v);
                default -> bobUf.union(u, v);
            };

            // If both UnionFind data structures are united, return the number of edges that were not added
            if (aliceUf.isUnited() && bobUf.isUnited())
                return edges.length - added;
        }

        // If both UnionFind data structures are united, return the number of edges that were not added
        if (aliceUf.isUnited() && bobUf.isUnited())
            return edges.length - added;

        // If both UnionFind data structures are not united, it is impossible to remove enough edges to make them united
        return -1;
    }
}

class UnionFind {
    final int[] parent;
    int groups;

    // Initialize the UnionFind data structure with n groups
    UnionFind(final int n) {
        parent = new int[n + 1];
        groups = n;
    }

    // Union two elements and return 1 if they were not already in the same group, 0 otherwise
    int union(final int u, final int v) {
        final int uParent = find(u);
        final int vParent = find(v);
        if (uParent == vParent)
            return 0;
        parent[uParent] = vParent;
        --groups;
        return 1;
    }

    // Find the parent of an element and perform path compression
    int find(final int v) {
        if (parent[v] != 0)
            return parent[v] = find(parent[v]);
        return v;
    }

    // Check if all elements are in the same group
    boolean isUnited() {
        return groups == 1;
    }
}
