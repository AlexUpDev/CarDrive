import java.util.*;

class Transmission{

    private String mode = "P";

    public void setMode(String mode,double speed) {
        if (speed == 0.0) {
            this.mode = mode;
        } else if (speed > 0 && (mode == "N" || mode == "D")) {
            this.mode = mode;
        } else if (speed < 0 && (mode == "N" || mode == "R")) {
            this.mode = mode;
        }
    }
    public String getMode() {
        return this.mode;
    }

}
