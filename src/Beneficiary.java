import java.util.ArrayList;

class Beneficiary extends User {

    private int noPersons=1;
    private RequestDonationList receivedList=new RequestDonationList();
    private Requests requestsList=new Requests();

    Beneficiary(){}

    Beneficiary(String name, String phone, int noPersons){
        super(name,phone);
        this.noPersons=noPersons;
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

    public int getNoPerson(){
        return noPersons;
    }

    public void setNoPersons(int noPersons) {
        this.noPersons = noPersons;
    }

    public void setNoPerson(int noPerson){
        this.noPersons=noPerson;
    }

    public RequestDonationList getReceivedList() {
        return receivedList;
    }

    public Requests getRequestsList() {

        return requestsList;
    }

    public void clearRecievedList() {
        receivedList.rdEntities.clear();
    }

    public void viewBeneficiaryDetails() {
        System.out.println("BENEFICIARY NAME: " + getName());
        System.out.println("BENEFICIARY PHONE: " + getPhone());
        System.out.println("BENEFICIARY MEMBERS: " + getNoPerson());
        System.out.println("BENEFICIARY REQUESTS: ");
        requestsList.monitor();
        System.out.println();
        System.out.println("BENEFICIARY RECIEVED:");
        receivedList.monitor();
        System.out.println();
    }
}