package com.tambolagame;

import java.util.HashMap;
import java.util.Iterator;

public class Player implements Runnable {

    HashMap<Integer, Boolean> ticket = new HashMap<>();
    static boolean housie = false;
    private Checker checker = new Checker();
    private  final String name;
    Player(String name) {
        int randomNumber;
        this.name=name;
        int min = 1, max = 90;
        while (ticket.size() != 15) {
            randomNumber = (int) (Math.random() * (max - min + 1) + min);
            ticket.put(randomNumber, false);
        }
    }
    void ticketMarker() {
        int markedValues = 0;
        while(markedValues!=15){
            int generatedNumber = Dealer.randomNumber;
            if(ticket.containsKey(generatedNumber)&&generatedNumber!=0) {
                ticket.replace(generatedNumber, true);
                markedValues+=1;
                System.out.println(name+" got a match "+generatedNumber);
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        checker.checker(ticket, name, TambolaBoard.board);
        housie=true;
    }

    void displayTicket() {
        Iterator<Integer> itemKey = ticket.keySet().iterator();
        int counter = 0;
        while (itemKey.hasNext()) {
            if (counter % 5 == 0) {
                System.out.println();
            }
            int key = itemKey.next();
            System.out.print(key + ":" + ticket.get(key) + "    ");
            counter++;
        }
        System.out.println("\n");
    }

    public void run() {
        ticketMarker();
    }

}