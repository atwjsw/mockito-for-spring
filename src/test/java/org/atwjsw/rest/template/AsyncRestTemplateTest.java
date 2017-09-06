package org.atwjsw.rest.template;

import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.client.AsyncClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRequestCallback;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.ResponseExtractor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by wenda on 9/3/2017.
 */
public class AsyncRestTemplateTest {

    @Test
    public void exchange() {
        AsyncRestTemplate asyncRestTemplate = new AsyncRestTemplate();
        String url = "http://localhost:8080/hello/all/";
        HttpMethod method = HttpMethod.GET;
        Class<String> responseType = String.class;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> requestEntity = new HttpEntity<String>("params", headers);
        ListenableFuture<ResponseEntity<String>> future = asyncRestTemplate.exchange(url, method, requestEntity, responseType);
        System.out.println("exchanged");
        try {
            //waits for the result
            ResponseEntity<String> entity = future.get();
            //prints body of the given URL
            System.out.println(entity.getBody());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void execute() {
        AsyncRestTemplate asyncTemp = new AsyncRestTemplate();
        String url = "http://localhost:8080/hello/all/";
        HttpMethod method = HttpMethod.GET;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        AsyncRequestCallback requestCallback = new AsyncRequestCallback() {
            @Override
            public void doWithRequest(AsyncClientHttpRequest request) throws IOException {
                System.out.println(request.getURI());
            }
        };
        ResponseExtractor<String> responseExtractor = new ResponseExtractor<String>() {
            @Override
            public String extractData(ClientHttpResponse response) throws IOException {
                System.out.println("reponse body: " + response.getBody().read());
                return response.getStatusText();
            }
        };
        Map<String, String> urlVariable = new HashMap<String, String>();
        ListenableFuture<String> future = asyncTemp.execute(url, method, requestCallback, responseExtractor, urlVariable);
        System.out.println("executed");
        try {
            //wait for the result
            String result = future.get();
            System.out.println("Status =" + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
