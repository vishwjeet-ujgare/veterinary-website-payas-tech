package com.ptpl.veternary_website.utils;

public class UserTypeUtils {
	 public static boolean isValidUserType(String userTypeString) {
		 System.out.println("hello in usertype itil is");
	        for (UserType userType : UserType.values()) {
	            if (userType.name().equals(userTypeString)) {
	                return true;
	            }
	        }
	        return false;
	    }
}
