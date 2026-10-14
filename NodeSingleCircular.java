public class NodeSingleCircular {
    String nama;
    String tipe;
    String level;
    NodeSingleCircular next;

    public NodeSingleCircular(
        String nama,
        String tipe,
        String level
    ) {
        this.nama = nama;
        this.tipe = tipe;
        this.level = level;
        this.next = null;
    }
}
