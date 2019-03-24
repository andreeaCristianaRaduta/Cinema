public class User {
    private String firstName, lastName;
    private Integer id;
    private String email;
    private String password;

    enum type{
        child, student, elder;
    }

    public type aType;

    public User(String firstName, String lastName, Integer id, type aType, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.aType = aType;
        this.email = email;
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(type aType) {
        this.aType = aType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getId() {
        return id;
    }

    public type getType() {
        return aType;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean inDataBase( String email ){
        //to be continued...
    }

    public void createUser( String firstName, String lastName, Integer id, type aType, String email, String password ){
        if( inDataBase( email ) == false ){
            User user = new User(firstName, lastName, id, aType, email, password);
            //bagam in baza de date
            //trimitem email cu datele contului
        }

        else System.out.println("User exists! Try login.");
    }

}
