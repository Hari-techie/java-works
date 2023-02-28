public class City
{
    String city,country,iso2,capital,adminName;
    double latitude,longitude;
    long population,populationId;
    public City(String city, String country, String iso2, String capital, String adminName, double latitude,
            double longitude, long population, long populationId) {
        this.city = city;
        this.country = country;
        this.iso2 = iso2;
        this.capital = capital;
        this.adminName = adminName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.populationId = populationId;
    }
    @Override
    public String toString() {
        return "City [city=" + city + ", country=" + country + ", iso2=" + iso2 + ", capital=" + capital
                + ", adminName=" + adminName + ", latitude=" + latitude + ", longitude=" + longitude + ", population="
                + population + ", populationId=" + populationId + "]";
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getIso2() {
        return iso2;
    }
    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public String getAdminName() {
        return adminName;
    }
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }
    public long getPopulationId() {
        return populationId;
    }
    public void setPopulationId(long populationId) {
        this.populationId = populationId;
    }
    
}