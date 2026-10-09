public class Character {
    private String name;
    private int hp;
    private int level;
    public Character (String name, int hp, int level){
        this.name = name;
        this.hp = hp;
        this.level = level;
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
    public void setName(String name){
        this.name = name;
    }
    public void setHP(int hp){
        this.hp = hp;
    }
    public void setLevel(int level){
        this.level = level;
    }


}

