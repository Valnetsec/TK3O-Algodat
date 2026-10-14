public class NodeDouble {
    Hero player;
    NodeDouble next;
    NodeDouble prev;

    public NodeDouble(Hero player) {
        this.player = player;
        this.next = null;
        this.prev = null;
    }
}
