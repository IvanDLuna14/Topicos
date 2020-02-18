package vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.eventos.EventoBuscaminas;

public class Buscaminas extends Stage implements EventHandler {

    private Label lblNoRows, lblNoCols;
    private TextField txtNoRows, txtNoCols;
    private Button btnMinar;
    private GridPane gdpCampo;
    private Button [] [] arBtnCeldas;
    private Scene escena;
    private HBox hBox;
    private VBox vBox;


    public Buscaminas(){

        CrearGUI();

        this.setTitle("Mi buscaminas :) ");
        this.setScene(escena);
        this.show();

    }

    private void CrearGUI() {
        vBox = new VBox();

        lblNoRows = new Label("No. Rows");
        lblNoCols = new Label("No. Colums");
        txtNoRows = new TextField();
        txtNoCols = new TextField();

        btnMinar = new Button("Minar Campo");
        //btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED,this);
        btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoBuscaminas(txtNoRows, txtNoCols,arBtnCeldas,gdpCampo,vBox));
       /* btnMinar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                System.out.println("mi tercer evento :) ");

            }
        });*/

       //btnMinar.setOnAction(event -> { System.out.println("Mi cuarto evento :D "); });

        //btnMinar.setOnAction(event -> Evento());

        hBox = new HBox(); // estanciarlo
        hBox.getChildren().addAll(lblNoRows,txtNoRows,lblNoCols,txtNoCols, btnMinar);
        vBox.getChildren().addAll(hBox);

        escena = new Scene(vBox, 600, 500);
        escena.getStylesheets().add("sample/Estilos/estilos_buscaminas.css ");

    }

    private void Evento() {
        System.out.println("Mi quinto evento :D ");
    }


    @Override
    public void handle(Event event) {
        System.out.println("Mi primer evento :) ");
    }
}
