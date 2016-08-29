package task.one;
import java.util.Optional;

public class PrintUserRoles {
	
	private static void printRoles(User user){
		Optional.of(user).map(User::getRoles).get().forEach(System.out::println);
	}

	public static void main(String args[]) {
		
		//all kinds of possibilities
		User user1 = new User();
		User user2 = null;
		
		printRoles(user1);
		printRoles(user2);
	}

}
