
import java.io.IOException;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) throws IOException{
		
		Scanner sc=new Scanner(System.in);
		ProcessedData cl=new ProcessedData();
		cl.getAllTheData();
		int val=0;
		do {
			System.out.println("Enter 1 to get All the Logged In details by Name");
			System.out.println("Enetr 2 to get Logged In Details by Name");
			int n=sc.nextInt();
			switch (n) {
			case 1:
				cl.printAll();
				break;
			case 2:
				System.out.println("enter your Name : ");
				String str=sc.next();
				try {
					cl.getByName(str);
				}catch (DetailsCustom e) {
					System.err.println(e+" exception");
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + n);
			}
			
			System.out.println("do you want to continue? enter 5");
			val=sc.nextInt();
			if(val!=5) {
				System.out.println("Thank you....");
			}
		}while(val==5);
		
	}
}
