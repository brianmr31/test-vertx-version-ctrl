package corp.Br1aN.ctrl.version.handler.backend;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.RoutingContext;

public class RouterHandler implements Handler<RoutingContext> {
  public void handle(RoutingContext context) {
    // HttpServerResponse response = context.response();
    System.out.println("Print RouterHandler");
    // JsonObject json = new JsonObject().put("message", "NOT AUTHORIZED");
    // response.putHeader("content-type", "application/json");
    // response.setStatusCode(403);
    // response.end(json.encodePrettily());

    // CARI ROUTER
    context.next();
  }
}
