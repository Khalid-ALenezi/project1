package main;

import java.util.*;
import java.io.*;

public class PharmacySystem {
    // استخدام مصفوفة عادية أو ArrayList كما هو مطلوب
    private static ArrayList<Medicine> inventory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // التحقق من سجل الدخول
        if (login()) {
            // إضافة بيانات يدوية بسيطة لضمان وجود شيء عند التشغيل
            inventory.add(new Medicine("P01", "Panadol", 15.0, MedicineCategory.PAINKILLER));
            inventory.add(new Medicine("A01", "Amoxicillin", 50.0, MedicineCategory.ANTIBIOTIC));
            
            showMenu();
        } else {
            System.out.println("Login Failed!");
        }
    }

    public static boolean login() {
        System.out.print("Username: ");
        String u = scanner.next();
        System.out.print("Password: ");
        String p = scanner.next();
        return u.equals("admin") && p.equals("1234");
    }

    public static void showMenu() {
        int choice = 0;
        while (choice != 4) {
            System.out.println("\n--- Pharmacy System ---");
            System.out.println("1. Show Category");
            System.out.println("2. Add Medicine");
            System.out.println("3. Show All");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();

            if (choice == 1) {
                showByCategory();
            } else if (choice == 2) {
                addMedicine();
            } else if (choice == 3) {
                displayAll();
            }
        }
    }

    public static void showByCategory() {
        System.out.println("1. PAINKILLER | 2. ANTIBIOTIC");
        int c = scanner.nextInt();
        
        // استخدام Loop بسيط جداً (For-each) لفحص العناصر
        for (int i = 0; i < inventory.size(); i++) {
            Medicine m = inventory.get(i);
            if (c == 1 && m.getCategory() == MedicineCategory.PAINKILLER) {
                System.out.println(m.getName() + " - Price: " + m.getPrice() + " SAR");
            } else if (c == 2 && m.getCategory() == MedicineCategory.ANTIBIOTIC) {
                System.out.println(m.getName() + " - Price: " + m.getPrice() + " SAR");
            }
        }
    }

    public static void addMedicine() {
        System.out.print("Name: ");
        String n = scanner.next();
        System.out.print("Price: ");
        double p = scanner.nextDouble();
        
        // إضافة الكائن للمصفوفة
        Medicine newMed = new Medicine("ID", n, p, MedicineCategory.VITAMIN);
        inventory.add(newMed);
        System.out.println("Added!");
    }

    public static void displayAll() {
        // طباعة العناصر باستخدام Loop عادي
        for (Medicine m : inventory) {
            System.out.println(m.toString());
        }
    }
}