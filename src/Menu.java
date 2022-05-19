import java.util.*;

class Menu {

    private Organization org = new Organization("Sweet Home");

    private static Material milk=new Material("Milk","1L",11,1,3,5);
    private static Material sugar=new Material("Sugar","1kg",12,1,2,4);
    private static Material rice=new Material("Rice","1kg",13,1,3,5);
    private static Service medicalSupport=new Service("Medical Support","medical support", 21);
    private static Service nurserySupport=new Service("Nursery Support","nursery support",22);
    private static Service babySitting=new Service("Baby Sitting","baby sitting",23);

    public static void creating(Organization org){
        org.addEntity(milk);
        org.addEntity(sugar);
        org.addEntity(rice);
        org.addEntity(medicalSupport);
        org.addEntity(nurserySupport);
        org.addEntity(babySitting);
    }

    public Material getMilk() {
        return milk;
    }

    public Material getSugar() {
        return sugar;
    }

    public Material getRice() {
        return rice;
    }

    public Service getMedicalSupport() {
        return medicalSupport;
    }

    public Service getNurserySupport() {
        return nurserySupport;
    }

    public Service getBabySitting() {
        return babySitting;
    }

    private Donator donator=new Donator();
    private Beneficiary beneficiary=new Beneficiary();

    public void menu(){
        creating(org);
        menuChoices mC = new menuChoices();
        double quantity;
        RequestDonation milkDonation, sugarDonation,riceDonation, milkRequest,sugarRequest,riceRequest;
        RequestDonation medicalSupportDonation, nurserySupportDonation, babySittingSupportDonation, medicalSupportRequest, nurserySupportRequest, babySittingSupportRequest;
        char option;
        String adminPhone = " ", adminName = " ", benName = " ", benPhone = " ", donatorPhone = " ", donatorName = " ";
        Scanner scan = new Scanner(System.in);

        theLabelLogOut:
        while (true) {
            try {



                mC.lines();
                System.out.println("Welcome to "+ org.getName()+ "!\n1. Register.\n2. Login.");
                option = scan.next().charAt(0);
                switch (option) {
                    //register case
                    case '1': //register donator and benefeciary users(creating their objects and saving the in the arrayList of each type)

                        mC.RegMes();
                        try {
                            option = scan.next().charAt(0);
                            switch (option) {
                                case '1':
                                    //register as a Donator
                                    mC.lines();

                                    System.out.println("Give your name...");
                                    donatorName = scan.next();

                                    System.out.println("Give mobile phone number...");
                                    donatorPhone = scan.next();

                                    donator = new Donator(donatorName, donatorPhone);
                                    org.insertDonator(donator);
                                    System.out.println(donatorName + " registered successfully with the phone number " + donatorPhone + ".");
                                    continue theLabelLogOut;

                                case '2':
                                    //register as a Beneficiary
                                    mC.lines();

                                    int noPerson;

                                    System.out.println("Give your name...");
                                    benName = scan.next();

                                    System.out.println("Give mobile phone number...");
                                    benPhone = scan.next();

                                    System.out.println("Give the total people of your family...");
                                    noPerson = scan.nextInt();

                                    beneficiary = new Beneficiary(benName, benPhone, noPerson);

                                    System.out.println(beneficiary.getName() + " you successfully registered as a beneficiary with mobile phone number " + beneficiary.getPhone() + " with a family of " + beneficiary.getNoPerson());
                                    org.insertBeneficiary(beneficiary);
                                    continue theLabelLogOut;

                                default:
                                    mC.lines();
                                    System.out.println("Wrong input");
                                    mC.lines();
                                    continue theLabelLogOut;
                            }
                        } catch (NumberFormatException ex) {
                            //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                            System.out.println("Not a valid input");

                        } catch (InputMismatchException ime) {
                            System.out.println("Not a valid input");
                        }


                    case '2'://login and system choices for each  type of user
                        theLabelBack:
                        while (true) {
                            //log-in case
                            mC.LogMes();
                            try {
                                option =scan.next().charAt(0);
                                switch (option) {
                                    case '1':         //log-in as a donator
                                        mC.lines();
                                        try {
                                            System.out.println("Give your name...");
                                            donatorName = scan.next();
                                            System.out.println("Give mobile phone number...");
                                            donatorPhone = scan.next();

                                            for (int i = 0; i < org.getDonatorsArrayList().size(); i++) {
                                                if ((donatorName.compareTo(org.getDonatorsArrayList().get(i).getName()) == 0 && donatorPhone.equals(org.getDonatorsArrayList().get(i).getPhone()))) {

                                                    System.out.println("Logged in...\n" + donatorName + " welcome back!");
                                                    mC.lines();
                                                    try {
                                                        LabelDonatorMenu:
                                                        while (true) {

                                                            mC.menuListDonator();
                                                            option = scan.next().charAt(0);

                                                            switch (option) {

                                                                case '1':
                                                                    mC.lines();
                                                                    mC.MatSer();
                                                                    option = scan.next().charAt(0);
                                                                    mC.lines();
                                                                    switch (option) {
                                                                        case '1':
                                                                            System.out.println();
                                                                            System.out.println("Please type what of the following Materials you want to add to our stock :");
                                                                            mC.lines();
                                                                            org.listMaterials();
                                                                            mC.lines();
                                                                            System.out.print("Type here...");
                                                                            option = scan.next().charAt(0);
                                                                            switch (option) {
                                                                                case '1':
                                                                                    System.out.println("You chose to offer " + getMilk().getName());
                                                                                    System.out.println("How much " + getMilk().getName() + " do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    milkDonation = new RequestDonation(getMilk(), quantity, getMilk());
                                                                                    donator.addDonation(milkDonation);
                                                                                    continue LabelDonatorMenu;

                                                                                case '2':
                                                                                    System.out.println("You chose to offer " + getSugar().getName());
                                                                                    System.out.println("How much " + getSugar().getName() + " do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    sugarDonation = new RequestDonation(getSugar(), quantity, getSugar());
                                                                                    donator.addDonation(sugarDonation);
                                                                                    continue LabelDonatorMenu;

                                                                                case '3':
                                                                                    System.out.println("You chose to offer " + getRice().getName());
                                                                                    System.out.println("How much " + getRice().getName() + " do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    riceDonation = new RequestDonation(getRice(), quantity, getRice());
                                                                                    donator.addDonation(riceDonation);
                                                                                    continue LabelDonatorMenu;
                                                                                default:
                                                                                    mC.lines();
                                                                                    System.out.println("Wrong input");
                                                                                    mC.lines();
                                                                                    continue LabelDonatorMenu;

                                                                            }

                                                                        case '2':
                                                                            System.out.println();
                                                                            System.out.println("Please type what of the following Servives you want to add to our stock :");
                                                                            mC.lines();
                                                                            org.listServices();
                                                                            mC.lines();
                                                                            System.out.print("Type here :");
                                                                            option = scan.next().charAt(0);
                                                                            switch (option) {
                                                                                case '1':
                                                                                    System.out.println("You chose to offer " + getMedicalSupport().getName());
                                                                                    System.out.println("How much " + getMedicalSupport().getName() + " hours do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    medicalSupportDonation = new RequestDonation(getMedicalSupport(), quantity);
                                                                                    donator.addDonation(medicalSupportDonation);
                                                                                    continue LabelDonatorMenu;
                                                                                case '2':
                                                                                    System.out.println("You chose to offer " + getNurserySupport().getName());
                                                                                    System.out.println("How much " + getNurserySupport().getName() + " hours do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    nurserySupportDonation = new RequestDonation(getNurserySupport(), quantity);
                                                                                    donator.addDonation(nurserySupportDonation);
                                                                                    continue LabelDonatorMenu;
                                                                                case '3':
                                                                                    System.out.println("You chose to offer " + getBabySitting().getName());
                                                                                    System.out.println("How much " + getBabySitting().getName() + " hours do you want to offer");
                                                                                    quantity = scan.nextDouble();
                                                                                    babySittingSupportDonation = new RequestDonation(getBabySitting(), quantity);
                                                                                    donator.addDonation(babySittingSupportDonation);
                                                                                    continue LabelDonatorMenu;
                                                                                default:
                                                                                    mC.lines();
                                                                                    System.out.println("Wrong input");
                                                                                    mC.lines();
                                                                                    continue LabelDonatorMenu;
                                                                            }
                                                                    }
                                                                case '2': //SHOW OFFERS

                                                                    donator.getOffersList().monitor();
                                                                    continue LabelDonatorMenu;
                                                                case '3': //COMMIT
                                                                    donator.offersList.commit(org);
                                                                    continue LabelDonatorMenu;
                                                                case '4': //BACK
                                                                    continue theLabelBack;

                                                                case '5': //LOGOUT
                                                                    System.out.println("Logging out...");
                                                                    Thread.sleep(500);
                                                                    System.out.println("Logged out successfully!!!");
                                                                    continue theLabelLogOut;

                                                                case '6': //EXIT
                                                                    System.out.println("Logging out...");
                                                                    Thread.sleep(500);
                                                                    System.out.println("Logged out successfully!!!");
                                                                    Thread.sleep(1000);
                                                                    System.out.println("Exiting System!");
                                                                    System.exit(0);
                                                                    continue theLabelLogOut;

                                                                default:
                                                                    mC.lines();
                                                                    System.out.println("Wrong input");
                                                                    mC.lines();
                                                                    continue LabelDonatorMenu;
                                                            }
                                                        }
                                                    } catch (InputMismatchException ime2) {
                                                        //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                        System.out.println("Not a valid input");
                                                    } catch (InterruptedException e) {
                                                        System.out.println("Not a valid input");
                                                    }

                                                }

                                            }
                                            for (int i = 0; i < org.getDonatorsArrayList().size(); i++) {
                                                if (!(donatorName.compareTo(org.getDonatorsArrayList().get(i).getName()) == 0 && donatorPhone.equals(org.getDonatorsArrayList().get(i).getPhone()))) {
                                                    System.out.println("You are not registered to the system!");
                                                    continue theLabelLogOut;
                                                }
                                            }


                                            continue theLabelLogOut;

                                        } catch (NullPointerException npe) {
                                            System.out.println(npe);
                                        }
                                        mC.lines();
                                        continue theLabelLogOut;


                                    case '2':         //log-in as a beneficiary
                                        mC.lines();

                                        try {
                                            System.out.println("Give your name...");
                                            benName = scan.next();
                                            System.out.println("Give mobile phone number...");
                                            benPhone = scan.next();

                                            for (int i = 0; i < org.getBeneficiaryArrayList().size(); i++) {
                                                if ((benName.compareTo(org.getBeneficiaryArrayList().get(i).getName()) == 0 && benPhone.compareTo(org.getBeneficiaryArrayList().get(i).getPhone()) == 0)) {
                                                    System.out.println("Logged in...\n"+ benName + " welcome back!");
                                                    mC.lines();
                                                    try {
                                                        LabelBeneficiaryMenu:
                                                        while (true) {

                                                            mC.menuListBeneficiary();
                                                            option = scan.next().charAt(0);

                                                            switch (option) {

                                                                case '1':

                                                                    mC.MatSer();
                                                                    option = scan.next().charAt(0);
                                                                    switch (option) {
                                                                        case '1':
                                                                            System.out.println();
                                                                            System.out.println("Please type what of the following Materials you want to request :");
                                                                            mC.lines();
                                                                            org.listMaterials();
                                                                            mC.lines();
                                                                            System.out.print("Type here : ");
                                                                            option = scan.next().charAt(0);
                                                                            switch (option) {
                                                                                case '1':
                                                                                    System.out.println("You chose to request " + getMilk().getName());
                                                                                    System.out.println("How much " + getMilk().getName() + " do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    milkRequest = new RequestDonation(getMilk(), quantity, getMilk());
                                                                                    beneficiary.getRequestsList().addRequest(milkRequest, beneficiary, org);
                                                                                    //    beneficiary.getRequestsList().addRdEntities();
                                                                                    continue LabelBeneficiaryMenu;

                                                                                case '2':
                                                                                    System.out.println("You chose to request " + getSugar().getName());
                                                                                    System.out.println("How much " + getSugar().getName() + " do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    sugarRequest = new RequestDonation(getSugar(), quantity, getSugar());
                                                                                    beneficiary.getRequestsList().addRequest(sugarRequest, beneficiary, org);
                                                                                    continue LabelBeneficiaryMenu;

                                                                                case '3':
                                                                                    System.out.println("You chose to request " + getRice().getName());
                                                                                    System.out.println("How much " + getRice().getName() + " do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    riceRequest = new RequestDonation(getRice(), quantity, getRice());
                                                                                    beneficiary.getRequestsList().addRequest(riceRequest, beneficiary, org);
                                                                                    continue LabelBeneficiaryMenu;

                                                                                default:
                                                                                    mC.lines();
                                                                                    System.out.println("Wrong input");
                                                                                    mC.lines();
                                                                                    continue LabelBeneficiaryMenu;
                                                                            }

                                                                        case '2':
                                                                            System.out.println();
                                                                            System.out.println("Please type what of the following Servives you want to request :");
                                                                            mC.lines();
                                                                            org.listServices();
                                                                            mC.lines();
                                                                            System.out.print("Type here :");
                                                                            option = scan.next().charAt(0);
                                                                            switch (option) {
                                                                                case '1':
                                                                                    System.out.println("You chose to request " + getMedicalSupport().getName());
                                                                                    System.out.println("How much " + getMedicalSupport().getName() + " hours do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    medicalSupportRequest = new RequestDonation(getMedicalSupport(), quantity);
                                                                                    beneficiary.getRequestsList().addRequest(medicalSupportRequest, beneficiary, org);
                                                                                    continue LabelBeneficiaryMenu;

                                                                                case '2':
                                                                                    System.out.println("You chose to request " + getNurserySupport().getName());
                                                                                    System.out.println("How much " + getNurserySupport().getName() + " hours do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    nurserySupportRequest = new RequestDonation(getNurserySupport(), quantity);
                                                                                    beneficiary.getRequestsList().addRequest(nurserySupportRequest, beneficiary, org);
                                                                                    continue LabelBeneficiaryMenu;

                                                                                case '3':
                                                                                    System.out.println("You chose to request " + getBabySitting().getName());
                                                                                    System.out.println("How much " + getBabySitting().getName() + " hours do you want to request");
                                                                                    quantity = scan.nextDouble();
                                                                                    babySittingSupportRequest = new RequestDonation(getBabySitting(), quantity);
                                                                                    beneficiary.getRequestsList().addRequest(babySittingSupportRequest, beneficiary, org);
                                                                                    continue LabelBeneficiaryMenu;

                                                                                default:
                                                                                    mC.lines();
                                                                                    System.out.println("Wrong input");
                                                                                    mC.lines();
                                                                                    continue LabelBeneficiaryMenu;
                                                                            }
                                                                        default:
                                                                            mC.lines();
                                                                            System.out.println("Wrong input");
                                                                            mC.lines();
                                                                            continue LabelBeneficiaryMenu;

                                                                    }

                                                                case '2': //SHOW REQUESTS
                                                                    beneficiary.getRequestsList().monitor();
                                                                    continue LabelBeneficiaryMenu;

                                                                case '3': //COMMIT
                                                                    beneficiary.getRequestsList().commit(org, beneficiary);

                                                                    continue LabelBeneficiaryMenu;

                                                                case '4': //BACK
                                                                    continue theLabelBack;

                                                                case '5': //LOGOUT
                                                                    System.out.println("Logging out...");
                                                                    Thread.sleep(500);
                                                                    System.out.println("Logged out successfully!!!");
                                                                    continue theLabelLogOut;

                                                                case '6': //EXIT
                                                                    System.out.println("Logging out...");
                                                                    Thread.sleep(500);
                                                                    System.out.println("Logged out successfully!!!");
                                                                    Thread.sleep(1000);
                                                                    System.out.println("Exiting System!");
                                                                    System.exit(0);
                                                                    continue theLabelLogOut;

                                                                default:
                                                                    System.out.println("Wrong Input");
                                                                    continue LabelBeneficiaryMenu;

                                                            }
                                                        }
                                                    } catch (InputMismatchException ime2) {
                                                        //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                        System.out.println("Give a valid number");
                                                    } catch (InterruptedException e) {
                                                        System.out.println(e);
                                                    }
                                                    continue theLabelLogOut;

                                                }
                                            }


                                            for (int i = 0; i < org.getBeneficiaryArrayList().size(); i++) {
                                                if ((benName.compareTo(org.getBeneficiaryArrayList().get(i).getName()) == 0 && benPhone.compareTo(org.getBeneficiaryArrayList().get(i).getPhone()) == 0)) {
                                                    System.out.println(benName + " you are not registered to the system!");
                                                    continue theLabelLogOut;
                                                }
                                            }


                                        } catch (NullPointerException npe) {
                                            System.out.println(npe);
                                        }
                                        mC.lines();


                                    case '3':
                                        //log-in as an Admin, admin is a pre-created object.
                                        mC.lines();
                                        String name = " ", phone = " ";
                                        Admin admin = new Admin("Admin", "12345678");

                                        System.out.println("Give your name...");
                                        name = scan.next();

                                        if (!name.equals(admin.getName())) {
                                            System.out.println("Wrong Admin name");
                                            continue theLabelLogOut;
                                        }

                                        System.out.println("Give admin login code:");
                                        int AdminCode = scan.nextInt();
                                        if (AdminCode != 7438) {
                                            System.out.println("Wrong Admin Code");
                                            continue theLabelLogOut;
                                        }


                                        System.out.println("Give mobile phone number...");
                                        phone = scan.next();

                                        if (!phone.equals(admin.getPhone())) {
                                            System.out.println("Wrong Admin phone");
                                            continue theLabelLogOut;
                                        }

                                        System.out.println("Logged in...\n"+ admin.getName() +" welcome back!");

                                        LabelAdminMenu:
                                        while (true) {
                                            mC.lines();
                                            mC.menuListAdmin();
                                            option = scan.next().charAt(0);


                                            try {


                                                switch (option) {

                                                    case '1':         //view
                                                        mC.MatSer();
                                                        option = scan.next().charAt(0);

                                                        try {
                                                            switch (option) {
                                                                case '1':
                                                                    org.listMaterials();
                                                                    continue LabelAdminMenu;

                                                                case '2':
                                                                    org.listServices();
                                                                    continue LabelAdminMenu;

                                                                default:
                                                                    mC.lines();
                                                                    System.out.println("Wrong input");
                                                                    mC.lines();
                                                                    continue LabelAdminMenu;
                                                            }
                                                        } catch (InputMismatchException ime) {
                                                            //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                            System.out.println("Give a valid number");
                                                        }

                                                        continue LabelAdminMenu;

                                                    case '2':     //monitor organization
                                                        mC.BenDonRes();
                                                        option = scan.next().charAt(0);

                                                        try {
                                                            switch (option) {
                                                                case '1':             //case for beneficiary
                                                                    try {
                                                                        mC.MonitorListBeneficiaries();
                                                                        option = scan.next().charAt(0);
                                                                        switch (option) {
                                                                            case '1':
                                                                                org.listBeneficiaries();

                                                                                break;

                                                                            case '2':
                                                                                System.out.println("Give the number of the beneficiary whom their received list you want to be cleared.");
                                                                                int num = scan.nextInt();
                                                                                org.removeBeneficiaryReceivedList(num);
                                                                                break;

                                                                            case '3':
                                                                                System.out.println("Give the number of the beneficiary whom you want to be removed.");
                                                                                num = scan.nextInt();
                                                                                org.removeBeneficiary(num);
                                                                                break;

                                                                            default:
                                                                                break;

                                                                        }
                                                                    } catch (InputMismatchException ime3) {
                                                                        //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                                        System.out.println("Give a valid number");
                                                                    }

                                                                    continue LabelAdminMenu;

                                                                case '2':             //case for donator

                                                                    try {
                                                                        mC.MonitorListDonator();
                                                                        option = scan.next().charAt(0);
                                                                        switch (option) {
                                                                            case '1':
                                                                                org.listDonators();
                                                                                org.listCurrentDonations();
                                                                                break;

                                                                                case '2':
                                                                                    org.removeDonator(donator);
                                                                                    System.out.println("Donators deleted successfully");
                                                                                    break;

                                                                                    default:
                                                                                        break;

                                                                        }
                                                                    } catch (InputMismatchException ime3) {
                                                                                    //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                                                    System.out.println("Give a valid number");
                                                                                }


                                                                                continue LabelAdminMenu;


                                                                case '3':             //case for clearing the received list of all the beneficiaries
                                                                    org.clearBeneficiaryRequests();
                                                                    System.out.println("Beneficiaries Recieved List Deleted Succesfully");
                                                                    continue LabelAdminMenu;
                                                            }
                                                        } catch (InputMismatchException ime3) {
                                                            //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                            System.out.println("Give a valid number");
                                                        }
                                                        continue LabelAdminMenu;

                                                    case '3':
                                                        System.out.println("Previous step...");
                                                        continue theLabelBack;

                                                    case '4':
                                                        System.out.println("Logging out...");
                                                        Thread.sleep(500);
                                                        System.out.println("Logged out successfully!!!");
                                                        continue theLabelLogOut;

                                                    case '5':
                                                        System.out.println("Logging out...");
                                                        Thread.sleep(500);
                                                        System.out.println("Logged out successfully!!!");
                                                        Thread.sleep(1000);
                                                        System.out.println("Exiting System!");
                                                        System.exit(0);
                                                        continue theLabelLogOut;

                                                    default:
                                                        System.out.println("Wrong Input");
                                                        continue LabelAdminMenu;

                                                }

                                            } catch (InputMismatchException ime2) {
                                                //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                                System.out.println("Give a valid number");
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                            continue LabelAdminMenu;

                                        }

                                }
                            } catch (InputMismatchException ime) {
                                //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                                System.out.println("Give a valid number");
                            }
                        }


                    default:
                        mC.lines();
                        System.out.println("Wrong input");
                        // systemLogin();
                        mC.lines();
                        continue theLabelLogOut;
                }


            } catch (NumberFormatException ex) {
                //Exception gia tin periptosi opou o xristi dosei kati ektos apo arithmo
                System.out.println("Not a valid input");
            } catch (InputMismatchException ime) {
                System.out.println("Not a valid input");
            }

        }

    }
}