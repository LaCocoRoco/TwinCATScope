package twincat.ads.enums;

public enum AmsEvent {
	/*************************/
	/** constant attributes **/
	/*************************/
	
	ROUTERSTOP 	  (0x0000),
	ROUTERSTART   (0x0001),
	ROUTERREMOVED (0x0002),
	UNKNOWN		  (0xFFFF);	
	
	/*************************/
	/*** global attributes ***/
	/*************************/	
	
	public final int value;

	/*************************/
	/****** constructor ******/
	/*************************/
	
    private AmsEvent(int value) {
        this.value = value;
    }
    
	/*************************/
	/** public static final **/
	/*************************/
	  
    public static final AmsEvent getByValue(int value) {
        for (AmsEvent dataType : AmsEvent.values()) {
            if (dataType.value == value) {
            	return dataType;
            }
        }
        
        return AmsEvent.UNKNOWN;
    } 
	
	public static final AmsEvent getByString(String value) {
		try {
			return AmsEvent.valueOf(value);
		} catch (IllegalArgumentException e) { 
			return AmsEvent.UNKNOWN;
		}
	}
}