package collection_of_teacherstudentapplication;
import java.util.*;

public class TeacherStudentApplication
{
    public static void main(String []args)
    {
        try {
            System.out.println("Welcome to Teacher Student Application ");
            System.out.println("Enter your teacher Id or username to proceed further:");
            Scanner sc = new Scanner(System.in);
            String login = sc.nextLine();
            Map<Integer ,String> names = new HashMap<>();
            Set<Integer> check = new HashSet<>();
            if(login.equals("login")){
                int i=1;
                do{
                    System.out.println("Press 1, To Add student in the class:");
                    System.out.println("Press 2, To Update student details in the class:");
                    System.out.println("Press 3, To Delete student details from the class:");
                    System.out.println("Press 4, To Display all the students in the class:");
                    System.out.println("Press 5, To Search a particular student with roll number:");
                    System.out.println("Press 0, To Exit :");
                    i = sc.nextInt();
                    sc.nextLine();
                    switch(i)
                    {
                        case 1:
                            System.out.println("Enter student name:");
                            String na = sc.nextLine();
                            Integer r;
                            do {
                                System.out.println("Enter student prn:");
                                r = sc.nextInt();
                                sc.nextLine();
                            }while(check.contains(r));
                            names.put(r,na);
                            check.add(r);
                            break;

                        case 2:
                            System.out.println("Enter PRN to be updated :");
                            Integer j = sc.nextInt();
                            if(check.contains(j))
                            {
                                System.out.println("Enter 1, to update PRN \t OR \t enter 2, to update name\nEnter 0, To update None:");
                                Integer o = sc.nextInt();
                                sc.nextLine();
                                if(o==0){
                                    System.out.println("Update none.");
                                }
                                else if(o==1)
                                {
                                    String k = names.get(j);
                                    names.remove(j);
                                    check.remove(j);
                                    System.out.println("Enter new PRN :");
                                    Integer p = sc.nextInt();
                                    sc.nextLine();
                                    names.put(p,k);
                                    check.add(p);
                                }
                                else if(o==2)
                                {
                                    names.remove(j);
                                    check.remove(j);
                                    System.out.println("Enter new Name :");
                                    String sj = sc.nextLine();
                                    names.put(j,sj);
                                    check.add(j);
                                }
                                else{
                                    System.out.println("Invalid Option.");
                                }
                            }
                            else{
                                System.out.println("PRN doesnt exist.");
                            }
                            break;

                        case 3:
                            System.out.println("Enter student PRN to be deleted:");
                            Integer d = sc.nextInt();
                            sc.nextLine();
                            if(check.contains(d)){
                                System.out.println("Deleted PRN : " + d);
                                names.remove(d);
                                check.remove(d);
                            }
                            else{
                                System.out.println("Not found.");
                            }
                            break;

                        case 4:
                            System.out.println("PRN"+"\t"+"Name");
                            for (Map.Entry<Integer, String> entry : names.entrySet()) {
                                Integer key = entry.getKey();
                                String value = entry.getValue();
                                System.out.println( key + "\t" + value);
                            }
                            break;

                        case 5:
                            System.out.println("Enter PRN to be searched in the class:");
                            Integer l = sc.nextInt();
                            sc.nextLine();
                            if(check.contains(l))
                            {
                                System.out.println("Name : "+names.get(l));
                            }
                            else{
                                System.out.println("Student not found in the class.");
                            }
                            break;

                        case 0:
                            System.out.println("You have exited the program.");
                            break;

                        default:
                            System.out.println("Invalid Option");
                    }

                }while(i!=0);
            }
            else{
                System.out.println("Run the program again with valid username.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error Occured in the program");
            System.out.println("Please run the program again with proper details in the input.");
            System.out.println(e.getMessage());
        }
        System.out.println("The program ends.");
    }
}
