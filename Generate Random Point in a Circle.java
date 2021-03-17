class Solution {

    double radius;
    double x_center;
    double y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
    }
    
    public double[] randPoint() {
     //  x_Center+sqrt[(radius)]*cos(angle)(0-2*PI)
     //  y_Center+sqrt[(radius)]*sin(angle)(0-2*PI)
        double length=Math.sqrt(Math.random())*radius;
        double angle=Math.random()*2*Math.PI;
        
        double x=x_center + length*Math.cos(angle);
        double y=y_center + length*Math.sin(angle);

        return new double[] {x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
