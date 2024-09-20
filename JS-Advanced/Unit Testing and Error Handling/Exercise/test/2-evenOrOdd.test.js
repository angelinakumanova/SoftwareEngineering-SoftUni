import { expect } from "chai";
import { isOddOrEven } from "../unit-tests-functions/2-even-or-odd.js";

describe('Problem 2: Test Even Or Odd', () => {
    it('Should return undefined for null input', () => {
        expect(isOddOrEven(null)).to.be.undefined;
    });
    
    it('Should return undefined for undefined input', () => {
        expect(isOddOrEven(undefined)).to.be.undefined;
    });
    
    it('Should return undefined for an array input', () => {
        expect(isOddOrEven([])).to.be.undefined;
    });

    it('Should return undefined to a number input', () => {
        expect(isOddOrEven(2)).to.be.undefined;
    });

    it('Should return even to a string of even length', () => {
        expect(isOddOrEven('javascript')).to.equal('even');
    });

    it('Should return odd to a string of odd length', () => {
        expect(isOddOrEven('mocha')).to.equal('odd');
    });
});
