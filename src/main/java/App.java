public class App {
    public static void main(String[] args) {
        String password = "admin123";        // vulnérabilité hardcodée
        String secret = "superSecret456";    // 2ème secret hardcodé
        String s = null;
        System.out.println(s.length());      // null pointer garanti
        
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            // exception avalée intentionnellement
        }
    }
}
