abstract class User {
    protected String name;
    protected String phone;

    User(){}

    User(String name,String phone){
        this.name=name;
        this.phone=phone;
    }

    abstract public String getName();

    abstract public void setName(String name);

    abstract public String getPhone();

    abstract public void setPhone(String phone) ;
}
