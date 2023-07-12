package org.grpc.Unary;

import io.grpc.stub.StreamObserver;


public class MyFunction extends MyServiceGrpc.MyServiceImplBase {
    private int my_func(int number){
        return number * number;
    }
    @Override
    public void myFunction(HelloGrpc.MyNumber request, StreamObserver<HelloGrpc.MyNumber> responseObserver) {
        int reqNumber = request.getValue();
        HelloGrpc.MyNumber myValue = HelloGrpc.MyNumber.newBuilder().setValue(my_func(reqNumber)).build();
        responseObserver.onNext(myValue);
        responseObserver.onCompleted();
    }
}
