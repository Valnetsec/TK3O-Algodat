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
            System.out.println("Level : " + checkNode.data.level);
            System.out.println("Weapon : " + checkNode.data.weapon);
            System.out.println("Element : " + checkNode.data.element);
            System.out.println("Region : " + checkNode.data.region + "\n");
            checkNode = checkNode.next;
        }
    }
    }
