package services;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import dao.UserInterfaceDAO;
import model.User;

public class UserServiceImplemantation implements UserServiceInterface{
	private UserInterfaceDAO userDao;
	
	
	public UserServiceImplemantation(UserInterfaceDAO userDao) {
		super();
		this.userDao = userDao;
	}

	
	@Override
	public User registerUser(User user) {
		/* Plain-text password initialisation. */  
        String password = user.getUserPassword();  
        String encryptedpassword = null;  
        try{  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }    
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
            //create the new object with the new encrypted password
            User usr = new User(user.getUsername(),user.getUserSurname(),user.getUserEmail(),encryptedpassword);
            
            return this.userDao.registerUser(usr);
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  
		return null;
	}
	
	@Override
	public String checkUser(String email,String password) {
		String encryptedpassword = null;  
  try{  
      /* MessageDigest instance for MD5. */  
      MessageDigest m = MessageDigest.getInstance("MD5");  
        
      /* Add plain-text password bytes to digest using MD5 update() method. */  
      m.update(password.getBytes());  
        
      /* Convert the hash value into bytes */   
      byte[] bytes = m.digest();  
        
      /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
      StringBuilder s = new StringBuilder();  
      for(int i=0; i< bytes.length ;i++)  
      {  
          s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
      }    
      /* Complete hashed password in hexadecimal format */  
      encryptedpassword = s.toString();  
//    
      return this.userDao.checkUser(email, encryptedpassword);
  }   
  catch (NoSuchAlgorithmException e)   
  {  
      e.printStackTrace();  
  }
return null;
	}

	
	@Override
	public String loginUser(String email, String password) {
		String encryptedpassword = null;  
        try{  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }    
            /* Complete hashed password in hexadecimal format */  
            encryptedpassword = s.toString();  
//            Student std = new Student(email,encrypted password);
            return this.userDao.loginUser(email, encryptedpassword);
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }
		return null;
	}

	@Override
	public String updateUser(
			String email, String password, 
			String newName, String newSurname, 
			String newEmail,String newPassword) {
		String encryptedpassword = null; 
		try{  
   /* MessageDigest instance for MD5. */  
   MessageDigest m = MessageDigest.getInstance("MD5");  
     
   /* Add plain-text password bytes to digest using MD5 update() method. */  
   m.update(newPassword.getBytes());  
     
   /* Convert the hash value into bytes */   
   byte[] bytes = m.digest();  
     
   /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
   StringBuilder s = new StringBuilder();  
   for(int i=0; i< bytes.length ;i++)  
   {  
       s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
   }    
   /* Complete hashed password in hexadecimal format */  
   encryptedpassword = s.toString();  
//   Student std = new Student(email,encrypted password);
   return this.userDao.updateUser(email, password, newName, newSurname, newEmail, encryptedpassword);
}   
catch (NoSuchAlgorithmException e)   
{  
   e.printStackTrace();  
}
		return null;
	}
}
