
public class MergeBU {
	private static Comparable[] aux;

	// auxiliary array for merges
	// See page 271 for merge() code.
	public static void sort(Comparable[] a) { // Do lg N passes of pairwise
												// merges.
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz)

			for (int lo = 0; lo < N - sz; lo += sz + sz) // lo: subarray index
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) { // Merge
																		// a[lo..mid]
																		// with
		// a[mid+1..hi].
		
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];

		}

	}

	public static void main(String[] args) {
		Integer[] sample = { 1, 9, 3, 4, 5 };
		sort(sample);
		for(Comparable x : sample){
				System.out.println(x);
		}
	}

}
