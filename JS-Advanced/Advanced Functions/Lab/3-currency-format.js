function createFormatter(separator, symbol, symbolFirst) {
    return currencyFormatter.bind(null, separator, symbol, symbolFirst);
}

const bgFormatter = createFormatter(',', 'лв.', false);
console.log(bgFormatter(5));



function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2,2);
    if (symbolFirst) return symbol + ' ' + result;
    else return result + ' ' + symbol;
}
