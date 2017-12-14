
package ics1202;

import java.util.Scanner;
/**
 *
 * @author STACY
 */
public class myAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       DBConnector d = new DBConnector();
        System.out.println("Reply with ");
        System.out.println("A:To add new record ");
        System.out.println("D:To delete a record ");
        System.out.println("U:To edit a record ");
        
        String reply;
        Scanner scanner = new Scanner(System.in);
        reply = scanner.nextLine();
        switch(reply){
            case "A":
                int student_no;
                String first_name,last_name,gender,programme;
                System.out.println("Your student number: ");
                student_no =scanner.nextInt();
                scanner.nextLine();
                System.out.println("Your first name: ");
                first_name = scanner.nextLine();
                System.out.println("Your last name: ");
                last_name=scanner.nextLine();
                System.out.println("Your gender: ");
                gender = scanner.nextLine();
                System.out.println("Your programme: ");
                programme =scanner.nextLine();
                
                CrudeOperations crudeoperations = new CrudeOperations();
                
                crudeoperations.setStudent_no(student_no);
                crudeoperations.setFirst_name(first_name);
                crudeoperations.setLast_name(last_name);
                crudeoperations.setGender(gender);
                crudeoperations.setProgramme(programme);
                crudeoperations.save();
                
                break;
                
            case "D":
                System.out.println("Cannot delete.");
                break;
                
            case "U":
                System.out.println("Cannot update.");
                break;
                
                
        }
        
    }
    
}
