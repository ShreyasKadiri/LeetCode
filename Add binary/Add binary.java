class Solution {

    public String addBinary(String a, String b) {

        StringBuilder a1 = new StringBuilder(a);
        StringBuilder b1 = new StringBuilder(b);
        if(a.length() > b.length()) {
            while(a1.length() != b1.length()) {
                b1.insert(0, '0');
            }
        } else if(b.length() > a.length()) {
            while(a1.length() != b1.length()) {
                a1.insert(0, '0');
            }
        }
        
        a = a1.toString();
        b = b1.toString();

        StringBuilder sb = new StringBuilder();
        
        int i = a.length() - 1;
        
        int carry = 0;
        while(i >= 0) {
            int r = carry + getBit(a.charAt(i)) + getBit(b.charAt(i));
            if(r >= 2) {
                carry = 1;
                sb.append((char)('0' + (r - 2)));
            } else {
                carry = 0;
                sb.append((char)('0' + r));
            }
            i--;
        }
        if(carry > 0) {
            sb.append((char)(carry + '0'));
        }
        return sb.reverse().toString();
    }
    
    int getBit(char c) {
        return c == '1' ? 1 : 0;
    }
}
