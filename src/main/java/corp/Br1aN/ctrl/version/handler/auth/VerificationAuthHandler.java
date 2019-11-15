package corp.Br1aN.ctrl.version.handler.auth;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.auth.jwt.JWTAuth;

public class VerificationAuthHandler implements Handler<RoutingContext> {
  
  private JWTAuth provider;
  private HttpServerResponse response;
  private JsonObject json;

  public VerificationAuthHandler(JWTAuth provider){
    this.provider = provider;
  }

  public void handle(RoutingContext context) {
    provider.authenticate(new JsonObject()
        .put("jwt", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1NzM3NDA3NzJ9.tlP2fF9j-NSPjLm2UgsgLY9scjhpe6IJ8IdtnaBgogQ")
        , res -> {
      // HttpServerResponse response = context.response();
      System.out.println("Check Auth Handler");
      if ( res.succeeded() == false ) {
        this.response = context.response();
        this.json = new JsonObject().put("message", "NOT AUTHORIZED");
        response.putHeader("content-type", "application/json");
        response.setStatusCode(403);
        response.end(json.encodePrettily());
      }
      context.next();
    });
  }
}
