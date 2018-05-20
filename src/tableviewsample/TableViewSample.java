package tableviewsample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tableviewsample.model.CountryModel;
 
public class TableViewSample extends Application {
 
    private final TableView<CountryModel> table = new TableView<>();
    private final ObservableList<CountryModel> data =
            FXCollections.observableArrayList(
            new CountryModel(1, "United States", "05/19/2018", "bradd", "05/19/2018", "bradd"),
            new CountryModel(2, "United Kingdom", "05/18/2018", "bradd", "05/18/2018", "bradd"),
            new CountryModel(3, "Canada", "05/17/2018", "bradd", "05/17/2018", "bradd"),
            new CountryModel(4, "Paraguay", "05/16/2018", "bradd", "05/16/2018", "bradd"),
            new CountryModel(5, "South Africa", "05/15/2018", "bradd", "05/15/2018", "bradd"));

    final HBox hb = new HBox();
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(800);
        stage.setHeight(550);
 
        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn<CountryModel, Integer> countryIdCol = 
            new TableColumn<>("Country Id");
        countryIdCol.setMinWidth(80);
        countryIdCol.setCellValueFactory(
            new PropertyValueFactory<>("countryId"));
        
        TableColumn<CountryModel, String> countryCol = 
            new TableColumn<>("Country");
        countryCol.setMinWidth(120);
        countryCol.setCellValueFactory(
            new PropertyValueFactory<>("country"));
       countryCol.setCellFactory(TextFieldTableCell.<CountryModel>forTableColumn());
       countryCol.setOnEditCommit(
            (CellEditEvent<CountryModel, String> t) -> {
                ((CountryModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCountry(t.getNewValue());
        });
 
        TableColumn<CountryModel, String> createDateCol = 
            new TableColumn<>("Create Date");
        createDateCol.setMinWidth(80);
        createDateCol.setCellValueFactory(
            new PropertyValueFactory<>("createDate"));
       createDateCol.setCellFactory(TextFieldTableCell.<CountryModel>forTableColumn());
       createDateCol.setOnEditCommit(
            (CellEditEvent<CountryModel, String> t) -> {
                ((CountryModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCreateDate(t.getNewValue());
        });
 
        TableColumn<CountryModel, String> createdByCol = 
            new TableColumn<>("Created By");
        createdByCol.setMinWidth(80);
        createdByCol.setCellValueFactory(
            new PropertyValueFactory<>("createdBy"));
       createdByCol.setCellFactory(TextFieldTableCell.<CountryModel>forTableColumn());
       createdByCol.setOnEditCommit(
            (CellEditEvent<CountryModel, String> t) -> {
                ((CountryModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setCreatedBy(t.getNewValue());
        });
 
        TableColumn<CountryModel, String> lastUpdateCol = 
            new TableColumn<>("Last Update");
        lastUpdateCol.setMinWidth(80);
        lastUpdateCol.setCellValueFactory(
            new PropertyValueFactory<>("lastUpdate"));
       lastUpdateCol.setCellFactory(TextFieldTableCell.<CountryModel>forTableColumn());
       lastUpdateCol.setOnEditCommit(
            (CellEditEvent<CountryModel, String> t) -> {
                ((CountryModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastUpdate(t.getNewValue());
        });
 
        TableColumn<CountryModel, String> lastUpdateByCol = 
            new TableColumn<>("Last Update");
        lastUpdateByCol.setMinWidth(80);
        lastUpdateByCol.setCellValueFactory(
            new PropertyValueFactory<>("lastUpdateBy"));
       lastUpdateByCol.setCellFactory(TextFieldTableCell.<CountryModel>forTableColumn());
       lastUpdateByCol.setOnEditCommit(
            (CellEditEvent<CountryModel, String> t) -> {
                ((CountryModel) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastUpdateBy(t.getNewValue());
        });
 
 
        table.setItems(data);
        table.getColumns().addAll(countryIdCol, countryCol, createDateCol, createdByCol, lastUpdateCol, lastUpdateByCol);
 
        final TextField addCountryId = new TextField();
        addCountryId.setPromptText("Country Id");
        addCountryId.setMaxWidth(countryIdCol.getPrefWidth());
        
        final TextField addCountry = new TextField();
        addCountry.setPromptText("Country");
        addCountry.setMaxWidth(countryCol.getPrefWidth());
        
        final TextField addCreateDate = new TextField();
        addCreateDate.setPromptText("Create Date");
        addCreateDate.setMaxWidth(createDateCol.getPrefWidth());
        
        final TextField addCreatedBy = new TextField();
        addCreatedBy.setPromptText("Created By");
        addCreatedBy.setMaxWidth(createdByCol.getPrefWidth());
        
        final TextField addLastUpdate = new TextField();
        addLastUpdate.setPromptText("Last Update");
        addLastUpdate.setMaxWidth(lastUpdateCol.getPrefWidth());
        
        final TextField addLastUpdateBy = new TextField();
        addLastUpdateBy.setPromptText("Last Update By");
        addLastUpdateBy.setMaxWidth(lastUpdateByCol.getPrefWidth());
        
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent e) -> {
            data.add(new CountryModel(
                    Integer.parseInt(addCountryId.getText()),
                    addCountry.getText(),
                    addCreateDate.getText(),
                    addCreatedBy.getText(),
                    addLastUpdate.getText(),
                    addLastUpdateBy.getText()
            ));
            addCountryId.clear();
            addCountry.clear();
            addCreateDate.clear();
            addCreatedBy.clear();
            addLastUpdate.clear();
            addLastUpdateBy.clear();
        });
 
        hb.getChildren().addAll(addCountryId, addCountry, addCreateDate, addCreatedBy, addLastUpdate, addLastUpdateBy, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        stage.setScene(scene);
        stage.show();
    }
}