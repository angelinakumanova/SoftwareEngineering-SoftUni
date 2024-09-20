import { expect } from "chai";
import { isSymmetric } from "../check-for-symmetry.js";

it('Should return false if input is non-array', () => {
    const input = 'test';
    const expectedResult = false;

    const actualResult = isSymmetric(input);

    expect(actualResult).to.equal(expectedResult);
});

it('Should return true for symmetric array', () => {
    const input = [1,1,1];
    const expectedResult = true;

    const actualResult = isSymmetric(input);

    expect(actualResult).to.equal(expectedResult);
});

it('Should return false for non-symmetric array', () => {
    const input = [1,2,3];
    const expectedResult = false;

    const actualResult = isSymmetric(input);

    expect(actualResult).to.equal(expectedResult);
});
