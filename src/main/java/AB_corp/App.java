package AB_corp;

import java.util.Scanner;

public class App {

    static int x = 5;
    static int y = 5;
    static final int SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char move;

        System.out.println("=== SIMPLE SNAKE GAME ===");
        System.out.println("Controls: W = Up | S = Down | A = Left | D = Right");
        System.out.println("Press Q to Quit");

        while (true) {
            drawBoard();
            System.out.print("Move: ");
            move = sc.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                System.out.println("Game Over!");
                break;
            }

            moveSnake(move);

            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Snake hit the wall!");
                System.out.println("Game Over!");
                break;
            }
        }
        sc.close();
    }

    static void moveSnake(char move) {
        switch (move) {
            case 'W': x--; break;
            case 'S': x++; break;
            case 'A': y--; break;
            case 'D': y++; break;
            default: System.out.println("Invalid move!");
        }
    }

    static void drawBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == x && j == y) {
                    System.out.print("S ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
