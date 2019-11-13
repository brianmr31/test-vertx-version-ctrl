package corp.Br1aN.ctrl.version.handler.auth;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.http.HttpServerResponse;

import io.vertx.core.json.JsonObject;

public class CheckAuthHandler implements Handler<RoutingContext> {
  public void handle(RoutingContext context) {
    HttpServerResponse response = context.response();
    // HttpServerResponse response = context.response();
    System.out.println("Check Auth Handler");
    String isAuth = "false";
    JsonObject json = new JsonObject().put("message", "check json wkwkkwkwk");
    // CHECK AUTH
    if( true ){
      isAuth = "true";
      response.putHeader("content-type", "application/json");
      response.end(json.encodePrettily());
    }
    context.put("auth", isAuth);
    context.next();
  }
}
