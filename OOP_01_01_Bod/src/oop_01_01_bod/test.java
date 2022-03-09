package oop_01_01_bod;
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point myPoint = new Point(6,8);
        Point myPoint2 = new Point(3,4);
        System.out.println(myPoint.toString());
        System.out.println(myPoint2.toString());
        System.out.println(myPoint); //volá toString
        System.out.println(myPoint2.distanceFromOrigin());
        System.out.println(myPoint2.distanceFrom(myPoint));
    }
    
}
