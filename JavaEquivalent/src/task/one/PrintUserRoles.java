package task.one;
import java.util.Optional;

public class PrintUserRoles {
	
	private static void printRoles(User user){
		Optional.ofNullable(user).map(User::getRoles).ifPresent(l -> l.forEach(System.out::println));
	}

	public static void main(String args[]) {
		
		//all kinds of possibilities
		User user1 = new User();
		User user2 = null;
		
		printRoles(user1);
		printRoles(user2);
	}

}
