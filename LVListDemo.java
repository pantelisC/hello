import java.util.HashMap;
import java.util.Scanner;


public class LVListDemo {

	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("1 oder 2 Eingeben (1-loadfactor, 2-operatrionen):");
		int number = input.nextInt();
		
		if(number == 1){
			
		}else if(number == 2){
			
		}else{
			System.out.println("wrong input number");
		}
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
	
	/** 
	 * @param number
	 * 			number of LV's
	 * @param lv
	 * 			first 3 numbers of LvNr which is in every study direction different
	 * @return LVList.LvElement[] with lvElement	
	 */
	
	private static LVList.LvElement[] createLvForOpertion(int lenght, int lv){
		
		LVList.LvElement[] lvElement = new LVList.LvElement[lenght];
			
			for(int i = 0; i < lvElement.length; i++){
				lvElement[i] = createLv(lv, i);
			}
			return lvElement;			
	}
	
	private static LVList.LvElement createLv(int lv, int number){
			String lvString = String.valueOf(lv);
			String nr = String.valueOf(number);
			nr = ("000" + nr).substring(nr.length());
			
			LVList.LvElement lvnr = new LVList.LvElement(lvString + nr, nr);
			return lvnr;
	}
	
	private static LVList fillList(double length, int lv, int number) {
		LVList a = new LVList(length);
		for(int i = 0; i < number; i++) {
			LVList.LvElement lvnr = createLv(lv, i);
			a.insert(lvnr.getLvNr(), lvnr.getName());
		}
		return a;
	}
		
}
