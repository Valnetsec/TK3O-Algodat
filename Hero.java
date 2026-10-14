public class Hero extends Character {
    private String hero;
    
    public Hero (String hero, String name, int hp, int level, String weapon){
        super(name, hp, level, weapon);
        this.hero = hero;
    }
    public String gethero(){
        return hero;
    }
    public void sethero(String hero){
        this.hero = hero;
    }
}
