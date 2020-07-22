import java.util.ArrayList;

public class Player {

    private int health;
    private int attack;
    private int magic;
    private int level;
    private int xp;
    private String attackType;
    private String magicType;
    private String race;
    private String name;
    private boolean alive;
    private ArrayList<Item> inventory;

    public Player(int health, int attack, int magic, String name, String race, boolean alive) {
        this.health = health;
        this.attack = attack;
        this.magic = magic;
        this.xp = 0;
        this.level = 1;
        this.name = name;
        this.race = race;
        this.alive = alive;
        this.inventory = new ArrayList<>();
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public String getMagicType() {
        return magicType;
    }

    public void setMagicType(String magicType) {
        this.magicType = magicType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setAttackType(String attackType) {
        this.attackType = attackType;
    }

    public String getAttackType() {
        return attackType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean getAlive() {
        return alive;
    }

    public void addItemToInventory(Item item) {
        this.inventory.add(item);
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void healthCheck() {
        if (getHealth() > 0) {
            System.out.println("You are still alive.");
        } else if (getHealth() <= 0) {
            System.out.println("You are dead.");
            setAlive(false);
        }
    }
}

