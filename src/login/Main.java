package login;

import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	public static Socket socket_main;
	public static Socket socket_money;
	public static Socket socket_hwtoopae;
	public static Socket socket_idch;
	
	public static void main(String[] args) throws IOException {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		socket_main = new Socket("192.168.0.9",12345);
		socket_money = new Socket("192.168.0.9",10000);
		socket_hwtoopae = new Socket("192.168.0.9",13000);
		socket_idch = new Socket("192.168.0.9",20000);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../Login.fxml"));
		Parent root = loader.load();
		Con_Login login = loader.getController();
		login.setRoot(root);
		
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
