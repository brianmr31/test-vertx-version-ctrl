package corp.Br1aN.ctrl.version.handler.version;

import java.util.List;
import java.util.ArrayList;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonObject;

import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.RoutingContext;

import io.vertx.sqlclient.SqlConnection;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.Row;

import io.vertx.pgclient.PgPool;

import corp.Br1aN.ctrl.version.model.Version;

public class ListVersionHandler implements Handler<RoutingContext> {

  private PgPool pool = null;

  public ListVersionHandler(PgPool pool){
    this.pool = pool;
  }

  public PgPool getPool(){
    return this.pool;
  }

  public void setConnection(PgPool pool){
    this.pool = pool;
  }

  public void handle(RoutingContext context) {
    HttpServerResponse response = context.response();
    this.pool.getConnection(ar -> {
      // Handling your connection
      if (ar.succeeded()) {
        SqlConnection conn = ar.result();
        conn.query("SELECT * FROM version where version_id = 1 limit 1", ar2 -> {
          if (ar2.succeeded()) {
              List<Version> versions = new ArrayList<Version>();
              RowSet<Row> rows = ar2.result();
              for (Row row : rows) {
                // System.out.println("TELLOOOOO " + row.getLong(0) + " " + row.getString(1)+" "+row.getString(2)+" "+row.getString(3) );
                versions.add(new Version(row.getLong(0), row.getString(1), row.getString(2), row.getString(3) ));
              }
              response.putHeader("content-type", "application/json");
              JsonObject json = new JsonObject().put("message", versions);
              response.end(json.encodePrettily());
          }
          conn.close();
        });
        System.out.println("Connected");
      }else{
        System.out.println("Not Connected");
      }
    });
  }
}
