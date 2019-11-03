/* Author: Stanley Pieda
 * Date August 21, 2019
 * Description: Record object for cheese records.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/** 
 * Represents a cheese record from a csv file 
 * @author Stanley Pieda
 */
public class CheeseRecord {
    /** Cheese Id */
    private Integer cheeseId;
    
    /** Cheese Name in English */
    private String cheeseNameEn;
    
    /** Manufacturer Name in English */
    private String manufacturerNameEn;
    
    /** Manufacturer Province Code */
    private String manufacturerProvCode;
    
    /** Manufacturing Type in English */
    private String manufacturingTypeEn;
    
    /** Web Site URL in English */
    private String webSiteEn;
    
    /** Fat Content as Percent */
    private Double fatContentPercent;
    
    /** Moisture as Percent */
    private Double moisturePercent;
    
    /** Particularities in English */
    private String particularitiesEn;
    
    /** Flavour in English */
    private String flavourEn;
    
    /** Characteristics in English */
    private String characteristicsEn;
    
    /** Ripening in English */
    private String ripeningEn;
    
    /** Organic or not */
    private Boolean organic;
    
    /** Category Type in English */
    private String categoryTypeEn;
    
    /** Milk Type in English */
    private String milkTypeEn;
    
    /** Milk Treatment Type in English */
    private String milkTreatmentTypeEn;
    
    /** Rind Type in English */
    private String rindTypeEn;
    
    /** Last Update Date */
    private LocalDate lastUpdateDate;
    
    /** Default Constructor */
    public CheeseRecord() {}

    /** String-based constructor, to facilitate reading string values from csv file.
     * The strings are cleaned, and converted to the appropriate type where needed, 
     * additionally empty strings are converted to null references.
     * @param cheeseId
     * @param cheeseNameEn
     * @param manufacturerNameEn
     * @param manufacturerProvCode
     * @param manufacturingTypeEn
     * @param webSiteEn
     * @param fatContentPercent
     * @param moisturePercent
     * @param particularitiesEn
     * @param flavourEn
     * @param characteristicsEn
     * @param ripeningEn
     * @param organic
     * @param categoryTypeEn
     * @param milkTypeEn
     * @param milkTreatmentTypeEn
     * @param rindTypeEn
     * @param lastUpdateDate
     */
    public CheeseRecord(
            String    cheeseId,         
            String    cheeseNameEn, 
            String    manufacturerNameEn,
            String    manufacturerProvCode,
            String    manufacturingTypeEn,
            String    webSiteEn,  
            String    fatContentPercent,
            String    moisturePercent,   
            String    particularitiesEn, 
            String    flavourEn,    
            String    characteristicsEn,
            String    ripeningEn,  
            String    organic,   
            String    categoryTypeEn,   
            String    milkTypeEn,    
            String    milkTreatmentTypeEn,
            String    rindTypeEn, 
            String    lastUpdateDate) {

        this.cheeseId               = processAsInteger(cheeseId);
        this.cheeseNameEn           = processAsString(cheeseNameEn);   
        this.manufacturerNameEn     = processAsString(manufacturerNameEn);
        this.manufacturerProvCode   = processAsString(manufacturerProvCode);
        this.manufacturingTypeEn    = processAsString(manufacturingTypeEn);
        this.webSiteEn              = processAsString(webSiteEn);
        this.fatContentPercent      = processAsDouble(fatContentPercent);
        this.moisturePercent        = processAsDouble(moisturePercent); 
        this.particularitiesEn      = processAsString(particularitiesEn); 
        this.flavourEn              = processAsString(flavourEn);         
        this.characteristicsEn      = processAsString(characteristicsEn); 
        this.ripeningEn             = processAsString(ripeningEn);  
        this.organic                = processAsBoolean(organic);      
        this.categoryTypeEn         = processAsString(categoryTypeEn);  
        this.milkTypeEn             = processAsString(milkTypeEn);      
        this.milkTreatmentTypeEn    = processAsString(milkTreatmentTypeEn);
        this.rindTypeEn             = processAsString(rindTypeEn);
        this.lastUpdateDate         = processAsLocalDate(lastUpdateDate);        
    }

    /** Accessor for cheeseId */
    public int getCheeseId() {
        return cheeseId;
    }
    /** Mutator for cheeseId */
    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }
    /** Accessor for cheeseNameEn */
    public String getCheeseNameEn() {
        return cheeseNameEn;
    }
    /** Mutator for cheeseNameEn */
    public void setCheeseNameEn(String cheeseNameEn) {
        this.cheeseNameEn = cheeseNameEn;
    }
    /** Accessor for manufacturerNameEn */
    public String getManufacturerNameEn() {
        return manufacturerNameEn;
    }
    /** Mutator for manufacturerNameEn */
    public void setManufacturerNameEn(String manufacturerNameEn) {
        this.manufacturerNameEn = manufacturerNameEn;
    }
    /** Accessor for manufacturerProvCode */
    public String getManufacturerProvCode() {
        return manufacturerProvCode;
    }
    /** Mutator for manufacturerProvCode */
    public void setManufacturerProvCode(String manufacturerProvCode) {
        this.manufacturerProvCode = manufacturerProvCode;
    }
    /** Accessor for manufacturingTypeEn */
    public String getManufacturingTypeEn() {
        return manufacturingTypeEn;
    }
    /** Mutator for manufacturingTypeEn */
    public void setManufacturingTypeEn(String manufacturingTypeEn) {
        this.manufacturingTypeEn = manufacturingTypeEn;
    }
    /** Accessor for webSiteEn */
    public String getWebSiteEn() {
        return webSiteEn;
    }
    /** Mutator for webSiteEn */
    public void setWebSiteEn(String webSiteEn) {
        this.webSiteEn = webSiteEn;
    }
    /** Accessor for fatContentPercent */
    public double getFatContentPercent() {
        return fatContentPercent;
    }
    /** Mutator for fatContentPercent */
    public void setFatContentPercent(double fatContentPercent) {
        this.fatContentPercent = fatContentPercent;
    }
    /** Accessor for moisturePercent */
    public double getMoisturePercent() {
        return moisturePercent;
    }
    /** Mutator for moisturePercent */
    public void setMoisturePercent(double moisturePercent) {
        this.moisturePercent = moisturePercent;
    }
    /** Accessor for particularitiesEn */
    public String getParticularitiesEn() {
        return particularitiesEn;
    }
    /** Mutator for particularitiesEn */
    public void setParticularitiesEn(String particularitiesEn) {
        this.particularitiesEn = particularitiesEn;
    }
    /** Accessor for flavourEn */
    public String getFlavourEn() {
        return flavourEn;
    }
    /** Mutator for flavourEn */
    public void setFlavourEn(String flavourEn) {
        this.flavourEn = flavourEn;
    }
    /** Accessor for characteristicsEn */
    public String getCharacteristicsEn() {
        return characteristicsEn;
    }
    /** Mutator for characteristicsEn */
    public void setCharacteristicsEn(String characteristicsEn) {
        this.characteristicsEn = characteristicsEn;
    }
    /** Accessor for ripeningEn */
    public String getRipeningEn() {
        return ripeningEn;
    }
    /** Mutator for ripeningEn */
    public void setRipeningEn(String ripeningEn) {
        this.ripeningEn = ripeningEn;
    }
    /** Accessor for organic */
    public boolean isOrganic() {
        return organic;
    }
    /** Mutator for organic */
    public void setOrganic(boolean organic) {
        this.organic = organic;
    }
    /** Accessor for categoryTypeEn */
    public String getCategoryTypeEn() {
        return categoryTypeEn;
    }
    /** Mutator for categoryTypeEn */
    public void setCategoryTypeEn(String categoryTypeEn) {
        this.categoryTypeEn = categoryTypeEn;
    }
    /** Accessor for milkTypeEn */
    public String getMilkTypeEn() {
        return milkTypeEn;
    }
    /** Mutator for milkTypeEn */
    public void setMilkTypeEn(String milkTypeEn) {
        this.milkTypeEn = milkTypeEn;
    }
    /** Accessor for milkTreatmentTypeEn */
    public String getMilkTreatmentTypeEn() {
        return milkTreatmentTypeEn;
    }
    /** Mutator for milkTreatmentTypeEn */
    public void setMilkTreatmentTypeEn(String milkTreatmentTypeEn) {
        this.milkTreatmentTypeEn = milkTreatmentTypeEn;
    }
    /** Accessor for rindTypeEn */
    public String getRindTypeEn() {
        return rindTypeEn;
    }
    /** Mutator for rindTypeEn */
    public void setRindTypeEn(String rindTypeEn) {
        this.rindTypeEn = rindTypeEn;
    }
    /** Accessor for lastUpdateDate */
    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }
    /** Mutator for lastUpdateDate */
    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
    
    /** basic string reprentation of the cheese record */
    @Override
    public String toString() {
        return String.format(
                "%d,%s,%s,%s,%s,%s,%f,%f,%s,%s,%s,%s,%b,%s,%s,%s,%s,%s",
                cheeseId,            
                cheeseNameEn,        
                manufacturerNameEn,  
                manufacturerProvCode,
                manufacturingTypeEn, 
                webSiteEn,           
                fatContentPercent,   
                moisturePercent,     
                particularitiesEn,   
                flavourEn,           
                characteristicsEn,   
                ripeningEn,          
                organic,             
                categoryTypeEn,      
                milkTypeEn,          
                milkTreatmentTypeEn, 
                rindTypeEn,          
                (lastUpdateDate == null? null:lastUpdateDate.format(DateTimeFormatter.ofPattern("yyyy MM dd")))
                );
    }
    
    /** Utility method to trim String of whitespace, resulting empty Strings
     * or Strings with only "null" result in null reference being returned.
     * @param value String to be processed
     * @return processed String or null
     */
    private String processAsString(String value) {
        if(value == null || value.trim().isEmpty() || value.trim().equalsIgnoreCase("null")){
            return null;
        }
        else {
            return value.trim();
        }   
    }
    
    /** Utility method that cleans the String passed and attempts to convert
     * it into an Integer. If the passed String is null, empty, or contains "null",
     * then a null is returned.
     * @param value String to be processed
     * @return Integer or null
     */
    private Integer processAsInteger(String value) {
        String result = processAsString(value);
        return (result == null ? null: Integer.parseInt(result));
    }
    
    /** Utility method that cleans the String passed and attempts to convert
     * it into a Double. If the passed String is null, empty, or contains "null",
     * then a null is returned.
     * @param value String to be processed
     * @return Double or null
     */
    private Double processAsDouble(String value) {
        String result = processAsString(value);
        return (result == null ? null: Double.parseDouble(result));
    }
    
    /** Utility method that cleans the String passed and attempts to convert
     * it into a Boolean. If the passed String is null, empty, or contains "null",
     * then a null is returned. Values of "1", "yes", "on", "true" are returned
     * as true while everything else is returned as false.
     * @param value String to be processed
     * @return Boolean or null
     */
    private Boolean processAsBoolean(String value) {
        // See Saqib (Aug 24, 2013) Boolean.parseBoolean("1") = false...? at:
        // https://stackoverflow.com/questions/7734202/boolean-parseboolean1-false
        String result = processAsString(value);
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) || 
                "true".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value))
                returnValue = true;
        return returnValue;
    }
    
    /** Utility method that cleans the String passed and attempts to convert
     * it into a LocalDate. If the passed String is null, empty, or contains "null",
     * then a null is returned.
     * @param value String to be processed
     * @return LocalDate or null
     */
    private LocalDate processAsLocalDate(String value) {
        String result = processAsString(value);
        return (result == null ? null: LocalDate.parse(result));
    }
}
