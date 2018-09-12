/**
 *Book my show.
 * @author Swapnika Vakacharla
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class for show.
 */
class Show {
    /**
     * moviename declaration.
     */
    private String movieName;
    /**
     * showtime declaration.
     */
    private String showTime;
    /**
     * seat numbers declaration.
     */
    private String[] seats;
    /**
     * Constructs the object.
     * default constructor.
     */
    Show() {
    }
    /**
     * Constructs the object.
     *
     * @param      movieName  The movie name
     * @param      showTime   The show time
     * @param      seats      The seats
     */
    Show(final String movieName, final String showTime, final String[] seats) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.seats = seats;
    }
    /**
     * Gets the name.
     *
     * @return  string   The name.
     */
    public String getName() {
        return movieName;
    }
    /**
     * gets the showtime.
     *
     * @return   string  { description_of_the_return_value }
     */
    public String getshowTime() {
        return showTime;
    }
    /**
     * gets the seat numbers.
     *
     * @return   stringarray  { description_of_the_return_value }
     */
    public String[] getseats() {
        return seats;
    }
    /**
     * Sets the seats that are notavailable.
     *
     * @param      index  The index
     */
    public void setSeatNA(int index) {
        seats[index] = "N/A";
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movieName + "," + showTime;
    }
}
/**
 * Class for patron.
 */
class Patron {
    /**
     * customername declaration.
     */
    private String customerName;
    /**
     * phonenumber declaration.
     */
    private String phoneNumber;
    /**
    *default constructor.
    **/
    Patron() {
    }
    /**
     * Constructs the object.
     *
     * @param      customerName  The customer name
     * @param      phoneNumber   The phone number
     */
    Patron(final String customerName, final String phoneNumber) {
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        // this.bookedSeats = bookedSeats;
    }
    /**
     * gets the customer name.
     *
     * @return     { description_of_the_return_value }
     */
    public String getcustomerName() {
        return customerName;
    }
    /**
     * gets the phone number.
     *
     * @return     { description_of_the_return_value }
     */
    public String getphoneNumber() {
        return phoneNumber;
    }
    // public String[] getbookedSeats() {
    //  return this.bookedSeats;
    // }
    /**
    *gives the name and number as a string.
    *@return string   The string
    **/
    public String toString() {
        return customerName + " " + phoneNumber;
    }
}
class BookYourShow {
    /**
     * using arraylist to show shows.
     */
    ArrayList<Show> showlist;
    /**
     * using arraylist to show tickets.
     */
    ArrayList<String> ticketlist;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        showlist = new ArrayList<>();
        ticketlist = new ArrayList<>();
    }
    /**
     * Adds a show to the showlist.
     *
     * @param      show  The show
     */
    public void addAShow(final Show show) {
        showlist.add(show);
    }
    /**
     * Gets a show.
     *
     * @param      movieName  The movie name
     * @param      showTime   The show time
     *
     * @return     A show.
     */
    public Show getAShow(final String movieName, final String showTime) {
        for (Show show : showlist) {
            if (show.getName().equals(movieName) && show.getshowTime().
                                            equals(showTime)) {
                return show;
            }
        }
        return null;
    }
    /**
     * book tickets for a show.
     *
     * @param      movieName  The movie name
     * @param      showTime   The show time
     * @param      patron     The patron
     * @param      seats      The seats
     */
    public void bookAShow(final String movieName, final String showTime,
                          final Patron patron, final String[] seats) {
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
            ticketlist.add(patron.getphoneNumber() + " " + movieName
                                                + " " + showTime);
        }
    }
    /**
     * prints the ticket.
     *
     * @param      movie        The movie
     * @param      showTime     The show time
     * @param      phoneNumber  The phone number
     */
    public void printTicket(final String movie, final String showTime,
                            final String phoneNumber) {
        String t = phoneNumber + " " + movie + " " + showTime;
        if (ticketlist.contains(t)) {
            System.out.println(t);
        } else {
            System.out.println("Invalid");
        }
    }
    /**
     * Shows all the shows.
     */
    public void showAll() {
        for (Show show : showlist) {
            System.out.println(show.toString() + ","
                    + Arrays.toString(show.getseats()).replace(" ", ""));
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
