package ua.training.block13.arrayutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p> This class provides methods for calculating sum of elements in array.
 *
 * @author Alexander Bogomolnyy
 * @version 1.0 22.12.2016.
 */
public class ArrayCalculator {

	/**
	 * A constant holding integer value for initializing array elements summing which uses 
	 * Java Stream API (single stream)  
	 */
	public static final int STREAM_SUM = 1;
	
	/**
	 * A constant holding integer value for initializing array elements summing which uses 
	 * Java Stream API (parallel summing)  
	 */
	public static final int STREAM_PARALLEL_SUM = 2;
	
	/**
	 * A constant holding integer value for initializing array elements summing which uses 
	 * custom multi thread summing   
	 */
	public static final int CUSTOM_PARALLEL_SUM = 3;

	/**
	 * This method returns array filled by random integer values. Each value in 
	 * array less then max parameter.
	 * 
	 * @param num - array size
	 * @param max - max element value in array
	 * @return new array of integer with size num
	 */
	public static int[] randomIntArray(int num, int max) {
		int[] array = new int[num];
		for(int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()*max);
		}
		return array;
	}
	
	/**
	 * This method counts total sum of elements in integer array. This method can
	 * take as parameter STREAM_SUM, STREAM_PARALLEL_SUM, CUSTOM_PARALLEL_SUM constant 
	 * from ArrayCalculation class or their integer equivalents. If CUSTOM_PARALLEL_SUM 
	 * calculation method is being used, it is necessary to specify number of threads as  
	 * a parameter right after this calculation method.   
	 * 
	 * @param array - array for summing
	 * @param method - method of summing with parameter if necessary
	 * @return total sum of elements
	 */
	public static long countSum(int[] array, int... method) {
		check(method);
		int currentMethod = method[0];
		switch (currentMethod) {
		case STREAM_SUM:
			return Arrays.stream(array).mapToLong(x -> x).sum();
		case STREAM_PARALLEL_SUM:
			return Arrays.stream(array).parallel().mapToLong(x -> x).sum();
		case CUSTOM_PARALLEL_SUM:
			int numberOfThreads = method[1];
			return customSumCalculation(array, numberOfThreads);
		default:
			throw new IllegalArgumentException("Unknown calculation method.");
		}
	}

	// checking initial values
	private static void check(int[] values) {
		if (values.length == 0)
			throw new IllegalArgumentException("Calculation method does not setted.");
		int method = values[0];
		switch (method) {
		case STREAM_SUM:
		case STREAM_PARALLEL_SUM:
			break;
		case CUSTOM_PARALLEL_SUM:
			if (values.length < 2 || values[1] <= 0)
				throw new IllegalArgumentException("Number of threads does not setted.");
			break;
		default:
			throw new IllegalArgumentException("Unknown calculation method.");
		}
	};

	// customer calculation method
	private static long customSumCalculation(int[] array, int numberOfThreads) {
		List<ArrayHolder> arrayHolders = new ArrayList<>();
		for (int i = 0; i < numberOfThreads; i++) {
			arrayHolders.add(new ArrayHolder(array, i, numberOfThreads));
		}
		List<Thread> threads = arrayHolders.stream().map(Thread::new).collect(Collectors.toList());
		threads.stream().forEach(Thread::start);
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return arrayHolders.stream().mapToLong(ArrayHolder::getSum).sum();
	}

	/**
	 * <p> This is an inner class for holding array of elements. 
	 *
	 * @author Alexander Bogomolnyy
	 * @version 1.0 22.12.2016.
	 */
	private static class ArrayHolder implements Runnable {
		
		/**
		 * array of elements
		 */
		int[] array;
		
		/**
		 * Star position for calculation
		 */
		int start;
		
		/**
		 * Step of calculation
		 */
		int interval;
		
		/**
		 * Sum of specific elements
		 */
		long sum;

		ArrayHolder(int[] array, int start, int interval) {
			super();
			this.array = array;
			this.start = start;
			this.interval = interval;
		}

		/**
		 * This method count sum of specific elements in the array.  
		 * 
		 * @return sum of elements
		 */
		long countSum() {
			long sum = 0;
			for (int i = start; i < array.length; i += interval) {
				sum += array[i];
			}
			return sum;
		}

		@Override
		public void run() {
			sum = countSum();
		}

		/**
		 * This method returns sum of elements
		 * 
		 * @return sum of elements
		 */
		long getSum() {
			return sum;
		}
	}
}
