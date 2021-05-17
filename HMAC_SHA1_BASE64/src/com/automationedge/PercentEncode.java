package com.automationedge;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PercentEncode {
	
	public static String encode(String url)  
    {  
              try {  
                   String encodeURL=URLEncoder.encode( url, "UTF-8" );  
                   return encodeURL;  
              } catch (UnsupportedEncodingException e) {  
                   return "Issue while encoding" +e.getMessage();  
              }  
    }  

	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
          
        String url2="https://finx22openplatform.fintech-galaxy.com";  
          
          
        String encodeURL = encode(url2);  
        System.out.println("Encoded URL2: "+encodeURL);  
   }  
}
