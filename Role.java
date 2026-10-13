public class Role extends Character {
    private String hero;
    private String bossfight;
    private String npc;
    public Role (String hero, String bossfight, String npc, String name, int hp, int level, String weapon){
        super(name,hp, level, weapon);
        this.hero = hero;
        this.bossfight = bossfight;
        this.npc = npc;
    }
    public String gethero(){
        return hero;
    }
        public String getbossfight(){
        return bossfight;
    }
    public String getnpc(){
        return npc;
    }
    public void sethero(String hero){
        this.hero = hero;
    }
    public void setbossfight(String bossfight){
        this.bossfight = bossfight;
    }
    public void setNpc(String  npc){
        this.npc = npc;
    }

}
