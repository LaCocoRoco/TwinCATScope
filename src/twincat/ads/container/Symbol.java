package twincat.ads.container;

import twincat.ads.constant.DataType;

public class Symbol {
    /*************************/
    /*** global attributes ***/
    /*************************/

    private String symbolName = new String();

    private DataType dataType = DataType.UNKNOWN;

    /*************************/
    /**** setter & getter ****/
    /*************************/
   
    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
