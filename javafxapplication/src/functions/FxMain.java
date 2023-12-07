/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functions;

/**
 *
 * @author Administrator
 */
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FxMain extends Application {

    private SimpleBooleanProperty showPassword ;
    private CheckBox checkBox;
    private Tooltip toolTip;
    private PasswordField pF;

    private Stage stage;
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        showPassword = new SimpleBooleanProperty();
        showPassword.addListener((ChangeListener<Boolean>) (observable, oldValue, newValue) -> {
            if(newValue){
                showPassword();
            }else{
                hidePassword();
            }
        });

        final Label message = new Label("");
        Label label = new Label("Password");

        toolTip = new Tooltip();
        toolTip.setShowDelay(Duration.ZERO);
        toolTip.setAutoHide(false);
        toolTip.setMinWidth(50);

        pF = new PasswordField();
        pF.setOnKeyTyped(e -> {
            if ( showPassword.get() ) {
                showPassword();
            }
        });

        HBox hb = new HBox(10, label, pF);
        hb.setAlignment(Pos.CENTER_LEFT);


        checkBox = new CheckBox("Show password");
        showPassword.bind(checkBox.selectedProperty());

        VBox vb = new VBox(10, hb, checkBox, message);
        vb.setPadding(new Insets(10));

        stage.setScene(new Scene(vb,300,100));
        stage.show();
    }

    private void showPassword(){
        Point2D p = pF.localToScene(pF.getBoundsInLocal().getMaxX(), pF.getBoundsInLocal().getMaxY());
        toolTip.setText(pF.getText());
        toolTip.show(pF,
                p.getX() + stage.getScene().getX() + stage.getX(),
                p.getY() + stage.getScene().getY() + stage.getY());
    }

    private void hidePassword(){
        toolTip.setText("");
        toolTip.hide();
    }
    public static void main(String[] args) {
        launch(args);
    }
}