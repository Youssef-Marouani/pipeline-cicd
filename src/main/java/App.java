public class App {
    public static void main(String[] args) {
        String password = "admin123"; // vulnérabilité hardcodée
        String s = null;
        System.out.println(s.length()); // bug null pointer
    }
}
