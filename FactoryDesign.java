package readfile;

public class FactoryDesign {
	
	public static Reader getReader(String readertype){
		Reader reader=null;
		if(readertype.equalsIgnoreCase("Database")){
			reader=new DatabaeReader();
		}else if(readertype.equals("CSVReader")){
			reader=new CSVReader();
		}else if(readertype.equalsIgnoreCase("ExcelReader")){
			reader=new ExcelReader();
		}
		
		return reader;
		
	}

}
