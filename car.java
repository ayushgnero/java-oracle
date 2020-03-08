package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

import javax.swing.text.TableView;

public class car
{
    private SimpleStringProperty EngineNumber,Model,Color,Manufacturer,Owner;
    public car (String EngineNumber,String Model,String Color,String Manufacturer,String Owner)
    {
        this.EngineNumber = new SimpleStringProperty(EngineNumber);
        this.Model = new SimpleStringProperty(Model);
        this.Color = new SimpleStringProperty(Color);
        this.Manufacturer = new SimpleStringProperty(Manufacturer);
        this.Owner = new SimpleStringProperty(Owner);
    }


    public String getOwner() {
        return Owner.get();
    }

    public String ownerProperty() {
        return Owner.get();
    }

    public void setOwner(String owner) {
        this.Owner.set(owner);
    }

    public String getEngineNumber() {
        return EngineNumber.get();
    }

    public String engineNumberProperty() {
        return EngineNumber.get();
    }

    public void setEngineNumber(String engineNumber) {
        this.EngineNumber.set(engineNumber);
    }

    public String getModel() {
        return Model.get();
    }

    public String modelProperty() {
        return Model.get();
    }

    public void setModel(String model) {
        this.Model.set(model);
    }

    public String getColor() {
        return Color.get();
    }

    public String colorProperty() {
        return Color.get();
    }

    public void setColor(String color) {
        this.Color.set(color);
    }

    public String getManufacturer() {
        return Manufacturer.get();
    }

    public String manufacturerProperty() {
        return Manufacturer.get();
    }

    public void setManufacturer(String manufacturer) {
        this.Manufacturer.set(manufacturer);
    }
}
