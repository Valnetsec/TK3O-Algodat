public class BossFight extends Character {
    private int domain;
    private String peliharaanMonster;

    public BossFight(String name, int hp, int level, String weapon, int domain, String peliharaanMonster) {
        super(name, hp, 1, weapon);
        this.domain = domain;
        this.peliharaanMonster = peliharaanMonster;
    }

    public int getDomain() {
        return domain;
    }


    public String getPeliharaanMonster() {
        return peliharaanMonster;
    }

    public void setDomain(int domain) {
        this.domain = domain;
    }

    public void setPeliharaanMonster(String peliharaanMonster) {
        this.peliharaanMonster = peliharaanMonster;
    }
}
