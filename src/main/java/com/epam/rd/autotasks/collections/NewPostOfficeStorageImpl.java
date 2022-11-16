package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class NewPostOfficeStorageImpl implements NewPostOfficeStorage {
    private List<Box> parcels;

    /**
     * Creates internal storage for becoming parcels
     */
    public NewPostOfficeStorageImpl() {
        parcels = new LinkedList<>();
    }

    /**
     * Creates own storage and appends all parcels into own storage.
     * It must add either all the parcels or nothing, if an exception occurs.
     *
     * @param boxes a collection of parcels.
     * @throws NullPointerException if the parameter is {@code null}
     *                              or contains {@code null} values.
     */
    public NewPostOfficeStorageImpl(Collection<Box> boxes) {
        // place your code here
    }

    @Override
    public boolean acceptBox(Box box) {
        // place your code here
        return false;
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        // place your code here
        return false;
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        // place your code here
        return false;
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        // place your code here
        return null;
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        // place your code here
        return null;
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) {
        // place your code here
        return null;
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        // place your code here
        return null;
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        // place your code here
        return null;
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        // place your code here
    }
}
