class Solution {
    public boolean squareIsWhite(String coordinates) {
       
        StringBuilder sb = new StringBuilder("");
        if(coordinates.charAt(0)=='a'){
            sb.append("1");
        }
         if(coordinates.charAt(0)=='b'){
            sb.append("2");
        }
         if(coordinates.charAt(0)=='c'){
            sb.append("3");
        }
         if(coordinates.charAt(0)=='d'){
            sb.append("4");
        }
         if(coordinates.charAt(0)=='e'){
            sb.append("5");
        } if(coordinates.charAt(0)=='f'){
            sb.append("6");
        } if(coordinates.charAt(0)=='g'){
            sb.append("7");
        }
         if(coordinates.charAt(0)=='h'){
            sb.append("8");
        }   
        
       int value =  Character.getNumericValue(coordinates.charAt(0))+  Character.getNumericValue(coordinates.charAt(1));
       return value%2 == 0 ;
    }
}




//One liner
class Solution {
   public boolean squareIsWhite(String a) {
        return (int)a.charAt(0) % 2 != (int)a.charAt(1) % 2;
    }
}

