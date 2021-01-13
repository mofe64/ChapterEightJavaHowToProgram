package com.nubari;

import com.sun.jdi.Value;

public class IntegerSet {
    private boolean[] set;

    public IntegerSet() {
        set = new boolean[101];
    }

    public String insertElement(int value) {
        if (value >= 0 && value <= 100) {
            if (!set[value]) {
                set[value] = true;
            } else {
                return "Value " + value + " is already is set";
            }
        }
        return "Value " + value + " is out of range";
    }

    public String deleteElement(int value) {
        if (value >= 0 && value <= 100) {
            if (!set[value]) {
                return "Value " + value + " is not in set";
            } else {
                set[value] = false;
                return "Value " + value + " removed successfully";
            }
        }
        return "Value " + value + " is out of range";
    }

    public static boolean[] union(boolean[] set1, boolean[] set2) {
        boolean[] unionSet = new boolean[101];
        for (int i = 0; i < set1.length; i++) {
            if (set1[i]) {
                unionSet[i] = true;
            }
        }
        for (int i = 0; i < set1.length; i++) {
            if (set2[i]) {
                unionSet[i] = true;
            }
        }
        return unionSet;
    }

    public static boolean[] intersection(boolean[] set1, boolean[] set2) {
        boolean[] intersectionSet = new boolean[101];
        for (int i = 0; i < set1.length; i++) {
            if (set1[i]) {
                intersectionSet[i] = true;
            }
        }
        for (int i = 0; i < set2.length; i++) {
            if (set2[i]) {
                intersectionSet[i] = true;
            }
        }
        return intersectionSet;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean setIsEmpty = true;
        for (int i = 0; i < set.length; i++) {
            if (set[i]) {
                setIsEmpty = false;
                stringBuilder.append(i);
                stringBuilder.append(" ");
            }
        }
        if (setIsEmpty) {
            return "---";
        } else {
            return stringBuilder.toString();
        }
    }

    public static boolean isEqual(boolean[] set1, boolean[] set2) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        for (boolean value : set1) {
            stringBuilder.append(value);
            stringBuilder.append(" ");
        }
        for (boolean value : set2) {
            stringBuilder1.append(value);
            stringBuilder1.append(" ");
        }
        return stringBuilder.toString().equals(stringBuilder1.toString());
    }

    public boolean[] getSet() {
        return set;
    }

    public void setSet(boolean[] set) {
        this.set = set;
    }
}
