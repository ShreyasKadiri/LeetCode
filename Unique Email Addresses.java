class Solution {
    public int numUniqueEmails(String[] emails) {
       HashSet<String> set = new HashSet<String>();
        for(String email : emails){
            String localNames[] = email.split("@");
            String domainNames[] = localNames[0].split("\\+");
            set.add(domainNames[0].replace(".", "") + "@" + localNames[1]);
        }
        return set.size();
    }
}
