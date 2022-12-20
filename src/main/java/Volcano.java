import java.time.chrono.ThaiBuddhistChronology;

public class Volcano {
    private Integer Year;
    private String Tsu;
    private String EQ;
    private String Name;
    private String Location;
    private String Country;
    private Double Latitude;
    private Double Longitude;
    private Integer Elevation;
    private String Type;
    private Integer VEI;
    private String Agent;
    private String DEATHS;
 
    
    
    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        this.Year = year;
    }

    public String getTsu() {
        return Tsu;
    }

    public void setTsu(String tsu) {
        this.Tsu = tsu;
    }

    public String getEQ() {
        return EQ;
    }

    public void setEQ(String EQ) {
        this.EQ = EQ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        this.Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        this.Longitude = longitude;
    }

    public Integer getElevation() {
        return Elevation;
    }

    public void setElevation(Integer elevation) {
        this.Elevation = elevation;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public Integer getVEI() {
        return VEI;
    }

    public void setVEI(Integer VEI) {
        this.VEI = VEI;
    }

    public String getAgent() {
        return Agent;
    }

    public void setAgent(String agent) {
        this.Agent = agent;
    }

    public String getDEATHS() {

        
        if(this.DEATHS=="")
            return "0";
        else{
            return this.DEATHS;
        }
            
    }

    public void setDEATHS(String DEATHS) {
        this.DEATHS = DEATHS;
    }
}
