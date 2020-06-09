package ARPipeline;

public class TestPipeline extends ARPipeline{

	public TestPipeline(){
		super();
	}

	public TestPipeline(FrameBuffer inputFrameBuffer) {
		super();
		this.setInputFrameBuffer(inputFrameBuffer);
	}

	public TestPipeline(FrameBuffer inputFrameBuffer, PoseBuffer outputPoseBuffer) {
		super();
		this.setInputFrameBuffer(inputFrameBuffer);
		this.setOutputPoseBuffer(outputPoseBuffer);
	}

	public TestPipeline(FrameBuffer inputFrameBuffer, PoseBuffer outputPoseBuffer, FrameBuffer outputFrameBuffer) {
		super();
		this.setInputFrameBuffer(inputFrameBuffer);
		this.setOutputPoseBuffer(outputPoseBuffer);
		this.setOutputFrameBuffer(outputFrameBuffer);
	}

	public void start() {}
	public void stop() {}

}