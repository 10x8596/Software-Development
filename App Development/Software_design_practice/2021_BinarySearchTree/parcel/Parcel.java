package parcel;

public class Parcel implements Comparable<Parcel> {
	private final int id;
	private final int weight;
	private final int allowedDays;
	private final Sender sender;
	private final Recipient recipient;
	private CartesianCoordinate warehouse = new CartesianCoordinate(20, 10); // warehouse coordinate

	public Parcel(int id,int weight, int allowedDays, Sender sender, Recipient recipient) {
		this.id = id;
		this.weight = weight;
		this.allowedDays = allowedDays;
		this.sender = sender;
		this.recipient = recipient;
	}

	public Parcel(Parcel parcel) {
		this.id = parcel.id;
		this.weight = parcel.weight;
		this.allowedDays = parcel.allowedDays;
		this.sender = new Sender(parcel.sender);
		this.recipient = new Recipient(parcel.recipient);
	}

	public int getId(){
		return id;
	}

	public int getWeight() {
		return weight;
	}

	public int getAllowedDays() {
		return allowedDays;
	}

	public Sender getSender() {
		return sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	@Override
	public int compareTo(Parcel other) {
		// TODO
		// START YOUR CODE
		// Get the distance of this parcel from the warehouse (current)
		double currentParcel = this.getRecipient().getLocation().getDistance(warehouse);
		// Get the distance of the other parcel from the warehouse
		double otherParcel = other.getRecipient().getLocation().getDistance(warehouse);

		if (otherParcel < currentParcel) {return 1;}
		else if (otherParcel > currentParcel) {return -1;}
		else {return 0;}

		// END YOUR CODE
	}

	@Override
	public String toString() {
		return "Parcel{" +
				"id=" + id +
				", sender=" + sender +
				", recipient=" + recipient +
				'}';
	}

}
