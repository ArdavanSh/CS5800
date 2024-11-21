package part2;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class Vehicle implements PropertyChangeListener {

    private String observedStatus;

    public Vehicle() {
        this.observedStatus = "No updates";
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        this.observedStatus = (String) event.getNewValue();
    }

    public String getObservedStatus() {
        return observedStatus;
    }

}


