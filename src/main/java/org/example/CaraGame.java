package org.example;

import java.util.*;

public class CaraGame {
    public static String[][] board = new String [3][3];
    public static int[] humanSelect = new int[3];
    public static int[] computerSelect = new int[3];
    public static List<Integer> availableCells = new ArrayList<>();
    /*
   2 player X, 0 ==> Human vs Computer
   Win, Loose , Draw
   Win 8 case
   Lose: machine win
   Draw: Not win
     */
    public static void main(String[] args){
        availableCells.add(1);
        availableCells.add(2);
        availableCells.add(3);
        availableCells.add(4);
        availableCells.add(5);
        availableCells.add(6);
        availableCells.add(7);
        availableCells.add(8);
        availableCells.add(9);
        Scanner input = new Scanner(System.in);
        System.out.println("Select 1 -9 ");
        for(int i =0; i<3; i++)
        {
            int cell = input.nextInt();
            System.out.println("You selected " + cell);
            if(!availableCells.contains(cell)){
                System.out.println("Please select other cell");
                cell= input.nextInt();
            }
            humanSelect[i]=cell;
           // System.out.println(availableCells.indexOf(cell));
            availableCells.remove(availableCells.indexOf(cell));

            String human = "X";
            String machine = "0";
            selectCell(cell,human);
            // System.out.println("-------------");
            printTable();
            System.out.println("============");
            int machineSelect = availableCells.get(generateRandomNumber(0, availableCells.size()-1));
            System.out.println("Computer selected " + machineSelect);
//            if(computerSelect.contains(machineSelect) || humanSelect.contains(machineSelect))
////            {
////                machineSelect = generateRandomNumber();
////                System.out.println("Computer selected " + machineSelect);
////            }
//       board[1][1]="0";
            computerSelect[i]=machineSelect;
            availableCells.remove(availableCells.indexOf(machineSelect));
            selectCell(machineSelect,machine);
            printTable();

        }
//        humanSelect.stream().forEach(System.out::println);
//        computerSelect.stream().forEach(System.out::println);
        checkWinner();

        /*
        00 -> 1
        01 -> 2
        02 -> 3
        10 -> 4
        11 -> 5
        12 -> 6
        20 -> 7
        21 -> 8
        22 -> 9
         */
//        board[0][Integer.parseInt(cell)-1] = "x";
//        printTable();

//
//       board[0][0] = "X";
//       printTable();
//
//       board[2][1] = "0";
//       printTable();


    }
    public static void checkWinner(){
        List<int[]> win = new ArrayList<>();
        win.add(new int[]{1,2,3});
        win.add(new int[]{4,5,6});
        win.add(new int[]{7,8,9});
        win.add(new int[]{2,5,8});
        win.add(new int[]{3,6,9});
        win.add(new int[]{1,5,9});
        win.add(new int[]{3,5,7});
        win.add(new int[]{1,4,7});
        Arrays.stream(humanSelect).forEach(System.out::println);


        // Check if targetArray exists in listOfArrays
        boolean humanWin = doesArrayExist(win, humanSelect);
        boolean machineWin = doesArrayExist(win, computerSelect);

        if (humanWin) {
            System.out.println("You win");
        } else if (machineWin){
            System.out.println("You lose");
        }else {
            System.out.println("You Draw");
        }
    }
    public static boolean doesArrayExist(List<int[]> listOfArrays, int[] targetArray) {
        for (int[] arr : listOfArrays) {
            if (Arrays.equals(arr, targetArray)) {
                return true;
            }
        }
        return false;
    }
    public static void selectCell(int cell, String player){
        switch (cell){
            case 1:  board[0][0] = player; break;
            case 2:  board[0][1] = player; break;
            case 3:  board[0][2] = player; break;
            case 4:  board[1][0] = player; break;
            case 5:  board[1][1] = player; break;
            case 6:  board[1][2] = player; break;
            case 7:  board[2][0] = player; break;
            case 8:  board[2][1] = player; break;
            case 9:  board[2][2] = player; break;
        }
    }
    public static void printTable(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" " + (board[row][col] !=null ? board[row][col]: " ")+ " ");
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println("");
            if (row < 2) {
                System.out.println("--------------");
            }
        }


    }
    public static int generateRandomNumber(int a, int b) {
//        // Tạo một đối tượng Random
//        Random random = new Random();
//
//        // Tạo số ngẫu nhiên trong phạm vi từ min đến max
//        int randomNumber = random.nextInt(8)+1;
//
//        return randomNumber;
        if (a > b) {
            throw new IllegalArgumentException("Invalid range: a must be less than or equal to b");
        }
        Random rand = new Random();
        return rand.nextInt(b - a + 1) + a;
    }
}
