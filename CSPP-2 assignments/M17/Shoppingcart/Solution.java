import java.util.Scanner;
import java.util.Arrays;
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
	Item(String name, int toquantity) {
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
    public void setproductname(String pname) {
    	this.productname = pname;
    }
    public void setquantity(int quant) {
    	this.quantity = quant;
    }
    public void setunitprice(double giveprice) {
    	this.unitprice = giveprice;
    }
    public String toString() {
    	return this.productname + " " + this.quantity + " " + this.unitprice;
    }
}
class ShoppingCart {
	private List<Item> catalog;
	private List<Item> cart;
	private String[] coupons;
	private double discount;
	private boolean flag;
	// private int icount;
	// private int ccount;
	ShoppingCart() {
		catalog = new List<Item>();
		cart = new List<Item>();
		coupons = new String[] {"IND10", "IND20", "IND30", "IND50"};
		discount = 0;
		flag = false;
		// icount = 0;
		// ccount = 0;
	}
	public void addToCatalog(Item item) {
		if (!catalog.contains(item)) {
			catalog.add(item);
		}
		// if (icount == catalog.length) {
		// 	CatalogResize();
		// } else {
		// 	catalog[icount] = item;
		// 	icount ++;
		// }
	}
	public void showCatalog() {
		for (int i = 0; i < catalog.size(); i++) {
            System.out.println(catalog.get(i));
        }
	}
	private int index(String productname, List<Item> search) {
		for (int i = 0; i < search.size(); i++) {
			if (search.get(i).getProductName().equals(productname)) {
            	return i;
			}
        }
        return -1;
	}
	public void addToCart(Item item) {
		int indexCatalog = index(item.getProductName(), catalog);
		if (indexCatalog != -1) {
			double unitprice = catalog.get(indexCatalog).getUnitPrice();
			int indexCart = index(item.getProductName(), cart);
			if (indexCart == -1) {
				//item is not in cart
				cart.add(new Item(item.getProductName(), item.getQuantity(), unitprice));
			} else {
				//item is present in cart
				Item oldItem = cart.get(indexCart);
				oldItem.setquantity(oldItem.getQuantity() + item.getQuantity());
			}
		}

		// if (ccount == cart.length) {
		// 	CartResize();
		// } else {
		// 	cart[ccount] = item;
		// 	ccount += 1;
		// }
	}
	// public void CartResize() {
	// 	cart = Arrays.copyOf(cart, ccount * 2);
	// }
	// public void CatalogResize() {
	// 	catalog = Arrays.copyOf(catalog, icount * 2);
	// }
	public void removeFromCart(Item item) {
		int indexCatalog = index(item.getProductName(), catalog);
		if (indexCatalog != -1) {
			double unitprice = catalog.get(indexCatalog).getUnitPrice();
			int indexCart = index(item.getProductName(), cart);
			if (indexCart != -1) {
				Item oldItem = cart.get(indexCart);
				if (oldItem.getQuantity() - item.getQuantity() != 0) {
					oldItem.setquantity(oldItem.getQuantity() - item.getQuantity());
				}
			} else {
				cart.remove(indexCart);
			}
		}

	}
	public void showCart() {
		for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).getProductName() + " " + cart.get(i).getQuantity());
        }

	}
	public double getTotalAmount() {
		double total = 0;
		for (int i = 0; i < cart.size(); i++) {
			total += cart.get(i).getQuantity() * cart.get(i).getUnitPrice();
		}
		return total;

	}
	public double getPayableAmount() {
		double amount = getTotalAmount();
		amount -= discount;
		amount += (0.15 * amount);
		return amount;
	}
	private void getcoupon() {
		if (flag) {
			flag = true;
			discount = discount / 100;
		}
	}
	public void applycoupon(String coupon) {
		for (int i = 0; i < coupons.length; i++) {
			if (coupons[i].equals(coupon)) {
				discount = Double.parseDouble(coupon.substring(2, coupon.length() - 1));
				getcoupon();
				return;
			}
		}
		System.out.println("Invalid coupon");
	}
	public void printInvoice() {
		System.out.println("Name quantity Price");
		showCart();
		double total = getTotalAmount();
		System.out.println("Total:" + total);
		System.out.println("Disc%:" + (discount));
		System.out.println("Tax:" + (0.15 * total));
		System.out.println("Payable amount: " + getPayableAmount());
	}
}
public class Solution {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
				case "Item":
					String[] items = tokens[1].split(",");
					cart.addToCatalog(new Item(items[0], Integer.parseInt
						            (items[1]), Double.parseDouble(items[2])));
					// System.out.println(tokens[1]);
				break;
				case "add":
					items = tokens[1].split(",");
					cart.addToCart(new Item(items[0], Integer.parseInt
						            (items[1])));
					// System.out.println(tokens[1]);
				break;
				case "remove":
					// System.out.println(tokens[1]);
					items = tokens[1].split(",");
					cart.removeFromCart(new Item(items[0], Integer.parseInt
						            (items[1])));
				break;
				case "show":
					// System.out.println("cart");
					cart.showCart();
				break;
				case "totalamount":
					System.out.println(cart.getTotalAmount());
				break;
				case "payableamount":
					cart.getPayableAmount();
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