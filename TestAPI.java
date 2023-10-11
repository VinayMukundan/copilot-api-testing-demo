/* Create a selenium java code for doing the following:
 1. Send a GET request to an REST API
 2. Check whether the response is correct
 3. Print the response
 4. Create new data in the API
 5. Update existing data in the API
*/

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;


public class TestAPI {

    public static void main(String[] args) throws Exception {

        // Create a HttpRequest method with the URL of the API and the method type as GET
        HttpRequest getRequest = new HttpRequest(HttpMethod.GET,"https://dummy.restapiexample.com/api/v1/employees");
        //getStatusCode=getResponse.getStatus();
        //System.out.println(getRequest.toString());

        URL url = new URL("https://dummy.restapiexample.com/api/v1/employees");

        HttpClient client = HttpClient.Factory.createDefault().createClient(url);

        // Get the response from the API without using the getRequest.execute() and getRequest.send() methods
        HttpResponse getResponse = client.execute(getRequest);

        //Create a list to store the response body
        List<String> responseBody = new ArrayList<String>();

        // Add the response body to the responseBody list
        responseBody.add((String)getResponse.getAttribute("name"));
        responseBody.add((String)getResponse.getAttribute("salary"));
        responseBody.add((String)getResponse.getAttribute("age"));        

        //Print the response body
        System.out.println(responseBody);

        //responseBody = getResponse.getAttribute("status");
        
        // Display the response
        System.out.println(responseBody);
        
        // Create a HttpRequest method with the URL of the API and the method type as POST
        HttpRequest postRequest = new HttpRequest(HttpMethod.POST,"https://dummy.restapiexample.com/api/v1/create");

        // Create a JSON object with the data to be sent
        JSONObject jsonObject2 = new JSONObject();

        // Add the data to the JSON object
        jsonObject2.put("name", "test");
        jsonObject2.put("salary", "123");
        jsonObject2.put("age", "23");

        
        // Add the JSON object to the request
        HttpResponse postResponse = client.execute(postRequest);

        // Display the response
        System.out.println(postResponse);

        // Create a HttpRequest method with the URL of the API and the method type as GET
        HttpRequest getRequest2 = new HttpRequest(HttpMethod.GET,"https://dummy.restapiexample.com/api/v1/employee/21");

        URL url2 = new URL("https://dummy.restapiexample.com/api/v1/employee/21");

        HttpClient client1 = HttpClient.Factory.createDefault().createClient(url2);

        // Get the response from the API without using the getRequest.execute() and getRequest.send() methods
        HttpResponse getResponse2 = client1.execute(getRequest2);

           //Create a list to store the response body
        List<String> responseBody2 = new ArrayList<String>();

        // Add the response body to the responseBody list
        responseBody2.add((String)getResponse2.getAttribute("name"));
        responseBody2.add((String)getResponse2.getAttribute("salary"));
        responseBody2.add((String)getResponse2.getAttribute("age"));        

        // Display the response
        System.out.println(responseBody2);
        
        // Create a HttpRequest method with the URL of the API and the method type as PUT
        HttpRequest putRequest = new HttpRequest(HttpMethod.PUT,"https://dummy.restapiexample.com/api/v1/update/21");

        URL url3 = new URL("https://dummy.restapiexample.com/api/v1/employee/21");

        HttpClient client2 = HttpClient.Factory.createDefault().createClient(url3);

        putRequest.addQueryParameter("name", "test");
        putRequest.addQueryParameter("salary", "123");
        putRequest.addQueryParameter("age", "23");


        // Add the JSON object to the request
        HttpResponse getResponse3=client2.execute(putRequest);

              //Create a list to store the response body
        List<String> responseBody3 = new ArrayList<String>();

        // Add the response body to the responseBody list
        responseBody3.add((String)getResponse3.getAttribute("name"));
        responseBody3.add((String)getResponse3.getAttribute("salary"));
        responseBody3.add((String)getResponse3.getAttribute("age"));        

        // Display the response
        System.out.println(responseBody3);

    }
                
}
