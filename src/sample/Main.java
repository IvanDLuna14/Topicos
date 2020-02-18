package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import vistas.Buscaminas;
import vistas.Taquimecanografo;

public class Main extends Application {

  /* private Button btn1, btn2, btn3, btn4;
   private HBox hbox; //BOTONES HORIZONTALES
   private VBox vbox; //BOTONES VERTICALES */

   MenuBar mnbProyecto;
   Menu menCompetencia1, menCompetencia2, menSalir;
   MenuItem mitPractica1, mitPractica2 ,mitBye;
   Scene escena;
   BorderPane brpPrincipal;

    @Override
    public void start(Stage primaryStage) throws Exception{
       /* //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        btn1 = new Button("Btn1");
        btn1.setPrefWidth(100); //tamaño del boton
        btn2 = new Button("Btn2");
        btn2.setPrefWidth(200); //tamaño del boton
        btn3 = new Button("Btn3");
        btn4 = new Button("Btn4");

        vbox = new VBox();
        hbox = new HBox();

        vbox.getChildren().addAll(btn1,btn2,hbox);
        hbox.getChildren().addAll(btn3,btn4);

        vbox.setSpacing(5D); //ESPACIADO ENTRE BOTONES
        hbox.setSpacing(5D);

        */

       brpPrincipal = new BorderPane();
       mnbProyecto = new MenuBar();
       brpPrincipal.setTop(mnbProyecto);

       menCompetencia1 = new Menu("1er. competencia");
       menCompetencia2 = new Menu("2da competencia");
       menSalir = new Menu("salir");

       mitPractica1 = new MenuItem("Buscaminas");
       mitPractica1.setOnAction(event -> OpcionMenu(1));
       mitPractica2 = new MenuItem("Taquimecanografo");
       mitPractica2.setOnAction(event ->  OpcionMenu(2));

       mitBye = new MenuItem("Bye");
       mitBye.setOnAction(event -> OpcionMenu(20));

       menCompetencia1.getItems().addAll(mitPractica1,mitPractica2);
       menSalir.getItems().add(mitBye);

        // cargamos los menus a menubar
        mnbProyecto.getMenus().addAll(menCompetencia1,menCompetencia2,menSalir);
        escena = new Scene(brpPrincipal, 300, 275);
        escena.getStylesheets().add("sample/Estilos/estilos_principal.css");

        primaryStage.setMaximized(true);
        primaryStage.setTitle("Hello Topicos :)");
        primaryStage.setScene(escena);
        primaryStage.show();



    }

    private void OpcionMenu(int i) {

        switch (i){
            case 1:
                new Buscaminas();
                break;

            case 2:
                new Taquimecanografo();
                break;

            case 20:
                System.exit(0);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
