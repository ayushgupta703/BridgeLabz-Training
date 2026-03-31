abstract class ProductCategory {
    String categoryName;

    ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

class BookCategory extends ProductCategory {
    BookCategory() {
        super("Books");
    }
}

class ClothingCategory extends ProductCategory {
    ClothingCategory() {
        super("Clothing");
    }
}

class GadgetCategory extends ProductCategory {
    GadgetCategory() {
        super("Gadgets");
    }
}

class Product<T extends ProductCategory> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public T getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }
}

class Marketplace {
    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }

    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Book", 500, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 800, new ClothingCategory());

        System.out.println(book.getName() + " price before discount: " + book.getPrice());
        applyDiscount(book, 10);
        System.out.println(book.getName() + " price after discount: " + book.getPrice());

        System.out.println(shirt.getName() + " price before discount: " + shirt.getPrice());
        applyDiscount(shirt, 20);
        System.out.println(shirt.getName() + " price after discount: " + shirt.getPrice());
    }
}