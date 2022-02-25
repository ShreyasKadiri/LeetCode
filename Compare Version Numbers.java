class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null || version1.length() == 0 || version2 == null || version2.length() == 0){
            return 0;
        }
        List<String>versionOneElements = new ArrayList<String>(Arrays.asList(version1.split("\\.")));
        List<String>versionTwoElements = new ArrayList<String>(Arrays.asList(version2.split("\\.")));
         while(versionOneElements.size() < versionTwoElements.size()){
             versionOneElements.add("0");
         }
        while(versionOneElements.size() > versionTwoElements.size()){
             versionTwoElements.add("0");
         }
        int i =  0;
        while(i < versionOneElements.size() && i < versionTwoElements.size()){
            int a = Integer.parseInt(versionOneElements.get(i));
            int b = Integer.parseInt(versionTwoElements.get(i));
            if(a > b){
                return 1;
            }else if(b > a){
                return -1;
            }
            i+=1;
        }
        return 0;
    }
}
