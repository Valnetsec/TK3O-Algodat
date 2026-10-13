public class SingleEldergrove {
    Node head;
    public SingleEldergrove (Doublelist d){
        NodeDouble checkNode = d.head;
        while (checkNode != null) {
            Node nodeBaru = new Node(checkNode.player);
            if (head == null) {
                head = nodeBaru; 
            }else{
                Node checkNext = head;
                while (checkNext.next != null) {
                    checkNext = checkNext.next;
                }
                checkNext.next = nodeBaru;
                
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
