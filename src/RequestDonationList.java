import java.util.ArrayList;
class RequestDonationList {
    ArrayList<RequestDonation> rdEntities=new ArrayList<RequestDonation>();

    public RequestDonation getRdEntities(RequestDonation reqdon) {
        for (RequestDonation index : rdEntities)
            if (index.getEntity().getId() == reqdon.getEntity().getId()) {
                return index;
            }
        return reqdon; //LATHOS PROS TO PARON theli exeption dame
    }

    public void addRdEntities(RequestDonation reqdon) {
        double newQuantity;
        for (RequestDonation index : rdEntities)
        {
            if(reqdon.getEntity().getId() == index.getEntity().getId())
            {
                newQuantity = index.getQuantity() + reqdon.getQuantity();
                index.setQuantity(newQuantity);
                return;
            }
        }
        rdEntities.add(reqdon); //j dame thorome an exoun to idio id
    }

    public void remove(RequestDonation reqdon) {
        for (RequestDonation index : rdEntities)
            if (index == reqdon) {
                rdEntities.remove(index);
                break;
            }
    }

    public void modify(RequestDonation reqdon, double quantity) {
        for (RequestDonation index : rdEntities)
            if (index == reqdon) {
                index.setQuantity(quantity);
            }
    }

    public void monitor() {
        for (RequestDonation index : rdEntities) {
            System.out.println(index.getEntity().getEntityInfo() + " QUANTITY: " + index.getQuantity());
        }
    }

    public void reset() {
        for (RequestDonation index : rdEntities) {
            rdEntities.remove(index);
        }
    }
}