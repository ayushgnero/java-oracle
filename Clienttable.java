package sample;

import javafx.beans.property.SimpleStringProperty;

public class Clienttable {
    private SimpleStringProperty Name,Mobile,Username,owned;

    public String getName() {
        return Name.get();
    }

    public String nameProperty() {
        return Name.get();
    }

    public void setName(String name) {
        this.Name.set(name);
    }

    public String getMobile() {
        return Mobile.get();
    }

    public String mobileProperty() {
        return Mobile.get();
    }

    public void setMobile(String mobile) {
        this.Mobile.set(mobile);
    }

    public String getUsername() {
        return Username.get();
    }

    public String usernameProperty() {
        return Username.get();
    }

    public void setUsername(String username) {
        this.Username.set(username);
    }

    public String getOwned() {
        return owned.get();
    }

    public String ownedProperty() {
        return owned.get();
    }

    public void setOwned(String owned) {
        this.owned.set(owned);
    }

    public Clienttable (String Name, String Mobile, String Username, String owned)
    {
        this.Name = new SimpleStringProperty(Name);
        this.Mobile = new SimpleStringProperty(Mobile);
        this.Username = new SimpleStringProperty(Username);
        this.owned = new SimpleStringProperty(owned);
    }
}
