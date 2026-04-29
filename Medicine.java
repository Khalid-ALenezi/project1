package main;

	import java.io.Serializable;

	public class Medicine implements Serializable {
		//هذه هي صفات الدواء (، الاسم، السعر، والفئة)
	    private String name;
	    private double price;
	    private MedicineCategory category;

	    // Constructor [cite: 7]
	    public Medicine(String name, double price, MedicineCategory category) {
	         // Using 'this' 
	        this.name = name;
	        this.price = price;
	        this.category = category;
	    }

	    // Getters and Setters 
	    //هذه الدوال وظيفتها فقط إرجاع القيمة (قراءة فقط).
	    public String getName() { return name; }
	    public double getPrice() { return price; }
	    //هذه الدالة الوحيدة التي تسمح بـ "التعديل". وضعناها للسعر فقط، مما يعني أنك بمجرد إنشاء الدواء، لا يمكنك تغيير الاسم، لكن يمكنك تحديث السعر.
	    public void setPrice(double price) { this.price = price; }

	    @Override
	    //دالة toString هي اللي تحول الـ Object من مجرد مساحة في الذاكرة إلى نص مفهوم نقدر نقراه ونعرف تفاصيل الدواء (اسمه، سعره، ) بمجرد ما نسوي له print."
	    public String toString() {
	        return " | Name: " + name + " | Price: " + price + " | Category: " + category;
	    }
	}



package main;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PharmacyManager manager = new PharmacyManager(100);
        
        // 1. نظام تسجيل الدخول (مطلب إلزامي)
        System.out.println("=== Pharmacy System Login ===");
        System.out.print("Username: ");
        String user = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();

        if (!(user.equals("admin") && pass.equals("123"))) {
            System.out.println("Wrong credentials. Exiting...");
            return;
        }

        // 2. القائمة الرئيسية (Menu-based)
        int choice;
        do {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add General Medicine");
            System.out.println("2. Add Prescription Medicine");
            System.out.println("3. Search Medicine");
            System.out.println("4. Update Price");
            System.out.println("5. Save & Exit");
            System.out.print("Select an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: "); String n = sc.next();
                    System.out.print("Price: "); double p = sc.nextDouble();
                    manager.addMedicine(new Medicine(n, p, MedicineCategory.GENERAL));
                    break;
                case 2:
                    System.out.print("Name: "); String pn = sc.next();
                    System.out.print("Price: "); double pp = sc.nextDouble();
                    System.out.print("Doctor Name: "); String d = sc.next();
                    manager.addMedicine(new PrescriptionMedicine(pn, pp, MedicineCategory.ANTIBIOTIC, d));
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    manager.searchByName(sc.next());
                    break;
                case 4:
                    System.out.print("Enter name: "); String un = sc.next();
                    System.out.print("New Price: "); double up = sc.nextDouble();
                    manager.updatePrice(un, up);
                    break;
                case 5:
                    manager.saveData();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
    }
}

