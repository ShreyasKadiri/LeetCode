public class Codec {
    
    private HashMap<String,String> longToShort;
    private int encodedValue=0;
       Codec(){
        longToShort = new HashMap<String, String>();
        encodedValue = 0;
    }
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String encodedUrl = "http://tinyurl.com/" + ++encodedValue;
        longToShort.put(encodedUrl, longUrl);
        return  encodedUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(longToShort.containsKey(shortUrl)){
            return longToShort.get(shortUrl);
        }
        
        return "";
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
