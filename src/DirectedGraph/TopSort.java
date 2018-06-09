package DirectedGraph;

import java.util.*;

public class TopSort {
    public static void main(String[] args) {
        List<DirectedGraphNode> neighborsList1 = new ArrayList<>();
        List<DirectedGraphNode> neighborsList2 = new ArrayList<>();
        List<DirectedGraphNode> neighborsList3 = new ArrayList<>();


        DirectedGraphNode node1 = new DirectedGraphNode(1, neighborsList1);
        DirectedGraphNode node2 = new DirectedGraphNode(2, neighborsList2);
        DirectedGraphNode node3 = new DirectedGraphNode(3, neighborsList3);
        neighborsList1.add(node1);
        neighborsList1.add(node2);

        //neighborsList2.add(node2);
        neighborsList2.add(node3);

        ArrayList<DirectedGraphNode> list = new ArrayList<>();
        list.addAll(neighborsList1);
        list.addAll(neighborsList2);
        list.addAll(neighborsList3);

        ArrayList<DirectedGraphNode> graph = new ArrayList<DirectedGraphNode>(list);
        List<DirectedGraphNode> result = new ArrayList<>();
        result = topSort(graph);
        for (DirectedGraphNode node : result) {
            System.out.println(node.label);
        }
    }

    /*
    TopSort implementation
     */
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // map 用来存储所有节点的入度，这里主要统计各个点的入度
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        // 初始化拓扑序列为空
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();

        // 把所有入度为0的点，放到BFS专用的队列中
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }

        // 每次从队列中拿出一个点放到拓扑序列里，并将该点指向的所有点的入度减1
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                // 减去1之后入度变为0的点，也放入队列
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }

        Iterator it = result.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        return result;
    }
}
