 import java.util.*;

class Patient { // yeh class ek patient ko reprsent karti hai
    int id;      // isme patient ki details hoti hai jise id, name, age 
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) { // constructor ka use object ki value set karne ke liye hota hai
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() { // ye method patient ki details preint karta hai
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("-------------");
    }
}

public class HealthManagementSystem {  // ye main class hai jisse program start hota hai

    static ArrayList<Patient> patients = new ArrayList<>(); // array list dynamically multiple patients ko store karta hai
    static Scanner sc = new Scanner(System.in); // scanner user se input lene ke liye use hota hai

    public static void main(String[] args) {
        int choice;

        do { // loop ka use tab tak menu dikhane ke liye hota hai jab tak user exit na kare
            System.out.println("\n--- Health Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();

            switch (choice) { // switch case user ke options ko handle karta hai 
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    searchPatient();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    static void addPatient() {  // user se input leta hai or new patient object banata hai // fir us object ko arraylist me stor karta hai
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        Patient p = new Patient(id, name, age, disease);
        patients.add(p);

        System.out.println("Patient Added Successfully!");
    }

    static void viewPatients() { // loop ke through sabhi patient ki details dikhata hai
        if (patients.isEmpty()) {
            System.out.println("No patients found!");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {  // id ke basis par patient serch karta hai // milne par details show hoti hai nhi milne par message aata hai
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();

        for (Patient p : patients) {
            if (p.id == id) {
                p.display();
                return;
            }
        }

        System.out.println("Patient not found!");
    }
}