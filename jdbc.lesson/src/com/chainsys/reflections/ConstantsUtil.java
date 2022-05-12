package com.chainsys.reflections;

import java.lang.reflect.Field;

public class ConstantsUtil {

	   public static String getModifierName(int value,Class<?> c1)
	   {
		   Field flist[] = c1.getFields();
		   String fieldName="";
		   for (Field f : flist) 
		   {
			   try
	 	      {
			   if((int)f.get(null)==value)
				   fieldName=f.getName();
			   break;
	 	      } catch (IllegalAccessException e) 
	 	      {
	 	        e.printStackTrace();
	 	      }
		   }
		   return fieldName;
	   }
	}