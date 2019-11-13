package corp.Br1aN.ctrl.version.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import io.vertx.pgclient.PgPool;

import corp.Br1aN.ctrl.version.handler.version.ListVersionHandler;

public class MainRouter {

  private Router router = null ;
  private ListVersionHandler listVersionHandler = null;
  private PgPool pool = null;

  public MainRouter(Vertx vertx, PgPool pool){
    this.pool = pool;
    this.router =  Router.router(vertx);
    this.listVersionHandler = new ListVersionHandler(this.pool);
  }
  public PgPool getPool(){
    return this.pool;
  }
  public ListVersionHandler getVersionHandler(){
    return this.listVersionHandler;
  }
  public Router getRouter(){
    return this.router;
  }
  public void setRouter( Router router ){
    this.router = router;
  }

  public void createHandler(){
    this.router.route().handler(BodyHandler.create());
    this.router.get("/api/v1/versions").handler(this.listVersionHandler);
    // this.router.get("/api/v1/versions").handler(this.versionHandler.handleListVersion());
    // this.router.get("/api/v1/version/:versionId").handler(this.versionHandler.handleGetVersion());
    // this.router.get("/api/v1/version/del/:versionId").handler(this.versionHandler.handleDelVersion());
    // this.router.post("/api/v1/version/").consumes("application/json").handler(this.versionHandler.handleAddVersion());
    // this.router.post("/api/v1/version/:versionId").consumes("application/json").handler(this.versionHandler.handlePutVersion());
  }
}
