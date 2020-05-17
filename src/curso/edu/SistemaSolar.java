package curso.edu;

import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SistemaSolar extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Group grp = new Group();
		Scene scn = new Scene(grp);
		primaryStage.setScene(scn);
		
		/*********************************************************
		 * Carregar uma imagem por meio de um InputStream, que é *
		 * aceito pela classe Image.                             *
		 *********************************************************/
		InputStream isEspaco = getClass().getResourceAsStream("/imagens/espaco.jpg");
		Image img = new Image(isEspaco);
		Image imgSun = new Image(getClass().getResourceAsStream("/imagens/sol.png"));
		Image imgEarth = new Image(getClass().getResourceAsStream("/imagens/terra.png"));
		Image imgMars = new Image(getClass().getResourceAsStream("/imagens/marte.png"));
		Canvas canvas = new Canvas(img.getWidth(), img.getHeight());
		grp.getChildren().add(canvas);
		
		final ImagePosition imgPosSun = new ImagePosition(imgSun, img.getWidth()/2, img.getHeight()/2);
		final ImagePosition imgPosEarth = new ImagePosition(imgEarth, img.getWidth()/2, img.getHeight()/2);
		imgPosEarth.setPolarPositionInDegrees(120, 0);
		imgPosEarth.setCoordinateScale(1, 0.7);
		final ImagePosition imgPosMars = new ImagePosition(imgMars, img.getWidth()/2, img.getHeight()/2);
		imgPosMars.setPolarPositionInDegrees(180, 0);
		imgPosMars.setCoordinateScale(1, 0.7);
		
		class ExecutaMouse implements EventHandler<MouseEvent> {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				if(event.getButton().ordinal() == 1) {
					imgPosEarth.setPolarPositionInDegrees(120, 0);
				} else if(event.getButton().ordinal() == 3) {
					imgPosMars.setPolarPositionInDegrees(180, 0);
				} else {
					imgPosEarth.setPolarPositionInDegrees(120, 0);
					imgPosMars.setPolarPositionInDegrees(180, 0);
				}
			}
			
		}
		final ExecutaMouse exe = new ExecutaMouse();
		canvas.addEventFilter(MouseEvent.MOUSE_PRESSED, exe);
		
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				ctx.drawImage(img, 0, 0);
				ctx.drawImage(imgSun, imgPosSun.getX(), imgPosSun.getY());
				ctx.drawImage(imgEarth, imgPosEarth.getScalableX(), imgPosEarth.getScalableY());
				ctx.drawImage(imgMars, imgPosMars.getScalableX(), imgPosMars.getScalableY());
				imgPosEarth.addPolarPositionInDegrees(0, -3);
				imgPosMars.addPolarPositionInDegrees(0, -2);
			}
			
		}.start();
		
		primaryStage.setTitle("Sistema Solar");
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(SistemaSolar.class, args);
	}
}
