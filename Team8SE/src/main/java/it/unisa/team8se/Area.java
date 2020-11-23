package it.unisa.team8se;


/**
 * @author cptso
 * @version 1.0
 * @created 22-nov-2020 11:33:34
 */
public class Area {

    private String Sector;
    private String Location;

    public Area(){

    }

    public Area(String Sector, String Location) {
        this.Sector = Sector;
        this.Location = Location;
    }

    
    public void finalize() throws Throwable {

    }

    public String getSector() {
        return Sector;
    }

    public String getLocation() {
        return Location;
    }

    @Override
    public String toString() {
        return Sector + " - "+ Location;
    }
	
}//end Area