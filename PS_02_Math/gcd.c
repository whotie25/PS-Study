int gcd(int n1, int n2) {
	/* Euclidean Algorithm */
	int r;
	while (n2) {
		r = n1 % n2;
		n1 = n2;
		n2 = r;
	}
	return n1;

}
