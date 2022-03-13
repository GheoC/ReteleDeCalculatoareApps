package Service.ParityCheck;


public class ParityCheckerService {

    private String encodedMessage;

    public String getEncodedMessage() {
        return encodedMessage;
    }

    public void setEncodedMessage(String encodedMessage) {
        this.encodedMessage = encodedMessage;
    }

    public void encodeUsingParityCheck(String message) {
        MessageCheckerService.checkMessage(message);
        extractHorizontalSum(message);
        extractVerticalSum(message);
        System.out.println(encodedMessage);
    }

    public void extractHorizontalSum(String message) {
        String generatedMessage = "";
        Integer sevenDigitSum = 0;

        for (int i = 0; i < message.length(); i++) {
            generatedMessage = generatedMessage + message.charAt(i);
            sevenDigitSum += Integer.parseInt(String.valueOf(message.charAt(i)));
            if ((i + 1) % 7 == 0) {
                generatedMessage = generatedMessage.concat(String.valueOf(sevenDigitSum % 2));
                generatedMessage = generatedMessage+" ";
                sevenDigitSum = 0;
            }
        }
        setEncodedMessage(generatedMessage);
    }

    public void extractVerticalSum(String message) {
        Integer totalRowSum = 0;
        Integer columnSum = 0;
        Integer numberOfRows = message.length() / 7;

        String columnGeneratedMessage = "";

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < numberOfRows; j++)
            {
                columnSum += Integer.parseInt(String.valueOf(message.charAt(j * 7 + i)));
            }
            columnGeneratedMessage = columnGeneratedMessage.concat(String.valueOf(columnSum % 2));
            totalRowSum = totalRowSum + columnSum % 2;
            columnSum = 0;
        }
        columnGeneratedMessage = columnGeneratedMessage.concat(String.valueOf(totalRowSum % 2));
        setEncodedMessage(getEncodedMessage().concat(columnGeneratedMessage));
    }
}
