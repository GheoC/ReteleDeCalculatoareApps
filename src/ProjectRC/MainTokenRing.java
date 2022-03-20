import Model.Computer;
import Model.ReteaDeCalculatoare;
import Service.TokenRingService.TokenRingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainTokenRing {
    public static void main(String[] args) {


        ReteaDeCalculatoare reteaDeCalculatoare = new ReteaDeCalculatoare();

        reteaDeCalculatoare.init();

        int numberOfComputers = reteaDeCalculatoare.getNumberOfComputers();
        Computer interator = reteaDeCalculatoare.getComputer();
        for (int i = 0; i < numberOfComputers; i++) {
            System.out.println(interator);
            interator = interator.getNextPC();
        }

        List<Computer> computers = reteaDeCalculatoare.getComputers();
        Random random = new Random();

        TokenRingService tokenRingService = new TokenRingService();

        int counter = 0;
        int receiverNumber;
        int senderNumber;
        while (counter < 10) {
            do {
                senderNumber = random.nextInt(numberOfComputers - 1);
                receiverNumber = random.nextInt(numberOfComputers - 1);
            } while (senderNumber == receiverNumber);

            System.out.println("\n=================================================================");
            System.out.println("From computer "+(senderNumber + 1) + " -> computer " + (receiverNumber + 1));

            tokenRingService.deliverMessage(reteaDeCalculatoare, computers.get(senderNumber), computers.get(receiverNumber));

            counter++;
        }
    }
}
