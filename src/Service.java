class Service extends Entity {
    public Service(String name, String description, int id) {
        super(name, description, id);
        setIsMaterial(false);
    }

    @Override
    String getDetails() {
        return "SERVICE";
    }
}