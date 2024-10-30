package leetcode.veryeasy;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Truck {
    public static void main(String[] args) {
        int[][] boxTypes = {{5,10}, {2,5},{4,7}, {3,9}};
        int truckSize = 10;
        System.out.println(getMaxUnits(boxTypes, truckSize));
    }

//    public static int getMaxUnits(int[][] boxTypes, int truckSize) {
//        List<List<Integer>> boxes = new ArrayList<>();
//        int result = 0;
//        for (int[] box : boxTypes) {
//            boxes.add(Arrays.asList(box[0], box[1]));
//        }
//        Collections.sort(boxes, new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                return Integer.compare(o2.get(1), o1.get(1));
//            }
//        });
//
//        System.out.println(boxes);
//        int truckSizeTrack = 0;
//
//        for (List<Integer> box : boxes) {
//            for (int i = 0; i < box.get(0); i++) {
//                result += box.get(1);
//                truckSizeTrack ++;
//
//                if (truckSizeTrack == truckSize) {
//                    return result;
//                }
//            }
//        }
//        return result;
//    }

    public static int getMaxUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int result = 0;
        for (int[] box : boxTypes) {
            if (truckSize - box[0] >= 0) {
                truckSize -= box[0];
                result += box[0] * box[1];
            } else {
                result += truckSize * box[1];
                break;
            }
        }
        return result;
    }
}
