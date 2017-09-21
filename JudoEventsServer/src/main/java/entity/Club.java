package entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by marcelpautz on 17.07.17.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name="Club.findAll",
                query = "SELECT c FROM Club c"
        )
})
@XmlRootElement
public class Club implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    private String name;
    private String discription;
    private String email;
    private String password;
    @Lob
    private byte[] picture;

    @OneToOne(cascade = CascadeType.ALL)
    private Representative representative;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Location location;

    public Club(String name, String discription, byte[] picture, Representative representative, Location location,String email,String password) {
        this.name = name;
        this.discription = discription;
        this.picture = picture;
        this.representative = representative;
        this.location = location;
        this.email = email;
        this.password = password;
    }

    public Club() {

    }

    //region GETTER AND SETTER

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
