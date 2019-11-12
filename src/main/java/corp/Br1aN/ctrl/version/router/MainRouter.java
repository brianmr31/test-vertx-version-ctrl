package corp.Br1aN.ctrl.version.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import corp.Br1aN.ctrl.version.router.VersionHandler;

public class MainRouter {

  private Router router = null ;

  public MainRouter(Vertx vertx){
    this.router =  Router.router(vertx);
  }
  public Router getRouter(){
    return this.router;
  }
  public void setRouter( Router router ){
    this.router = router;
  }

  public void createHandler(){
    this.router.route().handler(BodyHandler.create());
    this.router.get("/api/v1/versions").handler(VersionHandler::handleListVersion);
    this.router.get("/api/v1/version/:versionId").handler(VersionHandler::handleGetVersion);
    this.router.get("/api/v1/version/del/:versionId").handler(VersionHandler::handleDelVersion);
    this.router.post("/api/v1/version/").consumes("application/json").handler(VersionHandler::handleAddVersion);
    this.router.post("/api/v1/version/:versionId").consumes("application/json").handler(VersionHandler::handlePutVersion);
  }
}
