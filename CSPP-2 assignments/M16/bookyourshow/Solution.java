/**
 *Book my show.
 * @author Swapnika Vakacharla
 */
import java.util.Scanner;
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
     * @param      movieNamee  The movie name
     * @param      showTimee   The show time
     * @param      seatss      The seats
     */
    Show(final String movieNamee, final String showTimee,
            final String[] seatss) {
        this.movieName = movieNamee;
        this.showTime = showTimee;
        this.seats = seatss;
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
     * print the except tickets.
     *
     * @return     { description_of_the_return_value }
     */
    public String printexceptTickets() {
        return movieName + "," + showTime;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return movieName + "," + showTime + ","
        + Arrays.toString(seats).replace(", ", ",");
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
     * declaration of booked seats.
     */
    private String[] bookedSeats;
    /**
    *default constructor.
    **/
    Patron() {
    }
    /**
     * Constructs the object.
     *
     * @param      customerNamee  The customer name
     * @param      phoneNumberr   The phone number
     * @param      bookedSeatss   The booked seats
     */
    Patron(final String customerNamee, final String phoneNumberr,
        final String[] bookedSeatss) {
        this.customerName = customerNamee;
        this.phoneNumber = phoneNumberr;
        this.bookedSeats = bookedSeatss;
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
    /**
     * no of seats booked.
     *
     * @return     { description_of_the_return_value }
     */
    public String[] getbookedSeats() {
        return bookedSeats;
    }
}
/**
 * Class for book your show.
 */
class BookYourShow {
    /**
     * intitializing value of 10.
     */
    private static final int TEN = 10;
    /**
     * intitializing value of 20.
     */
    private static final int TWENTY = 20;
    /**
     * array of shows.
     */
    private Show[] shows;
    /**
     * array of patrons.
     */
    private Patron[] patrons;
    /**
     * size of shows array.
     */
    private int showSize;
    /**
     * size of patrons array.
     */
    private int patronSize;
    /**
     * Constructs the object.
     */
    BookYourShow() {
        this.shows = new Show[TEN];
        this.patrons = new Patron[TWENTY];
        this.showSize = showSize;
        this.patronSize = patronSize;
    }
    /**
     * resize the array.
     */
    public void resize() {
        shows = Arrays.copyOf(shows, shows.length);
        patrons = Arrays.copyOf(patrons, patrons.length);
    }
    /**
     * Adds a show.
     *
     * @param      show1  The newshow
     */
    public void addAShow(final Show show1) {
        if (showSize == shows.length) {
            resize();
        }
        shows[showSize++] = show1;
    }
    /**
     * Adds a patron.
     *
     * @param      pat     { parameter_description }
     */
    public void addAPatron(final Patron pat) {
        if (patronSize == patrons.length) {
            resize();
        }
        patrons[patronSize++] = pat;
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
        for (int i = 0; i < showSize; i++) {
            if (shows[i].getName().equals(movieName) && shows[i].getshowTime().
                                            equals(showTime)) {
                return shows[i];
            }
        }
        return null;
    }
    /**
     * { function_description }.
     *
     * @param      show       The show
     * @param      customerseats  The customerseats
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkSeats(final Show show, final String[] customerseats) {
        int count = 0;
        String[] seats = show.getseats();
        for (int i  = 0; i < seats.length; i++) {
            for (int j = 0; j < customerseats.length; j++) {
                if (seats[i].equals(customerseats[j])) {
                    count += 1;
                    seats[i] = seats[i].replace(seats[i], "N/A");
                }
            }
        }
        return (count == customerseats.length);
    }
    /**
     * { function_description }.
     *
     * @param      movieName  The movie name
     * @param      showTime   The showTime
     * @param      pat          { parameter_description }
     */
    public void bookAShow(final String movieName, final String showTime,
        final Patron pat) {
        addAPatron(pat);
        Show presentshow = getAShow(movieName, showTime);
        if (presentshow != null) {
            checkSeats(presentshow, pat.getbookedSeats());
        } else {
            System.out.println("No show");
        }
    }
    /**
     * { function_description }.
     *
     * @param      movieName     The movie name
     * @param      showTime      The showTime
     * @param      phoneNumber  The mobile number
     */
    public void printTicket(final String movieName, final String showTime,
        final String phoneNumber) {
        Show show = getAShow(movieName, showTime);
        if (show != null) {
            for (int i = 0; i < patronSize; i++) {
                if (patrons[i].getphoneNumber().equals(phoneNumber)) {
                    System.out.println(phoneNumber + " " + movieName
                        + " " + showTime);
                    return;
                }
            }
        }
        System.out.println("Invalid");
    }
    /**
     * Shows all.
     */
    public void showAll() {
        for (int i = 0; i < showSize; i++) {
            System.out.println(shows[i]);
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
                    new Patron(tokens[2], tokens[2 + 1], seats));
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show.printexceptTickets());
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
