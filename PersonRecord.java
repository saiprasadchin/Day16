import java.util.*;
import java.lang.*;
import java.io.FileWriter;
class  PersonRecord{
	String Fname;
	String Lname;
	String city;
	String state;
	int zip;
	long pnum;
	static PersonRecord Record(){
		PersonRecord pr1 = new PersonRecord();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the First Name");
		pr1.Fname = sc.nextLine();
		System.out.println("Enter the Last Name");
        	pr1.Lname = sc.nextLine();
		ReuseRecord(pr1);
		return pr1;
	}
	static void ReuseRecord(PersonRecord pr1){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the City");
       		pr1.city = sc.nextLine();
        	System.out.println("Enter the State");
        	pr1.state = sc.nextLine();
        	System.out.println("Enter the 6 Digit Zip code");
        	pr1.zip = sc.nextInt();
        	int length = (int)(Math.log10(pr1.zip)+1);
        	while(length != 6){
                System.out.println("enter 6 digit number");
                pr1.zip = sc.nextInt();
                length = (int)(Math.log10(pr1.zip)+1);
                	if(length==10){
                        pr1.zip=pr1.zip;
                        break;
                	}
         	}
        	System.out.println("Enter the 10 Digit Mobile Number");
        	pr1.pnum = sc.nextLong();
        	length = (int)(Math.log10(pr1.pnum)+1);
        	while(length != 10){
			System.out.println("enter 10 digit number");
                	pr1.pnum = sc.nextLong();
                	length = (int)(Math.log10(pr1.pnum)+1);
                	if(length==10){
				pr1.pnum=pr1.pnum;
                        	break;
                	}
         	}

        }

	public static void main(String[] args)throws Exception{
		boolean check=true;
		ArrayList<PersonRecord> l = new ArrayList<PersonRecord>();
		while(check==true){
			Scanner sc = new Scanner(System.in);
			System.out.println("1)ADD  2)UPDATE 3)DISPLAY 4)DELET  5)SORT BY NAME 6)SORT BY ZIP 7)EXIT");
			int select = sc.nextInt();
			switch (select) {
               			case 1:
                   			PersonRecord pr = Record();
					l.add(pr);
                   			break;
				case 2:

					boolean r=true;
					sc.nextLine();
                			System.out.println("Enter your name");
                			String NamePresent = sc.nextLine();
                 			for ( PersonRecord ch : l ){
	                    			if( ch.Fname.equals(NamePresent) ){
						 	r=false;
							ReuseRecord(ch);
                                			break;
                        			}
					}
					if(r){
                                		System.out.println("Record not exist");
                        		}

                                        break;

               			case 3:
					System.out.println("PERSONS RECORD : ");
					System.out.println("==============");
                   			for ( PersonRecord p : l ) {
                        			System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
					}
					break;
				case 4:
					r=true;
                                        sc.nextLine();
					System.out.println("Enter name which you want to Delet");
                                        String DeletName = sc.nextLine();
                                        for ( PersonRecord ch : l ){
                                                if( ch.Fname.equals(DeletName) ){
                                                        r=false;
                                                        l.remove(ch);
                                                        break;

                                                }
					}
                                        if(r){
                                             System.out.println("Record not exist");
                                         }

                                        break;
				case 5:

					Collections.sort(l, new Comparator<PersonRecord>(){

						public int compare(PersonRecord obj1,PersonRecord obj2){
							return obj2.Fname.compareTo(obj1.Fname);
						}

					}.reversed());
					System.out.println("PERSONS RECORD SORT BY NAME: ");
                                        System.out.println("============================");
					 for ( PersonRecord p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }

                                        break;


				case 6:
                                       Collections.sort(l, new Comparator<PersonRecord>(){

                                                public int compare(PersonRecord obj1,PersonRecord obj2){
                                                        return obj2.zip-obj1.zip;
                                                }
                                        }.reversed());
					 System.out.println("PERSONS RECORD SORT BY ZIP: ");
                                         System.out.println("============================");


                                         for ( PersonRecord p : l ) {
                                                System.out.println(p.Fname+"  "+p.Lname+"  "+p.city+"  "+p.state+"  "+p.zip+" "+p.pnum);
                                        }
                                        break;
				case 7:
                                        check=false;
					break;
               			default:
					System.out.println("invalid input");
                   			break;
           		}
			FileWriter writer = new FileWriter("AddressBook.txt");
                        for(PersonRecord ch : l) {
                        	writer.write(String.valueOf(ch.Fname+ " " + ch.Lname + " " + ch.city + " " + ch.state +" "+ ch.zip +" "+ ch.pnum+"\n"));

                        }
                        writer.close();




		}


	}


}


