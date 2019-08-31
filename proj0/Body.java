public class Body {

    private static final double G = 6.67E-11;

    // current x position
    public double xxPos;

    // current y position
    public double yyPos;

    // current velocity in the x direction
    public double xxVel;

    // current velocity in the y direction
    public double yyVel;

    // mass
    public double mass;

    // The name of the file that corresponds to the image that depicts the body
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Body b) {
        double dx = b.xxPos - xxPos;
        double dy = b.yyPos - yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Body b) {
        double r = calcDistance(b);
        return G * mass * b.mass / (r * r);
    }

    public double calcForceExertedByX(Body b) {
        double F = calcForceExertedBy(b);
        double dx = b.xxPos - xxPos;
        double r = calcDistance(b);
        return F * dx / r;
    }

    public double calcForceExertedByY(Body b) {
        double F = calcForceExertedBy(b);
        double dy = b.yyPos - yyPos;
        double r = calcDistance(b);
        return F * dy / r;
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double fX = 0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                fX += calcForceExertedByX(b);
            }
        }
        return fX;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double fY = 0;
        for (Body b : bodies) {
            if (!this.equals(b)) {
                fY += calcForceExertedByY(b);
            }
        }
        return fY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += dt * aX;
        yyVel += dt * aY;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }

}