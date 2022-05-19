import java.lang.String;

abstract class Entity {
    private String name;            //onoma
    private String description;    //sintomi perigrafi
    private int id;               //kodikos
    protected boolean isMaterial;

    public Entity(String name, String description, int id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setIsMaterial(boolean x) {
        isMaterial=x;
    }

    public boolean getIsMaterial() {
        return isMaterial;
    }

    public String getEntityInfo(){
        return "\nName: " + getName() + "\nDescription: " + getDescription() + "\nID: " +  getId();
    }

    abstract String getDetails();

    @Override
    public String toString(){
        return "--------------------" + getDetails() +"\n"+ getEntityInfo();
    }
}
