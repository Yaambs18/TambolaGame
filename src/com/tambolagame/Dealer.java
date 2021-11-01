package com.tambolagame;

import java.util.HashMap;
import java.util.Map;

class Dealer implements Runnable{
    static int randomNumber;
    Map<Integer,Boolean> tambolaBoard = TambolaBoard.board;

    void randomNumberGenerator(){
        System.out.println("Let's begin the game..................");
        while(!Player.housie){
                int min = 1, max = 90;
                randomNumber = (int) (Math.random() * (max - min + 1) + min);
                if (!tambolaBoard.get(randomNumber)) {
                    System.out.println("Generated number: "+randomNumber);
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
        if(Player.housie){
            randomNumber=0;
            System.exit(0);
        }
    }
    public void run(){
        randomNumberGenerator();
    }
}
