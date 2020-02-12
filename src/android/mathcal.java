package cordova.plugin.mathcal;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class mathcal extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else if(action.equals("add")){
           this.add(args, callbackContext);
           return true;
        }else if(action.equals("substract")){
            this.substract(args, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext)
    {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void add(JSONArray args,CallbackContext callbackContext){

        if(args != null){
            try{
                int param1 = Integer.parseInt(args.getJSONobject(0).getString("param1"));
                int param2 = Integer.parseInt(args.getJSONobject(1).getString("param2"));
                int result = param1 + param2;
                callbackContext.success("Addition of two is "+result);
            }catch(Exception ex){
               callbackContext.error("Something went wrong "+ex);
            }
        }else{
            callbackContext.error("Parameters should not be null");
        }
    }

    private void substract(JSONArray args,CallbackContext callbackContext){

        if(args != null){
            try{
                int param1 = Integer.parseInt(args.getJSONobject(0).getString("param1"));
                int param2 = Integer.parseInt(args.getJSONobject(1).getString("param2"));
                int result = param1 - param2;
                callbackContext.success("Substraction of two is "+result);
            }catch(Exception ex){
               callbackContext.error("Something went wrong "+ex);
            }
        }else{
            callbackContext.error("Parameters should not be null");
        }
    }
}
