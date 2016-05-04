import java.util.HashMap;

public class LVListDemo {

	public static void main(String[] args) {
		
		
		
	}
	
	/*private static LVList.LvElement createLV(int number){
		
	}*/
	
	
	private static HashMap<String, String> fuelleMap(int m, int number){
		
		HashMap<String, String> map = new HashMap<String, String>(m);
		for(int i = 0; i < number; i++){
			LVList.LvElement lv = createLv(i);
		}
		return null;
	}
	
	private static long LoadFactor(){
		 
	}
	
	
	
	private static String[] Operation(int length){
	
		String[] operations = new String[length];
		
		for(int i =0; i < operations.length; i++){
			double random = Math.random();
			if(random < 0.1){
				operations[i] = "insert";
			}else if(random < 0.2){
				operations[i] = "delete";
			}else{
				operations[i] = "giveName";
			}
		}
		return operations;
	}
	
	private static LVList.LvElement erstelleLV(String lvNr, String name){
		
		
		
		return lv;
	}
}

