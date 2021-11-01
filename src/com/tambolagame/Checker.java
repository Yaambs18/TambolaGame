package com.tambolagame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Checker {

    void checker (Map<Integer, Boolean> playersTicket, String player, Map<Integer,Boolean> board){
        Iterator<Integer> ticketKeys = playersTicket.keySet().iterator();

        int count = 0;
        while (ticketKeys.hasNext()) {
            int key = ticketKeys.next();
            System.out.println(key);
            if (board.get(key).equals(false)) {
                count+=1;
            }
        }
        if(count==0){
            System.out.println("Congratulations....."+player+" Won!!!!");
        }
        else{
            System.out.println("Invalid housie");
        }
    }
}

