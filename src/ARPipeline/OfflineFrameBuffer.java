package ARPipeline;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class OfflineFrameBuffer implements FrameBuffer {

	protected ArrayList<Frame> frames = new ArrayList<Frame>();
	public boolean YOnly = false;
	
	public OfflineFrameBuffer() {
		
	}
	
	public OfflineFrameBuffer(boolean YOnly) {
		this.YOnly = YOnly;
	}
	
	public void loadFile(String filename) {
		VideoCapture vc = new VideoCapture();
		vc.open(filename);
		
		if (vc.isOpened()) {
			Mat mat = new Mat();
			while(vc.read(mat)) {
				int numRows = mat.rows();
				int numCols = mat.cols();
				byte [] y = new byte[numRows * numCols];
				byte [] u = new byte[numRows * numCols];
				byte [] v = new byte[numRows * numCols];
				
				// go through each pixel and solve YUV values
				for(int row = 0; row < numRows; row++) {
					for(int col = 0; col < numCols; col++) {
						
						double B = mat.get(row, col)[0];
						double G = mat.get(row, col)[1];
						double R = mat.get(row, col)[2];
						byte Y = (byte)Math.floor(0.299 * R + 0.587 * G + 0.114 * B);
						byte U = (byte)Math.floor(0.492 * (B - Y));
						byte V = (byte)Math.floor(0.877 * (R - Y));
						
						y[row * numRows + col] = Y;
						if(!this.YOnly) {
							u[row * numRows + col] = U;
							v[row * numRows + col] = V;
						}
						

					}
				}
				
				Frame frame;
				
				if(this.YOnly) {
					frame = new Frame(y);
				} else {
					frame = new Frame(y, u, v);
				}
				
				this.frames.add(frame);
			}
			
		}
	}
	
	public void pushFrame(Frame frame) {
		this.frames.add(frame);
	}
	
	public Frame getCurrentFrame() {
		if(this.frames.size() > 0) {
			return this.frames.remove(0);
		} else {
			return null;
		}
	}
}
