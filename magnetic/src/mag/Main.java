package mag;

public class Main {
	public static void main(String[] args) {
		Main ob = new Main();
		double a11 = 0;
		for (double x = 4.05; x > -4.05; x = x - 0.1) {
			for (double y = 2.05; y > -2.05; y = y - 0.1) {
				q.x = x;
				q.y = y;
				a11 = ob.a(1, 1, b, q);
				//System.out.println("");
				System.out.println(x + " " + y + " " + a11);
			}
		}
		return;
	}

	public static Bounds b = new Bounds(-3, 3, -1, 1, -1, 1);
	public static Point q = new Point(0, 0, 0);

	public static double a(int i, int j, Bounds b, Point q) {
		if (i == 1 && j == 1) {
			return (1 / (4 * Math.PI)) * sumPKL(new FuncForSumPKL() {
				@Override
				public double func(int p, int k, int l) {
					double result = Math.pow(-1, p + k + l + 1)
							* Math.atan(((b.y(k) - q.y) * (b.z(l) - q.z)) / ((b.x(p) - q.x) * Rpkl(p, k, l, b, q)));
					//System.out.print("res(p=" + p + ",k=" + k + ",l=" + l + ")=" + result + ";");
					return result;
				}
			});

		}
		return 0;
	}

	private static double Rpkl(int p, int k, int l, Bounds b, Point q) {
		return Math.sqrt(Math.pow(b.x(p) - q.x, 2) + Math.pow(b.y(k) - q.y, 2) + Math.pow(b.z(l) - q.z, 2));
	}

	private interface FuncForSumPKL {
		public double func(int p, int k, int l);
	}

	public static double sumPKL(FuncForSumPKL func) {
		double result = 0;
		for (int p = 1; p < 3; p++) {
			for (int k = 1; k < 3; k++) {
				for (int l = 1; l < 3; l++) {
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
