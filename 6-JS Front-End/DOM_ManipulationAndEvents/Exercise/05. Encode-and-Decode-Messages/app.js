function encodeAndDecodeMessages() {
    const receivedMessageElement = document.querySelector('#main div:nth-child(1) textarea');
    const displayMsgTextArea = document.querySelector('#main div:nth-child(2) textarea');
    const encodeButton = document.querySelector('#main div:nth-child(1) button');
    const decodeButton = document.querySelector('#main div:nth-child(2) button');

    
    encodeButton.addEventListener('click', () => {
        const encodedMessage = encodeMessage(receivedMessageElement.value);
        displayMsgTextArea.value = encodedMessage;
        receivedMessageElement.value = '';
    });

    decodeButton.addEventListener('click', () => {
        const decodedMessage = decodeMessage(displayMsgTextArea.value);
        displayMsgTextArea.value = decodedMessage;
    });



    function encodeMessage(message) {
        return message.split('').map(char => String.fromCharCode(char.charCodeAt(0) + 1)).join('');
    }

    function decodeMessage(message) {
        return message.split('').map(char => String.fromCharCode(char.charCodeAt(0) - 1)).join('');
    }
}
