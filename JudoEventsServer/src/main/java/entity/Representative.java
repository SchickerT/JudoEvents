package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by marcelpautz on 17.07.17.
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name="Representative.findAll",
            query = "SELECT r FROM Representative r"
    )
})
@XmlRootElement
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Lob
    @JsonIgnore
    private byte[] representativePicture;

    public Representative() {

    }

    public Representative(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        //this.representativePicture = picture;
    }

    //region GETTER AND SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getRepresentativePicture() {
        return representativePicture;
    }

    public void setRepresentativePicture(byte[] representativePicture) {
        this.representativePicture = representativePicture;
    }

    //endregion
}
