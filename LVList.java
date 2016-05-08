
public class LVList {

	public static class LvElement{
		
		private String name;
		private String lvNr;
		//private LvElement next;
	
		
		public LvElement(String lvNr, String name){
			this.name = name;
			this.lvNr = lvNr;
			//this.next = null;
		}
	
		public void setName(String name){
			this.name = name;
		}

	
		public void setLvNr(String lvNr){
			this.lvNr = lvNr;
		}
		
		public String getName(){
			return name;
		}
	
		public String getLvNr(){
			return lvNr;
		}
	}
	
	private class DeletedEntry extends LvElement{
		
		private DeletedEntry entry = null;
		
		private DeletedEntry(){
			super(null, null);
			
		}
	
	   private DeletedEntry getUniqueDeletedEntry() {

           if (entry == null)

                 entry = new DeletedEntry();

           return entry;

     }
	}
	
		
	private LvElement[] hashTable;
	
	
	 /**
     * constructor for a hash table with length 2^power and load limit less or equal 1
      */
     public LVList(int power, double loadLimit){
    	 
    	 if(loadLimit <= 1){
    	 this.hashTable = new LvElement[(int) Math.pow(2, power)];
    	 }
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
    	 
    	 int hash = (lvNr.hashCode() % hashTable.length);
    	 DeletedEntry delete = new DeletedEntry();
    	 
    	 int initial = -1;
    	 int indexDeleted = -1;
    	 
    	 if(validLvNr(lvNr)){
    		 while(hash != initial && (hashTable[hash] == delete.getUniqueDeletedEntry() || hashTable[hash] != null && hashTable[hash].getLvNr() != lvNr)){
    		 
    		 if(initial == -1){
    			 initial = hash;
    		 }
    		 
    		 if (hashTable[hash] == delete.getUniqueDeletedEntry()){

                 indexDeleted = hash;
           
                 hash = (hash + 1) % hashTable.length;
           
    		 }
    		 

             if ((hashTable[hash] == null || hash == initial) && indexDeleted != -1){

                   hashTable[indexDeleted] = new LvElement(lvNr, name);

             }else if (initial != hash){

                   if (hashTable[hash] != delete.getUniqueDeletedEntry() && hashTable[hash] != null && hashTable[hash].getLvNr() == lvNr){

                         hashTable[hash].setName(name);
                   }

             }else

                         hashTable[hash] = new LvElement(lvNr, name);
             }   
       }
     }
    		 
    	 
     
     /**
      * delete data with matching lvNr;
      * no action if lvNr not found
      */ 
     public void delete (String lvNr){
    	 
    	 int hash = (lvNr.hashCode() % hashTable.length);
     	 DeletedEntry delete = new DeletedEntry();
         int initialHash = -1;
         
         if(validLvNr(lvNr)){
         
        	 while (hash != initialHash && (hashTable[hash] == delete.getUniqueDeletedEntry() || hashTable[hash] != null && hashTable[hash].getLvNr() != lvNr)){
        		 
        		 if (initialHash == -1){
                     initialHash = hash;
        		 }
               hash = (hash + 1) % hashTable.length;
        	 }
        	 
        	 if (hash != initialHash && hashTable[hash] != null){
                 hashTable[hash] = delete.getUniqueDeletedEntry();
        	 }
         }
    			
    }
     
     /**
      * returns the name corresponding to lvNr;
      * returns empty string, if lvNr not found
      */
     public String giveName (String lvNr){
    		
    	 int hash = (lvNr.hashCode() % hashTable.length);
        	DeletedEntry delete = new DeletedEntry();
            int initialHash = -1;
            int i = 0;
            
            if(validLvNr(lvNr)){
        		while (hash != initialHash && (hashTable[hash] == delete.getUniqueDeletedEntry() || hashTable[hash] != null && hashTable[hash].getLvNr() != lvNr)) {
        			
        			if (initialHash == -1){
                        initialHash = hash;
        			}
                  
                  hash = (hash + i) % hashTable.length;
                  i++;
            	}
            }
            if (hashTable[hash] == null || hash == initialHash){
                  return null;
            }else{
            	return hashTable[hash].getName();
            }
     	}
       
 		
     
     /**
      * returns true if the hash table contains no entries
      */
     public boolean isEmpty(){

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
 				count++;
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
     
     /*public String LvEintraege(){
    	 
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
     }*/
     
  
     
}
