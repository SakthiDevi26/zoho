package FileHandling;
import java.util.*;
import java.io.*;
public class Registeration {
	Scanner scanner = new Scanner(System.in);
	
	//check the password if password matches return the credentials
	public String checkPassWord(String userName, String passWord, String confirmPassWord)
	{
		
		if(passWord.equals(confirmPassWord))
		{
		String credentials = userName+"  "+passWord;
		return credentials;
		}
		else
		{
			String credentials="";
			System.out.println("Password doesn't match with confirm password");
			return credentials;
		}
	}
	public void createNewAccount() throws FileNotFoundException {
		// TODO Auto-generated method stub
		String userName, passWord, confirmPassWord;
		System.out.println("Enter User Name: ");
		userName = scanner.nextLine();
		System.out.println("Enter PassWord: ");
		passWord = scanner.nextLine();
		System.out.println("Confirm PassWord: ");
		confirmPassWord = scanner.nextLine();
		
		userName=userName.trim();
		passWord = passWord.trim();
		confirmPassWord = confirmPassWord.trim();
		String credentials = userName+"  "+passWord;
		//if the password matches and the credentials is not empty
		if(checkPassWord(userName, passWord, confirmPassWord)!="")
		{
			
			//System.out.println("done");
			File file = new File("Registeration.txt");
			Scanner fileContent = new Scanner(file);
			int flag =0;
			while(fileContent.hasNextLine())
			{
				String contentLineInFile = fileContent.nextLine();
				if(contentLineInFile.equals(credentials))
				{
					System.out.println("You are already registered");
					flag =1;
					Main.printMainMenu();
				}
			}
			if(flag==0)

			{
				try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Registeration.txt", true)); 
                    writer.write(userName+"  "+passWord+"\n");
                    writer.close();
                }
                catch (IOException e) {
                    System.out.println("exception occoured" + e);
                }
                 
                System.out.println("Successfully Registered");
                
                
                System.out.println("Please login");
                loginAccount();
			}
			
		}
		else
		{
			System.out.println("Recheck");
			Main.printMainMenu();
		}
	}

	public void loginAccount() {
		// TODO Auto-generated method stub
		String userName, passWord, confirmPassWord;
		System.out.println("Enter User Name: ");
		userName = scanner.nextLine();
		System.out.println("Enter PassWord: ");
		passWord = scanner.nextLine();
		System.out.println("Confirm PassWord: ");
		confirmPassWord = scanner.nextLine();
		
		userName=userName.trim();
		passWord = passWord.trim();
		confirmPassWord = confirmPassWord.trim();
		String credentials = userName+"  "+passWord;
		try {
			File file = new File("Registeration.txt");
			try (Scanner fileContent = new Scanner(file)) {
				int flag =0;
				while(fileContent.hasNextLine())
				{
					String contentLineInFile = fileContent.nextLine();
					if(contentLineInFile.equals(credentials))
					{
						flag=1;
						System.out.println("Login Successfull");	
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("Login Failed");
					Main.printMainMenu();
				}
			}
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Exception occured");
			e.printStackTrace();
		}
		
	}

}
