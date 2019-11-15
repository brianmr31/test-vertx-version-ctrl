package corp.Br1aN.ctrl.version.handler.auth;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.core.http.HttpServerResponse;

import io.vertx.core.json.JsonObject;

public class VerificationAuthHandler implements Handler<RoutingContext> {
  private JWTAuth provider;

  public VerificationAuthHandler(JWTAuth provider){
    this.provider = provider;
  }

  public void handle(RoutingContext context) {
    provider.authenticate(new JsonObject()
        .put("jwt", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzM3NDA3NzJ9.tlP2fF9j-NSPjLm2UgsgLY9scjhpe6IJ8IdtnaBgogQ")
        , res -> {
      HttpServerResponse response = context.response();
      // HttpServerResponse response = context.response();
      System.out.println("Check Auth Handler");
      String isAuth = "false";
      JsonObject json = new JsonObject().put("message", "check json wkwkkwkwk");
      if ( res.succeeded() == false ) {
        isAuth = "true";
        response.putHeader("content-type", "application/json");
        response.end(json.encodePrettily());
      }
      context.put("auth", isAuth);
      context.next();
    });
  }
}
