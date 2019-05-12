package com.myKidGoal.service;

import com.myKidGoal.model.Unit;

import java.util.Set;

public interface UnitService {

    /**
     * This method will save the new unit and update the existing one if user provided the same unit definition again.
     * The system assumes (Portfolio Name, Asset_Ref, Unit_Ref) will be unique. If same then system will update the
     * existing record.
     * 
     * @param units
     *            List of units
     */
    void saveAll(Set<Unit> units);

}
