public class NodeBoss {
    BossFight player;
    NodeBoss next;

    public NodeBoss(BossFight player) {
        this.player = player;
        this.next = null;
    }
}