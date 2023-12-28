package Util;

import Operation.DeleteData;
import Operation.DisplayData;
import Operation.InsertData;
import Operation.UpdateData;

import java.util.Scanner;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean status = true;
        while (status){
            System.out.println("1.INSERT DATA ");
            System.out.println("2.UPDATE DATA ");
            System.out.println("3.DELETE DATA ");
            System.out.println("4.DISPLAY DATA ");
            System.out.println("5.EXIT ");
            System.out.println("ENTER YOUR CHOICE 😎😎");
            int ch = sc.nextInt();

            switch (ch){
                case 1:
                    InsertData data = new InsertData();
                    data.addStudentsData();
                    break;
                case 2:
                    UpdateData  data1 = new UpdateData();
                    data1.updateData();
                    break;
                case 3:
                    DeleteData data2 = new DeleteData();
                    data2.deleteData();
                    break;
                case 4:
                    DisplayData displayData = new DisplayData();
                    displayData.displayAllData();
                    break;
                case 5:
                    status=false;
                    System.out.println("VISIT AGAIN !!");
                    break;
                default:
                    System.out.println("INVALID CHOICE🚫🚫");


            }
        }

    }
}
