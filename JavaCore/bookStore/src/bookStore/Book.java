package bookStore;

public class Book {
    private String ID;
    private String name;
    private double price;

    /**
     * Constructor
     * 
     * @param ID
     * @param name
     * @param price
     */
    public Book(String ID, String name, double price) {
        this.setId(ID);
        this.setName(name);
        this.setPrice(price);
    }

    /* Getter start */
    public String getId() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /* Getter End */
    /* Setter start */
    public void setId(String vId) {
        this.ID = vId;
    }

    public void setName(String vName) {
        this.name = vName;
    }

    public void setPrice(double vPrice) {
        this.price = vPrice;
    }
    /* Setter End */

    /* Show Info */
    public void showInfo() {
        System.out.println("Book Info: ");
        System.out.println("- ID \t \t:" + this.getId());
        System.out.println("- name \t \t:" + this.getName());
        System.out.println("- price \t \t:" + this.getPrice());
    }

}