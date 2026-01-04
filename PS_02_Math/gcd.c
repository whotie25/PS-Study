int gcd(int a, int b) {
	/* Euclidean Algorithm */
	int r;
	while (b) {
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}
