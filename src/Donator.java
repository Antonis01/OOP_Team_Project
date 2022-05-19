import java.util.ArrayList;
class Donator extends User {
    Offers offersList=new Offers();
    Donator(){}

    Donator(String name, String phone){
        super(name,phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RequestDonationList getOffersList() {
        return offersList;
    }

    public void addDonation(RequestDonation donation) {
        offersList.addRdEntities(donation);
    }

    public void removeDonation(RequestDonation donation) {
        for(RequestDonation index : offersList.rdEntities) {
            if(index.getEntity().getId()== donation.getEntity().getId())
            {
                offersList.remove(index);
            }
        }
    }

    public void viewDonatorDetails() {
        System.out.println("DONATOR NAME: " + getName());
        System.out.println("DONATOR PHONE: " + getPhone());
        System.out.println("DONATOR OFFERS: ");
        offersList.monitor();
    }

}