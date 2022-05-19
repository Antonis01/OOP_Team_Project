class Requests extends RequestDonationList
{
    double allowedq;
    double recievedq;



    public boolean validRequestDonation(RequestDonation request, Beneficiary ben, Organization org){
        recievedq = 0;

        boolean exists = false;
        for(RequestDonation index : org.getCurrentDonations().rdEntities) {
            if(request.getEntity().getId() == index.getEntity().getId() ) {
                exists = true;
            }
        }


        if(ben.getNoPerson() == 1) {
            allowedq = request.getEntityLevel1();
        }
        else if(ben.getNoPerson() >=2 && ben.getNoPerson() <=4) {
            allowedq = request.getEntityLevel2();
        }
        else if(ben.getNoPerson() >=5) {
            allowedq = request.getEntityLevel3();
        }

        for(RequestDonation index : ben.getReceivedList().rdEntities) {
            if(request.getEntity().getId()==index.getEntity().getId()) {
                recievedq += index.getQuantity();
            }
        }

        for(RequestDonation index : ben.getRequestsList().rdEntities) {
            if(request.getEntity().getId() == index.getEntity().getId()) {
                recievedq += index.getQuantity();
            }
        }

        if(request.getEntity().getIsMaterial()==false && exists && (request.getQuantity()+recievedq <= org.getCurrentDonations().getRdEntities(request).getQuantity()) ) {
            return true;
        }


        if((request.getQuantity() <= allowedq) && (request.getQuantity()+recievedq <= allowedq) && exists && (request.getQuantity()+recievedq <= org.getCurrentDonations().getRdEntities(request).getQuantity())) {
            return true;
        }
        else return false;
    }

    public void addRequest(RequestDonation request,Beneficiary ben,Organization org) {
        if(validRequestDonation(request, ben, org)) {
            ben.getRequestsList().addRdEntities(request);
            System.out.println(request.getEntity().getName() + " Request Added Succesfully");
        }
        else {
            System.out.println(request.getEntity().getName() + " Request DENIED");
        }

        }

    public void commit(Organization organization, Beneficiary beneficiary){

        for(RequestDonation index : beneficiary.getRequestsList().rdEntities) {
            organization.removeCurrentDonation(index.getEntity().getId(), index.getQuantity());
        }

        for(RequestDonation index : beneficiary.getRequestsList().rdEntities) {
            beneficiary.getReceivedList().rdEntities.add(index);
        }


        beneficiary.getRequestsList().rdEntities.clear();
    }

    } //O SINDIASMOS TWN VALID REQUEST DONATION J COMMIT AFIINEI TON BEN NA PIANEI PANTA ENA PIO LIO APOTI DIKEOUTE
