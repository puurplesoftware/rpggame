public class Coins extends Item {
    private int value;
    public Coins(String name, int value) {
        super(name);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
