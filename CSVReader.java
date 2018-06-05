package readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVReader implements Reader {

	@Override
	public String Read() {
		// TODO Auto-generated method stub
		String csvFile = "C:/Users/Aman/Desktop/Dummy.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        int indmcount=0;
        int indfcount=0;
        int indmincome=0;
        int indfincome=0;
        int usamcount=0;
        int usafcount=0;
        int usamincome=0;
        int usafincome=0;
        int engmcount=0;
        int engfcount=0;
        int engmincome=0;
        int engfincome=0;
        int japmcount=0;
        int japfcount=0;
        int japmincome=0;
        int japfincome=0;


        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
               
              //  System.out.println("Country [code= " + country[0] + " , Gender=" + country[1] + ",  Income=" + country[2] + "]");
               
                if(country[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("India")){
                	if(country[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("male")){
                		indmcount++;
                		indmincome+=Integer.parseInt(country[2].replaceAll("^\"|\"$", ""));
                		
                		
                	}else if(country[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("female")){
                		indfcount++;
                		indfincome+=Integer.parseInt(country[2].replaceAll("^\"|\"$", ""));
                		
                		
                	}
                	
                }
               
               
                if(country[0].replaceAll("^\"|\"$", "").equalsIgnoreCase("USA")){
                	if(country[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("male")){
                		usamcount++;
                		usamincome+=Integer.parseInt(country[2].replaceAll("^\"|\"$", ""));
                		
                		
                	}else if(country[1].replaceAll("^\"|\"$", "").equalsIgnoreCase("female")){
                		usafcount++;
                		usafincome+=Integer.parseInt(country[2].replaceAll("^\"|\"$", ""));
                		
                	}
                }
              
            }
            final String FILE_HEADER = "id,firstName,lastName,gender,age";
            final String NEW_LINE_SEPARATOR = "\n";


            FileWriter fileWriter = null;
            fileWriter = new FileWriter("C:/Users/Aman/Desktop/modi.csv");
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);


           fileWriter.append("India"  +  "Male" + indmincome/indmcount);
           fileWriter.append("India"  +  "Female" + indfincome/indfcount);
           fileWriter.append("USA"  +  "Male" + usamincome/usamcount);
           fileWriter.append("USA"  +  "Female" + usafincome/usafcount);
           fileWriter.flush();
           fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    
		return "CSV Read";
	}

}
