package juez.david.transportbcn.transport;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Tmb> tmbs = new ArrayList<Tmb>();
    private List<Bici> bici = new ArrayList<Bici>();
    private List<Metro> metro = new ArrayList<Metro>();

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

    /**
     *
     * @return
     *     The bici
     */
    public List<Bici> getBici() {
        return bici;
    }

    /**
     *
     * @param bici
     *     The bici
     */
    public void setBici(List<Bici> bici) {
        this.bici = bici;
    }

    /**
     *
     * @return
     *     The metro
     */
    public List<Metro> getMetro() {
        return metro;
    }

    /**
     *
     * @param metro
     *     The metro
     */
    public void setMetro(List<Metro> metro) {
        this.metro = metro;
    }
}
