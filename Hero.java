public class Hero extends Character {
    private String role;

    public Hero(String role, String name, int hp, int level, String weapon) {
        super(name, hp, level, weapon);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
