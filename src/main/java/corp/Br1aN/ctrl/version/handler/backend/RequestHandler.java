package corp.Br1aN.ctrl.version.handler.backend;

import io.vertx.core.Vertx;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;
// import io.vertx.core.MultiMap;
import io.vertx.core.buffer.Buffer;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.HttpResponse;

public class RequestHandler implements Handler<RoutingContext> {

  private WebClient client = null ;
  private Vertx Vertx = null ;
  private HttpServerResponse response = null;
  private JsonObject json = null;
  private HttpResponse<Buffer> responseAr = null;

  public RequestHandler( Vertx vertx ){
    this.Vertx = vertx;
    this.client = WebClient.create(vertx);
  }

  public void handle(RoutingContext context) {
    System.out.println("Print RequestHandler");
    String path = context.normalisedPath();
    System.out.println("path \n"+path);
    // Send a GET request
    this.client
      .get(8888, "127.0.0.1", "/")
      .send(ar -> {
        if (ar.succeeded()) {
          // context.reroute(String path);

          // context.reroute("/api/v1/auth");

          // MultiMap queryParams = context.queryParams();
          // String[] check = queryParams.toString().split("\n");
          // System.out.println("check \n"+check[0]);

          this.responseAr = ar.result();

          this.response = context.response();
          this.json = new JsonObject().put("message", "hello");
          this.response.putHeader("content-type", "application/json");
          this.response.end(json.encodePrettily());

          System.out.println("Received response with status code" + responseAr.statusCode());
        } else {
          this.response = context.response();
          this.json = new JsonObject().put("message", "Error wkwkwk");
          this.response.putHeader("content-type", "application/json");
          this.response.end(json.encodePrettily());

          System.out.println("Something went wrong " + ar.cause().getMessage());
        }
      });

  }
}
