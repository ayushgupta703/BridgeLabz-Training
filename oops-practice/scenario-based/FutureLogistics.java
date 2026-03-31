package scenario_based;

import java.util.Scanner;

//	GoodsTransport
abstract class GoodsTransport {
    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();

    public String getTransportId() {
        return transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }
}

//	BrickTransport
class BrickTransport extends GoodsTransport {

    @SuppressWarnings("unused")
	private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5)
            discount = price * 0.2f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.1f;

        float vehicleCost = vehicleSelection().equalsIgnoreCase("Truck") ? 1000 :
                            vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;

        return price + tax + vehicleCost - discount;
    }
}

//	TimberTransport
class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType() {
        return timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    @Override
    public String vehicleSelection() {
        float area = 2 * 3.147f * timberRadius * timberLength;

        if (area < 250)
            return "Truck";
        else if (area <= 400)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        float volume = 3.147f * timberRadius * timberRadius * timberLength;
        float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;

        float price = volume * timberPrice * rate;
        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5)
            discount = price * 0.2f;
        else if (transportRating == 3 || transportRating == 4)
            discount = price * 0.1f;

        float vehicleCost = vehicleSelection().equalsIgnoreCase("Truck") ? 1000 :
                            vehicleSelection().equalsIgnoreCase("Lorry") ? 1700 : 3000;

        return price + tax + vehicleCost - discount;
    }
}

//	Utility
class Utility {

    public boolean validateTransportId(String transportId) {
        String regex = "^RTS[0-9]{3}[A-Z]$";
        if (!transportId.matches(regex)) {
            System.out.println("Transport id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }
        return true;
    }

    public GoodsTransport parseDetails(String input) {
        String[] data = input.split(":");

        if (!validateTransportId(data[0])) {
            return null;
        }

        if (data[3].equalsIgnoreCase("BrickTransport")) {
            return new BrickTransport(
                    data[0], data[1], Integer.parseInt(data[2]),
                    Float.parseFloat(data[4]),
                    Integer.parseInt(data[5]),
                    Float.parseFloat(data[6]));
        } else if (data[3].equalsIgnoreCase("TimberTransport")) {
            return new TimberTransport(
                    data[0], data[1], Integer.parseInt(data[2]),
                    Float.parseFloat(data[4]),
                    Float.parseFloat(data[5]),
                    data[6],
                    Float.parseFloat(data[7]));
        }
        return null;
    }

    public String findObjectType(GoodsTransport obj) {
        if (obj instanceof BrickTransport)
            return "BrickTransport";
        else if (obj instanceof TimberTransport)
            return "TimberTransport";
        return null;
    }
}

//	UserInterface (MAIN)
public class FutureLogistics {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport gt = util.parseDetails(input);
        if (gt == null) {
            sc.close();
            return;
        }

        System.out.println("Transporter id : " + gt.getTransportId());
        System.out.println("Date of transport : " + gt.getTransportDate());
        System.out.println("Rating of the transport : " + gt.getTransportRating());

        String type = util.findObjectType(gt);

        if (type.equals("BrickTransport")) {
            BrickTransport bt = (BrickTransport) gt;
            System.out.println("Quantity of bricks : " + bt.getBrickQuantity());
            System.out.println("Brick price : " + bt.getBrickPrice());
        } else {
            TimberTransport tt = (TimberTransport) gt;
            System.out.println("Type of the timber : " + tt.getTimberType());
            System.out.println("Timber price per kilo : " + tt.getTimberPrice());
        }

        System.out.println("Vehicle for transport : " + gt.vehicleSelection());
        System.out.println("Total charge : " + gt.calculateTotalCharge());

        sc.close();
    }
}
