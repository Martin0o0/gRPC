package org.grpc.ClientStreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.grpc.Bidirectional.BidirectionalGrpc;
import org.grpc.Bidirectional.BidirectionalOuterClass;

import java.util.Arrays;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ClientStreamingGrpc.ClientStreamingStub stub = ClientStreamingGrpc.newStub(channel);


        List<String> messages = Arrays.asList(
                "message #1",
                "message #2",
                "message #3",
                "message #4",
                "message #5"
        );


        StreamObserver<Clientstreaming.Message> requestObserver = stub.getServerResponse(new StreamObserver<>() {


            @Override
            public void onNext(Clientstreaming.Number value) {
                System.out.println("[server to client] " + value.getValue());
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
            Clientstreaming.Message request = Clientstreaming.Message.newBuilder()
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
