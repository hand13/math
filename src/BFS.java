import java.util.ArrayList;
import java.util.List;

/**
 * @version $Revision$ $Date$
 * @author $Author$
*/
public class BFS {
    public static class Node{
        String color;
        int depth;
        int value;
    }

    public static void main(String[] args) {
        int size = 3;
        Node[] nodes = new Node[size];
        byte[][] map = new byte[size][size];
        int i=0;
        for(Node node : nodes) {
            node.color = "w";
            node.value = i;
            i++;
        }
        calculate(nodes,map,0);


    }
    private static void calculate(Node[] nodes,byte[][] map,int start) {
        if(nodes.length != map.length) {
            return;
        }
        nodes[start].color = "g";
        nodes[start].depth = 0;
        List<Node> grays = new ArrayList<>();
        List<Node> change = new ArrayList<>();
        grays.add(nodes[start]);
        int depth = 0;
        while(grays.size() != 0) {
            depth++;
            for(Node node :grays) {
                node.color = "b";
                for(int i =0; i<map[node.value].length;i++) {
                    if(map[node.value][i] == 1) {
                        if(nodes[i].color.equals("w")){
                            nodes[i].color = "g";
                            nodes[i].depth = depth;
                            change.add(node);
                        }
                    }
                }
            }
            grays = change;
            change = new ArrayList<>();
        }
    }
}
