pragma solidity ^0.4.0;


contract adder_costing {

    int contractTotal;

    function adder_costing() public {
        contractTotal = 0;
    }

    function getTotal() constant returns (int) {
        return contractTotal;
    }

    function addToTotalNTimes(int add, int times) returns (int) {
        int counter = 0;
        while (counter < times) {
            counter++;
            contractTotal += add;
        }
        return contractTotal;

    }
}
