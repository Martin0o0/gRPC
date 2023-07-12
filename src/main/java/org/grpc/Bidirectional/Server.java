package org.grpc.Bidirectional;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


import java.io.IOException;
import java.util.ArrayList;

public class Server {

    private static class BidirectionalService extends BidirectionalGrpc.BidirectionalImplBase {
        @Override
        public StreamObserver<BidirectionalOuterClass.Message> getServerResponse(StreamObserver<BidirectionalOuterClass.Message> responseObserver) {
            System.out.println("Server processing gRPC bidirectional streaming");
            return new StreamObserver<BidirectionalOuterClass.Message>() {
                @Override
                public void onNext(BidirectionalOuterClass.Message request) {
                    responseObserver.onNext(request);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    responseObserver.onCompleted();

                }
            };
        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        io.grpc.Server server = ServerBuilder.forPort(50051)
                .addService(new BidirectionalService())
                .build();

        System.out.println("Starting server. Listening on port 50051.");
        server.start();

        server.awaitTermination();
    }
}

