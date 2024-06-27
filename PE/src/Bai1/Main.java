package Bai1;
import Bai2.Validation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Validation {
        Scanner keyboard = new Scanner(System.in);
        HocVien hocVien = new HocVien();
        boolean isLoop=true;
        int choice = 0;
        while(isLoop)
        {
            System.out.println("Menu");
            System.out.println("1. Nhap hoc sinh");
            System.out.println("2. In ra tat ca thong tin");
            System.out.println("Input over 1 and 2 to exit");
            choice = Integer.parseInt(keyboard.nextLine());
            isLoop = false;
            if(choice==1)
            {
                hocVien.inputStudent();
                isLoop = true;
            }
            if (choice == 2)
            {
                hocVien.displayAll();
                isLoop = true;
            }

        }
    }
}