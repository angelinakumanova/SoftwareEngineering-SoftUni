import { expect } from "chai";
import { JSDOM } from "jsdom";
import { notify } from "../app.js";

const dom = new JSDOM('<!DOCTYPE html><div id="notification"></div>');
global.document = dom.window.document;

describe('showNotification', () => {
    it('Should display the notification with the given message', () => {
        const message = 'Test message';
        notify(message);

        const notificationDiv = document.getElementById('notification');
        expect(notificationDiv.style.display).to.equal('block');
        expect(notificationDiv.textContent).to.equal(message);
    });

    it('Should hide the notification when clicked', () => {
        const notificationDiv = document.getElementById('notification');
        notificationDiv.click();

        expect(notificationDiv.style.display).to.equal('none');
    });
});
