package com.epam.rd.autotasks.collections;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.assertj.core.api.ListAssert;

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
        parcels = new LinkedList<>(); // Always initialize
    if (boxes != null && !boxes.contains(null)) {
        parcels.addAll(boxes);
    } else {
        throw new NullPointerException("Collection cannot be null or contain null values");
    }

    }

    @Override
    public boolean acceptBox(Box box) {
        // place your code here
        if (box != null)
        {
            parcels.add(box);
            return true;
        }
        throw new NullPointerException("Null parameter");
    }

    @Override
    public boolean acceptAllBoxes(Collection<Box> boxes) {
        // place your code here
        if (boxes != null && !boxes.contains(null)) {
            parcels.addAll(boxes);
            return true;
        }
        throw new NullPointerException("Collection cannot be null or contain null values");
    }

    @Override
    public boolean carryOutBoxes(Collection<Box> boxes) {
        if (boxes == null) {
            throw new NullPointerException("Collection cannot be null");
        }
        for (Box box : boxes) {
            if (box == null) {
                throw new NullPointerException("Collection cannot contain null values");
            }
        }
        boolean wasChanged = parcels.removeAll(boxes);
        return wasChanged;
    }

    @Override
    public List<Box> carryOutBoxes(Predicate<Box> predicate) {
        // place your code here
        if (predicate != null)
        {
            List<Box> b = new LinkedList<>();
            Iterator<Box> it  = parcels.iterator();
            while (it.hasNext()) {
                Box t = it.next();
                if (predicate.test(t))
                {
                    b.add(t);
                    it.remove();
                }
            }
            return b;
        }
        throw new NullPointerException("null");
    }

    @Override
    public List<Box> getAllWeightLessThan(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero");
        }
        return searchBoxes(new WeightLessThanPredicate(weight));
    }
    
    // Predicate implementation as a private class
    private static class WeightLessThanPredicate implements Predicate<Box> {
        private final double weight;
    
        public WeightLessThanPredicate(double weight) {
            this.weight = weight;
        }
    
        @Override
        public boolean test(Box box) {
            return box.getWeight() < weight;
        }
    }

    @Override
    public List<Box> getAllCostGreaterThan(BigDecimal cost) { 
        Objects.requireNonNull(cost, "Cost cannot be null");
    if (cost.compareTo(BigDecimal.ZERO) < 0) {
        throw new IllegalArgumentException("Cost must be greater than or equal to zero");
    }
    return searchBoxes(new CostGreaterThanPredicate(cost));
}

// Predicate implementation as a private class
private static class CostGreaterThanPredicate implements Predicate<Box> {
    private final BigDecimal cost;

    public CostGreaterThanPredicate(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean test(Box box) {
        return box.getCost().compareTo(cost) > 0;
    }
    }

    @Override
    public List<Box> getAllVolumeGreaterOrEqual(double volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Volume must be greater than or equal to zero");
        }
        return searchBoxes(new VolumeGreaterOrEqualPredicate(volume));
    }
    
    // Predicate implementation as a private class
    private static class VolumeGreaterOrEqualPredicate implements Predicate<Box> {
        private final double volume;
    
        public VolumeGreaterOrEqualPredicate(double volume) {
            this.volume = volume;
        }
    
        @Override
        public boolean test(Box box) {
            return box.getVolume() >= volume;
        }
    }

    @Override
    public List<Box> searchBoxes(Predicate<Box> predicate) {
        // place your code here
        if(predicate != null){
        List<Box> b = new LinkedList<>();
        Iterator<Box> it = parcels.iterator();
        while (it.hasNext()) {
            Box t = it.next();
            if (predicate.test(t))
            {
                b.add(t);
            }
        }
        return b;
    }
        throw new NullPointerException();
    }

    @Override
    public void updateOfficeNumber(Predicate<Box> predicate, int newOfficeNumber) {
        if (predicate == null || newOfficeNumber < 0) {
            throw new NullPointerException("Predicate cannot be null and new office number must be non-negative");
        }
        for (Box b : parcels) { 
            if (predicate.test(b)) {
                b.setOfficeNumber(newOfficeNumber);
            }
        }
    }
}
