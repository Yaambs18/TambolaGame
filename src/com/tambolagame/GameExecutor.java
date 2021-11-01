package com.tambolagame;

public class GameExecutor {

    public static void main(String[] args) {
        TambolaBoard boardObj = new TambolaBoard();
        Thread tambolaBoard = new Thread(boardObj);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Thread playerThread1 = new Thread(player1);
        Thread playerThread2 = new Thread(player2);

        boardObj.displayBoard();
        System.out.println("-------------------Player1 ticket -------------------");
        player1.displayTicket();
        System.out.println("-------------------Player2 ticket -------------------");
        player2.displayTicket();

        Dealer dealer = new Dealer();
        Thread dealerThread = new Thread(dealer);

        dealerThread.start();
        tambolaBoard.start();
        playerThread1.start();
        playerThread2.start();
    }
}
