package vistas;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.WindowEvent;
import sample.eventos.EventoTaquimecanografo;
import sample.eventos.EventoVentanaTaqui;


import java.io.File;

public class Taquimecanografo extends Stage {

    private Scene escena;
    private ToolBar tlbMenu;
    private Button btnAbrir;
    private TextArea txaTexto, txaEscritura;
    private VBox vPrincipal, vTeclado;
    private HBox hTeclas3;

    private Button[] arBotones3;
    private String[] arTeclas3 = {"-->","Q","W","E","R","T","Y","U","I","O","P","`","+","}"};
    private FileChooser flcArchivos;

    private HBox hTeclas4;
    private Button[] arBotones4;
    private String[] arTeclas4 = {"bloq mayus","A","S","D","F","G","H","J","K","L","Ñ","{","Enter "};

    private HBox hTeclas5;
    private Button[] arBotones5;
    private String[] arTeclas5 = {" shift ","Z","X","C","V","B","N","M",",",".","-"," shift "};

    private HBox hTeclas6;
    private Button[] arBotones6;
    private String[] arTeclas6 = { "|", "1","2","3","4","5","6","7","8","9","0","?","¿","Borrar"};

    private HBox hTeclas7;
    private Button[] arBotones7;
    private String[] arTeclas7 = {"ctrl","fn","win","alt"," E S P A C I O", "alt gr", "<", "left","Up","down","rigth"};

    public Taquimecanografo(){
        CrearGUI();
        this.setTitle("Mi tutor de mecanografía");
        this.setScene(escena);
        this.show();


    }

    private void CrearGUI() {
        tlbMenu = new ToolBar();
        btnAbrir = new Button();
        //btnAbrir.setPrefSize(15,15);
        btnAbrir.setGraphic(new ImageView("sample/Imagenes/open.PNG.png"));
        btnAbrir.setOnAction(event -> AbrirExplorador());
        tlbMenu.getItems().add(btnAbrir);

        txaTexto = new TextArea();
        txaTexto.setEditable(false);
        txaTexto.setPrefRowCount(5);

        txaEscritura = new TextArea();
        txaEscritura.setPrefRowCount(5);
        txaEscritura.setOnKeyPressed(new EventoTaquimecanografo());


        hTeclas3 = new HBox();
        arBotones3 = new Button[14];
        for (int i = 0; i < 14 ; i++) {
            arBotones3[i] = new Button(arTeclas3[i]);
            hTeclas3.getChildren().add(arBotones3[i]);
        }

        hTeclas4 = new HBox();
        arBotones4 = new Button[13];
        for (int i=0; i< 13; i++){
            arBotones4[i] = new Button(arTeclas4[i]);
            hTeclas4.getChildren().add(arBotones4[i]);
        }

        hTeclas5 = new HBox();
        arBotones5 = new Button[12];
        for (int i = 0; i<12; i++){

            arBotones5[i] = new Button(arTeclas5[i]);
            hTeclas5.getChildren().add(arBotones5[i]);
        }

        hTeclas6 = new HBox();
        arBotones6 = new Button[14];
        for(int i = 0; i<14;i++){

            arBotones6[i] = new Button(arTeclas6[i]);
            hTeclas6.getChildren().add(arBotones6[i]);
        }

        hTeclas7 = new HBox();
        arBotones7 = new Button[11];
        for (int i = 0; i <11; i++){
            arBotones7[i] = new Button(arTeclas7[i]);
            hTeclas7.getChildren().add(arBotones7[i]);
        }

        vTeclado = new VBox();
        vTeclado.getChildren().addAll(hTeclas6,hTeclas3,hTeclas4,hTeclas5,hTeclas7);

        vPrincipal = new VBox();
        vPrincipal.setSpacing(5);
        vPrincipal.getChildren().addAll(tlbMenu,txaTexto,txaEscritura,vTeclado);
        escena = new Scene(vPrincipal,500,350);
        escena.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST,new EventoVentanaTaqui());
    }

    private void AbrirExplorador() {
        flcArchivos = new FileChooser();
        flcArchivos.setTitle("Archivo para Taquimecanógrafo");
        File objFile = flcArchivos.showOpenDialog(this);
    }



}
