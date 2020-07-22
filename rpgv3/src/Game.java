import java.security.cert.CRLReason;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your race");
        System.out.println("Type 'elf,' 'human,' or 'dwarf'");
        System.out.print("> ");
        String userSelectionForRace = scanner.next();
        userSelectionForRace = userSelectionForRace.toLowerCase();

        //checking if selection of race is valid
        while (!userSelectionForRace.equals("elf") && !userSelectionForRace.equals("human") && !userSelectionForRace.equals("dwarf")) {
            System.out.println("Invalid selection");
            System.out.println("Choose your race");
            System.out.println("Type 'elf,' 'human,' or 'dwarf'");
            userSelectionForRace = scanner.next();
        }

        System.out.println("Please enter your character name");
        System.out.print("> ");
        scanner.nextLine();
        String userSelectionForName = scanner.nextLine();
        userSelectionForName = userSelectionForName.toLowerCase();
        Player player = createCharacter(userSelectionForRace, userSelectionForName);
        System.out.println("You chose: " + player.getRace());
        System.out.println("Welcome, " + player.getName());
        System.out.println("Your Journey Begins...");

        Enemy enemy1 = spawnEnemy();
       // Enemy enemy2 = spawnEnemy(); //have to notify player that enemy is defeated


        //do some random roll for an encounter - I encounter a goblin


        //lets say I kill the goblin. goblin drops some coins
        Item coins = new Item("Coins"); //Create Coin class that extends item - that contain attributes of (value)
        player.addItemToInventory(coins);
        combatSequence(player, enemy1);
        //combatSequence(player, enemy2);


    }

    public static Enemy spawnEnemy() {
        Enemy enemy = new Enemy();
        int creationRoll = (int) (Math.random() * 100) + 1;

        if (creationRoll > 75) {
            enemy = new Goblin();
            System.out.println("A Goblin has appeared!");
        } else if (creationRoll >= 50) {
            enemy = new Dragon();
            System.out.println("A Dragon has appeared!");
        } else if (creationRoll >= 25) {
            enemy = new Orc();
            System.out.println("An Orc has appeared!");
        } else {
            enemy = new Ogre();
            System.out.println("An Ogre has appeared!");
        }

        return enemy;
    }

    public static void classCheck(Enemy enemy) {

        if (enemy instanceof Goblin) {

        } else if (enemy instanceof Dragon) {

        } else if (enemy instanceof Orc) {

        } else {

        }


    }

    public static Player createCharacter(String userSelectionForRace, String userSelectionForName) {

        Player player = new Player(0, 0, 0, "", "", true);

        if (userSelectionForRace.equals("elf")) {
            player = new Elf();
            player.setName(userSelectionForName);

        } else if (userSelectionForRace.equals("human")) {
            player = new Human();
            player.setName(userSelectionForName);

        } else if (userSelectionForRace.equals("dwarf")) {
            player = new Dwarf();
            player.setName(userSelectionForName);
        }
        return player;
    }

    public static void combatSequence(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);


        while (enemy.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println(player.getName() + " health: " + player.getHealth());
            System.out.println(enemy.getName() + " health: " + enemy.getHealth());
            System.out.println("Choose your attack");
            System.out.println("1. melee attack");
            System.out.println("2. lightning spell");
            System.out.println("3. fire spell");
            System.out.println("4. frost spell");
            System.out.println("5. Inventory");
            System.out.print("> ");
            String userAttack = scanner.next();
            if (userAttack.equals("1")) {
                enemy.setHealth(enemy.getHealth() - player.getAttack());
                System.out.println("You attack the " + enemy.getName() + " for " + player.getAttack());

            } else if (userAttack.equals("2")) {
                //
            } else if (userAttack.equals("3")) {

            } else if (userAttack.equals("4")) {

            } else if (userAttack.equals("5")) {
                System.out.println("Items in your inventory: ");
                for (int i = 0; i < player.getInventory().size(); i++) {
                    System.out.println((i + 1) + ". " + String.valueOf(player.getInventory().get(i).getName()));
                }
            } else {
                System.out.println("Your attack missed");
            }

            // this is the enemy's attack roll
            if (enemy.getHealth() > 0 && player.getHealth() > 0) {
                int enemyAttackRoll = (int) (Math.random() * 100) + 1;

                if (enemyAttackRoll > 50) {
                    player.setHealth(player.getHealth() - enemy.getAttack());
                    System.out.println(enemy.getName() + " attacks your for " + enemy.getAttack());
                } else {
                    System.out.println(enemy.getName() + "'s attack missed");
                }







            }

            if (enemy.getHealth() < 0) {
                enemy.setHealth(0);
            }

        }
        if (enemy.getHealth() <= 0) {
            player.setXp(player.getXp() + enemy.getXp());
            System.out.println("You defeated the " + enemy.getName());
            System.out.println("You have gained " + enemy.getXp() + " xp");
        } else {
            System.out.println("You have been defeated..");
        }



    }


}
