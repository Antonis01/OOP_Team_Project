class Material extends Entity  {

    private double level1,level2,level3;

    //CONSTRUCTOR
    Material(String name, String description, int id, double level1, double level2, double level3){
        super(name,description,id);
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        setIsMaterial(true);
    }

    public double getLevel1() {
        return level1;
    }

    public double getLevel2() {
        return level2;
    }

    public double getLevel3() {
        return level3;
    }

    String getDetails(){
        return "MATERIAL";
    }
}