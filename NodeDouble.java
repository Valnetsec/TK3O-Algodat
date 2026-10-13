public class NodeDouble {
    Role player;
    NodeDouble next;
    NodeDouble prev;

    public NodeDouble(Role player) {
        this.player = player;
        this.next = null;
        this.prev = null;
    }
}
