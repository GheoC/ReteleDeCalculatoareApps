package Service.CyclicRedundancyCode;

import Service.ParityCheck.MessageCheckerService;

public class CyclicRedundancyCodeService {

    public String encodeUsingCRC(String message, String generatedCode) {

        MessageCheckerService.checkMessageContent(message);
        MessageCheckerService.checkMessageContent(generatedCode);
        MessageCheckerService.checkMessageLengthComparedToGeneratedCode(message, generatedCode);

        String tempMessage = "";
        String addonMsg = "";
        System.out.println("Initial msg: " + message);
        for (int i = 0; i < (generatedCode.length()-1); i++)
        {
            message = message.concat("0");

        }

        System.out.println("MSG + number of 0s at the end: " + message);
        for (int i = 0; i < generatedCode.length(); i++) {
            tempMessage = tempMessage.concat(String.valueOf(message.charAt(i)));
        }
        System.out.println("The divider is: " + tempMessage);
        message = message.replaceFirst(tempMessage, "");
        System.out.println("Remaining MSG: " + message);
        System.out.println("Calculating the remainder of the division: "+tempMessage+" by " +generatedCode);
        tempMessage = calculateXOR(tempMessage, generatedCode);
        System.out.println("the remainder is: " + tempMessage);

        System.out.println("\nHERE WE GOOOOO:  \n");
        do {


            Integer numberOfCharsToAdd = generatedCode.length() - tempMessage.length();
            if (message.length()<numberOfCharsToAdd)
            {
                tempMessage = tempMessage.concat(message);
                System.out.println("FINAL remainder is: " + tempMessage);
                return tempMessage;
            }
            for (int i = 0; i < numberOfCharsToAdd; i++) {
                addonMsg = addonMsg.concat(String.valueOf(message.charAt(i)));
            }
            tempMessage = tempMessage.concat(addonMsg);
            System.out.println("The new divider is " + tempMessage);
            message = message.replaceFirst(addonMsg, "");
            addonMsg="";
            System.out.println("Remaining msg: " + message);
            System.out.println("Calculating the remainder of the division: "+tempMessage+" by " +generatedCode);
            tempMessage  = calculateXOR(tempMessage, generatedCode);

            System.out.println("the remainder is: " + tempMessage);
            System.out.println("===============================");
        } while (!message.isEmpty());

        System.out.println("FINAL remainder is: " + tempMessage);

        return tempMessage;
    }

    public String calculateXOR(String message1, String message2) {
        String rezultString = "";

        for (int i = 0; i < message1.length(); i++) {
            if (message1.charAt(i) != message2.charAt(i)) {
                rezultString = rezultString.concat("1");
            } else {
                rezultString = rezultString.concat("0");
            }
        }
        return removeZeros(rezultString);
    }

    public String removeZeros(String message) {
        String tempMsg = message;

        while (tempMsg.charAt(0) == '0') {
            tempMsg = tempMsg.replaceFirst("0", "");
            if (tempMsg.equals("")) {
                break;
            }
        }

        return tempMsg;
    }
}
