package com.hotel.api.search.interceptors;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.interceptor.GrpcGlobalClientInterceptor;
import org.slf4j.MDC;

@GrpcGlobalClientInterceptor
@Slf4j
public class ApiKeyAuthInterceptor implements ClientInterceptor {

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
        log.info("client interceptor {}", methodDescriptor.getFullMethodName());
        return new
                ForwardingClientCall.SimpleForwardingClientCall<>(channel.newCall(methodDescriptor, callOptions)) {
                    @Override
                    public void start(Listener<RespT> responseListener, Metadata headers) {
                    headers.put(Metadata.Key.of("accesstoken", Metadata.ASCII_STRING_MARSHALLER), MDC.get("token"));
                    super.start(responseListener, headers);
                    }
                };
    }
}
