import org.opencv.videoio.VideoCapture;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;

public class ARSetup {
	
	public Display display = null;
	
	public ARSetup() {
		
	}
	
	public ARSetup(Display display) {
		this.display = display;
	}
	
	public void start() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String SAMPLE_PATH = "E:/Primary/Files/College/Research/ar-system-02/src/samples/";
		String filename = SAMPLE_PATH + "loft01.avi";
		
		VideoCapture vc = new VideoCapture();
		vc.open(filename);
		
		if (vc.isOpened()) {
			Mat frame = new Mat();
			vc.read(frame);
			System.out.println(frame.get(0, 0)[0] + " " + frame.get(0, 0)[1] + " " + frame.get(0, 0)[2]);
			Imgcodecs.imwrite("first frame.png", frame);
		}

	}
}