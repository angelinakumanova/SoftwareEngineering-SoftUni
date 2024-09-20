import { expect } from "chai";
import { createCalculator } from "../calculator.js";


describe('createCalculator()', () => {
    let calculator;

    beforeEach(() => {
        calculator = createCalculator();
    });

    it('Should return 0 when get() is called initially', () => {
        expect(calculator.get()).to.equal(0);
    });

    it('Should add numbers correctly', () => {
        calculator.add(5);
        expect(calculator.get()).to.equal(5);
    });

    it('Should add string numbers correctly', () => {
        calculator.add('5');
        expect(calculator.get()).to.equal(5);
    });

    it('Should subtract numbers correctly', () => {
        calculator.subtract(5);
        expect(calculator.get()).to.equal(-5);
    });

    it('Should subtract string numbers correctly', () => {
        calculator.subtract('5');
        expect(calculator.get()).to.equal(-5);
    });

    it('Should add and subtract correctly', () => {
        calculator.add(10);
        calculator.subtract(4);
        expect(calculator.get()).to.equal(6);
    });

    it('Should handle multiple operations correctly', () => {
        calculator.add(10);
        calculator.subtract('4');
        calculator.add(1.5);
        calculator.subtract(2.5);
        expect(calculator.get()).to.equal(5);
    });

    it('Should not modify the internal value directly', () => {
        expect(calculator.value).to.be.undefined;
    });

    it('Should return NaN when adding a non-numeric string', () => {
        calculator.add('hello');
        expect(calculator.get()).to.be.NaN;
    });

    it('Should return NaN when subtracting a non-numeric string', () => {
        calculator.subtract('world');
        expect(calculator.get()).to.be.NaN;
    });
});
