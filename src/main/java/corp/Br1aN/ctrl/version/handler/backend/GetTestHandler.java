package corp.Br1aN.ctrl.version.handler.backend;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.http.HttpServerResponse;

import io.vertx.core.json.JsonObject;

public class GetTestHandler implements Handler<RoutingContext> {
  public void handle(RoutingContext context) {
    if( context.get("auth").equals("false") ){
      HttpServerResponse response = context.response();
      System.out.println("Print GetTestHandler");
      JsonObject json = new JsonObject().put("message", "hello");
      response.putHeader("content-type", "application/json");
      response.end(json.encodePrettily());
    }
  }
}
