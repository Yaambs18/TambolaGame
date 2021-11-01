package com.tambolagame;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TambolaBoard implements Runnable{

    static Map<Integer, Boolean> board = new HashMap<>();

    TambolaBoard(){
        int number;
        for(number=1;number<91;number++) {
            board.put(number, false);
        }
    }

    void boardMarker() {
        boolean numberGenerated = true;
        while(numberGenerated){
            int generatedNumber = Dealer.randomNumber;
            if(generatedNumber>0){
                board.replace(generatedNumber, true);
            }
            else{
                numberGenerated=false;
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    protected void displayBoard(){
        System.out.println("Tambola board................");
        Iterator<Integer> itemsKey = board.keySet().iterator();
        int counter = 0;
        while(itemsKey.hasNext())
        {
            if(counter%9==0){
                System.out.println();
            }
            int key=itemsKey.next();
            System.out.print(key+":"+board.get(key)+"    ");
            counter++;
        }
        System.out.println("\n");
    }
    public void run(){
        boardMarker();
    }
}
