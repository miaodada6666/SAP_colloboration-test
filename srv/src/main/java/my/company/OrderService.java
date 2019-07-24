package my.company;
 import java.util.Arrays;
import java.util.HashMap;

import com.sap.cloud.sdk.service.prov.api.DataSourceHandler;
import com.sap.cloud.sdk.service.prov.api.EntityData;
import com.sap.cloud.sdk.service.prov.api.ExtensionHelper;
import com.sap.cloud.sdk.service.prov.api.annotations.Action;
import com.sap.cloud.sdk.service.prov.api.exception.DatasourceException;
import com.sap.cloud.sdk.service.prov.api.operations.Create;
import com.sap.cloud.sdk.service.prov.api.request.CreateRequest;
import com.sap.cloud.sdk.service.prov.api.request.OperationRequest;
import com.sap.cloud.sdk.service.prov.api.response.CreateResponse;
import com.sap.cloud.sdk.service.prov.api.response.ErrorResponse;
import com.sap.cloud.sdk.service.prov.api.response.OperationResponse;
public class OrderService {
	@Create(serviceName="CatalogService",entity="StatusProfile")
	public CreateResponse addCustomer(CreateRequest createRequest,ExtensionHelper extensionHelper)
	{
        DataSourceHandler handler=extensionHelper.getHandler();
        EntityData entityData=createRequest.getData();
        String state="Create";
        entityData=EntityData.getBuilder(entityData).removeElement("description").addElement("description",state).buildEntityData("StatusProfile");
        try {
            EntityData createdEntity=handler.executeInsert(entityData,true);
            CreateResponse createResponse=CreateResponse.setSuccess().setData(createdEntity).response();
            return createResponse;
        } catch (DatasourceException e) {
            ErrorResponse errorResponse=ErrorResponse.getBuilder().setMessage(e.getMessage()).setCause(e).response();
            return CreateResponse.setError(errorResponse);
            //TODO: handle exception
        }		
    }
    @Action(Name="setToUse",serviceName="CatalogService")
    public OperationResponse setToUse(OperationRequest actionRequest,ExtensionHelper extensionHelper)
    {
        java.util.Map<String, Object> parameters=actionRequest.getParameters();
        DataSourceHandler handler =extensionHelper.getHandler();
        java.util.Map<String, Object> keys=new HashMap<String,Object>();
        keys.put("ID",String.valueOf(parameters.get("ID"))); 
      try {
          EntityData entityData=handler.executeRead("StatusProfile",keys,Arrays.asList("ID"));
          String state="Action";
          entityData =EntityData.getBuilder(entityData).removeElement("desription").addElement("description",state).buildEntityData("StatusProfile");
          handler.executeUpdate(entityData,keys,false);
          OperationResponse response=OperationResponse.setSuccess().setEntityData(Arrays.asList(entityData)).response();
          return response;
      } catch (DatasourceException e) 
      {
          ErrorResponse errorResponse=ErrorResponse.getBuilder().setMessage(e.getMessage()).setCause(e).response();
          return OperationResponse.setError(errorResponse);

      }
          //TODO: handle exception
      
    }

}
