import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if (findProduct(id) != null){
            findProduct(id).increaseQuantity(amount);
        }
        else{
            System.out.println("El id seleccionado no existe");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product producto = null;
        int index = 0;
        boolean found = false;
        while(index < stock.size() || !found)
        {
            if(stock.get(index).getID()==id)
            {
                found = true;
                producto = stock.get(index);
            }
            index ++;
        }
        return producto;
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
        int cantidad = 0;
        if(findProduct(id) != null){
            cantidad = findProduct(id).getQuantity();
        }
        return cantidad;

    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        {
            for (Product producto : stock){
                System.out.println(producto);
            }
        }
    }
    /**
     * imprime por pantalla los detalles de los productos 
     * cuyo stock este por debajo del parametro dado
     */
    public void underGivenNumberInStock(int stockMinimo)
    {
        for(Product producto : stock)
        {
            int cantidad = producto.getQuantity();
            if(cantidad < stockMinimo)
            {
                System.out.println(producto);
            }            
        }
    }
}
