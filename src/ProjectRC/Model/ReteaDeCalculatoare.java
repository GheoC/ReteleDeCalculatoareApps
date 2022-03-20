package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReteaDeCalculatoare {
    Computer computer;
    Integer numberOfComputers;
    Token token;


    public ReteaDeCalculatoare() {
    }

    public void init() {
        Random random = new Random();
        int numberOfPC = 0;
        while (numberOfPC <10) {
            numberOfPC = random.nextInt(40);
        }

        List<Computer> computers = new ArrayList<>();
        for (int i = 0; i < numberOfPC; i++) {
            String ip;
            ip = String.valueOf(random.nextInt(255)) + "." + String.valueOf(random.nextInt(255)) +
                    "." + String.valueOf(random.nextInt(255)) + "." + String.valueOf(random.nextInt(255));

            Computer computer = new Computer(ip, "calculator " + (i + 1));
            computers.add(computer);
        }

        for (int i = 0; i < computers.size(); i++) {
            int nextPCNumber = (i + 1) % computers.size();
            computers.get(i).setNextPC(computers.get(nextPCNumber));

        }

        this.numberOfComputers = numberOfPC;
        this.computer = computers.get(0);
        Token token = new Token();
        token.setPosition(computers.get(0).getIpAddress());
        this.token = token;
    }


    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Integer getNumberOfComputers() {
        return numberOfComputers;
    }

    public void setNumberOfComputers(Integer numberOfComputers) {
        this.numberOfComputers = numberOfComputers;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }


    public List<Computer> getComputers()
    {
        List<Computer> computers = new ArrayList<>();
        Computer iterator = this.computer;
        for (int i = 0; i < numberOfComputers; i++)
        {
            computers.add(iterator);
            iterator = iterator.getNextPC();
        }

        return computers;
    }

    public Computer findComputer(String ipAddress)
    {
        Computer iterator = this.computer;
        for (int i = 0; i < numberOfComputers; i++)
        {
            if (iterator.getIpAddress().equals(ipAddress))
            {
                return iterator;
            }
            iterator = iterator.getNextPC();
        }
        return null;
    }
}
