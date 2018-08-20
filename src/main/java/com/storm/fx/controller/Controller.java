package com.storm.fx.controller;

import com.storm.fx.model.PersonViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class Controller {
    @FXML
    private TextField nameTextField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label surnameLabel;

    @FXML
    private TextField yearTextField;

    @FXML
    private CheckBox confirmCheckBox;

    @FXML
    private Button logginButton;

    @FXML
    private Label ageLabel;

    private PersonViewModel personViewModel = new PersonViewModel();

    @FXML
    public void initialize() {
        nameTextField.textProperty().bindBidirectional(personViewModel.getNameProperty());
        nameLabel.visibleProperty().bind(personViewModel.getNameOkProperty());

        surnameTextField.textProperty().bindBidirectional(personViewModel.getSurnameProperty());
        surnameLabel.visibleProperty().bind(personViewModel.getSurnameOKProperty());
        surnameTextField.disableProperty().bind(personViewModel.getDisableSurnameProperty());

        StringConverter converter = new NumberStringConverter();
        yearTextField.textProperty().bindBidirectional(personViewModel.getYearProperty(), converter);

        confirmCheckBox.selectedProperty().bindBidirectional(personViewModel.getConfirmProperty());

        ageLabel.textProperty().bind(personViewModel.getAgeProperty());

        logginButton.disableProperty().bind(personViewModel.getButtonProperty());

        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            nameTextField.setText(newValue.toUpperCase());
        });

        surnameTextField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            surnameTextField.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        });


    }

    public void ShowModal(ActionEvent event) {
        Stage dialog = new Stage();

//        dialog.initOwner(parentStage);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.showAndWait();
    }
}
