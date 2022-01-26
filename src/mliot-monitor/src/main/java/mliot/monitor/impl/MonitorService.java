package mliot.monitor.impl;

import io.grpc.stub.StreamObserver;
import mliot.monitor.generated.*;

public  class MonitorService extends MonitorServiceGrpc.MonitorServiceImplBase {
    @Override
    public void onStepDetected(StepDetectionMessage request, StreamObserver<MonitorResponse> responseObserver) {
        super.onStepDetected(request, responseObserver);
        responseObserver.onNext(null);
        responseObserver.onCompleted();
    }

    @Override
    public void onProximityDetected(ProximityMessage request, StreamObserver<MonitorResponse> responseObserver) {
        super.onProximityDetected(request, responseObserver);
    }

    @Override
    public void onMotionDetected(MotionDetectionMessage request, StreamObserver<MonitorResponse> responseObserver) {
        super.onMotionDetected(request, responseObserver);
    }
}
