/*Αντιστοιχεί στον οργανισμό που υποστηρίζει το σύστημα donation.*/
import java.util.ArrayList;
class Organization
{
     private String name;
     private Admin admin;
     private ArrayList<Entity> entityList = new ArrayList<Entity>();
     private ArrayList<Donator> donatorList = new ArrayList<Donator>();
     private ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
     private RequestDonationList currentDonations = new RequestDonationList();


    Organization(){}
    Organization(String name) {
        this.name = name;
        ArrayList<Entity> entityList = new ArrayList<Entity>();
        ArrayList<Donator> donatorList = new ArrayList<Donator>();
        ArrayList<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
        RequestDonationList currentDonations = new RequestDonationList();
    }


    public ArrayList<Donator> getDonatorsArrayList() {
        return donatorList;
    }

    public ArrayList<Beneficiary> getBeneficiaryArrayList() {
        return beneficiaryList;
    }

    public void setBeneficiaryList(ArrayList<Beneficiary> beneficiaryList) {
        this.beneficiaryList = beneficiaryList;
    }

    void setAdmin(Admin new_admin) {
        admin = new_admin;
    }

    Admin getAdmin() {
        return admin;
    }

    public RequestDonationList getCurrentDonations() {
        return currentDonations;
    }


    public String getName() {
        return name;
    }

    public void addEntity(Entity new_entity) {
        entityList.add(new_entity);
    }

    public void removeEntity(Entity removed_entity) {
        entityList.remove(removed_entity);
    }

    public void insertDonator(Donator new_donator) {
        donatorList.add(new_donator);
    }

    public void removeDonator(Donator removed_donator) {
        donatorList.clear();
    }

    public void insertBeneficiary(Beneficiary new_beneficiary) {
        beneficiaryList.add(new_beneficiary);
    }


    public void removeBeneficiary(int choice) {
        int cnt=0;

        for (int i = 0; i < beneficiaryList.size(); i++) {
            if((choice-1) == i) {
                beneficiaryList.remove(choice-1);
                cnt++;
                System.out.println("Beneficiary has been deleted!");
            }
        }

        if(cnt==0){
            System.out.println("Beneficiary " + name + " not found!"); }
            }

    public void removeBeneficiaryReceivedList(int choice) {
        for (int i = 0; i < beneficiaryList.size(); i++) {
            if((choice-1) == i) {
                beneficiaryList.get(choice-1).clearRecievedList();
                System.out.println("Beneficiary's received list cleared");
            }
        }
    }

    public void removeCurrentDonation(int id,double quantity) {
        for(RequestDonation index : currentDonations.rdEntities ) {
            if(id == index.getEntity().getId()) {
                index.setQuantity(index.getQuantity()-quantity);
            }
        }

    }

    public void clearBeneficiaryRequests () {
        for(Beneficiary index : beneficiaryList) {
            index.clearRecievedList();
        }
    }



    //------------------------------------------------------------------LISTING

    void listEntities() {
        System.out.println("<This is the list of "+ getName() +" Entities>");
        System.out.println();
        for (Entity index : entityList) {
            System.out.println(index.toString());
            System.out.println();
        }
    }

    void listBeneficiaries() {
        int cnt = 0;
        System.out.println("<This is the list of "+ getName() +" Beneficiaries>");
        System.out.println();
        for (Beneficiary index : beneficiaryList) {
            System.out.println(++cnt);
            index.viewBeneficiaryDetails();
        }
    }

    void listDonators() {
        System.out.println("<This is the list of "+ getName() +" Donators>");
        System.out.println();
        for (Donator index : donatorList) {
            index.viewDonatorDetails();
        }
    }

    void listCurrentDonations() {
        System.out.println("<This is the list of "+ getName() +" Current Donations>");
        System.out.println();
        currentDonations.monitor();
    }

    void listMaterials() {
        int cnt=0;
        System.out.println("<This is the list of " + getName() + " Materials>");
        System.out.println();
        for (Entity index : entityList) {
            if (index.getIsMaterial())
                System.out.println(++cnt + ". " + index.toString());
            System.out.println();
        }
    }

    void listServices() {
        int cnt=0;
        System.out.println("<This is the list of " + getName() + " Services>");
        System.out.println();
        for (Entity index : entityList) {
            if (!(index.getIsMaterial()))
                System.out.println(++cnt + ". " + index.toString());
            System.out.println();
        }
    }
}