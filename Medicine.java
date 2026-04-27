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

