package corp.Br1aN.ctrl.version;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.Promise;

import corp.Br1aN.ctrl.version.router.MainRouter;
import corp.Br1aN.ctrl.version.connection.Connection;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    VertxOptions options = new VertxOptions();
    options.setWorkerPoolSize(40);
    options.setEventLoopPoolSize(40);
    Vertx vertx = Vertx.vertx(options);

    Connection connection = new Connection( vertx );

    HttpServer server = vertx.createHttpServer();
    System.out.println("START SERVER");
    MainRouter mainRouter = new MainRouter(vertx, connection.getPool());
    // MainRouter mainRouter = new MainRouter(vertx);
    mainRouter.createHandler();

    server.requestHandler(mainRouter.getRouter()).listen(8080);
  }
}
