 class Encoder_Decoder{

    

   static char[] ref={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
   '0','1','2','3','4','5','6','7','8','9',
   '(',')','*','+',',','-','.','/'};
   
   static int search(char[] arr,char target){

      
   for(int i=0;i<arr.length;i++)
   {
    if(arr[i]==target)
    {
        return i;
    }
   };
   
   
   return -1;

   }

   public String encode(String plainText,char offset_char){

    String encoded_string=""+offset_char;
    int offset_char_index=search(ref,offset_char);    //Number
    
    for(int i=0;i<plainText.length();i++)
    {
      int index_of_char=search(ref,plainText.charAt(i)) ;  //Number
      
       
      
      if(index_of_char != -1 )
      {
      int new_index_of_char=index_of_char-offset_char_index;
    
     if(new_index_of_char<0)
     {
       new_index_of_char=ref.length+new_index_of_char;   //since new_index_of_char is negative
       
       encoded_string=encoded_string+ref[new_index_of_char];
    
     }
      else
      {  
        encoded_string=encoded_string+ref[new_index_of_char];
      }
    
    }
    
    else
    {  //any charaacter not in ref table will be added in as the same character
       encoded_string=encoded_string+plainText.charAt(i);
    }
    
    
    
    }
    
    return encoded_string;
    
    
    }

    public String decode(String encodedText){        //static is want to call not using objects

        char offset_char=encodedText.charAt(0);
        String original_string="";
        int offset_char_index=search(ref,offset_char) ;   //Number
        
        for(int i=1;i<encodedText.length();i++)
        {
          int index_of_char=search(ref,encodedText.charAt(i)) ;  //Number
          
           
          
          if(index_of_char!=-1)
          {
          int new_index_of_char=index_of_char+offset_char_index;
        
         if(new_index_of_char>ref.length-1)
         {
           int difference=new_index_of_char-(ref.length-1);
            new_index_of_char=difference-1;
           
           original_string=original_string+ref[new_index_of_char];
        
         }
          else
          {  
            original_string=original_string+ref[new_index_of_char];
          }
        
        }
        
        else
        {  //any charaacter not in ref table will be added in as the same character
           original_string=original_string+encodedText.charAt(i);
        }
        
        
        
        }
        
        return original_string;
        
        
        }

    public static void main(String args[]){
        Encoder_Decoder myObj=new Encoder_Decoder();
        String encoded_output=myObj.encode("HELLO WORLD", 'F');
        String decoded_output=myObj.decode(encoded_output);
    System.out.println(encoded_output);
    System.out.println(decoded_output);

    }
    }











