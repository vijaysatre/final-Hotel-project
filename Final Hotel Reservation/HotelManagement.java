import java.lang.*;
import java.util.*;

class Registration
{
    Scanner sc=new Scanner(System.in);
    //int ac_room,non_ac,delux;
    int age,member;
    String name,add,gender,aadhar_no,date_in,rly;
    String data_out;
    long mobile_no;
    int ch_rooms;
    int flag;
    int rooms,room_no;

    Registration(int age,int member,int ch_rooms,int flag,int rooms,int room_no,String name,String add,String gender,String aadhar_no,String date_in,String data_out,String rly,long mobile_no)
    {
        this.age=age;
        this.member=member;
        this.name=name;
        this.add=add;
        this.gender=gender;
        this.aadhar_no=aadhar_no;
        this.date_in=date_in;
        this.data_out=data_out;
        this.rly=rly;
        this.mobile_no=mobile_no;
        this.ch_rooms=ch_rooms;
        this.flag=flag;
        this.rooms=rooms;
        this.room_no=room_no;
    }

    public Registration() {

    }

    Registration reg() throws InterruptedException
    {
        System.out.println("Which Type of Rooms you want");
        System.out.println("1:.Ac Rooms");
        System.out.println("2:.Non Ac Rooms");
        System.out.println("3:.Delux Rooms");
        System.out.println("Enter your Choice");
        ch_rooms=sc.nextInt();
        sc.nextLine();

        if(ch_rooms==1)
        {
            rooms=1;
            System.out.println("*********AC ROOM Registration********");
            System.out.println("Head Member Name for Registration::");
            name=sc.nextLine();
            System.out.println("AC ROOM Number");
            room_no=sc.nextInt();
            sc.nextLine();
        }
        else if(ch_rooms==2)
        {

            rooms=2;
            System.out.println("*********NON AC ROOM Registration********");
            System.out.println("Head Member Name for Registration::");
            name=sc.nextLine();
            System.out.println(" NON AC ROOM Number");
            room_no=sc.nextInt();
            sc.nextLine();

        }
        else if(ch_rooms==3)
        {
            rooms=3;
            System.out.println("*********DELUX ROOM Registration********");
            System.out.println("Head Member Name for Registration::");
            name=sc.nextLine();
            System.out.println("DELUX ROOM Number");
            room_no=sc.nextInt();
            sc.nextLine();
        }
        else
        {
            System.out.println("Invalid choice!!!");
            System.exit(0);
        }

        System.out.println("Age of Member::");
        age=sc.nextInt();
        //sc.nextLine();
        System.out.println("Gender of Member::");
        gender=sc.nextLine();
        sc.nextLine();
        System.out.println("Address of Member::");
        add=sc.nextLine();
        //sc.nextLine();
        System.out.println("Mobile Number of Member::");
        mobile_no=sc.nextLong();
        sc.nextLine();
        do
        {
            System.out.println("Aadhar Card of Member::");
            aadhar_no=sc.nextLine();
            int len=aadhar_no.length();
            if(len!=12)
            {
                System.out.println("\t\tSystem is verifying....Please Wait");
                Thread.sleep(1000);
                System.out.println("\t\tAadhar Card is Invalid");
                flag=0;
            }
            else
            {

                System.out.println("\t\tSystem is verifying....Please Wait");
                Thread.sleep(1000);
                System.out.println("\t\tAadhar Card is Valid");
                Thread.sleep(1000);
                System.out.println("\t\tAadhar card is Successfully Verified");
                flag=1;
            }
        }while(flag==0);

        System.out.println("Date-in::");
        date_in=sc.nextLine();
        //sc.nextLine();
        System.out.println("Date-out::");
        data_out=sc.nextLine();
        //sc.nextLine();
        System.out.println("How Many Member are have to Stay::");
        member=sc.nextInt();
        sc.nextLine();
        Thread.sleep(1000);
        System.out.println("Members Added Sucessfully");

        return new Registration(age,member,ch_rooms,flag,rooms,room_no,name,add,gender,aadhar_no,date_in,data_out,rly,mobile_no);
    }

}
public class HotelManagement
{
    public static void main(String args[]) throws InterruptedException {
		int ok;
        Scanner in = new Scanner(System.in);
        Registration regi=new Registration();
        ArrayList<Registration> registration= new ArrayList<>();
        int cho;
        int choice;
        do
        {
            System.out.println("\t**********Hotel Reversation System********");
            System.out.println();
            System.out.println("\t\t1. New Registration \n");
            System.out.println("\t\t2. Booking Review \n");
            System.out.println("\t\t3. Search the Member \n");
            System.out.println("\t\t4. Cancellation of Booking \n");
            System.out.println("\t\t5. Exit \n");
            System.out.println("Enter your choice");
            choice=in.nextInt();
            switch(choice)
            {
                case 1:
                    registration.add(regi.reg());
                    break;
                case 2:
                    System.out.println("Booking reviews");
                    System.out.println("1.Ac Rooms");
                    System.out.println("2.Non Ac Rooms");
                    System.out.println("3.Delux Rooms");
                    System.out.println("Enter your choice");
                    cho=in.nextInt();
					System.out.println("**********************************************************************");	
				
                    for(Registration i:registration)
                    {
                        if(cho==i.rooms)
                        {
                            System.out.println("Name:: "+i.name);
                            System.out.println("Age ::"+i.age);
                            System.out.println("Gender :: "+i.gender);
                            System.out.println("Address :: "+i.add);
                            System.out.println("Mobile Number ::"+i.mobile_no);
                            System.out.println("Aadhar Card Number ::"+i.aadhar_no);
                            System.out.println("Date-in ::"+i.date_in);
                            System.out.println("Date-out ::"+i.data_out);
                            System.out.println("Total Members in Room is ::"+i.member);
                            
							System.out.println("**********************************************************************");
                        }
						else
						{
							//System.out.println("No Member are Available in this room");
						
						}
						
						
                    }
					
					
					break;
					
                case 3:
					in.nextLine();
                    System.out.println("Please Enter the Room Number");
                    int index=in.nextInt();
					System.out.println("**********************************************************************");
                    for(Registration i:registration)
                    {
                        if(index==i.room_no)
                        {
                            System.out.println("Name ::"+i.name);
                            System.out.println("Age ::"+i.age);
                            System.out.println("Gender ::"+i.gender);
                            System.out.println("Address :: "+i.add);
                            System.out.println("Mobile Number::"+i.mobile_no);
                            System.out.println("Aadhar Card Number ::"+i.aadhar_no);
                            System.out.println("Date-in :: "+i.date_in);
                            System.out.println("Date-out :: "+i.data_out);
                            System.out.println("Total Members in Room is :: "+i.member);
							
                        }
						else
						{
							System.out.println("No Member are Available in this room");
						}
						
                    }
					
					System.out.println("**********************************************************************");
                    break;
                case 4:
					in.nextLine();
                    System.out.println("Enter your room no");
                    int deleteRoomno=in.nextInt();
					System.out.println("**********************************************************************");
                    for(Registration i:registration)
                    {
                        if(deleteRoomno==i.room_no)
                        {
                            registration.remove(deleteRoomno -1);
                            break;
                        }
                        System.out.println("Deleted Member");
                    }
					System.out.println("**********************************************************************");
                    break;
					case 5:

							System.out.println("No Member are Available in this room");
		
                default:
                    System.out.println("invalid Choice....!!!");
					
                    break;
            }

        }while(choice>0||choice<5);
    }
}
