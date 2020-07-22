public class Dragon extends Enemy{

    public Dragon() {
        this.setAttack(15);
        this.setHealth(100);
        this.setDefense(10);
        this.setMagicDefense(1.5); //if enemy is resistant then player's magic dmg/this number otherwise player's magicdamage * this number
        this.setXp(50);
        this.setName("Dragon");
    }

}
