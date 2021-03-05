
/*
Approach
a)Apply topological sort amongs groups
b)Apply topological sort among the elements of the same group
c)There are two types of dependencies.. item and graph based dependency
*/

class Solution{
public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Item dependency graph creation.
        Map<Integer,Set<Integer>> itemGraph=new HashMap<>();
        Map<Integer,Integer> itemInDegree=new HashMap<>();
        for (int i=0;i<n;i++) {
            itemGraph.putIfAbsent(i,new HashSet<>());
        }

        // Group dependency graph creation
        Map<Integer,Set<Integer>> groupGraph = new HashMap<>();
        Map<Integer,Integer> groupInDegree = new HashMap<>();

        for (int g : group) {
            groupGraph.putIfAbsent(g,new HashSet<>());
        }

        for (int i=0;i<beforeItems.size();i++) {
            List<Integer> list = beforeItems.get(i);
            if(list.size()!=0) {
                for (int val : list) {
                    itemGraph.get(val).add(i);
                    itemInDegree.put(i,itemInDegree.getOrDefault(i,0)+1);
                    // If an item(i1) is dependent on another(i2) then its group(g1) should also be dependent on (g2)
                    int g1 = group[val];
                    int g2 = group[i];
                    if (g1 != g2 && groupGraph.get(g1).add(g2)) {
                        groupInDegree.put(g2,groupInDegree.getOrDefault(g2,0)+1);
                    }
                }
            }
        }

        List<Integer> itemOrdering = topologicalSort(itemGraph, itemInDegree, n);
        List<Integer> groupOrdering = topologicalSort(groupGraph, groupInDegree, groupGraph.size());

        if(itemOrdering.size()==0 || groupOrdering.size()==0) {
            return new int[0];
        }

        Map<Integer,List<Integer>> map = new HashMap<>();

        // Put items in respective buckets.
        for (int item : itemOrdering) {
            int g = group[item];
            map.putIfAbsent(g,new ArrayList<>());
            map.get(g).add(item);
        }

        int[] result = new int[n];
        int i=0;

        for (int g : groupOrdering) {
            List<Integer> list = map.get(g);
            for (int item : list) {
                result[i] = item;
                i++;
            }
        }

        return result;

    }

    private List<Integer> topologicalSort(Map<Integer,Set<Integer>> graph,
                                          Map<Integer,Integer> inDegree,int count) {

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int key : graph.keySet()) {
            if(inDegree.getOrDefault(key,0)==0) {
                queue.add(key);
            }
        }

        while (!queue.isEmpty()) {
            int pop = queue.poll();
            count--;
            result.add(pop);
            for (int next : graph.get(pop)) {
                int val = inDegree.get(next);
                inDegree.put(next,val-1);
                if(inDegree.get(next) ==0) {
                    queue.add(next);
                }
            }
        }
        return count==0 ? result : new ArrayList<>();
    }
    }