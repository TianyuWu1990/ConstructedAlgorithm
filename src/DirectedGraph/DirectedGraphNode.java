package DirectedGraph;

import java.util.List;

class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    public DirectedGraphNode(int label, List<DirectedGraphNode> neighbors) {
        this.label = label;
        this.neighbors = neighbors;
    }

    private void addNeighbors(DirectedGraphNode node) {
        neighbors.add(node);
    }
}
