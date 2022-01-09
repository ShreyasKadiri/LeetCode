class Solution{
public boolean isRobotBounded(String ins) {
        int x=0;
        int y=0;
        int i=0;
        int directions[][] = {{0, 1}, {1,0}, {0,-1}, { -1,0}};
        for (int j=0; j<ins.length(); j++)
            if(ins.charAt(j) == 'R')
                i=(i+1)%4;
            else if(ins.charAt(j)=='L')
                i=(i+3)%4;
            else {
                x+=directions[i][0];
                y+=directions[i][1];
            }
        return x==0 && y==0 || i>0;
    }
