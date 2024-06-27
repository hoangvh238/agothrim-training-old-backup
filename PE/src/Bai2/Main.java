package Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Validation {
        Scanner keyboard = new Scanner(System.in);
        int choice = 0;
        while(true)
        {
            System.out.println("Menu");
            System.out.println("1.Cong 2 phan so");
            System.out.println("2.Tru 2 phan so");
            System.out.println("3.Nhan 2 phan so");
            System.out.println("4.Chia 2 phan so");
            System.out.println("5.So 2 phan so");
            System.out.println("Input over 1,2,3,4,5 to exit");
            choice = Integer.parseInt(keyboard.nextLine());
            if(choice < 1 || choice >5) break;
            System.out.println("Nhap tu so");
            int first = Integer.parseInt(keyboard.nextLine());
            System.out.println("Nhap mau so");
            int second = Integer.parseInt(keyboard.nextLine());
            PhanSo phanSo = new PhanSo(first,second);

            System.out.println("Nhap phan so thu 2 ");
            System.out.println("Nhap tu so");
            int first1 = Integer.parseInt(keyboard.nextLine());
            System.out.println("Nhap mau so");
            int second1 = Integer.parseInt(keyboard.nextLine());
            PhanSo phanSo1 = new PhanSo(first1,second1);

            if(choice==1)
            {
                System.out.println("Cong");
                System.out.println(phanSo.add(phanSo1).toString());

            }
            if (choice == 2)
            {
                System.out.println("Tru");
                System.out.println(phanSo.subtract(phanSo1).toString());


            }
            if(choice ==3)
            {
                System.out.println("Nhan");
                System.out.println(phanSo.multiply(phanSo1).toString());
            }
            if (choice == 4)
            {
                System.out.println("Chia");
                System.out.println(phanSo.compare(phanSo1));
            }
            if (choice==5)
            {
                System.out.println("So sanh");
            }
        }
    }
}