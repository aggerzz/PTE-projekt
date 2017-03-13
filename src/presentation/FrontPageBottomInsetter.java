package presentation;

import domain.Beregning;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class FrontPageBottomInsetter {
	TableView<Beregning> beregningsTable;

	public GridPane insetButtom() {
		
		GridPane buttomGrid = new GridPane();
		
		//opretter table
		beregningsTable = new TableView<Beregning>();
		beregningsTable = new TableCreator().beregningTable(beregningsTable);
		buttomGrid.add(beregningsTable, 0, 0, 10, 10);
		
		return buttomGrid;
	}

	public TableView<Beregning> getBeregningsTable() {
		return beregningsTable;
	}

	public void setBeregningsTable(TableView<Beregning> beregningsTable) {
		this.beregningsTable = beregningsTable;
	}

}
