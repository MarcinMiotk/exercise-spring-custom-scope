package pl.wind.humpback.app.scopesample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 *
 */
public class DialogScope implements Scope {

    private final Map<String, Object> objectMap = Collections.synchronizedMap(new HashMap<String, Object>());

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#get(java.lang.String,
     * org.springframework.beans.factory.ObjectFactory)
     */
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        System.out.println("######      get-" + name + "-" + objectFactory);

        if (!objectMap.containsKey(name)) {
            objectMap.put(name, objectFactory.getObject());
        }
        return objectMap.get(name);

    }

    /**
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.config.Scope#remove(java.lang.String)
     */
    @Override
    public Object remove(String name) {
        System.out.println("######      remove-" + name);

        return objectMap.remove(name);
    }

    /**
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.config.Scope#registerDestructionCallback(java.lang.String,
     * java.lang.Runnable)
     */
    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // do nothing
        System.out.println("######      registerDestructionCallback-" + name + "-" + callback);
    }

    /**
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.config.Scope#resolveContextualObject(java.lang.String)
     */
    @Override
    public Object resolveContextualObject(String key) {

        System.out.println("######      resolveContextualObject-" + key);

        return null;
    }

    /**
     * (non-Javadoc)
     *
     * @see org.springframework.beans.factory.config.Scope#getConversationId()
     */
    @Override
    public String getConversationId() {

        System.out.println("######      getConversationId-");

        return "DialogScope";
    }

    /**
     * vaporize the beans
     */
    public void vaporize() {
        objectMap.clear();
    }

}
