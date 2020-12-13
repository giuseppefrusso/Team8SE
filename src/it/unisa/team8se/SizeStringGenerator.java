/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.team8se;

import java.text.DecimalFormat;

/**
 *
 * @author cptso
 */
public class SizeStringGenerator {
    
    private static final long KILOBYTE = 1024;
    private static final long MEGABYTE = 1024*1024;
    private static final long GIGABYTE = 1024*1024*1024;
    
    public static String generate(long byteSize){
        if(byteSize < 0){
            return "N/A";
        }
        else{
            DecimalFormat df = new DecimalFormat("#.##");
            
            if(byteSize > GIGABYTE){
                long gigs = byteSize / GIGABYTE;
                byteSize -= gigs * GIGABYTE;
                float displaySize = (float)gigs + (float)byteSize/GIGABYTE;
                return df.format(displaySize) + " GB";
            }
            else if (byteSize > MEGABYTE){
                long megs = byteSize / MEGABYTE;
                byteSize -= megs * MEGABYTE;
                float displaySize = (float)megs + (float)byteSize/MEGABYTE;
                return df.format(displaySize) + " MB";
            }
            else if (byteSize > KILOBYTE){
                long kilos = byteSize / KILOBYTE;
                byteSize -= kilos * KILOBYTE;
                float displaySize = (float)kilos + (float)byteSize/KILOBYTE;
                return df.format(displaySize) + " KB";
            }
            else{
                return byteSize + " bytes";
            }
        }
    }
}
