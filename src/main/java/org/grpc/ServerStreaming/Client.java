package org.grpc.ServerStreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ServerStreamingGrpc.ServerStreamingStub stub = ServerStreamingGrpc.newStub(channel);

        Serverstreaming.Number request = Serverstreaming.Number.newBuilder().setValue(5).build();

        stub.getServerResponse(request, new StreamObserver<Serverstreaming.Message>() {
                    @Override
                    public void onNext(Serverstreaming.Message value) {
                        System.out.println(value.getMessage());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println(t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("완료");
                    }
                });
            Thread.sleep(1000);

        channel.shutdown();
    }
}
