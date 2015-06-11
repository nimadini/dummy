/**
 * Created by stanley on 10/25/14.
 */

package utexas.ece.vv.hw2;

import java.util.HashSet;
import java.util.Set;

public class LList {
    public Node header;
    public int size;

    public LList() {
        this(null, 0);
    }

    public LList(Node header, int size) {
        this.header = header;
        this.size = size;
    }

    public static class Node {
        public int elem;
        public Node next;
    }

    public boolean repOk() {
        if (header == null)
            return size == 0;
        Set<Node> nodes = new HashSet<Node>();
        for (Node cur = header; cur != null; cur = cur.next) {
            if (nodes.contains(cur))
                return cur.next == cur && nodes.size() == size;
            nodes.add(cur);
        }
        return false;
    }

    public void addFirst(int x) {
        Node newly = new Node();
        newly.elem = x;
        if (header == null)
            newly.next = newly;
        else
            newly.next = header;
        header = newly;
        size++;
    }

    private Node getLastNode() {
        if (header == null)
            return null;
        Node cur = header;
        while (cur != cur.next)
            cur = cur.next;
        return cur;
    }

    public void addLast(int x) {
        Node newly = new Node();
        newly.elem = x;
        newly.next = newly;
        Node lastNode = getLastNode();
        if (lastNode == null)
            header = newly;
        else
            lastNode.next = newly;
        size++;
    }

    public String toString() {
        if (header == null)
            return "";
        String res = Integer.toString(header.elem);
        Node cur = header;
        while (cur != cur.next) {
            cur = cur.next;
            res = res + " " + cur.elem;
        }
        return res;
    }
}