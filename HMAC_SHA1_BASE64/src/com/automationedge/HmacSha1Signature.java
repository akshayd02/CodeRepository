package com.automationedge;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Formatter;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;  

public class HmacSha1Signature {
	private static final String HMAC_SHA1_ALGORITHM = Messages.getString("HmacSha1Signature.algorithm"); //$NON-NLS-1$
	
	private static String toBase64String(byte[] bytes) {
		Formatter formatter = new Formatter();
		Base64.Encoder encoder = Base64.getEncoder();  
		/*for (byte b : bytes) {
			formatter.format("%02x", b);
		}*/

		return encoder.encodeToString(bytes);
	}

	public static String calculateRFC2104HMAC(String data, String key)
			throws SignatureException, NoSuchAlgorithmException, InvalidKeyException {
		SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), HMAC_SHA1_ALGORITHM);
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		mac.init(signingKey);
		
		return toBase64String(mac.doFinal(data.getBytes()));
	}

	public static void main(String[] args) throws Exception {
		
		  String data = Messages.getString("HmacSha1Signature.data"); //$NON-NLS-1$
		//String data = "POST&https%3A%2F%2Ffinx22openplatform.fintech-galaxy.com%2Foauth%2Finitiate&oauth_callback%3Dhttps%253A%252F%252Fgoogle.com%26oauth_consumer_key%3Dtlu2jfhaf2o4mdnix2lcxakhvd4zi4gq4fr3duoe%26oauth_nonce%3D7hrqcrrm83j6u%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1617881712%26oauth_version%3D1.0";
		String key = Messages.getString("HmacSha1Signature.key"); //$NON-NLS-1$
		String hmac = calculateRFC2104HMAC(data, key);

		System.out.println(hmac);
		//assert hmac.equals("pKHxsFWOc7mD/aizTT9l5HeBHAE=");
	}
}