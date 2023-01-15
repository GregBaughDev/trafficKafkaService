package main.java.api;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TrafficAPI implements Connector {


    @Override
    public HttpRequest getDataRequest() {
        return null;
    }

    @Override
    public HttpResponse<String> getSendDataRequest() {
        return null;
    }
}
