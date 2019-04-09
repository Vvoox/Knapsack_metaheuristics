package com.example.java;
import java.util.*;

public class Main {
    public static int obj_number, max_weight;

    public static void main(String[] args) {
        System.out.println("Hello , This program is for calculating the possibilities of holding n object in back_bag we called it 'Knapsack'");
        System.out.print("Enter the number of objects you've : ");
        Scanner ob = new Scanner(System.in);
        obj_number = ob.nextInt();
        System.out.print("Enter the max of weight your knapsack have : ");
        Scanner wgh = new Scanner(System.in);
        max_weight = wgh.nextInt();
        int[] knapsack[]= new int[obj_number][2];
        int cnt = 1;
        for (int i = 0; i < obj_number; i++) {
            System.out.print("Object "+cnt+" , Outcome : ");
            Scanner obj_value = new Scanner(System.in);
            knapsack[i][0] = obj_value.nextInt();
            System.out.print("Object "+cnt+" ,Weight : ");
            Scanner obj_weight = new Scanner(System.in);
            knapsack[i][1]= obj_weight.nextInt();
            cnt++;
        }
        System.out.print(" Your Table of Objects :    ");
        for(int i=0 ; i<obj_number;i++){

            System.out.print(" | ");

            for(int j=0 ; j<2 ; j++){

                System.out.print(knapsack[i][j]+" ");
            }
            System.out.print("| ");
        }
        Knapsack(obj_number, max_weight,knapsack);
    }

    public static void Knapsack(int obj_number, int max_weight, int[] knapsack[]) {

        for (int i = 0; i < obj_number; i++) {

            for (int j = 0; j < obj_number; j++) {

                if (knapsack[i][0] >= knapsack[j][0] && i != j) {

                        int[] l = knapsack[i];
                        knapsack[i]= knapsack[j];
                        knapsack[j] = l;
                }
                else {
                    break;
                }
            }
        }
        System.out.print("\n");
        System.out.print(" Sorted table by outcomes : ");

        for(int i=0 ; i<obj_number;i++){
            System.out.print(" | ");
            for(int j=0 ; j<2 ; j++){

                System.out.print(knapsack[i][j]+" ");
            }
            System.out.print("| ");
        }
        System.out.print("\n");
        int[] objects ;
        int somme=0;
        int t=1;
        for(int i=0 ; i<obj_number ; i++){

            if (knapsack[i][1] < max_weight) {
                int s=i;
                System.out.println("Best possiblity "+t+" :" );
                System.out.println(" You can hold the Objects "+s);

                for(int j=i+1 ; j<obj_number ; j++){

                    somme += knapsack[i][1];

                    if (somme <= max_weight && i!=j) {

                        somme += knapsack [j][1];

                        if(i!=j){

                            System.out.println(" and "+ j+ " in you knapsack ");
                            t++;
                        }

                    }
                }
            }

        }

        }

}
