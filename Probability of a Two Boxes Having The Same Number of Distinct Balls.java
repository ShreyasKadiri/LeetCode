class Solution {
    public double getProbability(int[] balls) {
        int sum = 0;
        for (int i=0; i<balls.length; i++)
            sum+=balls[i];
            double total=recurse(balls, 0, 0, 0, 0, 0, sum);
        double valid = casesWithEqualDistinctBalls(balls, 0, 0, 0, 0, 0, sum);
        return ((1.0) * valid / total);
    }

    public double recurse(int[] b, int pos, int f, int s, int disF, int disS, int sum) {
        if (pos==b.length) {
            if (f==s)
                return fact(sum/2) * fact(sum/2); 
            return 0;
        }
        double answer = 1.0 * recurse(b, pos + 1, f, s + b[pos], disF, disS + 1, sum) / fact(b[pos]);
        answer += 1.0 * recurse(b, pos + 1, f + b[pos], s, disF + 1, disS, sum) / fact(b[pos]);
        for (int i = 1; i < b[pos]; ++i) {
answer += 1.0 * (recurse(b, pos + 1, f + i, s + b[pos] - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b[pos] - i))); 
        }
        return answer;

    }

public double casesWithEqualDistinctBalls(int[] b, int pos, int f, int s, int disF, int disS, int sum) {
        if (pos == b.length) {
            if (f == s && disF == disS) return fact(sum / 2) * fact(sum / 2); 
            return 0;
        }

        double answer = 1.0 * casesWithEqualDistinctBalls(b, pos + 1, f, s + b[pos], disF, disS + 1, sum) / fact(b[pos]);

        answer += 1.0 * casesWithEqualDistinctBalls(b, pos + 1, f + b[pos], s, disF + 1, disS, sum) / fact(b[pos]);
        for (int i = 1; i < b[pos]; ++i) {
            answer += 1.0 * (casesWithEqualDistinctBalls(b, pos + 1, f + i, s + b[pos] - i, disF + 1, disS + 1, sum) / (fact(i) * fact(b[pos] - i))); 
        }
        return answer;

    }

    double fact(double n) {
        double res = 1;
        for (int i = 2; i <= n; i++)
            res = res * i;
        return res;
    }
}