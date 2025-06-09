import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.authentication.PreemptiveBasicAuthScheme;

import io.restassured.http.ContentType;

import io.restassured.response.Response;


public class CreateTicketInJira {

          @Test()

          public void createJiraIssue() {

                    // Jira API endpoint

                    String jiraUrl = "https://yourJiraInstance/rest/api/2/issue/";

                    // Set up basic authentication

                    PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();

                    basicAuth.setUserName("jiraUsername");

                    basicAuth.setPassword("jiraPassword");

          RestAssured.authentication = basicAuth;

                    // Create JSON payload for the new ticket

                    String jiraPayload = "{\n" + " \" fields\": {\n" + " \" project\": {\n" + " \" key\": \"projectKey\"\n" + " },\n" + " \"summary\": \"Sample Bug Creation: This is not Working as Expected\",\n" + " \" description\": \"Sample Bug Ticket creation using RestAssured API.\",\n" + " \"issuetype\": {\n" + " \" name\": \"Bug\"\n" + " }\n" + " }\n" + "}";


                    // Send a POST request to create the ticket

                    Response response = RestAssured.given().contentType(ContentType.JSON).body(jiraPayload ).post(jiraUrl);

                    // Extract the response details

                    int statusCode = response.getStatusCode();

                    String responseBody = response.getBody().asPrettyString();

                    // Print the response details

                    System.out.println("Response Status Code: " + statusCode);

                    System.out.println("Response Body: " + responseBody);

          }
}
