package GameLogic.Board.Occupants;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import GameLogic.Board.Location;

/**
 *
 * @author James
 */
public class Operation implements Occupant {

    private Location location;

    private Operation operation;

    public Operation(Location location, Operation operation) {
        this.location = location;
        this.operation = operation;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.location = location;
    }
}
