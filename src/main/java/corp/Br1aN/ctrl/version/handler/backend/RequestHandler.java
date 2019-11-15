package corp.Br1aN.ctrl.version.handler.backend;

import io.vertx.core.Vertx;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.client.WebClient;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.core.buffer.Buffer;

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
    // Send a GET request
    this.client
      .get(8888, "127.0.0.1", "/")
      .send(ar -> {
        if (ar.succeeded()) {
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
