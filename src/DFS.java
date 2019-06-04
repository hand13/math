import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author $Author$
 * @version $Revision$ $Date$
 */
public class DFS {
    public static void main(String[] args) {

    }

    public static class Node {
        String value;
        boolean visited = false;
    }

    public void startScan(Map<Node, List<Node>> maps, List<Node> ns) {
        this.maps = maps;
        this.nodes.clear();
        this.nodes.push(ns.get(0));
        visit();
    }

    public Stack<Node> nodes = new Stack<>();
    public Map<Node, List<Node>> maps;

    public void visit() {
        if(nodes.empty()){
            return;
        }
        Node node = nodes.peek();
        System.out.println("i am visiting this node ==== " + node.value);
        List<Node> children = maps.get(node);
        if (children != null && children.size() != 0) {
            for (Node n : children) {
                if (!n.visited && !nodes.contains(n)) {
                    nodes.push(n);
                    visit();
                }
            }
        }
        node.visited = true;
        nodes.pop();

    }
}
