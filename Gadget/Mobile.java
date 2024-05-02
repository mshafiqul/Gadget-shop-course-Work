public class Mobile extends Gadget {
    private int minutesOfCredit;

    public Mobile(String model, double price, int weight, String size, int minutesOfCredit) {
        super(model, price, weight, size);
        this.minutesOfCredit = minutesOfCredit;
    }

    public int getMinutesOfCredit() {
        return minutesOfCredit;
    }

    public void addCallingCredit(int credit) {
        if (credit > 0) {
            minutesOfCredit += credit;
            System.out.println("Added " + credit + " minutes of calling credit.");
        } 
    else {
            System.out.println("Please enter a positive amount of calling credit.");
        }
    }

    public void makePhoneCall(String phoneNumber, int duration) {
        if (minutesOfCredit >= duration) {
            minutesOfCredit -= duration;
            System.out.println("Made a phone call to " + phoneNumber + " for " + duration + " minutes.");
        } else {
            System.out.println("Insufficient credit to make the call.");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Minutes of calling credit remaining: " + minutesOfCredit);
    }
}
