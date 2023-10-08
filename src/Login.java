import java.util.Scanner;
public class Login {

	public static void main(String[] args) 
	{

		Scanner scanner=new Scanner(System.in);
		
		// Asking user to enter the first name
		System.out.println("Enter your first name :");
		String FirstName=scanner.nextLine();
		
	
		System.out.println("Enter your Last name");
		String LastName=scanner.nextLine();
		
		
		System.out.println("Enter your company domain (E.g hamk.fi)");
		String domain=scanner.nextLine();
		
	
		if(FirstName.isEmpty()||LastName.isEmpty())
		{
			System.out.println("Oops..First name, Last name or both missing.");
		}
		else
		{
			//Calling methods to genarate email and username 
			String email=genarateEmail(FirstName,LastName,domain);
			String userName=genarateUsername(FirstName,LastName);
			
			//Display genarated email and username
			System.out.println("Your genarated Email Address:"+email );
			System.out.println("Your User name :"+userName);
		}
		scanner.close();
	}
	//Creating a function to genarate the email address
	public static String genarateEmail(String FirstName,String LastName,String domain)
	{
		//Converting names and domain to lowercase
		FirstName=FirstName.toLowerCase();
		LastName=LastName.toLowerCase();
		domain=domain.toLowerCase();
		
		//Removing spaces and special characters
		FirstName=FirstName.replaceAll("[^a-zA-Z0-9]", "");
		LastName=LastName.replaceAll("[^a-zA-Z0-9]", "");
		
		//combining names and domain
		String email=FirstName+"."+LastName+"@"+domain;
		
		return email;
	}
	
	//Creating a function to genarate username
	public static String genarateUsername(String FirstName,String LastName)
	{
		// Taking the first and last four characters from first name and last name
		String userName=FirstName.substring(0,Math.min(4,FirstName.length()))+LastName.substring(Math.max(0,LastName.length()-4));
		
		//Converting to lowercase
		userName=userName.toLowerCase();
		
		return userName;
	}

}
