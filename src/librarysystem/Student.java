package librarysystem;

/**
 *
 * @author Renata, Suellen
 */

public class Student {

    private Long id;
    private String name;
    private String address;

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //print student details
    @Override
    public String toString() {
        return "\n_______________\n"
                + "ID = " + id + "\n"
                + "Name = " + name + "\n"
                + "Address = " + address;
    }

}
