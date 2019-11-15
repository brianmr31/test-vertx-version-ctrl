package corp.Br1aN.ctrl.version.handler.log;

import io.vertx.core.Handler;
// import io.vertx.core.http.HttpServerResponse;
// import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.RoutingContext;

public class AddLogHandler implements Handler<RoutingContext> {
  public void handle(RoutingContext context) {
    // HttpServerResponse response = context.response();
    System.out.println("Print Log Data");
    // INSERT DI DATABASE
    context.next();
  }
}
