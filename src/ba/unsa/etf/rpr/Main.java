package ba.unsa.etf.rpr;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static  int Day9Method1(ArrayList<ArrayList<Integer>> matrix){

        int counter =0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int x =matrix.get(i).get(j);
                if(i==0 && j== 0) {
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j+1)) counter+=x+1;
                }
                else if ( i==0 && j==matrix.get(i).size()-1){
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j-1)) counter+=x+1;
                }
                else if ( i==matrix.size()-1 && j==0){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j+1)) counter+=x+1;
                }
                else if ( i==matrix.size()-1 && j==matrix.get(i).size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j-1)) counter+=x+1;
                }
                else if( i==0){
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j+1) && x < matrix.get(i).get(j-1)) counter+=x+1;
                }
                else if (i==matrix.size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j-1)  && x < matrix.get(i).get(j+1)) counter+=x+1;
                }
                else if (j==0){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j+1)) counter+=x+1;
                }
                else if (j==matrix.get(i).size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j-1)) counter+=x+1;
                }
                else {
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j-1) && x < matrix.get(i).get(j+1)) counter+=x+1;
                }
            }
        }
        return counter;
    }
    public static  int Day9Method2(ArrayList<ArrayList<Integer>> matrix ){


        ArrayList<Integer> ResultsFirstIndex = new ArrayList<>();
        ArrayList<Integer> ResultsSecondIndex= new ArrayList<>();

        int counter =0;
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                int x =matrix.get(i).get(j);
                if(i==0 && j== 0) {
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j+1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if ( i==0 && j==matrix.get(i).size()-1){
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j-1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if ( i==matrix.size()-1 && j==0){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j+1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if ( i==matrix.size()-1 && j==matrix.get(i).size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j-1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if( i==0){
                    if(x < matrix.get(i+1).get(j) && x < matrix.get(i).get(j+1) && x < matrix.get(i).get(j-1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if (i==matrix.size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i).get(j-1)  && x < matrix.get(i).get(j+1)){ ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if (j==0){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j+1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else if (j==matrix.get(i).size()-1){
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j-1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
                else {
                    if(x < matrix.get(i-1).get(j) && x < matrix.get(i+1).get(j)  && x < matrix.get(i).get(j-1) && x < matrix.get(i).get(j+1)) { ResultsFirstIndex.add(i);ResultsSecondIndex.add(j);}
                }
            }
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if(matrix.get(i).get(j)==9) matrix.get(i).set(j,-2);           }
        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        int x =0;
        for (int i = 0; i < ResultsFirstIndex.size(); i++) {
            results.add(CalculateBasin(matrix,ResultsFirstIndex.get(i),ResultsSecondIndex.get(i),x,matrix.get(ResultsFirstIndex.get(i)).get(ResultsSecondIndex.get(i))-1));
        }
        Collections.sort(results);

        return results.get(results.size()-1)* results.get(results.size()-2)*results.get(results.size()-3);
    }
    public static int CalculateBasin(ArrayList<ArrayList<Integer>> matrix, int position1, int position2, int counter, int number){
        int x = matrix.get(position1).get(position2);

        if(x<0) return counter;

        if ( x==9) return  counter;

        if ( position1 ==0 ){
            if (position2==0){
                if(matrix.get(position1+1).get(position2)>x) {
                    counter= CalculateBasin(matrix, position1 + 1, position2,counter,x);
                }
                if(matrix.get(position1).get(position2+1)>x){
                    counter= CalculateBasin(matrix,position1,position2+1,counter,x);
                }
            }
            else if (position2==matrix.get(position1).size()-1){
                if(matrix.get(position1).get(position2-1)>x){
                    counter= CalculateBasin(matrix,position1,position2-1,counter,x);

                }
                if(matrix.get(position1+1).get(position2)>x) {
                    counter= CalculateBasin(matrix,position1+1,position2,counter,x);
                }
            }
            else {
                if(matrix.get(position1+1).get(position2)>x) {
                    counter= CalculateBasin(matrix, position1 + 1, position2,counter,x);
                }
                if(matrix.get(position1).get(position2+1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 + 1,counter,x);

                }
                if(matrix.get(position1).get(position2-1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 - 1,counter,x);
                }
            }
        }
        else if( position2 == 0){
            if(position1==matrix.size()-1){
                if(matrix.get(position1-1).get(position2)>x) {
                    counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);
                }
                if(matrix.get(position1).get(position2+1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 + 1,counter,x);
                }
            }
            else {
                if(matrix.get(position1-1).get(position2)>x) {
                    counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);
                }
                if(matrix.get(position1+1).get(position2)> x) {
                    counter= CalculateBasin(matrix, position1 + 1, position2,counter,x);
                }
                if(matrix.get(position1).get(position2+1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 + 1,counter,x);
                }
            }
        }
        else if (position1 == matrix.size()-1){
            if(position2==matrix.get(position1).size()-1){
                if(matrix.get(position1).get(position2-1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 - 1,counter,x);
                }
                if(matrix.get(position1-1).get(position2)> x) {
                    counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);

                }
            }
            else{
                if(matrix.get(position1).get(position2-1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 - 1,counter,x);
                }
                if(matrix.get(position1-1).get(position2)> x) {
                    counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);
                }
                if(matrix.get(position1).get(position2+1)> x) {
                    counter= CalculateBasin(matrix, position1, position2 + 1,counter,x);
                }
            }
        }
        else if (position2 == matrix.get(position1).size()-1){
            if(matrix.get(position1).get(position2-1)> x) {
                counter= CalculateBasin(matrix, position1, position2 - 1,counter,x);
            }
            if(matrix.get(position1+1).get(position2)> x) {
                counter= CalculateBasin(matrix, position1 + 1, position2,counter,x);
            }
            if(matrix.get(position1-1).get(position2)> x) {
                counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);
            }
        }
        else {
            if(matrix.get(position1).get(position2-1)>x) {
                counter= CalculateBasin(matrix, position1, position2 - 1,counter,x);
            }
            if(matrix.get(position1+1).get(position2)> x) {
                counter= CalculateBasin(matrix, position1 + 1, position2,counter,x);
            }
            if(matrix.get(position1-1).get(position2)> x) {
                counter= CalculateBasin(matrix, position1 - 1, position2,counter,x);
            }
            if(matrix.get(position1).get(position2+1)> x) {
                counter= CalculateBasin(matrix, position1, position2 + 1,counter,x);
            }
        }
        if(x!=9) matrix.get(position1).set(position2,-2);
        return  1+counter;
    }

    public  static void day9Method2Scanner(){
        System.out.println("Input:");
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String currentLine = s.nextLine();
            if(currentLine.isBlank() || currentLine.isEmpty()) break;

            String[] numbersArray = currentLine.split("");
            ArrayList<Integer> helpy  = new ArrayList<>();
            for (int i = 0; i <numbersArray.length ; i++) {
                helpy.add(Integer.parseInt(numbersArray[i]));
            }
            matrix.add(helpy);

        }
        int result = Day9Method2(matrix); // Change to Day9Method1(matrix), if you want to test out Day9Method1(matrix);
        System.out.println("Result:" + result);
    }

    public static void main(String[] args) {
        day9Method2Scanner();
    }
}
