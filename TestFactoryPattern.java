package readfile;

public class TestFactoryPattern {
	
	public static void main(String args[]){
		
		System.out.println(FactoryDesign.getReader("CSVReader").Read());
		
	}

}
