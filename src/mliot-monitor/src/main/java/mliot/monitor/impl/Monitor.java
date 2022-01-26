package mliot.monitor.impl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import mliot.monitor.generated.MonitorServiceGrpc;
import mliot.monitor.util.Util;

public  class Monitor extends MonitorServiceGrpc.MonitorServiceImplBase {

    private Server server;

    public Monitor(MonitorServiceGrpc.MonitorServiceImplBase monitorServiceImplBase) {
        this.server = ServerBuilder.forPort(Util.MONITOR_PORT_NUMBER)
                .addService(monitorServiceImplBase)
                .build();
    }
}
