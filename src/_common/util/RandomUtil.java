package _common.util;

import java.util.Random;

public class RandomUtil {

    public static int generateFixedDigitRandomNumber(int digits) {
        if (digits <= 0) {
            throw new IllegalArgumentException("자리수는 1 이상이어야 합니다.");
        }

        int min = (int) Math.pow(10, digits - 1);
        int max = (int) Math.pow(10, digits) - 1;

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int generateRandomNumberInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("최소값은 최대값보다 작거나 같아야 합니다.");
        }

        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}
