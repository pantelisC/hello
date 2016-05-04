
public class LVList {

	public static class LvElement{
		
		private String name;
		private String lvNr;
		private LvElement next;
	
		
		public LvElement(String lvNr, String name){
			this.name = name;
			this.lvNr = lvNr;
			this.next = null;
		}
	
		public void setName(String name){
			this.name = name;
		}
	
		public String getName(){
			return name;
		}
	
		public void setLvNr(String lvNr){
			this.lvNr = lvNr;
		}
	
		public String getLvNr(){
			return lvNr;
		}
	
		public void setNext(LvElement next){
			this.next = next;
		}
		
		public LvElement getNext(){
			int i, j = 0;
			j = hashCode();
		
			return next;
		}
	
		/*public int h(LvElement k){
			
			return (int) k.hashCode();
		}
		
		public void hashF(int k){
			int i = 0; 
			int j = 0;
			
			if(i >= 0){
				j=h(k);
			}else{
				j = i + j;
			}
		}*/
	}
	
	private LvElement[] hashTable;
	
	
	 /**
     * constructor for a hash table with length 2^power and load limit less or equal 1
      */
     public LVList(int power, double loadLimit){
    	 
    	 if(loadLimit <= 1){
    	 hashTable = new LvElement[(int) Math.pow(2, power)];
    	 }
    	 
    /*	 if(power > loadLimit){
    		hashTable = new LV[2*hashTable.length];
    	}*/
     }
     
     public int h(LvElement k){
			return k.hashCode();
		}
     
	private int getPosition(String lvNr){
		
		int m = giveLength();
		LvElement k = null;
		int i = 0;
		int j = h(k);
		int hash = 0;
		
		for(int a = 0; a < hashTable.length; a++){
			
			if(hashTable[a] != null){
				j = i + j;
			}
		}
		hash = j % m;
		return hash;
	}
	
	   private boolean validLvNr(String lvNr){
	    	 String numbers = "[0-9]+";
	    	 
	    	 if(lvNr.length() == 6 && lvNr.matches(numbers)){
	    		 return true;
	    	 }else 
	    		 return false;
	     }
	
	/**
      * insert new data; overwrites data with the same course-id;
      * if the loadfactor gets greater than loadLimit: the length of the hash table is doubled
      * both strings have to be not empty!
      */
     public void insert (String lvNr, String name){
    	 
    	 
    		/* int i = 0;
    		 int j = 0;
    		 
    		 do{
    			j = getPosition(lvNr);
    				if(hashTable[i] == null){
    					hashTable[i] = new LvElement(lvNr, name);
    					hashTable[i] = name;
    				}
    		 }while(i == hashTable.length);*/
    			 
    		 
    		 
    		if(hashTable.length > 0 && validLvNr(lvNr) && name.length() > 0){
    		 LvElement a = new LvElement(lvNr, name);
    		 LvElement b = new LvElement(lvNr, name);
    		
    		 int pos = getPosition(lvNr);
    		 	
    		 if(giveName(lvNr).equals("")){
    			 if(hashTable[pos] == null){
    				 hashTable[pos] = new LvElement(lvNr, name);
    				 hashTable[pos].setNext(null);
    			 }else{
    				a = hashTable[pos];
    			 	hashTable[pos] = new LvElement(lvNr, name);
    			    hashTable[pos].setNext(a);
    			 }
    	 }else{
    		 if(hashTable[pos] != null){
    			 a = hashTable[pos];
    			 if(a.getLvNr().equals(lvNr)){
    				 a.setName(name);
    			 }else{
    				 while(a != null && a.getNext() != null){
    					 b = a.getNext();
    					 if(b.getLvNr().equals(lvNr)){
    						 b.setName(name);
    					 }
    					 a = b;
    				 }
    			 }
    		 }
    	 }
    		 
    	 }
    		 
     }
     
     /**
      * delete data with matching lvNr;
      * no action if lvNr not found
      */ 
     public void delete (String lvNr){
  
    			if (hashTable.length > 0 && validLvNr(lvNr)){
    				
    				int pos = getPosition(lvNr);
   				
    				if (hashTable[pos] != null) {
    					LvElement a = hashTable[pos];
    					
    					if (a.getLvNr().equals(lvNr)) {
    						if (a.getNext() != null)
    							hashTable[pos] = a.getNext();
    						else
    							hashTable[pos] = null;
    					} else {
    						while (a != null && a.getNext() != null) {
    							LvElement b = a.getNext();
    							if (b.getLvNr().equals(lvNr)) {
    								if (b.getNext() != null)
    									a.setNext(b.getNext());
    								else
    									a.setNext(null);
    								break;
    							}
    							a = b;
    						}
    					}
    				}
    			}
    		}
     
     /**
      * returns the name corresponding to lvNr;
      * returns empty string, if lvNr not found
      */
     public String giveName (String lvNr){
    	 
 		if (hashTable.length > 0 && validLvNr(lvNr)) {
 			int pos = getPosition(lvNr);
 						
			if (hashTable[pos] != null) {
				LvElement a = hashTable[pos];
				if (a.getLvNr().equals(lvNr)) {
					return a.getName();
				} else {
					while (a != null && a.getNext() != null) {
						LvElement b = a.getNext();
						if (b.getLvNr().equals(lvNr)) {
							return b.getName();
						}
						a = b;
					}
				}
			}
		}
		return "";
	}
     
     /**
      * returns true if the hash table contains no entries
      */
     public boolean isEmpty (){

    			for (int i = 0; i < hashTable.length; i++) {
    				if (hashTable[i] != null)
    					return false;
    			}
    			return true;
    		}
 
     /**
      * returns the number of entries in the hash table
      */
     public int numberOfEntries (){
    	
    	int count = 0;
 		for (int k = 0; k < giveLength(); k++) {
 			if(hashTable[k] != null) {
 				LvElement i = hashTable[k];
 				count++;
 				while (i.getNext() != null) {
 					i = i.getNext();
 					count++;
 				}
 			}
 		}
 		return count;
     }

     /**
      * returns the length of the hash table
      */
     public int giveLength(){
    	 
    	 return hashTable.length;
    	 
    	}
    	 
     
     /**
 	 * Methode zur Rueckgabe aller Eintraege in einem Array
 	 * 
 	 * @return Alle Eintraege in einen Array gespeichert
 	 */
     
     public String LvEintraege(){
    	 
    	 String eintrag = "";
    	 
    	 for(int i = 0; i < hashTable.length; i++ ){
    		if(hashTable[i] == null){
    			eintrag = eintrag + "<empty> \n";
    		}else{
    			LvElement a = hashTable[i];
    			eintrag = eintrag + a.getLvNr()+" "+ a.getName();
    			while(a.getNext() != null){
    				a = a.getNext();
    				eintrag = eintrag + a.getLvNr() +" "+ a.getName();
    			}
    			eintrag = eintrag + "\n";
    		}
    			
    	}
    	 return eintrag;
     }
     
  
     
}
