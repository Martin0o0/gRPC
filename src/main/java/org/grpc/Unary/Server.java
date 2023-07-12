package org.grpc.Unary;

import io.grpc.ServerBuilder;


public class Server {
    private io.grpc.Server unaryServer;

    public Server(int port){//생성자
        unaryServer = ServerBuilder.forPort(port).addService(new MyFunction()).build();
    }

    public void start(){
        try{
            unaryServer.start();
            System.out.println("Starting server. Listening on port 50051.");
            unaryServer.awaitTermination();
        }catch (Exception exception){
            System.out.println("예외처리로 인한 종료");

        }
    }
    public static void main(String[] args) {
        Server myServiceServer = new Server(50051);
        myServiceServer.start();
    }

}
