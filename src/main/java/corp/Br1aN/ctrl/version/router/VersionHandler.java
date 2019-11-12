package corp.Br1aN.ctrl.version.router;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class VersionHandler {

  public static void handleGetVersion(RoutingContext routingContext){
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
  public static void handleListVersion(RoutingContext routingContext){
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
  public static void handleAddVersion(RoutingContext routingContext){
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
  public static void handlePutVersion(RoutingContext routingContext){
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
  public static void handleDelVersion(RoutingContext routingContext){
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain");
    // Write to the response and end it
    response.end("Hello World from Vert.x-Web!");
  }
}
