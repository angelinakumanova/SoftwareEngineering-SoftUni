function printLoadingBar(number) {
    if (number === 100) {
        console.log('100% Complete!')
    } else {
        console.log(fillLoadingBar(number));
    }
    


    function fillLoadingBar(number) {
        let loadingBar = `${number}% [..........]`;
        for (let i = 0; i < number / 10; i++) {
            loadingBar = loadingBar.replace('.', '%');
        }

        return loadingBar + `\nStill loading...`;
    }
}

printLoadingBar(30);
printLoadingBar(50);
printLoadingBar(100);
