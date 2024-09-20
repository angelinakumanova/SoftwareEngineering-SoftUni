import { expect } from "chai";
import { sum } from "../sum.js";

it('Should return sum of array', () => {
    const array = [1, 2, 3];
    const expectedResult = 6;

    const actualResult = sum(array);

    expect(actualResult).to.equal(expectedResult);
});
