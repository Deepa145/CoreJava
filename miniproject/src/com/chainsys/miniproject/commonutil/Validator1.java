package com.chainsys.miniproject.commonutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import com.chainsys.entrypoint.InvalidInputDataException;

public class Validator1 {

	public static boolean checkStringForParse(String data) throws InvalidInputDataException {
		// TODO--This method is incomplete
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			int asc = (int) data.charAt(index);
			if (asc > 47 && asc < 58)
				result = true;
			else
				throw new InvalidInputDataException("enter numeric value only");
		}
		return result;
	}

	public static boolean CheckNumberForGreaterThanZero(int data) throws InvalidInputDataException {
		boolean result = false;
		if (data > 0) {
			result = true;
		} else
			throw new InvalidInputDataException();
		return result;
	}

	public static boolean checklengthOfString(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		if (len < 3)
			throw new InvalidInputDataException("length Does not meet required length ");
		else if (len > 15)
			throw new InvalidInputDataException("length exceeds the required length");
		else
			result = true;
		return result;
	}

	public static boolean checkStringOnly(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		for (int index = 0; index < len; index++) {
			data.toUpperCase();
			int asc = (int) data.charAt(index);
			if (asc > 64 && asc < 91) {
				result = true;
			} else if (asc > 96 && asc < 123) {
				result = true;
			} else
				throw new InvalidInputDataException("Enter Alphabets Only");
		}
		return result;
	}

	public static boolean checkMail(String email) throws InvalidInputDataException {
		boolean result = false;
		String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if (email == null)
			throw new InvalidInputDataException("enter email id ");
		else if (Pattern.compile(regexPattern).matcher(email).matches()) {
			result = true;
		} else {
			throw new InvalidInputDataException("enter valid email id ");
		}
		return result;
	}

	public static boolean checkDateFormat(String data) throws InvalidInputDataException {
        boolean result = false;
        int len = data.length();
        String[] data1 = data.split("/");
        //for (int i = 0; i < data1.length; i++)
            //System.out.println(data1[i]);
        int date = Integer.parseInt(data1[0]);
        int mon = Integer.parseInt(data1[1]);
        int yrs = Integer.parseInt(data1[2]);
        for (int index = 0; index < len; index++) {
            int asc = (int) data.charAt(index);
            if ((asc < 46) || (asc > 58))// || (asc != 47))
                throw new InvalidInputDataException("Enter date in correct format ");
        }
     // date before 1/1/1985

        if (yrs > 1984 && yrs <= 2022) {
            if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
                if (date > 0 && date <= 31)
                    result = true;
                else
                    throw new InvalidInputDataException("enter valid date");
            else if (mon == 2 || mon == 4 || mon == 6 || mon == 9 || mon == 11)
                if (date > 0 && date <= 30)
                    result = true;
                else
                    throw new InvalidInputDataException("enter valid date");
            else
                throw new InvalidInputDataException("enter valid month");
        } else
            throw new InvalidInputDataException("enter valid year");
//        if(date.before(calender.getI);

        return result;

    }

	public static boolean checkjob(String data) throws InvalidInputDataException {
        // TODO Auto-generated method stub
        boolean result = false;
        int len = data.length();
        for (int index = 0; index < len; index++) {
            int asc = (int) data.toUpperCase().charAt(index);
            
            if (((asc > 64) && (asc < 91)) ||(asc == 95))
                      result = true;
                 
                 
            else
                throw new InvalidInputDataException("Enter Alphabets(A-Z) and underscore(_) only");
        }
        return result;


    }

	public static boolean checkSalLimit(float salParse) throws InvalidInputDataException {
		boolean result = false;

		if (salParse < 0 && salParse > 1000000) {
			System.out.println("Enter amount between 0 to 1 Lac");
		} else if (salParse % 500 != 0) {
			System.out.println("Enter amount in multiples of five hundred");
		} else {
			result = true;
		}
		return result;
	}

	public static void checkPhone(String data) throws InvalidInputDataException {
		boolean result = false;
		String pattern = "^[0-9]{10}$";
		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result = match.matches();
		if (!result)
			throw new InvalidInputDataException("please enter 10 digit ");
	}

	
	public static boolean checkStringSpacesLength(String data) throws InvalidInputDataException {
        boolean result = false;
        int len = data.length();
        if (len < 3)
            throw new InvalidInputDataException("the value must contain three characters");
        else if (len > 36)
            throw new InvalidInputDataException("the value must not exceed fifteen  characters");
        
        for (int index = 0; index < len; index++) {
            String Data = data.toUpperCase();
            int asc = (int) Data.charAt(index);
            if ((asc < 91) && (asc > 64)) {
                if (asc == 32)
                    result = true;
            } else
                throw new InvalidInputDataException("the value only have Alphabets and spaces ");
        }
        return result;

    }
	public static boolean checkStringForParseFloat(String data) throws InvalidInputDataException {
        boolean result = false;
        int len = data.length();
        for (int index = 0; index < len; index++) {
            int asc = (int) data.charAt(index);
            
            if ((asc > 47 && asc < 58)||(asc==46))
                result = true;
            else
                throw new InvalidInputDataException("The value in String must contain only numbers");
        }

        // if data is invalid throw new InvalidInputDataException ("The value in String
        // must contain only numbers")
        return result;
    }
	
	public static boolean CheckNofutureDate(Date date) throws InvalidInputDataException {
//      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      Date dateA = new Date(0, 0, 0);
      boolean result = false;
  if( date.compareTo(dateA)<0 )
      result=true;
  else
      throw new InvalidInputDataException("enter valid date");
      return result;
//      String testDate = formatter.format(date);
  }

    public static boolean checklengthOfPhno(String phno) throws InvalidInputDataException {
        boolean result =false;
        int len = phno.length();
        if (len==10)
            result = true;
        else
            throw new InvalidInputDataException("enter 10 digits of phone number");
        return result;
    }
    public static boolean checkfee(float fee) throws InvalidInputDataException {
        boolean result =false;
        if(fee >0) {
            if(fee<100000)
                result = true;
            else 
                throw new InvalidInputDataException("the value of fee must less than 100000 and positive");
        }    
        return result;
    }

    
    public static void checkDate(String emp_HireDate) throws InvalidInputDataException {
		
	    if (emp_HireDate.matches("[0-9]{2}[.]{1}[0-9]{2}[.]{1}[0-9]{4}")) {
	      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	      sdf.setLenient(false);
	      try {
	        Date d1 = sdf.parse(emp_HireDate);
	        System.out.println("Valid");
	      } catch (ParseException e) {
	        System.out.println("Invalid");
	      }
	    } else if (emp_HireDate.matches("[0-9]{2}[/]{1}[0-9]{2}[/][0-9]{4}")) {
	      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	      sdf.setLenient(false);
	      try {
	        Date d1 = sdf.parse(emp_HireDate);
	        System.out.println("Valid");
	      } catch (ParseException e) {
	        System.out.println("Invalid");
	      }
	    } else if (emp_HireDate.matches("[0-9]{2}[-]{1}[0-9]{2}[-][0-9]{4}")) {
	      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	      sdf.setLenient(false);
	      try {
	        Date d1 = sdf.parse(emp_HireDate);
	        System.out.println("Valid");
	      } catch (ParseException e) {
	        System.out.println("Invalid");
	      }
	    } else
	    	throw new InvalidInputDataException("enter valid Date ");
	    
	  }
}



