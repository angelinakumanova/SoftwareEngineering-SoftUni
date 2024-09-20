import { expect } from "chai";
import { mathEnforcer } from "../unit-tests-functions/4-math-enforcer.js";

describe('Problem 4: Test Math Enforcer', () => {

    describe('Test addFive function', () => {
        it('Should return undefined if input is null', () => {
            expect(mathEnforcer.addFive(null)).to.be.undefined;
        });

        it('Should return undefined if input is array', () => {
            expect(mathEnforcer.addFive([])).to.be.undefined;
        });

        it('Should add 5 to a positive number', () => {
            expect(mathEnforcer.addFive(5)).to.equal(10);
        });

        it('Should add 5 to a negative number', () => {
            expect(mathEnforcer.addFive(-5)).to.equal(0);
        });

        it('Should add 5 to a floating-point number', () => {
            expect(mathEnforcer.addFive(2.5)).to.equal(7.5);
        });
    });


    describe('Test subtractTen function', () => {
        it('Should return undefined if input is null', () => {
            expect(mathEnforcer.subtractTen(null)).to.be.undefined;
        });

        it('Should return undefined if input is array', () => {
            expect(mathEnforcer.subtractTen([])).to.be.undefined;
        });

        it('Should subtract 10 from a positive number', () => {
            expect(mathEnforcer.subtractTen(10)).to.equal(0);
        });

        it('Should subtract 10 from a negative number', () => {
            expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
        });

        it('Should subtract 10 from a floating-point number', () => {
            expect(mathEnforcer.subtractTen(12.5)).to.equal(2.5);
        });
    });
    /*sum: function (num1, num2) {
        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }*/


    describe('Test sum function', () => {
        it('Should return undefined if first parameter is not a number', () => {
            expect(mathEnforcer.sum('1', 1)).to.be.undefined;
        });

        it('Should return undefined if second parameter is not a number', () => {
            expect(mathEnforcer.sum(1, '1')).to.be.undefined;
        });

        it('Should return undefined if both parameters are not numbers', () => {
            expect(mathEnforcer.sum('1', '1')).to.be.undefined;
        });

        it('Should return the sum of two positive numbers', () => {
            expect(mathEnforcer.sum(2,2)).to.equal(4);
        });

        it('Should return the sum of two negative numbers', () => {
            expect(mathEnforcer.sum(-5, -5)).to.equal(-10);
        });

        it('Should return the sum of a positive and a negative number', () => {
            expect(mathEnforcer.sum(2, -5)).to.equal(-3);
        });

        it('Should return the sum of two floating-point numbers', () => {
            expect(mathEnforcer.sum(2.5, 5.5)).to.equal(8);
        });

    });
});
