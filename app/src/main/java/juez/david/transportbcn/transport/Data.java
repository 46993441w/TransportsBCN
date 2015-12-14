package juez.david.transportbcn.transport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private List<Tmb> tmbs = new ArrayList<Tmb>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The tmbs
     */
    public List<Tmb> getTmbs() {
        return tmbs;
    }

    /**
     * 
     * @param tmbs
     *     The tmbs
     */
    public void setTmbs(List<Tmb> tmbs) {
        this.tmbs = tmbs;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
