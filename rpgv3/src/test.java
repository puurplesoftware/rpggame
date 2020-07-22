public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            int creationRoll = (int) (Math.random() * 10) + 1;
            System.out.println(creationRoll);
        }
    }
}
