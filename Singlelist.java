public class SingleEldergrove {
    NodeSingleCircular head;
    public Singlelist (Doublelist double){
        NodeDouble checkNode = double.head;
        while (checkNode != null) {
            NodeSingleCircular nodeBaru = new NodeSingleCircular(checkNode.data);
            if (head == null) {
                head = nodeBaru; 
            }else{
                NodeSingleCircular checkNext = head;
                while (checkNext.next != null) {
                    checkNext = checkNext.next;
                }
                checkNext.next = nodeBaru;
                nodeBaru.prev = checkNext;
            }
            checkNode = checkNode.next;
        }
        public void showChar (){
        NodeSingleCircular checkNode = head;
        while (checkNode != null) {
            System.out.println("Nama : " + checkNode.player.nama);
            System.out.println("Hp : " + checkNode.player.hp);
            System.out.println("Level : " + checkNode.player.level);
            System.out.println("Weapon : " + checkNode.player.weapon);
            System.out.println("Element : " + checkNode.player.element);
            System.out.println("Region : " + checkNode.player.region + "\n");
            checkNode = checkNode.next;
        }
    }
    }
