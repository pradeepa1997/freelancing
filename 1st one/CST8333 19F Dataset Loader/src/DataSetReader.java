/* Author: Stanley Pieda
 * Date: Jan 1, 2019
 * Modified August 21, 2019
 * Description: Sample program, that uses Apache Commons CSV library to open
 * and print records from the CSV dataset on screen.
 * 
 * Apache Commons CSV version 1.6 downloaded from:
 * http://commons.apache.org/proper/commons-csv/download_csv.cgi
 * License is packaged within the downloadable binary zip archive,
 *  as well as included in this project folder.
 * 
 * This program was created with help from Appache Commons API documents:
 * http://commons.apache.org/proper/commons-csv/archives/1.6/apidocs/index.html
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
// import org.apache.commons.csv.CSVParser;
// import org.apache.commons.csv.CSVPrinter;

/**
 * A class that opens a csv file and outputs the data to the screen.
 * @author spieda
 */
public class DataSetReader {

    /**
     * Entry point to the program
     * @param args command-line arguments, not used in this program
     */
    public static void main(String[] args) {
        DataSetReader dataSetReader = new DataSetReader();
        List<CheeseRecord> list = new ArrayList<CheeseRecord>();
        dataSetReader.loadList(list);
        dataSetReader.printList(list);
    }

    private void loadList(List<CheeseRecord> list) {
        BufferedReader csvFile = null;
        try {
            System.out.println("Program by Stanley Pieda");
            csvFile = openFile("canadianCheeseDirectory.csv");
            
            // This example comes from 
            // Apache Commons. (2019). Apache Commons CSV User Guide
            // http://commons.apache.org/proper/commons-csv/user-guide.html
            
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(csvFile);
            for(CSVRecord record: records) {
                CheeseRecord cheese = new CheeseRecord(
                record.get("CheeseId"),
                record.get("CheeseNameEn"),
                record.get("ManufacturerNameEn"),
                record.get("ManufacturerProvCode"),
                record.get("ManufacturingTypeEn"),
                record.get("WebSiteEn"),
                record.get("FatContentPercent"),
                record.get("MoisturePercent"),
                record.get("ParticularitiesEn"),
                record.get("FlavourEn"),
                record.get("CharacteristicsEn"),
                record.get("RipeningEn"),
                record.get("Organic"),
                record.get("CategoryTypeEn"),
                record.get("MilkTypeEn"),
                record.get("MilkTreatmentTypeEn"),
                record.get("RindTypeEn"),
                record.get("LastUpdateDate"));
                list.add(cheese);
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            closeFile(csvFile);
        }
    }

    private void printList(List<CheeseRecord> list) {
        for (CheeseRecord cheese : list) {
            System.out.println(cheese);
            System.out.println();
            
        }
    }



    /**
     * Opens the file, initializes the class-level Scanner object to use the file for reading.
     * Make sure to call method closeFile() of this class before closing down the program.
     * The file used in (18F) seems to have a UTF-8 byte order mark (BOM), the code was not changed for the 19F dataset
     * See https://stackoverflow.com/questions/17405165/first-character-of-the-reading-from-the-text-file-%C3%AF/17405840
     * as answered by author Nayuki on Jul 1, 2013.
     */
    public BufferedReader openFile(String fileName) {
        BufferedReader in = null;
        try {
            //[start quoted code] Nayuki (2013). Explanatory comments by Stanley Pieda
            in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            in.mark(1); // mark current position, while allowing to read-ahead 1 character.
            if(in.read() != 0xFEFF) { // read (remove) that one character, if it is 0xFEFF skip the reset as BOM was 1st character
                in.reset(); // the 1st character is not the BOM, so reset stream back to 1st character so it will be read correctly
            }
            //[end quoted code]
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found: "
                    + ex.getMessage());
        }
        catch(IOException ex){
            System.out.println("Problem opening file: "
                    + ex.getMessage());
        }
        return in;
    }

    /**
     * Closes the class-level Scanner object, which also closes the underlying file stream.
     */
    private void closeFile(BufferedReader reader) {
        try {
            if(reader != null) {reader.close();}
        }
        catch(Exception ex) {
            System.out.println("Problem closing file: "
                    + ex.getMessage());
        }
    }

}
