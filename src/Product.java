public class Product {
    private String  name;
    private String productionDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean bookingStatus;

    public Product(String name, String productionDate, String manufacturer, String countryOfOrigin, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    public void printInfo() {
        System.out.println("название: " + name);
        System.out.println("дата производства: " + productionDate);
        System.out.println("производитель: " + manufacturer);
        System.out.println("страна происхождения: " + countryOfOrigin);
        System.out.println("цена: " + price);
        System.out.println("состояние бронирования: " + bookingStatus);
    }
}