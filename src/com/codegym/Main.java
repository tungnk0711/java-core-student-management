package com.codegym;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        StudentManagement studentManagement = new StudentManagement();
        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Student student = inputStudent();
                    int result = studentManagement.addStudent(student);
                    if (result == -2) {
                        System.out.println("Sv da ton tai");
                    } else if (result == -1) {
                        System.out.println("Vuot qua so luong");
                    } else {
                        System.out.println("Them moi thanh cong");
                    }

                    break;
                }
                case 2: {
                    Student student = inputStudent();
                    boolean result = studentManagement.editStudent(student);
                    if (result) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Khong tim thay sv");
                    }
                    break;
                }
                case 3:
                    System.out.println("Nhap Id:");
                    int id = input.nextInt();
                    boolean result = studentManagement.removeStudent(id);
                    if (result == false) {
                        System.out.println("Khong tim thay sinh vien");
                    } else {
                        System.out.println("Da xoa thanh cong");
                    }

                    break;
                case 4:
                    studentManagement.sortStudent();
                    break;
                case 5:
                    Student[] listStudent = studentManagement.listStudent();
                    for (int i = 0; i < listStudent.length; i++) {
                        if (listStudent[i] != null) {
                            System.out.println("\nID:" + listStudent[i].getId() + "\nName:" + listStudent[i].getName() + "\nAge:" + listStudent[i].getAge() + "\nAddress:" + listStudent[i].getAddress() + "\nGPA:" + listStudent[i].getGpa());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Cancel");
                    break;
            }
        } while (choice != 0);

    }

    private static void menu() {
        System.out.println("\n-Quan ly sinh vien-");
        System.out.println("1. Them moi");
        System.out.println("2. Sua");
        System.out.println("3. Xoa");
        System.out.println("4. Sap xep");
        System.out.println("5. Hien thi");
        System.out.println("0. Thoat");
        System.out.println("Nhap vao chon lua: ");
    }

    private static Student inputStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap ID:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Nhap Name:");
        String name = input.nextLine();
        System.out.println("Nhap Age:");
        int age = input.nextInt();
        input.nextLine();
        System.out.println("Nhap Address:");
        String address = input.nextLine();
        System.out.println("Nhap GPA:");
        float gpa = input.nextFloat();

        Student student = new Student(id, name, age, address, gpa);
        return student;
    }
}
