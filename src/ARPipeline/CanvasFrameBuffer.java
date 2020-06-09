package ARPipeline;

import java.io.ByteArrayInputStream;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

// Frame buffer that outputs frames directly to a canvas
public class CanvasFrameBuffer implements FrameBuffer {

	protected Canvas canvas = new Canvas();
	
	public CanvasFrameBuffer() {
		
	}
	
	public CanvasFrameBuffer(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public Canvas getCanvas() {
		return this.canvas;
	}
	
	public static Mat frameToMat(Frame frame) {
		return null;
	}
	
	public void pushFrame(Frame frame) {
		
		// clear frame
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
		
		// create image
		Mat mat = frameToMat(frame);
		MatOfByte byteMat = new MatOfByte();
		Imgcodecs.imencode(".bmp", mat, byteMat);
		Image img = new Image(new ByteArrayInputStream(byteMat.toArray()));
		
		// draw image
		
		
	}
	
	public Frame getCurrentFrame() {
		return null;
	}
	
}
