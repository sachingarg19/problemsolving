/**
 * 
 */
package com.wayfair;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Base64.Encoder;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Sachin Garg
 *
 */
public class ShorternUrl {

	/**
	 * @param args
	 */
	
	static String url = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
	static Encoder base64 = Base64.getUrlEncoder();
	static Encoder mimicEncoder = Base64.getMimeEncoder(6,"".getBytes());
	static MessageDigest md;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(base64.encodeToString(url.getBytes()));
		System.out.println(mimicEncoder.encodeToString(url.getBytes()));
		
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(url.getBytes());
			byte[] digest = md.digest();
			String str = DatatypeConverter.printBase64Binary(digest);
			System.out.println(str);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
