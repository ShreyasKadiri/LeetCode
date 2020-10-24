class Solution {
    public int[] smallestSufficientTeam(String[] skills, List<List<String>> people) {
        int sLen = skills.length, pLen = people.size();
        
        Map<String, Integer> skmap = new HashMap<>();
        for(int i = 0; i < sLen; i++)
            skmap.put(skills[i], i);
        
        Set<Integer>[] skillArr = new Set[1 << sLen];
        skillArr[0] = new HashSet<>();
        
        for(int ppl = 0; ppl < pLen; ppl++){
            int pplSkill = 0;
            for(String sks : people.get(ppl)){
                pplSkill |= 1 << (skmap.get(sks));
            }
            
            for(int k = 0; k < skillArr.length; k++){
                if(skillArr[k] == null) continue;
                Set<Integer> currSkills = skillArr[k];
                int combined = k | pplSkill;
                if(combined == k) continue;
                if(skillArr[combined] == null || skillArr[combined].size() > currSkills.size() + 1){
                    Set<Integer> cSkills = new HashSet<>(currSkills);
                    cSkills.add(ppl);
                    skillArr[combined] = cSkills;
                }
            }
        }
        
        Set<Integer> resSet = skillArr[(1 << sLen) - 1];
        int[] res = new int[resSet.size()];
        int pos = 0;
        for(Integer n : resSet)
            res[pos++] = n;
        
        return res;
    }
}