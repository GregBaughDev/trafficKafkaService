package main.java.api;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface Connector {
    HttpRequest getDataRequest();
    HttpResponse<String> getSendDataRequest();
}
