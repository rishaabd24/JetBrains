package cinema;
import java.text.DecimalFormat;
import java.util.*;
public class Cinema {
    public static Scanner sc = new Scanner(System.in);
    public static int rows=0, seats=0,totalIncome=0,currentIncome=0,total_seats=0,tktcount=0;
    public static double tkt_perc = 0.00;
    public static char[][] room;
    static void createCinema() {
        while (true) {
            System.out.println("Enter the number of rows:");
            rows = sc.nextInt();
            System.out.println("Enter the number of seats in each row:");
            seats = sc.nextInt();
            if (rows < 1 || seats < 1) {
                System.out.println("There must be at least one row/seats!");
            } else {
                break;
            }
        }
        total_seats = rows * seats;
        room = new char[rows][seats];
        for (char[] arr : room) {
            Arrays.fill(arr, 'S');
        }
        if (total_seats <= 60) {
            totalIncome = total_seats * 10;
        } else {
            if (rows % 2 == 0) {
                int seat_div = (rows / 2) * seats;
                totalIncome = (seat_div * 10) + (seat_div * 8);
            } else {
                int front_seat = (rows / 2) * seats;
                int back_seat = (rows - (rows / 2)) * seats;
                totalIncome = (front_seat * 10) + (back_seat * 8);
            }
        }
    }
    static void printCinema(char[][] arr){
        int rowCnt = 1;
        int seatCnt = 1;
        System.out.println("Cinema:");
        System.out.print(" ");
        while (seatCnt <= arr[0].length) {
            System.out.print(" " + seatCnt);
            seatCnt++;
        }
        System.out.println();
        for (char[] arr1 : arr) {
            System.out.print(rowCnt);
            for (char c : arr1) {
                System.out.print(" " + c);
            }
            System.out.println();
            rowCnt++;
        }
    }
    static void buyTicket(){
        int row_no, seat_no;
        while (true){
            System.out.println("Enter a row number:");
            row_no = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            seat_no = sc.nextInt();
            if (row_no > room[0].length || row_no < 1 || seat_no > room[row_no - 1].length || seat_no < 1) {
                System.out.println("Wrong input!");
            }
            else {
                if(room[row_no-1][seat_no-1]=='B'){
                    System.out.println("That ticket has already been purchased!");
                }
                else{
                    room[row_no-1][seat_no-1] = 'B';
                    tktcount++;
                    break;
                }
            }
        }
        if(total_seats<=60){
            System.out.println("Ticket price: $10");
            currentIncome += 10;
        }
        else{
            if(row_no<=(rows/2)){
                System.out.println("Ticket price: $10");
                currentIncome += 10;
            }
            else{
                System.out.println("Ticket price: $8");
                currentIncome += 8;
            }
        }
    }
    static void statistics(){
        DecimalFormat df = new DecimalFormat("0.00");
        tkt_perc = (double) tktcount/total_seats *100;
        String ticketPerc = df.format(tkt_perc);
        System.out.println("Number of purchased tickets: "+tktcount);
        System.out.println("Percentage: "+ticketPerc+"%");
        System.out.println("Current Income: $"+currentIncome);
        System.out.println("Total Income: $"+totalIncome);
    }
    public static void main(String[] args) {
        createCinema();
        boolean cont = true;
        while (cont){
            System.out.println("1. Show the seats\n"+"2. Buy a ticket\n"+"3. Statistics\n"+"0. Exit");
            int optn = sc.nextInt();
            switch (optn){
                case 1:
                    printCinema(room);
                    break;
                case 2:
                    buyTicket();
                    break;
                case 0:
                    cont = false;
                    break;
                case 3:
                    statistics();
                    break;
            }
        }
    }
}
