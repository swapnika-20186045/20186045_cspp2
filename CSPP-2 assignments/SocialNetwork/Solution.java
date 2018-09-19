import java.util.Scanner;
import java.util.Arrays;
class User {
	private String username;
	private List<String> frndlist;
	User(String username, List<String> frndlist) {
		this.username = username;
		this.frndlist = frndlist;
	}
	public String getUserame() {
		return this.username;
	}
	public List<String> getfrndlist() {
		return this.frndlist;
	}

}
class SocialNetwork {
	List<User> userlist;
	SocialNetwork() {
		userlist = new List<User>();
	}
	public void addUser(User friend) {
		userlist.add(friend);
	}
	public void addConnections(String friend, String other) {
		int index = indexOf(friend);
		if (index != -1) {
			List<String> frndlist = userlist.get(index).getfrndlist();
			frndlist.add(other);
		}
	}
	public int indexOf(String name) {
		for (int i = 0; i < userlist.size(); i++) {
			if (userlist.get(i).getUserame().equals(name)) {
				return i;
			}
		}
		return -1;
	} 
	public List<String> getConnections(String name) {
		int index = indexOf(name);
		if (index != -1) {
			return userlist.get(indexOf(name)).getfrndlist();
		}
		return null;
	}
	public List<String> CommonConnections(String name1, String name2) {
		int index1 = indexOf(name1);
		int index2 = indexOf(name2);
		if(index1 != -1 || index2 != -1) {
			List<String> friend1 = userlist.get(index1).getfrndlist();
			List<String> friend2 = userlist.get(index2).getfrndlist();
			List<String> commonfrnds = new List<String>();
			for (int i = 0; i < friend2.size(); i++) {
				if (friend1.contains(friend2.get(i))) {
					commonfrnds.add(friend2.get(i));
				}
			}
			return commonfrnds;
		}
		return null;
	}
	public String tostring() {
		String[] strs = new String[userlist.size()];
		for (int i = 0; i < userlist.size(); i++) {
			strs[i] = userlist.get(i).getUserame();
		}
		Arrays.sort(strs);
		String s = "";
		int i = 0;
		for (i = 0; i < strs.length - 1; i++) {
			s += strs[i] + ": " + getConnections(strs[i]) + ", ";
		}
		s += strs[i] + ": " + getConnections(strs[i]);
		return s;
	}

}
public class Solution {
	public static void main(String[] args) {
		SocialNetwork fb = new SocialNetwork();
		Scanner scan = new Scanner(System.in);
		String[] str = scan.nextLine().split(" ");
		int i = 0;
		while(i < Integer.parseInt(str[1])) {
			String[] tokens = scan.nextLine().split(" is connected to ");
			String[] friends = tokens[1].replace(".", "").split(", ");
			List<String> friendsList = new List<String>();
			for (int j = 0; j < friends.length; j++) {
				friendsList.add(friends[j]);
			}
			fb.addUser(new User(tokens[0], friendsList));
			i++;
		}
		while (scan.hasNext()) {
			String st = scan.nextLine();
			String[] token = st.split(" ");
			System.out.println(token[0]);
			switch (token[0]) {
				case "Network":
					System.out.println(fb.tostring());
				break;
				case "addConnections":
					fb.addConnections(token[1], token[2]);
				break;
				case "getConnections":
					if (fb.getConnections(token[1]) == null) {
						System.out.println("Not a user in Network");
					} else {
						System.out.println(fb.getConnections(token[1]));
					}
				break;
				case "CommonConnections":
					System.out.println(fb.CommonConnections(token[1], token[2]));
				break;
				default:
				break;
			}
		}
	}
}
