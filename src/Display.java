import javafx.application.*;
import javafx.event.EventHandler;
import javafx.stage.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.paint.*;

public class Display extends Application {
	
	public int WIDTH = 960;
	public int HEIGHT = 540;
	public Canvas canvas = new Canvas(this.WIDTH, this.HEIGHT);
	public ARSetup arSetup = new ARSetup(this);
	public Thread arThread = new Thread(){
		public void run() {
			arSetup.start();
		}
	};

	public void start(Stage stage) {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent e) {
		     Platform.exit();
		     System.exit(0);
		    }
		  });
		stage.setTitle("AR System 02 - Desktop");
		Group root = new Group();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, this.WIDTH, this.HEIGHT);
		root.getChildren().add(this.canvas);
		stage.show();
		this.setupARSystem();
	}
	
	public void setupARSystem() {
		this.arThread.start();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
