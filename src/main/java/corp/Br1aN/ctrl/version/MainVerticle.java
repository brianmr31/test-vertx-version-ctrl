package corp.Br1aN.ctrl.version;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.Promise;

import corp.Br1aN.ctrl.version.router.MainRouter;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start(Promise<Void> startPromise) throws Exception {
    HttpServer server = vertx.createHttpServer();

    MainRouter mainRouter = new MainRouter(vertx);
    mainRouter.createHandler();

    server.requestHandler(mainRouter.getRouter()).listen(8080);
  }
}
