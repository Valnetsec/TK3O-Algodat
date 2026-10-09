public class Atribut extends Character {
    private String weapon;
    private String element;
    private String region;
    public Atribut (String weapon, String element, String region, String name, int hp, int level){
        super (name, hp,level);
        this.weapon = weapon;
        this.element = element;
        this.region = region;
    }
    public String getWeapon(){
        return weapon;
    }
        public String getElement(){
        return element;
    }
    public String getRegion(){
        return region;
    }
    public void seWeapon(String weapon){
        this.weapon = weapon;
    }
    public void setElement(String element){
        this.element = element;
    }
    public void setRegion(String region){
        this.region = region;
    }

}
