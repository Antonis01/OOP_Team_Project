import java.util.ArrayList;
class Offers extends RequestDonationList {
    public void commit(Organization organization){
        for(RequestDonation index : this.rdEntities) {
            organization.getCurrentDonations().addRdEntities(index);
        }
        this.rdEntities.clear();
    }
}
