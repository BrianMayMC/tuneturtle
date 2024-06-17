package me.nootnoot;

import com.google.gson.Gson;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {
    /**
     * This function listens at endpoint "/api/HttpExample". Two ways to invoke it using "curl" command in bash:
     * 1. curl -d "HTTP Body" {your host}/api/HttpExample
     * 2. curl "{your host}/api/HttpExample?name=HTTP%20Query"
     */

    private static final List<String> notifications = new CopyOnWriteArrayList<>();

    @FunctionName("notifications")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "req",
                methods = {HttpMethod.GET},
                authLevel = AuthorizationLevel.ANONYMOUS)
                HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a notifications request.");

        context.getLogger().info("Notifications: " + notifications);
        HttpResponseMessage message = request.createResponseBuilder(HttpStatus.OK).body(new Gson().toJson(notifications)).build();
        notifications.clear();

        return message;
    }


    @FunctionName("addNotification")
    public HttpResponseMessage runNotifications(
            @HttpTrigger(
                    name="req",
                    methods = {HttpMethod.POST},
                    authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context){

        final String query = request.getQueryParameters().get("name");
        final String name = request.getBody().orElse(query);

        context.getLogger().info("Query: " + query);
        context.getLogger().info("Name: " + name);

        if (name == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST).body("Please pass a name on the query string or in the request body").build();
        } else {
            notifications.add(name);
            context.getLogger().info("Adding notification: " + name);
            return request.createResponseBuilder(HttpStatus.OK).build();
        }
    }

}
