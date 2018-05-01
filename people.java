package com.imooc2;

class people {  
    static String name = "类体重定义的name";         //类中的成员变量并赋值  
  
    people(){  
    }  
      
    public static void speak() {  
        String name = "类体方法中定义的name";       //在方法speak中定义和成员变量名字相同的name并赋值  
        System.out.println(name);  
        System.out.println(people.name);      //通过this来访问类中的成员变量  
          
    }  
    
    //果没有public类，那么源文件的名字只要和某个类的名字相同就可以了。  
    public static void main(String[] args) {         
    	//people myPeople = new people();  
    	new people().speak();  
    	people.speak();
    	System.out.println(people.name);
}  
}  
  
    