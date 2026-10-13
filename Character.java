public class Character {
    private String name;
    private int hp;
    private int level;
    private String weapon;
    public Character (String name, int hp, int level, String weapon){
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.weapon = weapon;
    }
    public String getName(){
        return name;
    }
        public int getHp(){
        return hp;
    }
    public int getLevel(){
        return level;
    }
    public String getweapon(){
        return weapon;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setweapon(String weapon){
        this.weapon = weapon;
    }


}

