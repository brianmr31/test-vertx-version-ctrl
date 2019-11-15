package corp.Br1aN.ctrl.version.router;

import io.vertx.core.Vertx;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import io.vertx.pgclient.PgPool;

import corp.Br1aN.ctrl.version.handler.version.ListVersionHandler;
import corp.Br1aN.ctrl.version.handler.backend.RouterHandler;
import corp.Br1aN.ctrl.version.handler.backend.RequestHandler;
import corp.Br1aN.ctrl.version.handler.log.AddLogHandler;
import corp.Br1aN.ctrl.version.handler.auth.VerificationAuthHandler;
import corp.Br1aN.ctrl.version.handler.auth.LoginAuthHandler;

public class MainRouter {

  private Router router = null ;
  private PgPool pool = null;
  private JWTAuth provider = null;

  private ListVersionHandler versionHandler = null;
  private RouterHandler routerHandler = null;
  private RequestHandler requestHandler = null;
  private AddLogHandler addLogHandler = null;
  private VerificationAuthHandler verificationAuthHandler = null;
  private LoginAuthHandler loginAuthHandler = null;

  public MainRouter(Vertx vertx, JWTAuth provider){
    // this.pool = pool;
    this.provider = provider;
    this.router =  Router.router(vertx);
    // this.listVersionHandler = new ListVersionHandler(this.pool);
    this.routerHandler = new RouterHandler();
    this.requestHandler = new RequestHandler(vertx);
    this.addLogHandler = new AddLogHandler();
    this.verificationAuthHandler = new VerificationAuthHandler(this.provider);
    this.loginAuthHandler = new LoginAuthHandler(this.provider);
  }
  public MainRouter(Vertx vertx, PgPool pool, JWTAuth provider){
    this.pool = pool;
    this.provider = provider;
    this.router =  Router.router(vertx);
    this.versionHandler = new ListVersionHandler(this.pool);
    this.routerHandler = new RouterHandler();
    this.requestHandler = new RequestHandler(vertx);
    this.addLogHandler = new AddLogHandler();
    this.verificationAuthHandler = new VerificationAuthHandler(this.provider);
    this.loginAuthHandler = new LoginAuthHandler(this.provider);
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
    this.router.get("/api/v1/backend/*").order(1).handler(this.verificationAuthHandler);
    this.router.get("/api/v1/backend/*").order(2).handler(this.routerHandler);
    this.router.get("/api/v1/backend/*").order(3).handler(this.requestHandler);
    this.router.get("/api/v1/versions").order(3).handler(this.versionHandler);
    this.router.get("/api/v1/auth").order(3).handler(this.loginAuthHandler);
    // this.router.get("/api/v1/version/:versionId").handler(this.versionHandler.handleGetVersion());
    // this.router.get("/api/v1/version/del/:versionId").handler(this.versionHandler.handleDelVersion());
    // this.router.post("/api/v1/version/").consumes("application/json").handler(this.versionHandler.handleAddVersion());
    // this.router.post("/api/v1/version/:versionId").consumes("application/json").handler(this.versionHandler.handlePutVersion());
  }
}
