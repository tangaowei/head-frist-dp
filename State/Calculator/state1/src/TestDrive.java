public class TestDrive {
    public static void main(String[] args) {
	Calculator cal = new Calculator();
	cal.testDrive("+"); //s0
	cal.testDrive(".1.2C"); // s0-s1-s0
	cal.testDrive("12..3+-1+C"); // s0-s1-s2-s3-s2-s0
	cal.testDrive("123-3aC"); // s0-s1-s2-s3-s0
	cal.testDrive("3+1=C"); // s0-s1-s2-s3-s4-s0
	cal.testDrive("2*4*3/6=+1.1.1-4=1+2=C"); //s0-s1-s2-s3-s2-s3-s2-s3-s4-s2-s3-s2-s3-s4-s1-s2-s3-s4-s0
    }
}
