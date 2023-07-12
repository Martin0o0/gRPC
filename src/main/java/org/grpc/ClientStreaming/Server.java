package org.grpc.ClientStreaming;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.grpc.Bidirectional.BidirectionalGrpc;
import org.grpc.Bidirectional.BidirectionalOuterClass;
import org.grpc.Bidirectional.Client;
import org.grpc.Unary.HelloGrpc;

import java.io.IOException;

public class Server {
    private io.grpc.Server server;
    private static class ClientStreamingServicer extends ClientStreamingGrpc.ClientStreamingImplBase {



        @Override
        public StreamObserver<Clientstreaming.Message> getServerResponse(StreamObserver<Clientstreaming.Number> responseObserver) {
            System.out.println("Server processing gRPC Client streaming");

            return new StreamObserver<Clientstreaming.Message>() {
                int number = 0;
                @Override
                public void onNext(Clientstreaming.Message value) {
                    System.out.println("server : " + number);
                    number += 1;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println(t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("oncomplete " + number);
                    Clientstreaming.Number result = Clientstreaming.Number.newBuilder()
                            .setValue(number)
                            .build();
                    responseObserver.onNext(result);
                    responseObserver.onCompleted();

                }
            };
        }

    }

    public Server(int port){
        server = ServerBuilder.forPort(port)
                .addService(new ClientStreamingServicer())
                .build();
    }

    public void start(){
        try {
            server.start();
            System.out.println("Starting server. Listening on port 50051.");
            server.awaitTermination();
        }catch(Exception exception){
            System.out.println("예외처리로 인한 종료");
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        Server clientStreamingServer = new Server(50051);
        clientStreamingServer.start();;


    }
}
