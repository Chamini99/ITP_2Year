package IT20198886;
import java.util.regex.Pattern;  


public class EmailValidation {  
  
    public static boolean isValid(String email){  
        String emailFormate ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."  
                + "[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";  
          
        Pattern p = Pattern.compile(emailFormate);  
        if(email == null){  
        return false;  
        }   
        return p.matcher(email).matches();  
    }  
    public static void main(String[] args) {  
    	StaffRegister frame= new StaffRegister();  
        frame.setVisible(true);  
    }      
} 