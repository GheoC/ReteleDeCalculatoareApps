package Service.TokenRingService;

import Model.Computer;
import Model.ReteaDeCalculatoare;
import Model.Token;

public class TokenRingService {

    public void deliverMessage(ReteaDeCalculatoare reteaDeCalculatoare, Computer sender, Computer receiver) {
        System.out.println("=============================================================================");
        System.out.println("Sending message from " + sender.getIpAddress() + " to " + receiver.getIpAddress());
        System.out.println();
        Token token = reteaDeCalculatoare.getToken();
        moveToken(reteaDeCalculatoare, sender);
        System.out.println("Receiving message from sender...");
        String message = reteaDeCalculatoare.findComputer(token.getPosition()).getBuffer();

        token.setMessage(message);
        moveToken(reteaDeCalculatoare, receiver);
        System.out.println("Delivering message to receiver...");
        Computer destination = reteaDeCalculatoare.findComputer(token.getPosition());
        destination.setBuffer(destination.getBuffer().concat("; mesaj primit de la: ").concat(token.getMessage()));
        System.out.println(destination.getBuffer());
    }

    private void moveToken(ReteaDeCalculatoare reteaDeCalculatoare, Computer computer) {
        String positionOfToker = reteaDeCalculatoare.getToken().getPosition();
        Computer tokenComputer = reteaDeCalculatoare.findComputer(positionOfToker);

        System.out.println("Token is at: " + tokenComputer.getIpAddress() + "; Moving towards: " + computer.getIpAddress());

        while (!tokenComputer.getIpAddress().equals(computer.getIpAddress())) {
            tokenComputer = tokenComputer.getNextPC();
            System.out.println("Token is at: " + tokenComputer.getIpAddress());
        }

        reteaDeCalculatoare.getToken().setPosition(tokenComputer.getIpAddress());
        System.out.println("***** Token arrived at destination *****");
    }
}
