import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author Erik Cooke 
 * @version 2019.10.8
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list only if the product id is unique
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if(findProduct(item.getID()) == null) {
            stock.add(item);
        }
        else {
            System.out.println("\nAn item with the product id: " + item.getID() + " already exists");
            System.out.println(findProduct(item.getID()).toString());
        }
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        Product prod = findProduct(id);
        if(prod != null) {
            prod.increaseQuantity(amount);
        }
        else {
            System.out.println("\nThere is no product with the id: " + id);
        }
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        int index = 0;
        while(index < stock.size()) {
            if(stock.get(index).getID() == id) {
                return stock.get(index);
            }
            else {
                index ++;
            }
        }
        return null;
    }
    
    /**
     * Finds a product by its name
     * @param name string used to search for product
     * @return The product that is found, or null if none match with name
     */
    public Product findProduct(String name) {
        int index = 0;
        while(index < stock.size()) {
            if(stock.get(index).getName().equalsIgnoreCase(name)) {
                return stock.get(index);
            }
            else {
                index ++;
            }
        }
        return null;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        Product prod = findProduct(id);
        if(prod == null) {
            return 0;
        }
        else {
            return prod.getQuantity();
        }
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        if(stock.size() == 0) {
         System.out.println("\nThere are no products in the list");
        }
        else {
            System.out.println("\nCurrent Product Details");
            System.out.println("ID: Description: Quantity");
            System.out.println("-------------------------");
            for(Product prod : stock) {
                System.out.println(prod.toString());
            }
        }
    }
    
    /**
     * Prints a list of all products with a stock level less than
     * the passed in parameter
     * @param below print stock that is less than this number
     */
    public void printStockBelow(int below) {
        System.out.println("\nProducts that have less than " + below + " stock");
        System.out.println("------------------------------------------------");
        for(Product prod : stock) {
            if(prod.getQuantity() < below) {
                System.out.println(prod.toString());
            }
        }
    }
    
}
