package mliot.monitor.impl;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import mliot.monitor.generated.MonitorServiceGrpc;
import mliot.monitor.util.Util;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public  class Monitor extends Thread {

    private final Server server;
    private static final Long SHUT_DOWN_TIMEOUT = 30L;
    private final Logger logger = Logger.getLogger(Monitor.class.getCanonicalName());

    public Monitor(MonitorServiceGrpc.MonitorServiceImplBase monitorServiceImplBase) {
        this.server = ServerBuilder.forPort(Util.MONITOR_PORT_NUMBER)
                .addService(monitorServiceImplBase)
                .build();
    }

    @Override
    public void run() {
        try {
            this.server.start();
            this.logger.log(Level.INFO, String.format(Locale.getDefault(), "gRPC Monitoring Server is running at %s:%d", Util.getIpAddress(), Util.MONITOR_PORT_NUMBER));
            this.server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            this.logger.log(Level.SEVERE, "Error while starting gRPC Monitoring Server", e);
        }
    }

    public void shutDown() {
        try {
            this.server.shutdown().awaitTermination(SHUT_DOWN_TIMEOUT, TimeUnit.SECONDS);
            this.logger.log(Level.INFO, "gRPC Monitoring Server is shut down");
        } catch (InterruptedException e) {
            this.logger.log(Level.SEVERE, "Error while shutting down gRPC Monitoring Server", e);
        }
    }
}
