package presentation;

import java.math.BigDecimal;

import domain.Beregning;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableCreator {

	public TableView<Beregning> beregningTable(TableView<Beregning> beregningsTable) {
//		udfylder tabel
		ObservableList<Beregning> beregninger = FXCollections.observableArrayList();

		TableColumn<Beregning, String> resultNameCol = new TableColumn<Beregning, String>("result name");
		resultNameCol.setCellValueFactory(new PropertyValueFactory<Beregning, String>("resultName"));
		resultNameCol.setMinWidth(100);

		TableColumn<Beregning, String> equationCol = new TableColumn<Beregning, String>("equation");
		equationCol.setCellValueFactory(new PropertyValueFactory<Beregning, String>("equation"));
		equationCol.setMinWidth(250);

		TableColumn<Beregning, BigDecimal> resultCol = new TableColumn<Beregning, BigDecimal>("Result");
		resultCol.setCellValueFactory(new PropertyValueFactory<Beregning, BigDecimal>("result"));
		resultCol.setMinWidth(100);

		beregningsTable.setMinSize(450, 500);

		beregningsTable.setItems(beregninger);
		beregningsTable.getColumns().setAll(resultNameCol, equationCol, resultCol);

		return beregningsTable;
	}
}
