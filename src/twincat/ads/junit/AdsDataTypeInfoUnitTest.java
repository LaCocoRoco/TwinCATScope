package twincat.ads.junit;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twincat.TwincatLogger;
import twincat.ads.AdsClient;
import twincat.ads.AdsSymbolDataTypeInfo;
import twincat.ads.AmsNetId;
import twincat.ads.enums.AmsPort;
import twincat.ads.AdsException;

public class AdsDataTypeInfoUnitTest {
    private final AdsClient adsClient = new AdsClient();
    private final Logger logger = TwincatLogger.getSignedLogger();
    
    private final String dataTypeName = "junit_st";
    
    @Before
    public void startAds() {
        adsClient.open();
    }

    @Test
    public void adsSymbolBySymbolInfoUnitTest() {
        try {
            adsClient.setAmsNetId(AmsNetId.LOCAL);
            adsClient.setAmsPort(AmsPort.TC2PLC1);
            
            AdsSymbolDataTypeInfo dataTypeInfo = adsClient.readDataTypeInfoByDataTypeName(dataTypeName);
            
            printAdsDataTypeInfo(dataTypeInfo, true);
        } catch (AdsException e) {
            logger.info(e.getAdsErrorMessage());
        }   
    }
    
    @After
    public void stopAds() throws AdsException {
        adsClient.close();
    }
    
    private void printAdsDataTypeInfo(AdsSymbolDataTypeInfo dataTypeInfo, boolean printSubData) {
        logger.info("Length        : " + dataTypeInfo.getLength());
        logger.info("Version       : " + dataTypeInfo.getVersion());
        logger.info("HashValue     : " + dataTypeInfo.getHashValue());
        logger.info("TypeHashValue : " + dataTypeInfo.getTypeHashValue());
        logger.info("DataSize      : " + dataTypeInfo.getDataSize());
        logger.info("Offset        : " + dataTypeInfo.getOffset());
        logger.info("DataType      : " + dataTypeInfo.getDataType());
        logger.info("DataTypeFlag  : " + dataTypeInfo.getDataTypeFlag());
        logger.info("DataTypeName  : " + dataTypeInfo.getDataTypeName());
        logger.info("TypeName      : " + dataTypeInfo.getType());
        logger.info("Comment       : " + dataTypeInfo.getComment());
        
        if (printSubData) {
            logger.info("##############:");
            for (AdsSymbolDataTypeInfo subDataTypeInfo : dataTypeInfo.getSubSymbolDataTypeInfoList()) {
                printAdsDataTypeInfo(subDataTypeInfo, printSubData);
            }
        }
    }
}
