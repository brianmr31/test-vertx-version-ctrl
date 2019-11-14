package corp.Br1aN.ctrl.version.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import io.vertx.pgclient.PgPool;

import corp.Br1aN.ctrl.version.handler.version.ListVersionHandler;
import corp.Br1aN.ctrl.version.handler.backend.GetTestHandler;
import corp.Br1aN.ctrl.version.handler.log.AddLogHandler;
import corp.Br1aN.ctrl.version.handler.auth.CheckAuthHandler;
public class MainRouter {

  private Router router = null ;
  private PgPool pool = null;

  private ListVersionHandler versionHandler = null;
  private GetTestHandler getTestHandler = null;
  private AddLogHandler addLogHandler = null;
  private CheckAuthHandler checkAuthHandler = null;

  public MainRouter(Vertx vertx){
    this.router =  Router.router(vertx);
    // this.listVersionHandler = new ListVersionHandler(this.pool);
    this.getTestHandler = new GetTestHandler();
    this.addLogHandler = new AddLogHandler();
    this.checkAuthHandler = new CheckAuthHandler();
  }
  public MainRouter(Vertx vertx, PgPool pool){
    this.pool = pool;
    this.router =  Router.router(vertx);
    this.versionHandler = new ListVersionHandler(this.pool);
    this.getTestHandler = new GetTestHandler();
    this.addLogHandler = new AddLogHandler();
    this.checkAuthHandler = new CheckAuthHandler();
  }

  public PgPool getPool(){
    return this.pool;
  }
  public Router getRouter(){
    return this.router;
  }
  public void setRouter( Router router ){
    this.router = router;
  }

  public void createHandler(){
    this.router.route().handler(BodyHandler.create());
    // this.router.get("/api/v1/versions").handler(this.listVersionHandler);
    this.router.get("/api/v1/backend/*").order(0).handler(this.addLogHandler);
    this.router.get("/api/v1/backend/*").order(1).handler(this.checkAuthHandler);
    this.router.get("/api/v1/backend/test").order(2).handler(this.getTestHandler);
    this.router.get("/api/v1/versions").order(2).handler(this.versionHandler);
    // this.router.get("/api/v1/version/:versionId").handler(this.versionHandler.handleGetVersion());
    // this.router.get("/api/v1/version/del/:versionId").handler(this.versionHandler.handleDelVersion());
    // this.router.post("/api/v1/version/").consumes("application/json").handler(this.versionHandler.handleAddVersion());
    // this.router.post("/api/v1/version/:versionId").consumes("application/json").handler(this.versionHandler.handlePutVersion());
  }
}
