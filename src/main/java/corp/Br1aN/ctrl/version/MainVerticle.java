package corp.Br1aN.ctrl.version;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.Promise;

import corp.Br1aN.ctrl.version.router.MainRouter;
import corp.Br1aN.ctrl.version.connection.Connection;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    Connection connection = new Connection( vertx );

    HttpServer server = vertx.createHttpServer();

    MainRouter mainRouter = new MainRouter(vertx, connection.getPool());
    mainRouter.createHandler();

    server.requestHandler(mainRouter.getRouter()).listen(8080);
  }
}
