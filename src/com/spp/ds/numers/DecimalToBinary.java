package com.spp.ds.numers;

public class DecimalToBinary {
        public int getBinarybyLogiWithString(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return 0;
        }
        while (num > 0) {
            int rem = num % 2;
            sb.append(rem);
            num = num / 2;
        }
        return Integer.valueOf(sb.reverse().toString());
    }
/**************************************************************/
    public int getBinaryByLogicWithIntArray(int num) {
        int biarray[] = new int[32];
        int bitTracker = 0;

        if (num == 0) return 0;
        else {
            while (num > 0) {
                biarray[bitTracker++] = num % 2;
                num = num / 2;
            }
        }
        int binaryNumber = 0;
        for (bitTracker = bitTracker - 1; bitTracker >= 0; bitTracker--) {
            binaryNumber = binaryNumber * 10 + biarray[bitTracker];
        }
        return binaryNumber;
    }
/************************************************************/
    public int decimaltoBinarybyJava(int num) {
        int binum = 0;
        if (num == 0) return num;
        else {
            String strbin = Integer.toBinaryString(num);
            binum = Integer.valueOf(strbin);
        }
        return binum;
    }
}
