package auxiliares;

import javafx.scene.control.Alert;

public class MetodosAuxiliares{

	public void MSG(String msg){
		Alert alerta = new Alert(Alert.AlertType.WARNING);
		alerta.setTitle("Atenção");
		alerta.setHeaderText(null);
		alerta.setContentText(msg);
		alerta.showAndWait();
	}

}
