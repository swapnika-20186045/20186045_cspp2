/**
 * Shopping cart.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for item.
 */
class Item {
    /**
     * productname declaration.
     */
    private String productname;
    /**
     * quantity declaration.
     */
    private int quantity;
    /**
     * unitprice declaration.
     */
    private double unitprice;
    /**
     * Constructs the object.
     * default constructor.
     */
    Item() {
    }
    /**
     * Constructs the object.
     *
     * @param      name  The name
     * @param      toquantity     The toquantity
     * @param      price    The price
     */
    Item(final String name, final int toquantity, final double price) {
        this.productname = name;
        this.quantity = toquantity;
        this.unitprice = price;
    }
    /**
     * Constructs the object.
     *
     * @param      name        The name
     * @param      toquantity  The toquantity
     */
    Item(final String name, final int toquantity) {
        productname = name;
        quantity = toquantity;
    }
    /**
     * Gets the product name.
     *
     * @return  string   The name.
     */
    public String getProductName() {
        return productname;
    }
    /**
     * gets the quantity.
     *
     * @return   int  { description_of_the_return_value }
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * gets the unitprice.
     *
     * @return   double  { description_of_the_return_value }
     */
    public double getUnitPrice() {
        return unitprice;
    }
    /**
     * sets the product name.
     *
     * @param      pname  The pname
     */
    public void setproductname(final String pname) {
        this.productname = pname;
    }
    /**
     * sets the quantity.
     *
     * @param      quant  The pname
     */
    public void setquantity(final int quant) {
        this.quantity = quant;
    }
    /**
     * sets the unit price.
     *
     * @param      giveprice  The pname
     */
    public void setunitprice(final double giveprice) {
        this.unitprice = giveprice;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.productname + " " + this.quantity + " " + this.unitprice;
    }
}
/**
 * Class for shopping cart.
 */
class ShoppingCart {
    /**
     *items list catalog.
     */
    private List<Item> catalog;
    /**
     * items list cart.
     */
    private List<Item> cart;
    /**
     * coupons in a string.
     */
    private String[] coupons;
    /**
     * discount declaration.
     */
    private double discount;
    /**
    *@variable THREE
    **/
    private static final int THREE = 3;
    /**
    *@variable FIFTEEN
    **/
    private static final double FIFTEEN = 0.15;
    /**
    *@variable TEN
    **/
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    ShoppingCart() {
        catalog = new List<Item>();
        cart = new List<Item>();
        coupons = new String[] {"IND10", "IND20", "IND30", "IND50"};
        discount = 0;
        // icount = 0;
        // ccount = 0;
    }
    /**
     * Adds to catalog.
     *
     * @param      item  The item
     */
    public void addToCatalog(final Item item) {
        if (!catalog.contains(item)) {
            catalog.add(item);
        }
        // if (icount == catalog.length) {
        //  CatalogResize();
        // } else {
        //  catalog[icount] = item;
        //  icount ++;
        // }
    }
    /**
     * Shows the catalog.
     */
    public void showCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
    }
    /**
     * to get the index of item.
     *
     * @param      productname  The productname
     * @param      search       The search
     * @return     { description_of_the_return_value }
     */
    private int index(final String productname, final List<Item> search) {
        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).getProductName().equals(productname)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Adds the item to cart.
     *
     * @param      item  The item
     */
    public void addToCart(final Item item) {
        int indexCatalog = index(item.getProductName(), catalog);
        if (indexCatalog != -1) {
            double unitprice = catalog.get(indexCatalog).getUnitPrice();
            int indexCart = index(item.getProductName(), cart);
            if (indexCart == -1) {
                //item is not in cart
                cart.add(new Item(item.getProductName(),
                         item.getQuantity(), unitprice));
            } else {
                //item is present in cart
                Item oldItem = cart.get(indexCart);
                oldItem.setquantity(oldItem.getQuantity()
                                        + item.getQuantity());
            }
        }

        // if (ccount == cart.length) {
        //  CartResize();
        // } else {
        //  cart[ccount] = item;
        //  ccount += 1;
        // }
    }
    /**
     * Removes an item from cart.
     *
     * @param      item  The item
     */
    public void removeFromCart(final Item item) {
        int indexCatalog = index(item.getProductName(), catalog);
        if (indexCatalog != -1) {
            double unitprice = catalog.get(indexCatalog).getUnitPrice();
            int indexCart = index(item.getProductName(), cart);
            if (indexCart != -1) {
                Item oldItem = cart.get(indexCart);
                if (oldItem.getQuantity() - item.getQuantity() > 0) {
                    oldItem.setquantity(oldItem.getQuantity()
                                        - item.getQuantity());
                } else if (oldItem.getQuantity() - item.getQuantity() == 0) {
                    cart.remove(indexCart);
                }
            } else {
                cart.remove(indexCart);
            }
        }
    }
    /**
     * shows the items.
     */
    public void show() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getProductName() + " "
                               + cart.get(i).getQuantity());
        }
    }
    /**
     * Shows the items in cart.
     */
    public void showCart() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getProductName() + " "
             + cart.get(i).getQuantity() + " " + cart.get(i).getUnitPrice());
        }
    }
    /**
     * Gets the total amount.
     *
     * @return     The total amount.
     */
    public double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getQuantity() * cart.get(i).getUnitPrice();
        }
        return total;

    }
    /**
     * Gets the payable amount.
     *
     * @return     The payable amount.
     */
    public double getPayableAmount() {
        double amount = getTotalAmount();
        // System.out.println("187 " + discount);
        amount = (1 - discount) * amount;
        amount += (FIFTEEN * amount);
        return amount;
    }
    /**
     * applies the coupon.
     *
     * @param      coupon  The coupon
     */
    public void applycoupon(final String coupon) {
        if (discount == 0) {
            for (int i = 0; i < coupons.length; i++) {
                if (coupons[i].equals(coupon)) {
                    discount = Double.parseDouble(coupon.substring(THREE,
                        coupon.length() - 1)) / TEN;
                    // getcoupon();
                    return;
                }
            }
            System.out.println("Invalid coupon");
        }
    }
    /**
     * prints the invoice.
     */
    public void printInvoice() {
        System.out.println("Name   quantity   Price");
        showCart();
        double total = getTotalAmount();
        System.out.println("Total:" + (total));
        System.out.println("Disc%:" + (total * discount));
        System.out.println("Tax:" + (FIFTEEN * (total * (1 - discount))));
        System.out.println("Payable amount: " + getPayableAmount());
    }
}
/**
 * Class for solution.
 */
class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            switch (tokens[0]) {
            case "Item":
                String[] items = tokens[1].split(",");
                cart.addToCatalog(new Item(items[0], Integer.parseInt(
                                items[1]), Double.parseDouble(items[2])));
                // System.out.println(tokens[1]);
                break;
            case "add":
                items = tokens[1].split(",");
                cart.addToCart(new Item(items[0], Integer.parseInt(
                                        items[1])));
                // System.out.println(tokens[1]);
                break;
            case "remove":
                // System.out.println(tokens[1]);
                items = tokens[1].split(",");
                cart.removeFromCart(new Item(items[0], Integer.parseInt(
                                             items[1])));
                break;
            case "show":
                // System.out.println("cart");
                cart.show();
                break;
            case "totalAmount":
                System.out.println("totalAmount: " + cart.getTotalAmount());
                break;
            case "payableAmount":
                System.out.println("Payable amount: "
                                    + cart.getPayableAmount());
                break;
            case "catalog":
                cart.showCatalog();
                break;
            case "coupon":
                // System.out.println(tokens[1]);
                cart.applycoupon(tokens[1]);
                break;
            case "print":
                cart.printInvoice();
                break;
            default:
                break;
            }
        }
    }
}
