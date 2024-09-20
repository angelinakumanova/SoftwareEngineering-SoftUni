import { expect } from "chai";
import { lookupChar } from "../unit-tests-functions/3-char-lookup.js";

describe('Problem 3: Test Char Lookup', () => {
    it('Should return undefined to a null input', () => {
        expect(lookupChar(null, 1)).to.be.undefined;
    });

    it('Should return undefined to a non-numeric index', () => {
        expect(lookupChar('test', [])).to.be.undefined;
    });

    it('Should return undefined to a floating-point index', () => {
        expect(lookupChar('test', 1.5)).to.be.undefined;
    })

    it('Should return \'Incorrect index\' for an empty string and any index', () => {
        expect(lookupChar('', 0)).to.equal('Incorrect index');
    });

    it('Should return \'Incorrect index\' when index is less than zero', () => {
        expect(lookupChar('test', -1)).to.equal('Incorrect index');
    });

    it('Should return \'Incorrect index\' when index is bigger than string\'s length', () => {
        expect(lookupChar('test', 5)).to.equal('Incorrect index');
    });

    it('Should return char at given index', () => {
        expect(lookupChar('javascript', 6)).to.equal('r');
    });
})
