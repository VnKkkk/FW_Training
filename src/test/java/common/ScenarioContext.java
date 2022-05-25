package common;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Map<String, Object> scenarioContext;

    public static void setContext(Enums key, Object value) {
        scenarioContext = new HashMap<String, Object>();
        scenarioContext.put(key.toString(), value);
    }

    public static Object getContext(Enums key){
        return scenarioContext.get(key.toString());
    }

    public static Boolean isContains(Enums key){
        return scenarioContext.containsKey(key.toString());
    }
}
