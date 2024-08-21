import java.util.Scanner;
import java.util.Random;

public class passwordSystem {
    private static final String USER_PASSWORD = "koushikbuddha9";
    private static final String SECURITY_QUESTION = "What is your pet's name?";
    private static final String SECURITY_ANSWER = "sheero";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if (!password.equals(USER_PASSWORD)) {
            System.out.println("Authentication failed. Incorrect password.");
            return;
        }
        System.out.println("Password verified.");

        System.out.println("Security Question: " + SECURITY_QUESTION);
        System.out.print("Answer: ");
        String answer = scanner.nextLine();
        if (!answer.equalsIgnoreCase(SECURITY_ANSWER)) {
            System.out.println("Authentication failed. Incorrect answer.");
            return;
        }
        System.out.println("Security question verified.");

        String otp = generateOTP();
        System.out.println("OTP has been sent to your registered device: " + otp);
        System.out.print("Enter the OTP: ");
        String userOtp = scanner.nextLine();
        if (!userOtp.equals(otp)) {
            System.out.println("Authentication failed. Incorrect OTP.");
            return;
        }
        System.out.println("OTP verified.");
        System.out.println("Authentication successful! Access granted.");
    }

    private static String generateOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generates a 4-digit number
        return String.valueOf(otp);
    }
}