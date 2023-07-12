package org.grpc.ServerStreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.grpc.ClientStreaming.ClientStreamingGrpc;
import org.grpc.ClientStreaming.Clientstreaming;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Server {
    private io.grpc.Server server;

    public Server(int port){
        server = ServerBuilder.forPort(port)
                .addService(new ServerStreamingServicer())
                .build();
    }

    public void start(){
        try {
            System.out.println("Starting server. Listening on port 50051.");
            server.start();
            server.awaitTermination();
        }catch(Exception exception){
            System.out.println("예외처리로 인한 종료");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Server serverStreamingServer = new Server(50051);
        serverStreamingServer.start();
    }

    private static class ServerStreamingServicer extends ServerStreamingGrpc.ServerStreamingImplBase {
        @Override
        public void getServerResponse(Serverstreaming.Number request, StreamObserver<Serverstreaming.Message> responseObserver) {
            List<String> messages = Arrays.asList(
                    "message #1",
                    "message #2",
                    "message #3",
                    "message #4",
                    "message #5"
            );
            System.out.println("Server processing gRPC Server streaming");
            int Value = request.getValue();

            for (String msg : messages) {
                Serverstreaming.Message response = Serverstreaming.Message.newBuilder()
                        .setMessage("[server to client] " + msg)
                        .build();
                responseObserver.onNext(response);

            }

            responseObserver.onCompleted();

        }

    }


}

