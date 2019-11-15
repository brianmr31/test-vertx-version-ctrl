package corp.Br1aN.ctrl.version.handler.auth;

import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.core.http.HttpServerResponse;

import io.vertx.core.json.JsonObject;

public class LoginAuthHandler implements Handler<RoutingContext> {

  private JWTAuth provider;

  public LoginAuthHandler(JWTAuth provider){
    this.provider = provider;
  }

  public void handle(RoutingContext context) {

    String token = this.provider.generateToken(new JsonObject());

    HttpServerResponse response = context.response();
    // HttpServerResponse response = context.response();
    System.out.println("Check Auth Handler");
    String isAuth = "false";
    JsonObject json = new JsonObject().put("message", token);
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
