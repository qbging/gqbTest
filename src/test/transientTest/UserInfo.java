package test.transientTest;

import java.io.Serializable;

public class UserInfo implements Serializable {  
	   
    private static final long serialVersionUID = 1L;  

    private String name ;  
     
    private transient String pwd ;  
     
    public UserInfo(String name,String pwd){  
           this.name =name;  
           this.pwd =pwd;  
   }  
     
    public String toString(){  
           return "name=" +name +",psw=" +pwd ;  
   }  
}  