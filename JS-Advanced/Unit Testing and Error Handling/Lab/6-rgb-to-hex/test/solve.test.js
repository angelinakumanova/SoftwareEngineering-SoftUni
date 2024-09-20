import { expect } from "chai";
import { rgbToHexColor } from "../solve.js";

describe('rgbToHexColor()', function() {
    it('Should return #FF9EAA for (255, 158, 170)', () => {
        expect(rgbToHexColor(255, 158, 170)).to.equal('#FF9EAA');
    });

    it('Should return #000000 for (0, 0, 0)', () => {
        expect(rgbToHexColor(0, 0, 0)).to.equal('#000000');
    });

    it('Should return #FFFFFF for (255, 255, 255)', () => {
        expect(rgbToHexColor(255, 255, 255)).to.equal('#FFFFFF');
    });

    it('Should return undefined for out of range values like (256, 255, 255)', () => {
        expect(rgbToHexColor(256, 255, 255)).to.be.undefined;
    });

    it('Should return undefined for negative values like (-1, 0, 0)', () => {
        expect(rgbToHexColor(-1, 0, 0)).to.be.undefined;
    });

    it('Should return undefined for non-integer values like (1.5, 0, 0)', () => {
        expect(rgbToHexColor(1.5, 0, 0)).to.be.undefined;
    });

    it('Should return undefined for non-number values like ("255", 255, 255)', () => {
        expect(rgbToHexColor("255", 255, 255)).to.be.undefined;
    });

    it('Should return undefined when missing arguments', () => {
        expect(rgbToHexColor(255, 255)).to.be.undefined;
    });

    it('Should return undefined when no arguments are provided', () => {
        expect(rgbToHexColor()).to.be.undefined;
    });
});
