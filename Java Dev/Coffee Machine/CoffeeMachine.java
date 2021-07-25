package machine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class CoffeeMachine {
    static int water = 400,milk = 540, beans = 120, cups = 9,money = 550;
    static Scanner sc = new Scanner(System.in);
    static  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    static void buy_coffee() throws IOException {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = r.readLine();
        switch (choice){
            case "1":
                if(water<250){
                    System.out.println("Sorry, not enough water!");
                }
                else if(beans<16){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if(cups<1){
                    System.out.println("Sorry, not enough disposable cups!");
                }
                else{
                    water -= 250;
                    beans -= 16;
                    money += 4;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if(water<350){
                    System.out.println("Sorry, not enough water!");
                }
                else if(milk<75){
                    System.out.println("Sorry, not enough milk!");
                }
                else if(beans<20){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if(cups<1){
                    System.out.println("Sorry, not enough disposable cups!");
                }
                else{
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    money += 7;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if(water<200){
                    System.out.println("Sorry, not enough water!");
                }
                else if(milk<100){
                    System.out.println("Sorry, not enough milk!");
                }
                else if(beans<12){
                    System.out.println("Sorry, not enough coffee beans!");
                }
                else if(cups<1){
                    System.out.println("Sorry, not enough disposable cups!");
                }
                else{
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    money += 6;
                    cups -= 1;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
        }
    }
    static  void fill_resources(){
        int water_fill,milk_fill,bean_fill,cup_fill;
        System.out.println("Write how many ml of water you want to add:");
        water_fill = sc.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk_fill = sc.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        bean_fill = sc.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cup_fill = sc.nextInt();
        water += water_fill;
        milk += milk_fill;
        beans += bean_fill;
        cups += cup_fill;
    }
    static  void take_money(){
        System.out.println("I gave you $"+money);
        money = 0;
    }
    static void remaining_resources(){
        System.out.println("The coffee machine has:");
        System.out.println(water+" ml of water \n"+milk+" ml of milk \n"+beans+" g of coffee beans \n"+cups+
                " disposable cups \n$"+money+" of money");
    }
    static boolean machine_input(String opt) throws IOException {
        boolean cont=true;
        switch (opt){
            case "buy":
                buy_coffee();
                cont = true;
                break;
            case "fill":
                fill_resources();
                cont = true;
                break;
            case "take":
                take_money();
                cont = true;
                break;
            case "remaining":
                remaining_resources();
                cont = true;
                break;
            case "exit":
                cont = false;
                break;
        }
        return cont;
    }
    public static void main(String[] args) throws IOException {
        boolean cont = true;
        while (cont){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String optn = r.readLine();
            cont = machine_input(optn);
        }
    }
}
