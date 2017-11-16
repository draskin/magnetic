package mag;

public class Main {
	public static void main(String[] args) {
		System.out.println("Hello World");
		new Main().a(1, 1, -1, 1, -1, 1, -1, 1, 0, 0, 0);
		return;
	}

	public static double a(	int i, int j,
							double x1, double x2,
							double y1, double y2,
							double z1, double z2,
							double qx, double qy, double qz) {
		Bounds b = new Bounds(x1, x2, y1, y2, z1, z2);
		Point q = new Point(qx, qy, qz);
		if (i == 1 && j == 1) {
			for( int p = 1; p < 3; p++) {
				for( int k = 1; k < 3; k++) {
					for( int l = 1; l < 3; l++) {
						
					}
				}
			}
			double result = (1/(4*Math.PI));
		}
		return 0;
	}

	private interface FuncForSum {
		public double func(int p, int k, int l);
	}

	public static double sumPKI(FuncForSum func) {
		double result = 0;
		for( int p = 1; p < 3; p++) {
			for( int k = 1; k < 3; k++) {
				for( int l = 1; l < 3; l++) {
					result = result + func.func(p, k, l);
				}
			}
		}
		return result;
	}

	private static class Bounds {
		public Bounds(double x1, double x2, double y1, double y2, double z1, double z2) {
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
			this.z1 = z1;
			this.z2 = z2;
		}
		private double x1;
		private double x2;
		private double y1;
		private double y2;
		private double z1;
		private double z2;

		public double x(int i) {
			if (i != 1 && i != 2) {
				throw new RuntimeException();
			}
			return i == 1 ? x1 : x2;
		}

		public double y(int i) {
			if (i != 1 && i != 2) {
				throw new RuntimeException();
			}
			return i == 1 ? y1 : y2;
		}

		public double z(int i) {
			if (i != 1 && i != 2) {
				throw new RuntimeException();
			}
			return i == 1 ? z1 : z2;
		}
	}

	private static class Point {
		public Point(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		public double x;
		public double y;
		public double z;
	}
}
