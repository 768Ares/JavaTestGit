package com.storm.fx.model;
import java.time.LocalDate;
import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonViewModel {
    private StringProperty nameProperty = new SimpleStringProperty();
    private BooleanProperty nameOkProperty = new SimpleBooleanProperty(false);
    private StringProperty surnameProperty = new SimpleStringProperty();
    private BooleanProperty surnameOkProperty = new SimpleBooleanProperty(false);
    private BooleanProperty surnameDisableProperty = new SimpleBooleanProperty(true);
    private IntegerProperty yearProperty = new SimpleIntegerProperty();
    private BooleanProperty confirmProperty = new SimpleBooleanProperty(false);
    private StringProperty ageProperty = new SimpleStringProperty();
    private BooleanProperty buttonProperty = new SimpleBooleanProperty(false);
    private IntegerProperty actualYearProperty = new SimpleIntegerProperty(LocalDate.now().getYear());

    public PersonViewModel() {
       nameOkProperty.bind(nameProperty.isNotEmpty());
       surnameOkProperty.bind(surnameProperty.isNotEmpty());
       surnameDisableProperty.bind(nameProperty.isEmpty());
       buttonProperty.bind(confirmProperty.not());
       ageProperty.bind(new When(yearProperty.greaterThan(0))
               .then(actualYearProperty.subtract(yearProperty).asString())
               .otherwise(""));

    }


    public BooleanProperty getButtonProperty() {
        return buttonProperty;
    }

    public void setButtonProperty(BooleanProperty buttonProperty) {
        this.buttonProperty = buttonProperty;
    }

    public IntegerProperty getActualYearProperty() {
        return actualYearProperty;
    }

    public void setActualYearProperty(IntegerProperty actualYearProperty) {
        this.actualYearProperty = actualYearProperty;
    }

    public BooleanProperty getDisableSurnameProperty() {
        return surnameDisableProperty;
    }

    public void setDisableSurnameProperty(BooleanProperty disableSurnameProperty) {
        this.surnameDisableProperty = disableSurnameProperty;
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    public void setNameProperty(StringProperty nameProperty) {
        this.nameProperty = nameProperty;
    }

    public StringProperty getSurnameProperty() {
        return surnameProperty;
    }

    public void setSurnameProperty(StringProperty surnameProperty) {
        this.surnameProperty = surnameProperty;
    }

    public IntegerProperty getYearProperty() {
        return yearProperty;
    }

    public void setYearProperty(IntegerProperty yearProperty) {
        this.yearProperty = yearProperty;
    }

    public BooleanProperty getConfirmProperty() {
        return confirmProperty;
    }

    public void setConfirmProperty(BooleanProperty confirmProperty) {
        this.confirmProperty = confirmProperty;
    }

    public StringProperty getAgeProperty() {
        return ageProperty;
    }

    public void setAgeProperty(StringProperty ageProperty) {
        this.ageProperty = ageProperty;
    }

    public BooleanProperty getNameOkProperty() {
        return nameOkProperty;
    }

    public void setNameOkProperty(BooleanProperty nameOkProperty) {
        this.nameOkProperty = nameOkProperty;
    }

    public BooleanProperty getSurnameOKProperty() {
        return surnameOkProperty;
    }

    public void setSurnameOKProperty(BooleanProperty surnameOKProperty) {
        this.surnameOkProperty = surnameOKProperty;
    }
}
