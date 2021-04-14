class Solution {
    public boolean squareIsWhite(String coordinates) {
        char c = coordinates.charAt(0);
         char d = coordinates.charAt(1);
        
        StringBuilder sb = new StringBuilder("");
        if(c=='a'){
            sb.append("1");
        }
         if(c=='b'){
            sb.append("2");
        }
         if(c=='c'){
            sb.append("3");
        }
         if(c=='d'){
            sb.append("4");
        }
         if(c=='e'){
            sb.append("5");
        } if(c=='f'){
            sb.append("6");
        } if(c=='g'){
            sb.append("7");
        }
         if(c=='h'){
            sb.append("8");
        }
        
        int val =  Character.getNumericValue(c)+  Character.getNumericValue(d); 
        
        
        return val%2 == 0 ;
    }
}
