package Service.ParityCheck;

public class MessageCheckerService {

    public static void checkMessage(String message) {
        checkMessageLength(message);
        checkMessageContent(message);
    }

    public static void checkMessageLength(String message) {
        if (message.length() % 7 != 0) {
            throw new RuntimeException("Wrong message length");
        }
    }

    public static void checkMessageContent(String message) {
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != '0' && message.charAt(i) != '1') {
                throw new NumberFormatException("Message must contain only 0 or 1");
            }

        }
    }
}
