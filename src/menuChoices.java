class menuChoices {

    public void lines() {
        //klasi pou tiponei grammes gia morfopiisi
        System.out.println("=====================================");
    }

    public void RegMes() {
        lines();
        System.out.println("What do you want register as?");
        lines();
        System.out.println("1. Donator");
        System.out.println("2. Beneficiary");
        System.out.println("Give the number of your choice:");

    }


    public void LogMes() {
        lines();
        System.out.println("What do you want log-in as?");
        lines();
        System.out.println("1. Donator");
        System.out.println("2. Beneficiary");
        System.out.println("3. Admin.");
        System.out.println("Give the number of your choice:");

    }


    public void menuListDonator() {
        System.out.println("1. Add Offer");
        System.out.println("2. Show Offers");
        System.out.println("3. Commit");
        System.out.println("4. Back");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        lines();
        System.out.println("Give the number of your choice:");
    }

    public void menuListBeneficiary() {
        System.out.println("1. Add Request");
        System.out.println("2. Show Request");
        System.out.println("3. Commit");
        System.out.println("4. Back");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        lines();
        System.out.println("Give the number of your choice:");
    }

    public void menuListAdmin() {
        System.out.println("1. View");
        System.out.println("2. Monitor Organization");
        System.out.println("3. Back");
        System.out.println("4. Logout");
        System.out.println("5. Exit");
        lines();
        System.out.println("Give the number of your choice:");
    }

    public void MatSer() {
        System.out.println("1. Material:");
        System.out.println("2. Service:");
        System.out.println("Give the number of your choice...");
    }


    public void BenDonRes() {
        System.out.println("1. List Beneficiaries");
        System.out.println("2. List Donators");
        System.out.println("3. Reset Beneficiary List");
    }

    public void MonitorListBeneficiaries(){
        System.out.println("1. Current State.");
        System.out.println("2. Clear the received list of a specified beneficiary.");
        System.out.println("3. Delete a specified beneficiary.");
    }

    public void MonitorListDonator(){
        System.out.println("1. Current State.");
        System.out.println("2. Delete all the donators.");
    }
}