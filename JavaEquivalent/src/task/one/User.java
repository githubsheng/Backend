package task.one;
import java.util.ArrayList;
import java.util.List;


public class User {

	private final List<Role> roles;
	
	public User(){
		this.roles = new ArrayList<>();
		roles.add(new Role("role1"));
		roles.add(new Role("role2"));
		roles.add(new Role("role3"));
	}

	public List<Role> getRoles() {
		return roles;
	}

	
}
