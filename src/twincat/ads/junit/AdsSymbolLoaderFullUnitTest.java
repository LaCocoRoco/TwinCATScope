package twincat.ads.junit;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twincat.TwincatLogger;
import twincat.ads.AdsClient;
import twincat.ads.AdsException;
import twincat.ads.AdsSymbol;
import twincat.ads.AdsSymbolLoader;
import twincat.ads.AmsNetId;
import twincat.ads.enums.AdsDataType;
import twincat.ads.enums.AmsPort;

public class AdsSymbolLoaderFullUnitTest {
    private final AdsClient adsClient = new AdsClient();
    private final Logger logger = TwincatLogger.getSignedLogger();

    @Before
    public void startAds() {
        adsClient.open();
    }   
    
    @Test
    public void adsSymbolLoaderFullUnitTest() {
        try {
            adsClient.setAmsNetId(AmsNetId.LOCAL);
            adsClient.setAmsPort(AmsPort.TC2PLC1);
            
            AdsSymbolLoader symbolLoader = adsClient.getSymbolLoader();

            // IMPORTEND: crash with big projects
            for (AdsSymbol symbol : symbolLoader.getSymbols()) {
                
                // get symbols of big type symbol
                if (symbol.getDataType().equals(AdsDataType.BIGTYPE)) {
                    for(AdsSymbol bigTypeSymbol : symbolLoader.getSymbolsOfBigType(symbol)) {
                        String name = bigTypeSymbol.getName();
                        String type = String.format("%-8s", bigTypeSymbol.getDataType().toString());
                        logger.info("Type: " + type + "| Name: " + name); 
                    }  
                } else {
                    String name = symbol.getName();
                    String type = String.format("%-8s", symbol.getDataType().toString());
                    logger.info("Type: " + type + "| Name: " + name);             
                }
            }
        } catch (AdsException e) {
            logger.info(e.getAdsErrorMessage());
        }
    }
    
    @After
    public void stopAds() throws AdsException {
        adsClient.close();
    }     
}
