package corp.Br1aN.ctrl.version;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.Promise;

import corp.Br1aN.ctrl.version.router.MainRouter;
import corp.Br1aN.ctrl.version.connection.Connection;

import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;
import io.vertx.ext.auth.PubSecKeyOptions;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    VertxOptions options = new VertxOptions();
    options.setWorkerPoolSize(40);
    options.setEventLoopPoolSize(40);
    Vertx vertx = Vertx.vertx(options);

    JWTAuth provider = JWTAuth.create(vertx, new JWTAuthOptions()
      .addPubSecKey(new PubSecKeyOptions()
      .setAlgorithm("HS256")
      .setPublicKey("TeloGOrengWKWKWK")
      .setSymmetric(true)));
    // Connection connection = new Connection( vertx );

    HttpServer server = vertx.createHttpServer();
    System.out.println("START SERVER");
    // MainRouter mainRouter = new MainRouter(vertx, connection.getPool());
    MainRouter mainRouter = new MainRouter(vertx, provider);
    mainRouter.createHandler();

    server.requestHandler(mainRouter.getRouter()).listen(8080);
  }
}
