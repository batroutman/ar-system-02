import org.opencv.videoio.VideoCapture;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import ARPipeline.*;

public class ARSetup {
	
	public Display display = null;
	String SAMPLE_PATH = "E:/Primary/Files/College/Research/ar-system-02/src/samples/";
	String filename = SAMPLE_PATH + "roomFloor01_270.avi";
	
	public ARSetup() {
		
	}
	
	public ARSetup(Display display) {
		this.display = display;
	}
	
	public void start() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		OfflineFrameBuffer ofb = new OfflineFrameBuffer(filename, true);
		CanvasFrameBuffer cfb = new CanvasFrameBuffer(display.canvas);
		ARPipeline pipeline = new TestPipeline(ofb, cfb);
		pipeline.start();

		println("Done.");
	}
	
	public static void println(Object obj) {
		System.out.println(obj);
	}
}