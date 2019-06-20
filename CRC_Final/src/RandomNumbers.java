import java.util.Random;

public class RandomNumbers {
	private static java.util.Random r;

	public static String RandomNumber(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		int s = r.nextInt((max - min) + 1) + min;
		String t = String.valueOf(s);
		return t;
	}
	
	public static void main(String[] args)
	{
		for(int i = 0; i<6;i++)
			System.out.println(RandomNumber(0, 1));
	}
	
}
