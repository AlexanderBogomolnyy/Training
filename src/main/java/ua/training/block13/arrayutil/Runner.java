package ua.training.block13.arrayutil;

/**
 * <p> The main executive class.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.12.2016.
 */
public class Runner {
	
	/**
	 * A constant holding information about number of threads in custom method 
	 * of parallel array elements summing. 
	 */
	private static final int NUMBER_OF_THREADS = 5;
	
	/**
	 * The main executive method 
	 * 
	 * @param arg - additional string arguments from command line
	 */
	public static void main(String... arg) {
		int[] array = ArrayCalculator.randomIntArray(10000000, 15);
		System.out.println("Sum calculation results --> ");
		System.out.println("Custom calculation method ("+ NUMBER_OF_THREADS +" threads): " + 
				ArrayCalculator.countSum(array, ArrayCalculator.CUSTOM_PARALLEL_SUM, NUMBER_OF_THREADS));
		System.out.println("Parallel stream calculation method: " + 
				ArrayCalculator.countSum(array, ArrayCalculator.STREAM_PARALLEL_SUM));
		System.out.println("Stream calculation method (single thread): " + 
				ArrayCalculator.countSum(array, ArrayCalculator.STREAM_SUM));
	}
	
}
