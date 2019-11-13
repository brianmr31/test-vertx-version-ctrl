package corp.Br1aN.ctrl.version.model;

import java.util.Date;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

public class Version {
    private long version_id;
    private String version_name;
    private String version_is_force;
    private String version_app_type;
    private String version_created_by;
    private Date version_created_at;
    private boolean version_deleted_flag;

    public Version(long version_id, String version_name, String version_is_force, String version_app_type){
      this.version_id = version_id;
      this.version_name = version_name;
      this.version_is_force = version_is_force;
      this.version_app_type = version_app_type;
      this.version_created_by = "brian";
      this.version_created_at = new Date();
      this.version_deleted_flag = false;
    }

    public long getVersionId(){
      return this.version_id;
    }
    public void setVersionId(long version_id){
      this.version_id = version_id;
    }
    public String getVersionName(){
      return this.version_name;
    }
    public void setVersionName(String version_name){
      this.version_name = version_name;
    }
    public String getVersionIsForce(){
      return this.version_is_force;
    }
    public void setVersionIsForce(String version_is_force){
      this.version_is_force = version_is_force;
    }
    public String getVersionAppType(){
      return this.version_app_type;
    }
    public void setVersionAppType(String version_app_type){
      this.version_app_type = version_app_type;
    }
    public String getVersionCreatedBy(){
      return this.version_created_by;
    }
    public void setVersionCreatedBy(String version_created_by){
      this.version_created_by = version_created_by;
    }
    public Date getVersionCreatedAt(){
      return this.version_created_at;
    }
    public void setVersionCreatedAt(Date version_created_at){
      this.version_created_at = version_created_at;
    }
    public boolean getVersionDeletedFlag(){
      return this.version_deleted_flag;
    }
    public void setVersionDeletedFlag(boolean version_deleted_flag){
      this.version_deleted_flag = version_deleted_flag;
    }
}
