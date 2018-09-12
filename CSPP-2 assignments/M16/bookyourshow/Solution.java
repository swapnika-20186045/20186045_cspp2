import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Show {
	private String movieName;
	private String showTime;
	private String[] seats;

	Show() {
	}
	Show(String movieName, String showTime, String[] seats) {
		this.movieName = movieName;
		this.showTime = showTime;
		this.seats = seats;
	}
	public String getName() {
		return movieName;
	}
	public String getshowTime() {
		return showTime;
	}
	public String[] getseats() {
		return seats;
	}
	public void setSeatNA(int index) {
        seats[index] = "N/A";
    }

    public String toString() {
        return movieName + "," + showTime;
    }
}

class Patron {
	private String customerName;
	private String phoneNumber;
	// private String[] bookedSeats;

	public Patron() {
	}
	public Patron(String customerName, String phoneNumber) {
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		// this.bookedSeats = bookedSeats;
	}
	public String getcustomerName() {
		return customerName;
	}
	public String getphoneNumber() {
		return phoneNumber;
	}
	// public String[] getbookedSeats() {
	// 	return this.bookedSeats;
	// }
	public String toString() {
        return customerName + " " + phoneNumber;
    }
}
class BookYourShow {
	ArrayList<Show> showlist;
    ArrayList<String> ticketlist;

    BookYourShow() {
        showlist = new ArrayList<>();
        ticketlist = new ArrayList<>();
    }

    public void addAShow(Show show) {
        showlist.add(show);
    }

    public Show getAShow(String movieName, String showTime) {
        for (Show show : showlist) {
            if (show.getName().equals(movieName) && show.getshowTime().equals(showTime)) {
                return show;
            }
        }
        return null;
    }
    public void bookAShow(String movieName, String showTime, Patron patron, String[] seats) {
        Show show = getAShow(movieName, showTime);
        boolean flag = false;
        if (show == null) {
            System.out.println("No show");
            return;
        } 
        String[] seats1 = show.getseats();
            for (String seat : seats) {
                for (int i = 0; i < seats1.length; i++) {
                    if (seat.equals(seats1[i])) {
                        show.setSeatNA(i);
                        flag = true;
                    }
                }
            }
        if (flag) {
            ticketlist.add(patron.getphoneNumber() + " " + movieName + " " + showTime);
        }
    }
    public void printTicket(String movie, String showTime, String phoneNumber) {
        String t = phoneNumber + " " + movie + " " + showTime;
        if (ticketlist.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }
    public void showAll() {
        for (Show show : showlist) {
            System.out.println(show.toString() + "," +
                Arrays.toString(show.getseats()).replace(" ",""));
        }
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show);
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}
