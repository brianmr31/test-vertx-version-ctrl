package corp.Br1aN.ctrl.version.handler.version;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

import io.vertx.pgclient.PgPool;

import corp.Br1aN.ctrl.version.model.Version;

public class ListVersionHandler implements Handler<RoutingContext> {

  private PgPool pool = null;

  public ListVersionHandler(PgPool pool){
    this.pool = pool;
    // this.pool.getConnection(ar -> {
    //   // Handling your connection
    //   if (ar.succeeded()) {
    //     System.out.println("Connected");
    //   }else{
    //     System.out.println("Not Connected");
    //   }
    // });
  }

  public PgPool getPool(){
    return this.pool;
  }

  public void setConnection(PgPool pool){
    this.pool = pool;
  }

  public void handle(RoutingContext context) {
    HttpServerResponse response = context.response();
    response.putHeader("content-type", "text/plain");
    response.end("Hello World from Vert.x-Web!");
  }
}
