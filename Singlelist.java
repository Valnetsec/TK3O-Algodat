public class SingleEldergrove {
    Node head;
    public SingleEldergrove (Doublelist reader){
        NodeDouble checkNode = reader.head;
        Node tail = null;
        while (checkNode != null) {
            Node nodeBaru = new Node(checkNode.player);
            if (head == null) {
                head = nodeBaru; 
                tail = nodeBaru;
            }else{
               tail.next = nodeBaru;
               tail = nodeBaru;
            }
            checkNode = checkNode.next;
        }    
    }
        public void showChar (){
        Node checkNode = head;
        while (checkNode != null) {
            System.out.println("Nama : " + checkNode.player.getName());
            System.out.println("Hp : " + checkNode.player.getHp());
            System.out.println("Level : " + checkNode.player.getLevel());
            System.out.println("Weapon : " + checkNode.player.getWeapon());
            checkNode = checkNode.next;
        }
    }
}
