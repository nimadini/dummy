/**
 * Created by stanley on 10/25/14.
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utexas.ece.vv.hw2.LList;
import static utexas.ece.vv.hw2.LList.Node;

public class LListTester {
    @Test()
    public void test0() {
        LList l = new LList();
        l.addLast(1);
        assertEquals(l.repOk(), true);
    }

    @Test()
    public void test1() {
        LList l = new LList();
        l.addFirst(1);
        l.addFirst(2);
        l.addLast(3);
        assertEquals(l.repOk(), true);
    }

    @Test()
    public void test2() {
        LList l = new LList();
        assertEquals(l.repOk(), true);
        l.addLast(4);
        assertEquals(l.repOk(), true);
        assertEquals(l.toString(), "4");
    }

    @Test()
    public void test3() {
        LList l = new LList();
        l.header = new Node();
        l.header.next = null;
        l.header.elem = 5;
        l.size = 1;
        assertEquals(l.repOk(), false);
        l.header.next = l.header;
        assertEquals(l.repOk(), true);
        l.header.next = new Node();
        l.header.next.elem = 2;
        l.header.next.next = l.header.next;
        assertEquals(l.repOk(), false);
        l.size = 2;
        assertEquals(l.repOk(), true);
        l.addLast(3);
        assertEquals(l.repOk(), true);
        l.addFirst(4);
        assertEquals(l.repOk(), true);
    }

    @Test()
    public void test4() {
        LList l = new LList();
        assertEquals(l.repOk(), true);
        Node n = new Node();
        l.header = n;
        l.size = 3;
        n.next = new Node();
        n.next.next = new Node();
        n.next.next.next = n;
        assertEquals(l.repOk(), false);
    }
}