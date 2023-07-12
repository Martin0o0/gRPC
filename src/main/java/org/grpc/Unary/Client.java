package org.grpc.Unary;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    private ManagedChannel managedChannel;
    private MyServiceGrpc.MyServiceBlockingStub myServiceBlockingStub;
    private MyServiceGrpc.MyServiceStub myServiceStub;

    public Client(String host, int port){
        managedChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        myServiceBlockingStub = MyServiceGrpc.newBlockingStub(managedChannel);
        myServiceStub = MyServiceGrpc.newStub(managedChannel);

    }

    public HelloGrpc.MyNumber result(int number){
        HelloGrpc.MyNumber reqeust = reqeustNumber(number);
        return myServiceBlockingStub.myFunction(reqeust);
    }

    public HelloGrpc.MyNumber reqeustNumber(int number){
        return HelloGrpc.MyNumber.newBuilder().setValue(number).build();

    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 50051);
        System.out.println("gRPC result : " + client.result(4).getValue());
    }
}
