package org.kits.simple.numbergame;

import java.util.Random;

/**
 * A four digit number where each number is different.
 */
public class Number {

    private int[] digits = new int[4];

    public Number(int[] digits) {
        this.digits = digits;
    }

    public Number() {
        Random randomDigitGenerator = new Random();

        //Generate 4 unique digits
        this.digits[0] = randomDigitGenerator.nextInt(10);
        for (int i = 1; i < 4; i++) {
            int j = i-1;
            this.digits[i] = randomDigitGenerator.nextInt(10);
            while (j > 0) {
                while (this.digits[i] == this.digits[j]) {
                    this.digits[i] = randomDigitGenerator.nextInt(10);
                }

                j--;
            }
        }
    }

    public boolean equals(Object o) {

        if (o != null) {
            if (o == this) {
                return true;
            }

            if (o instanceof Number) {
                Number otherNumber = (Number)o;
                for (int i = 0; i < 4; i++) {
                    if (this.digits[i] != otherNumber.digits[i]) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    public int getMatches(Number otherNumber) {
        int matchCount = 0;

        for (int i = 0; i < 4; i++) {
            if (this.digits[i] == otherNumber.digits[i]) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public int getPresents(Number otherNumber) {
        int presentCount = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    continue;
                }
                if (this.digits[i] == otherNumber.digits[j]) {
                    presentCount++;
                }
            }
        }

        return presentCount;
    }
}
