class RequestDonation {
    private Entity entity;
    private double quantity;
    private double entityLevel1;
    private double entityLevel2;
    private double entityLevel3;

    RequestDonation(Entity entity, double quantity){
        this.entity=entity;
        this.quantity=quantity;
    }

    RequestDonation(Entity entity, double quantity, Material mat){
        this.entity=entity;
        this.quantity=quantity;
        this.entityLevel1 = mat.getLevel1();
        this.entityLevel2 = mat.getLevel2();
        this.entityLevel3 = mat.getLevel3();
    }
    RequestDonation (){}

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public double getEntityLevel1 () {
        return entityLevel1;
    }

    public double getEntityLevel2 () {
        return entityLevel2;
    }

    public double getEntityLevel3 () {
        return entityLevel3;
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}