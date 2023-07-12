package org.grpc.Bidirectional;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


import java.util.Arrays;
import java.util.List;

public class Client {


    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        BidirectionalGrpc.BidirectionalStub stub = BidirectionalGrpc.newStub(channel);


        List<String> messages = Arrays.asList(
                "message #1",
                "message #2",
                "message #3",
                "message #4",
                "message #5"
        );



        StreamObserver<BidirectionalOuterClass.Message> requestObserver = stub.getServerResponse(new StreamObserver<>() {
            @Override
            public void onNext(BidirectionalOuterClass.Message response) {
                System.out.println("[server to client] " + response.getMessage());
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

        for (String message : messages) {
            BidirectionalOuterClass.Message request = BidirectionalOuterClass.Message.newBuilder()
                    .setMessage(message)
                    .build();
            System.out.println("[client to server] " + message);
            requestObserver.onNext(request);
        }
        requestObserver.onCompleted();
        Thread.sleep(1000);

        channel.shutdown();
    }
}

